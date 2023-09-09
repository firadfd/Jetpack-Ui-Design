package com.example.uipractice.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun AppLogo(
    icon: Int
) {
    Box(
        Modifier
            .width(200.dp)
            .height(200.dp)
            .clip(shape = RoundedCornerShape(12.dp))
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun CustomTextField(
    hintText: String,
    icon: ImageVector,
    data: String,
    keyboardType: KeyboardType,
    capitalization: KeyboardCapitalization = KeyboardCapitalization.None,
    onDataChange: (String) -> Unit
) {
    val keyboardStatus = LocalSoftwareKeyboardController.current
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        singleLine = true,
        textStyle = TextStyle(color = Color.Black),
        value = data,
        placeholder = {
            Text(text = hintText, style = TextStyle(color = Color.Gray))
        },
        onValueChange = {
            onDataChange.invoke(it)
        },
        trailingIcon = {
            OutlineIcon(icon = icon)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            autoCorrect = true,
            capitalization = capitalization,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            keyboardStatus?.hide()
        })
    )
}
@Composable
fun OutlineIcon(icon: ImageVector) {
    Icon(imageVector = icon, contentDescription = null, tint = Color.Gray)
}

