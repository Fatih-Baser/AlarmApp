package com.fatihbaser.alarmapp.feature_alarm.domain

import kotlinx.coroutines.flow.Flow

interface AlarmRepository {
    fun getAll(): Flow<List<Alarm>>
    suspend fun getById(id: String): Alarm?
    suspend fun upsert(alarm: Alarm)
    suspend fun toggle(alarm: Alarm)
    suspend fun toggleDay(day: DayValue, alarm: Alarm)

    /**
     * Disable the alarm after it has been turned off by the user. No need to cancel it from AlarmManager
     */
    suspend fun disableAlarmById(id: String)
    suspend fun deleteById(id: String)
    suspend fun scheduleAllEnabledAlarms()
}