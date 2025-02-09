package com.fatihbaser.alarmapp.feature_alarm.presentation.util

import com.fatihbaser.alarmapp.feature_alarm.domain.Alarm


fun getDummyAlarm(
    name: String,
    hour: Int,
    minute: Int,
    enabled: Boolean
) = Alarm(
    name = name,
    hour = hour,
    minute = minute,
    enabled = enabled,
    repeatDays = setOf(),
    volume = 70,
    ringtoneUri = "",
    vibrate = true
)