package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // This commit is from android studio to github
            Text(text = "Basic Calculator", fontSize = 40.sp, color = Color.Black)

            var res by remember {
                mutableStateOf(0)
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {


                Text(text = "Enter Value 1", fontSize = 30.sp, color = Color.Red)
                var val1 by remember {
                    mutableStateOf("")
                }

                TextField(
                    value = val1,
                    onValueChange = { val1 = it },
                    Modifier.padding(vertical = 10.dp)
                )

                Text(text = "Enter Value 2", fontSize = 30.sp, color = Color.Red)
                var val2 by remember {
                    mutableStateOf("")
                }
                TextField(
                    value = val2,
                    onValueChange = { val2 = it },
                    Modifier.padding(vertical = 20.dp)
                )

                Row {
                    Row(Modifier.padding(vertical = 30.dp)) {
                        Button(
                            onClick = { res = (val1.toInt() + val2.toInt()) },
                            colors = ButtonDefaults.buttonColors(Color.Green)
                        ) {
                            Text(text = "Add +", fontSize = 30.sp, color = Color.Blue)
                        }

                        Button(
                            onClick = { res = (val1.toInt() - val2.toInt()) },
                            Modifier.padding(horizontal = 20.dp),
                            colors = ButtonDefaults.buttonColors(Color.Green)
                        ) {
                            Text(text = "Sub -", fontSize = 30.sp, color = Color.Blue)
                        }
                    }
                }

                Row(Modifier.padding(vertical = 10.dp)) {
                    Button(
                        onClick = { res = (val1.toInt() * val2.toInt()) },
                        colors = ButtonDefaults.buttonColors(Color.Green)
                    ) {
                        Text(text = "Mul *", fontSize = 30.sp, color = Color.Blue)
                    }

                    Button(
                        onClick = { res = (val1.toInt() / val2.toInt()) },
                        Modifier.padding(horizontal = 20.dp),
                        colors = ButtonDefaults.buttonColors(Color.Green)
                    ) {
                        Text(text = "Div/", fontSize = 30.sp, color = Color.Blue)
                    }
                }

                Text(text = "Result", fontSize = 30.sp, color = Color.Red)
                var ans by remember {
                    mutableStateOf("")
                }
                TextField(
                    value = res.toString(),
                    onValueChange = { ans = it },
                    Modifier.padding(vertical = 20.dp)
                )

            }

        }
    }
}
