package com.fatihbaser.alarmapp.feature_alarm.presentation.add_edit

import com.fatihbaser.alarmapp.core.presentation.ui.UiText


interface AddEditAlarmEvent {
    data object OnSuccess: AddEditAlarmEvent
    data class OnFailure(val uiText: UiText): AddEditAlarmEvent
}