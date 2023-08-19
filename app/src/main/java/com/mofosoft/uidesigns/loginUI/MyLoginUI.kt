package com.mofosoft.uidesigns.loginUI

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mofosoft.uidesigns.R
import com.mofosoft.uidesigns.ui.theme.UIDesignsTheme


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyLoginUI(){

    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    UIDesignsTheme(
        darkTheme = false
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Column(
                            modifier = Modifier.weight(0.8f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                contentAlignment = Alignment.BottomCenter
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.wave),
                                    contentDescription = "wave",
                                    contentScale = ContentScale.Crop
                                )

                                Image(
                                    painter = painterResource(id = R.drawable.logo_s),
                                    contentDescription = "wave"
                                )
                            }

                        }
                        Column(
                            modifier = Modifier.weight(1f)
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Log in",
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp
                            )
                            Spacer(modifier = Modifier.padding(10.dp))
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .imePadding()
                                    .fillMaxSize()

                            ) {
                                TextField(
                                    value = name,
                                    onValueChange = { name = it },
                                    label = { Text(text = "Username") },
                                    leadingIcon = {
                                        Icon(
                                            painter = painterResource(id = R.drawable.baseline_person_24),
                                            contentDescription = "person"
                                        )
                                    },
                                    keyboardOptions = KeyboardOptions(
                                        imeAction = ImeAction.Next,
                                        keyboardType = KeyboardType.Text
                                    ),
                                    colors = TextFieldDefaults.textFieldColors(
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent
                                    ),
                                    singleLine = true,
                                    modifier = Modifier
                                        .fillMaxWidth(0.7f),
                                    shape = RoundedCornerShape(8.dp)
                                )
                                Spacer(modifier = Modifier.padding(10.dp))
                                TextField(
                                    value = password,
                                    onValueChange = { password = it },
                                    label = { Text(text = "Password") },
                                    leadingIcon = {
                                        Icon(
                                            painter = painterResource(id = R.drawable.baseline_lock_24),
                                            contentDescription = "lock"
                                        )
                                    },
                                    keyboardOptions = KeyboardOptions(
                                        imeAction = ImeAction.Done,
                                        keyboardType = KeyboardType.Password
                                    ),
                                    colors = TextFieldDefaults.textFieldColors(
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent
                                    ),
                                    visualTransformation = PasswordVisualTransformation(),
                                    singleLine = true,
                                    modifier = Modifier
                                        .fillMaxWidth(0.7f),
                                    shape = RoundedCornerShape(8.dp)
                                )
                                Spacer(modifier = Modifier.padding(10.dp))
                                Button(
                                    onClick = { /*TODO*/ },
                                    modifier = Modifier.fillMaxWidth(0.75f),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(red=187, green = 134, blue = 252)
                                    )
                                ) {
                                    Text(text = "Log in")

                                }
                                Spacer(modifier = Modifier.padding(10.dp))
                                Text(text = "or")
                                Spacer(modifier = Modifier.padding(10.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(0.7f),
                                    horizontalArrangement = Arrangement.SpaceEvenly,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Button(
                                        onClick = { /*TODO*/ },
                                        shape = CircleShape,
                                        colors = ButtonDefaults.buttonColors(Color.White),
                                        elevation = ButtonDefaults.buttonElevation(10.dp),
                                        modifier = Modifier
                                            .size(50.dp)
                                            .padding(0.dp),
                                        contentPadding = PaddingValues(0.dp)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.icons_google),
                                            contentDescription ="google_icon"
                                        )
                                    }


                                    Button(
                                        onClick = { /*TODO*/ },
                                        shape = CircleShape,
                                        colors = ButtonDefaults.buttonColors(Color.White),
                                        elevation = ButtonDefaults.buttonElevation(10.dp),
                                        modifier = Modifier
                                            .size(50.dp)
                                            .padding(0.dp),
                                        contentPadding = PaddingValues(0.dp)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.icons_facebook),
                                            contentDescription ="facebook_icon"
                                        )
                                    }


                                    Button(
                                        onClick = { /*TODO*/ },
                                        shape = CircleShape,
                                        colors = ButtonDefaults.buttonColors(Color.White),
                                        elevation = ButtonDefaults.buttonElevation(10.dp),
                                        modifier = Modifier
                                            .size(50.dp),
                                        contentPadding = PaddingValues(0.dp)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.icons_twitter),
                                            contentDescription ="twitter_icon"
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.padding(10.dp))
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(text = "Don't have an account?")
                                    TextButton(
                                        onClick = { /*TODO*/ }
                                    ) {
                                        Text(text = "Register here")
                                    }
                                }
                            }
                        }

                    }
                }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun LoginUIPreview() {
    UIDesignsTheme {
        MyLoginUI()
    }
}