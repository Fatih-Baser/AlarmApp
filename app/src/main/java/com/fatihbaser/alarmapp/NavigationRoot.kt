package com.fatihbaser.alarmapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation
import com.fatihbaser.alarmapp.feature_alarm.AlarmGraph


@Composable
fun NavigationRoot(navController: NavHostController) {
    NavHost(navController = navController, startDestination = AlarmGraph.Root) {

        navigation(startDestination = "alarm_list", route = "alarm_graph") {

            // Alarm Listesi Ekranı

        }

    }
}
