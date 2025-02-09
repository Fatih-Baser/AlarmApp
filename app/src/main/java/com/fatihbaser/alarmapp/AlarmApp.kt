package com.fatihbaser.alarmapp

import android.app.Application
import com.fatihbaser.alarmapp.core.database.di.coreDatabaseModule
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
                coreDatabaseModule
            )
        }
    }
}
