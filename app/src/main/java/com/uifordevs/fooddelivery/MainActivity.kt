package com.uifordevs.fooddelivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import com.uifordevs.fooddelivery.component.Authentication
import com.uifordevs.fooddelivery.component.OnBoardingScreen
import com.uifordevs.fooddelivery.ui.theme.FoodDeliveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodDeliveryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Authentication()
                }
            }
        }
    }
}