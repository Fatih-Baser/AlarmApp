package com.fatihbaser.alarmapp.feature_alarm.schedular_receiver.di


import com.fatihbaser.alarmapp.feature_alarm.domain.AlarmScheduler
import com.fatihbaser.alarmapp.feature_alarm.presentation.scheduler_receiver.AndroidAlarmScheduler
import com.fatihbaser.alarmapp.feature_alarm.schedular_receiver.ReminderViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val featureAlarmSchedulerReceiverModule = module {
    viewModel { (alarmId: String) -> ReminderViewModel(alarmId, get()) }
    single<AndroidAlarmScheduler> {
        AndroidAlarmScheduler(androidContext(),get())
    }.bind<AlarmScheduler>()
}