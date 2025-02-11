package com.fatihbaser.alarmapp.feature_alarm.domain

import kotlinx.coroutines.flow.Flow

interface AlarmRepository {
    fun getAll(): Flow<List<Alarm>>
    suspend fun getById(id: String): Alarm?
    suspend fun upsert(alarm: Alarm)

}