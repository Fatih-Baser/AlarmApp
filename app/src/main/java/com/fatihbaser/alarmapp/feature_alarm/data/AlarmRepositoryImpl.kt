package com.fatihbaser.alarmapp.feature_alarm.data

import android.content.Context
import com.fatihbaser.alarmapp.core.database.alarm.AlarmDao
import com.fatihbaser.alarmapp.core.domain.ringtone.RingtoneManager
import com.fatihbaser.alarmapp.feature_alarm.data.mapper.toAlarm
import com.fatihbaser.alarmapp.feature_alarm.data.mapper.toAlarmEntity
import com.fatihbaser.alarmapp.feature_alarm.domain.Alarm
import com.fatihbaser.alarmapp.feature_alarm.domain.AlarmRepository
import com.fatihbaser.alarmapp.feature_alarm.domain.AlarmScheduler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AlarmRepositoryImpl(
    private val alarmDao: AlarmDao,
    private val alarmScheduler: AlarmScheduler,

): AlarmRepository {
    override fun getAll(): Flow<List<Alarm>> {
        return alarmDao.getAll().map { alarms ->
            alarms.map { it.toAlarm() }
        }
    }



    override suspend fun getById(id: String): Alarm? {
        return alarmDao.getById(id)?.toAlarm()
    }

    override suspend fun upsert(alarm: Alarm) {
        alarmDao.upsert(alarm.toAlarmEntity())
        alarmScheduler.schedule(alarm)
    }
}