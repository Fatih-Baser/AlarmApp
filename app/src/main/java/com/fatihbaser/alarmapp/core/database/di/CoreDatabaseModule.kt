package com.fatihbaser.alarmapp.core.database.di

import androidx.room.Room
import com.fatihbaser.alarmapp.core.database.AlarmDatabase
import com.fatihbaser.alarmapp.core.database.alarm.AlarmDao

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val coreDatabaseModule = module {
    single<AlarmDatabase> {
        Room.databaseBuilder(
            context = androidApplication(),
            klass = AlarmDatabase::class.java,
            name = "alarms.db"
        ).build()
    }
    single<AlarmDao> {
        get<AlarmDatabase>().alarmDao
    }
}