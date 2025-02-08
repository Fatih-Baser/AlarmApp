package com.fatihbaser.alarmapp.feature_alarm.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fatihbaser.alarmapp.feature_alarm.domain.DayValue
import com.fatihbaser.alarmapp.ui.theme.AlarmAppTheme

@Composable
fun DayChip(
    dayValue: DayValue,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = Color(0xffECEFFF),
    labelColor: Color = Color(0xff0D0F19)
) {
    val dayValueStr = when (dayValue) {
        DayValue.MONDAY -> "Mo"
        DayValue.TUESDAY -> "Tu"
        DayValue.WEDNESDAY -> "We"
        DayValue.THURSDAY -> "Th"
        DayValue.FRIDAY -> "Fr"
        DayValue.SATURDAY -> "Sa"
        DayValue.SUNDAY -> "Su"
    }

    FilterChip(
        selected = isSelected,
        onClick = onClick,
        label = {
            Text(
                text = dayValueStr,
                style = MaterialTheme.typography.labelSmall,
                lineHeight = 16.sp,
                fontSize = 12.sp
            )
        },
        modifier = modifier,
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = MaterialTheme.colorScheme.primary,
            selectedLabelColor = MaterialTheme.colorScheme.background,
            containerColor = containerColor,
            labelColor = labelColor
        ),
        shape = RoundedCornerShape(38.dp),
        border = BorderStroke(0.dp, Color.Transparent)
    )
}

@Preview
@Composable
private fun DayChipPreview() {
    AlarmAppTheme() {
        DayChip(
            dayValue = DayValue.MONDAY,
            isSelected = false,
            onClick = {},
        )
    }
}