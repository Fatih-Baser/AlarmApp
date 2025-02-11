package com.fatihbaser.alarmapp.feature_alarm.data.di

import com.fatihbaser.alarmapp.feature_alarm.domain.AlarmRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val featureAlarmDataModule = module {
    singleOf(::AlarmRepositoryImpl).bind<AlarmRepository>()
    singleOf(::GetFutureDateUseCase)
}