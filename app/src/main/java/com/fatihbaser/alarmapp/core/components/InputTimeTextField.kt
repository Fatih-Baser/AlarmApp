package com.fatihbaser.alarmapp.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fatihbaser.alarmapp.ui.theme.AlarmAppTheme

@Composable
fun InputTimeTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    hint: String = "00",
    maxLines: Int = 1,
    maxCharacter: Int = 2
){
    var isFocused by remember {
        mutableStateOf(false)
    }
    val textStyle = MaterialTheme.typography.displayMedium.copy(
        fontSize = 52.sp,
        lineHeight = 62.sp,
        color = MaterialTheme.colorScheme.primary
    )
    val shape = RoundedCornerShape(10.dp)
    val focusedBorderModifier = if (isFocused) {
        modifier.border(2.dp, MaterialTheme.colorScheme.primary, shape = shape)
    } else {
        modifier
    }

    BasicTextField(
        value=value,
        onValueChange= {
            if (it.length <= maxCharacter) {
                onValueChange(it)
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        textStyle = textStyle,
        maxLines = maxLines,
        decorationBox = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .clip(shape)
                    .background(MaterialTheme.colorScheme.surface),
                contentAlignment = Alignment.Center
            ){
                if(value.isBlank()&&!isFocused){
                    Text(
                        text = hint,
                        style = textStyle,
                        color = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
                else if (value.isNotBlank()){
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.5f),
                        contentAlignment = Alignment.Center
                    ){
                        it()
                    }
                }
            }

        },
        modifier = modifier
            .onFocusChanged {
                isFocused = it.isFocused
            }
            .then(focusedBorderModifier),
        cursorBrush = SolidColor(Color.Transparent)
    )

}
@Preview
@Composable
private fun InputTimeTextFieldPreview() {
    AlarmAppTheme() {
        InputTimeTextField(
            value = "",
            onValueChange = {}
        )
    }
}