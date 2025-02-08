package com.fatihbaser.alarmapp.feature_alarm.presentation.add_edit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fatihbaser.alarmapp.R
import com.fatihbaser.alarmapp.ui.theme.AlarmAppTheme


class AddEditAlarmScreen {
}

@Composable
private fun AddAlarmScreen(
    state: AddEditAlarmState,
    onAction: (AddEditAlarmAction) -> Unit,
){

}
@Composable
private fun AddAlarmScreenMainContent(
    state: AddEditAlarmState,
    onAction: (AddEditAlarmAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ){
        CloseAndSaveButtons(
            canSave = state.canSave,
            onCloseClick = {
                onAction(AddEditAlarmAction.OnCloseClick)
            },
            onSaveClick = {
                onAction(AddEditAlarmAction.OnSaveClick)
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))


    }

}
@Preview
@Composable
private fun AddAlarmScreenPreview() {
    AlarmAppTheme {
        var state by remember { mutableStateOf(AddEditAlarmState(alarmName = "Work")) }

        AddAlarmScreenMainContent(
            state = state,

        ) { }
    }
}
@Composable
private fun CloseAndSaveButtons(
    canSave: Boolean,
    onCloseClick: () -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
         painter = painterResource(R.drawable.subtract),
            contentDescription=null,
            modifier = Modifier
                .size(32.dp)
                .clickable(
                    role = Role.Button
                ){
                    onCloseClick()
                },
            tint = MaterialTheme.colorScheme.primary
        )
        Button(
            onClick = onSaveClick,
            contentPadding = PaddingValues(
                horizontal = 1.dp,
                vertical = 6.dp
            ),
            shape = RoundedCornerShape(30.dp),
            enabled = canSave,
            colors = ButtonDefaults.buttonColors(
                disabledContentColor = MaterialTheme.colorScheme.onSurface
            )
        ) {
            Text(
                text = "Save",
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}
@Composable
private fun HourAndMinuteInputField(
    hour: String,
    minute: String,
    onHourChange: (String) -> Unit,
    onMinuteChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

    }
}