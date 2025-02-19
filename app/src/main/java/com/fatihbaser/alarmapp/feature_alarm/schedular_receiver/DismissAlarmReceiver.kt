package com.fatihbaser.alarmapp.feature_alarm.schedular_receiver

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.fatihbaser.alarmapp.core.domain.AlarmRepository
import com.fatihbaser.alarmapp.core.ringtone.RingtoneManager
import com.fatihbaser.alarmapp.core.util.hideNotification
import com.fatihbaser.alarmapp.core.util.isOreoPlus
import com.fatihbaser.alarmapp.feature_alarm.domain.AlarmConstants
import com.fatihbaser.alarmapp.feature_alarm.domain.AlarmScheduler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DismissAlarmReceiver : BroadcastReceiver(), KoinComponent {

    private val alarmRepository: AlarmRepository by inject()
    private val alarmScheduler: AlarmScheduler by inject()
    private val ringtoneManager: RingtoneManager by inject()
    private val scope: CoroutineScope by inject()

    override fun onReceive(context: Context?, intent: Intent?) {
        val alarmId = intent?.getStringExtra(AlarmConstants.EXTRA_ALARM_ID) ?: return
        val shouldSnooze = intent.getBooleanExtra(AlarmConstants.EXTRA_SHOULD_SNOOZE, false)
        if (context == null) {
            return
        }

        ringtoneManager.stop()
        context.hideNotification(alarmId.hashCode())
        intent.getStringExtra(AlarmConstants.EXTRA_ALARM_CUSTOM_CHANNEL_ID)?.let { channelId ->
            deleteNotificationChannel(context, channelId)
        }

        scope.launch(Dispatchers.Main) {
            val alarm = alarmRepository.getById(alarmId) ?: return@launch

            if (shouldSnooze) {
                alarmScheduler.schedule(
                    alarm = alarm,
                    shouldSnooze = true
                )
                return@launch
            }

            if (alarm.isOneTime) {
                alarmRepository.disableAlarmById(alarmId)
            } else {
                /**
                 * We need to disable the alarm first to re-trigger this compose state if you're on AlarmListScreen
                 * val timeLeftInSeconds by remember(alarm.enabled, alarm.repeatDays) {}
                 */
                alarmRepository.disableAlarmById(alarmId)
                alarmRepository.upsert(alarm.copy(enabled = true))
            }
        }
    }

    private fun deleteNotificationChannel(context: Context, channelId: String) {
        if (isOreoPlus()) {
            val notificationManager = context.getSystemService(NotificationManager::class.java)
            notificationManager.deleteNotificationChannel(channelId)
        }
    }
}