package com.example.weatherappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.weatherappui.screens.WeatherScreen
import com.example.weatherappui.ui.theme.WeatherAppUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppUiTheme {
                WeatherScreen()
            }
        }
    }
}