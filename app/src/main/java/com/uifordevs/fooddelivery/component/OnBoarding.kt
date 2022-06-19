package com.uifordevs.fooddelivery.component

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.uifordevs.fooddelivery.R.*

@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier, onCtaClicked :() -> Unit) {
    val view = LocalView.current
    val statusBarColor = MaterialTheme.colors.secondary.toArgb()
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = statusBarColor

            WindowCompat.getInsetsController(
                (view.context as Activity).window, view
            ).isAppearanceLightStatusBars = false
        }
    }

    Box(
        modifier = modifier
            .background(
                color = MaterialTheme.colors.secondary
            )
    ) {
        Image(
            modifier = modifier
                .fillMaxWidth()
                .align(
                    Alignment.BottomCenter
                ),
            painter = painterResource(id = drawable.ic_onboarding_bg),
            contentDescription = "Background",
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(
                    32.dp
                )
        ) {
            Image(
                modifier = modifier
                    .size(70.dp)
                    .background(
                        color = MaterialTheme.colors.primary,
                        shape = CircleShape
                    ),
                painter = painterResource(
                    id = drawable.ic_onboarding_logo
                ),
                contentDescription = "Logo",
            )
            Text(
                text = stringResource(
                    id = string.onboarding_title
                ),
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onSecondary
            )
            Spacer(
                modifier = Modifier.weight(1f)
            )
            Button(
                modifier = modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(60.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary,
                    contentColor = MaterialTheme.colors.onPrimary
                ),
                onClick = onCtaClicked,
            ) {
                Text(
                    text = stringResource(
                        id = string.onboarding_screen_button_text
                    ),
                )
            }
        }
    }
}