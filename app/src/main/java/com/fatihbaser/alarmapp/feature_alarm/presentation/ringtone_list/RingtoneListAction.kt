package com.fatihbaser.alarmapp.feature_alarm.presentation.ringtone_list

import com.fatihbaser.alarmapp.core.domain.ringtone.NameAndUri


sealed interface RingtoneListAction {
    data class OnRingtoneSelected(val ringtone: NameAndUri): RingtoneListAction
    data object OnBackClick: RingtoneListAction
}