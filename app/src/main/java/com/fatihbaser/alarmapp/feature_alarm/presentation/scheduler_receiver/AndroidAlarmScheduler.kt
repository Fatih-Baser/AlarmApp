package com.fatihbaser.alarmapp.feature_alarm.presentation.scheduler_receiver

import android.content.Context
import com.fatihbaser.alarmapp.feature_alarm.domain.Alarm
import com.fatihbaser.alarmapp.feature_alarm.domain.AlarmScheduler

/*
Kodun Genel Açıklaması
	•	AlarmManager kullanarak belirli bir saatte alarm çalmasını sağlıyor.
	•	AlarmReceiver adlı bir BroadcastReceiver’ı tetikleyerek alarmı çalıştırıyor.
	•	shouldSnooze parametresiyle erteleme (snooze) desteği sunuyor.
	•	GetFutureDateUseCase kullanarak gelecekteki alarm saatini hesaplıyor.
	•	cancel() fonksiyonu ile belirli bir alarmı iptal edebiliyor.
 */
class AndroidAlarmScheduler(
    private val context: Context
   // private val getFutureDateUseCase: GetFutureDateUseCase
): AlarmScheduler {
    override fun schedule(alarm: Alarm, shouldSnooze: Boolean) {
        TODO("Not yet implemented")
    }

    override fun cancel(alarm: Alarm) {
        TODO("Not yet implemented")
    }

}