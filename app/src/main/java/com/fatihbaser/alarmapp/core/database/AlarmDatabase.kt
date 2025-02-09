package com.fatihbaser.alarmapp.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.fatihbaser.alarmapp.core.database.alarm.AlarmDao
import com.fatihbaser.alarmapp.core.database.alarm.AlarmEntity


@Database(
    entities = [AlarmEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class AlarmDatabase: RoomDatabase() {

    abstract val alarmDao: AlarmDao
}