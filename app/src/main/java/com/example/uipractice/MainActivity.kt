package com.example.uipractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uipractice.screen.AppLogo
import com.example.uipractice.screen.CustomTextField
import com.example.uipractice.ui.theme.UIPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UIPracticeTheme {
                RootApp()
            }
        }
    }
}

@Composable
fun RootApp() {

    val name = remember {
        mutableStateOf("")
    }
    val email = remember {
        mutableStateOf("")
    }
    val phone = remember {
        mutableStateOf("")
    }
    val pass = remember {
        mutableStateOf("")
    }
    val checkStatus = remember {
        mutableStateOf(false)
    }

    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AppLogo(R.drawable.instagram)
            CustomTextField(
                "Full name", Icons.Default.Person, name.value, KeyboardType.Text,
                KeyboardCapitalization.Words
            ) {
                name.value = it
            }
            CustomTextField("Valid email", Icons.Default.Email, email.value, KeyboardType.Text) {
                email.value = it
            }
            CustomTextField("Phone number", Icons.Default.Phone, phone.value, KeyboardType.Number) {
                phone.value = it
            }
            CustomTextField(
                "Strong password",
                Icons.Default.Lock,
                pass.value,
                KeyboardType.Password
            ) {
                pass.value = it
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Checkbox(checked = checkStatus.value, onCheckedChange = {
                    checkStatus.value = it
                })
                Text(
                    text = "By checking the box you agree to our ",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        color = Color.Gray
                    )
                )
                Text(
                    text = " Terms ",
                    style = TextStyle(
                        fontSize = 9.sp,
                        fontWeight = FontWeight(400),
                        color = Color.Red
                    ),
                    modifier = Modifier.clickable {

                    }
                )
                Text(
                    text = " & ",
                    style = TextStyle(
                        fontSize = 9.sp,
                        fontWeight = FontWeight(400),
                        color = Color.Gray
                    )
                )
                Text(
                    text = " Conditions.",
                    style = TextStyle(
                        fontSize = 9.sp,
                        fontWeight = FontWeight(400),
                        color = Color.Red
                    ),
                    modifier = Modifier.clickable {

                    }
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedButton(
                onClick = {},
                modifier = Modifier
                    .width(300.dp)
                    .height(50.dp)
                    .clip(shape = RoundedCornerShape(25.dp))
                    .background(
                        color = Color.Unspecified
                    )
            ) {
                Text(
                    text = "Next",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(600),
                        color = Color.Cyan,
                    )
                )

            }

            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Already a member? ",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        color = Color.Gray
                    )
                )
                Text(
                    text = " Log In",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        color = Color.Red
                    ),
                    modifier = Modifier.clickable {

                    }
                )
            }
        }
    }
}
