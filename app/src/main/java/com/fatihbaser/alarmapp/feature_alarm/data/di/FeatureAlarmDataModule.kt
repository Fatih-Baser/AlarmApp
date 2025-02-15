package com.fatihbaser.alarmapp.feature_alarm.data.di

import com.fatihbaser.alarmapp.core.domain.AlarmRepository
import com.fatihbaser.alarmapp.feature_alarm.data.AlarmRepositoryImpl
import com.fatihbaser.alarmapp.core.domain.GetFutureDateUseCase
import com.fatihbaser.alarmapp.core.domain.GetTimeLeftInSecondsUseCase
import com.fatihbaser.alarmapp.core.domain.GetTimeToSleepInSecondsUseCase
import com.fatihbaser.alarmapp.core.domain.ValidateAlarmUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val featureAlarmDataModule = module {
    singleOf(::AlarmRepositoryImpl).bind<AlarmRepository>()
    singleOf(::ValidateAlarmUseCase)
    singleOf(::GetFutureDateUseCase)
    singleOf(::GetTimeLeftInSecondsUseCase)
    singleOf(::GetTimeToSleepInSecondsUseCase)
}