package com.fatihbaser.alarmapp.feature_alarm

import com.fatihbaser.alarmapp.core.ringtone.NameAndUri
import kotlinx.serialization.Serializable

object AlarmGraph {
    @Serializable
    data object Root

    @Serializable
    data object AlarmList
    @Serializable
    data class AlarmDetail(val alarmId: String?)

    @Serializable
    data class RingtoneList(val name: String?, val uri: String?) {
        fun getNameAndUri(): NameAndUri? {
            if (name == null || uri == null) {
                return null
            }

            return Pair(name, uri)
        }
    }
}