package com.fatihbaser.alarmapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.fatihbaser.alarmapp.feature_alarm.AlarmGraph
import com.fatihbaser.alarmapp.feature_alarm.presentation.list.AlarmListScreenRoot
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf


@Composable
fun NavigationRoot(
    navController: NavHostController
) {

    NavHost(navController = navController, startDestination = AlarmGraph.Root) {
        alarmGraph(navController)
    }
}

private fun NavGraphBuilder.alarmGraph(navController: NavHostController) {
    navigation<AlarmGraph.Root>(
        startDestination = AlarmGraph.AlarmList
    ) {
        composable<AlarmGraph.AlarmList> {
            AlarmListScreenRoot(
                navigateToAddEditScreen = {
                    navController.navigate(AlarmGraph.AlarmDetail(it))
                }
            )
        }

        composable<AlarmGraph.AlarmDetail> { entry ->
            val alarmDetailRoute: AlarmGraph.AlarmDetail = entry.toRoute()


        }

    }
}

@Composable
inline fun <reified T: ViewModel> NavBackStackEntry.sharedKoinViewModel(
    navController: NavHostController
): T {
    val navGraphRoute = destination.parent?.route ?: return koinViewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return koinViewModel(viewModelStoreOwner = parentEntry)
}