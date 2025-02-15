package com.fatihbaser.alarmapp.feature_alarm.presentation.ringtone_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fatihbaser.alarmapp.core.domain.ringtone.NameAndUri
import com.fatihbaser.alarmapp.core.domain.ringtone.RingtoneManager
import com.fatihbaser.alarmapp.core.domain.ringtone.SILENT
import kotlinx.coroutines.launch


class RingtoneListViewModel(
    private val selectedRingtone: NameAndUri?,
    private val ringtoneManager: RingtoneManager
): ViewModel() {

    var state by mutableStateOf(RingtoneListState())
        private set
    init {
        viewModelScope.launch {
            val ringtones = ringtoneManager.getAvailableRingtones()
            val ringtone = selectedRingtone ?: ringtones.getOrNull(1)

            state = state.copy(
                ringtones = ringtones,
                selectedRingtone = ringtone
            )
        }
    }
    fun onAction(action: RingtoneListAction) {
        when (action) {
            is RingtoneListAction.OnRingtoneSelected -> {
                state = state.copy(selectedRingtone = action.ringtone)
                val (_, uri) = action.ringtone
                if (uri == SILENT) {
                    return
                }

                ringtoneManager.play(uri)
            }

            RingtoneListAction.OnBackClick -> {
                ringtoneManager.stop()
            }
        }
    }

}