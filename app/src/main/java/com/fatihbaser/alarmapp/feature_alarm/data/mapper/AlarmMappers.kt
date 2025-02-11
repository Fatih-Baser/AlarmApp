package com.fatihbaser.alarmapp.feature_alarm.data.mapper

import com.fatihbaser.alarmapp.core.database.alarm.AlarmEntity
import com.fatihbaser.alarmapp.feature_alarm.domain.Alarm
import com.fatihbaser.alarmapp.feature_alarm.domain.DayValue


fun Alarm.toAlarmEntity(): AlarmEntity {
    return AlarmEntity(
        id = id,
        name = name,
        hour = hour,
        minute = minute,
        enabled = enabled,
        repeatDays = repeatDays.toSetOfInt(),
        volume = volume,
        ringtoneUri = ringtoneUri,
        vibrate = vibrate
    )
}

fun AlarmEntity.toAlarm(): Alarm {
    return Alarm(
        id = id,
        name = name,
        hour = hour,
        minute = minute,
        enabled = enabled,
        repeatDays = repeatDays.toDayValues(),
        volume = volume,
        ringtoneUri = ringtoneUri,
        vibrate = vibrate
    )
}

fun Set<Int>.toDayValues(): Set<DayValue> {
    return this.map { DayValue.entries[it] }.toSet()
}

fun Set<DayValue>.toSetOfInt(): Set<Int> {
    return this.map { it.ordinal }.toSet()
}