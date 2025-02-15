package com.fatihbaser.alarmapp.feature_alarm.presentation.ringtone_list

import com.fatihbaser.alarmapp.core.ringtone.NameAndUri


data class RingtoneListState(
    val ringtones: List<NameAndUri> = emptyList(),
    val selectedRingtone: NameAndUri? = null
)
