package com.fatihbaser.alarmapp.feature_alarm.schedular_receiver

import com.fatihbaser.alarmapp.feature_alarm.domain.Alarm


sealed interface ReminderEvent {
    data class OnAlarmFetched(val alarm: Alarm): ReminderEvent
    data object OnTimerExpired: ReminderEvent
    data object AlarmIsNotExisting: ReminderEvent
}