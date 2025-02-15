package com.fatihbaser.alarmapp.core.ringtone.di

import com.fatihbaser.alarmapp.core.domain.ringtone.RingtoneManager
import com.fatihbaser.alarmapp.core.ringtone.AndroidRingtoneManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.bind
import org.koin.dsl.module


val coreRingtoneModule = module {
    single { AndroidRingtoneManager(androidContext()) }.bind<RingtoneManager>()
}