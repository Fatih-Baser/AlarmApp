package com.fatihbaser.alarmapp.core.domain

import java.time.LocalDateTime
import java.time.ZoneId

fun convertLocalDateTimeToEpochSeconds(localDateTime: LocalDateTime): Long {
    return localDateTime.atZone(ZoneId.systemDefault()).toEpochSecond()
}