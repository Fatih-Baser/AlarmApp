package com.fatihbaser.alarmapp.feature_alarm.data.di


import com.fatihbaser.alarmapp.core.ringtone.NameAndUri
import com.fatihbaser.alarmapp.feature_alarm.presentation.add_edit.AddEditAlarmViewModel
import com.fatihbaser.alarmapp.feature_alarm.presentation.list.AlarmListViewModel
import com.fatihbaser.alarmapp.feature_alarm.presentation.ringtone_list.RingtoneListViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val featureAlarmPresentationModule = module {
    viewModelOf(::AlarmListViewModel)
    viewModel { (alarmId: String?) ->
        AddEditAlarmViewModel(
            alarmId = alarmId,
            alarmRepository = get(),
            validateAlarmUseCase = get(),
            ringtoneManager = get()
        )
    }
    viewModel { (selectedRingtone: NameAndUri) -> RingtoneListViewModel(selectedRingtone, get()) }
}