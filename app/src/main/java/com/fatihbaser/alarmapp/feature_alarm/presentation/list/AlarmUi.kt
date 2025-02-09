package com.fatihbaser.alarmapp.feature_alarm.presentation.list

import com.fatihbaser.alarmapp.feature_alarm.domain.Alarm


data class AlarmUi(
    val alarm: Alarm,
    val timeLeftInSeconds: Long,
    val timeToSleepInSeconds: Long?
)