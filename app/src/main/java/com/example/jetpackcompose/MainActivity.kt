package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignIn()
        }
    }

    @Preview
    @Composable
    fun DefaultPreview() {
        SignIn()
    }

    @Composable
    fun SignIn() {
        val gradientGrayWhite = Brush.verticalGradient(
            0f to White, 1000f to Blue
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(gradientGrayWhite)
                .padding(20.dp)
        ) {

            Text(
                modifier = Modifier
                    .padding(top = 150.dp),
                text = "Hi There!",
                color = Black,
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
            )
            Column(modifier = Modifier.align(Alignment.Center)) {
                UserInput()
                Spacer(modifier = Modifier.height(10.dp))
                UserInput()
            }
            BottomButton(modifier = Modifier.align(Alignment.BottomCenter))
        }
    }

    @Composable
    fun UserInput() {
        var userInput by remember {
            mutableStateOf("")
        }
        TextField(
            value = userInput,
            onValueChange = {
                userInput = it
            },
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                cursorColor = Black
            ),
            label = {
                Text("User name", color = Black)
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(20)
        )
    }

    @Composable
    fun BottomButton(
        modifier: Modifier = Modifier,
        buttonText: String = "Sign in"

    ) {
        Button(
            onClick = {},

            modifier = modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Black),
        )
        {
            Text(text = buttonText, color = White)
        }
    }
}