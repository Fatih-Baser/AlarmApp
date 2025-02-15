package com.fatihbaser.alarmapp

import android.app.Application
import com.fatihbaser.alarmapp.core.database.di.coreDatabaseModule
import com.fatihbaser.alarmapp.core.ringtone.di.coreRingtoneModule
import com.fatihbaser.alarmapp.feature_alarm.data.di.featureAlarmDataModule
import com.fatihbaser.alarmapp.feature_alarm.data.di.featureAlarmPresentationModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AlarmApp: Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()


        startKoin {
            androidLogger()
            androidContext(this@AlarmApp)
            modules(
                appModule,
                coreDatabaseModule,
                coreRingtoneModule,
                featureAlarmDataModule,
                featureAlarmPresentationModule,
                //featureAlarmSchedulerReceiverModule
            )
        }
    }}
