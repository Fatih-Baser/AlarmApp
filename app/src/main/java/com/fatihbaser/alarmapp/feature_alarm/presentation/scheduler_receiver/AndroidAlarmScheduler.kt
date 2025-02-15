package com.fatihbaser.alarmapp.feature_alarm.presentation.scheduler_receiver

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.fatihbaser.alarmapp.core.domain.GetFutureDateUseCase
import com.fatihbaser.alarmapp.feature_alarm.domain.Alarm
import com.fatihbaser.alarmapp.feature_alarm.domain.AlarmConstants
import com.fatihbaser.alarmapp.feature_alarm.domain.AlarmScheduler
import com.fatihbaser.alarmapp.feature_alarm.schedular_receiver.AlarmReceiver
import java.time.LocalDateTime
import java.time.ZoneId

/*
Kodun Genel Açıklaması
	•	AlarmManager kullanarak belirli bir saatte alarm çalmasını sağlıyor.
	•	AlarmReceiver adlı bir BroadcastReceiver’ı tetikleyerek alarmı çalıştırıyor.
	•	shouldSnooze parametresiyle erteleme (snooze) desteği sunuyor.
	•	GetFutureDateUseCase kullanarak gelecekteki alarm saatini hesaplıyor.
	•	cancel() fonksiyonu ile belirli bir alarmı iptal edebiliyor.
 */
class AndroidAlarmScheduler(
    private val context: Context,
    private val getFutureDateUseCase: GetFutureDateUseCase
): AlarmScheduler {

    private val alarmManager = context.getSystemService(AlarmManager::class.java)

    @SuppressLint("MissingPermission")
    override fun schedule(alarm: Alarm, shouldSnooze: Boolean) {
        val futureDateTime = getFutureDateUseCase(
            hour = alarm.hour,
            minute = alarm.minute,
            repeatDays = alarm.repeatDays
        )

        val intent = Intent(context, AlarmReceiver::class.java).apply {
            putExtra(AlarmConstants.EXTRA_ALARM_ID, alarm.id)
        }

        val curDateTime = LocalDateTime.now()
        val triggerAtMillis = if (shouldSnooze) {
            curDateTime
                .plusMinutes(5)
                .withSecond(0)
                .atZone(ZoneId.systemDefault())
                .toEpochSecond() * 1_000L
        } else {
            futureDateTime.atZone(ZoneId.systemDefault()).toEpochSecond() * 1_000L
        }

        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            triggerAtMillis,
            PendingIntent.getBroadcast(
                context,
                alarm.id.hashCode(),
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
        )
    }

    override fun cancel(alarm: Alarm) {
        alarmManager.cancel(
            PendingIntent.getBroadcast(
                context,
                alarm.id.hashCode(),
                Intent(context, AlarmReceiver::class.java),
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
        )
    }
}