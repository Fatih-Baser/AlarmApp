package com.fatihbaser.alarmapp.feature_alarm.schedular_receiver

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.fatihbaser.alarmapp.core.domain.AlarmRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class BootCompletedReceiver: BroadcastReceiver(), KoinComponent {

    private val alarmRepository: AlarmRepository by inject()
    private val scope: CoroutineScope by inject()

    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_BOOT_COMPLETED) {
            scope.launch {
                alarmRepository.scheduleAllEnabledAlarms()
            }
        }
    }
}