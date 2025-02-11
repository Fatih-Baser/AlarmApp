package com.fatihbaser.alarmapp.feature_alarm.domain

interface  AlarmScheduler {
    fun schedule(alarm: Alarm , shouldSnooze:Boolean = false)
    fun cancel(alarm: Alarm)
}