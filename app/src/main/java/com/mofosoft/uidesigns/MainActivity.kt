package com.mofosoft.uidesigns

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mofosoft.uidesigns.loginUI.MyLoginUI

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLoginUI()
        }
    }
}
