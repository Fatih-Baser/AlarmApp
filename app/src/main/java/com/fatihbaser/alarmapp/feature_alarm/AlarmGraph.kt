package com.fatihbaser.alarmapp.feature_alarm

import kotlinx.serialization.Serializable

object AlarmGraph {
    @Serializable
    data object Root

    @Serializable
    data object AlarmList
    @Serializable
    data class AlarmDetail(val alarmId: String?)
}