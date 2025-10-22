package com.aalh.firebase.presentation.initial

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aalh.firebase.R
import com.aalh.firebase.ui.theme.BackgroundButton
import com.aalh.firebase.ui.theme.Black
import com.aalh.firebase.ui.theme.Gray
import com.aalh.firebase.ui.theme.Green
import com.aalh.firebase.ui.theme.ShapeButton

@Preview()
@Composable
fun InitialScreen(navigateToLogin: () -> Unit = {}, navigateToSignUp: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Gray, Black), startY = 0f, endY = 600f)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Logo"
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            "Millions of songs.",
            color = Color.White,
            fontSize = 38.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            "Free on Spotify.",
            color = Color.White,
            fontSize = 38.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { navigateToSignUp() },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 32.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Green)
        ) {
            Text("Sign up free", color = Black, fontWeight = Bold)
        }
        Spacer(modifier = Modifier.height(8.dp))
        CustomButton(
            Modifier.clickable {},
            painterResource(R.drawable.ic_launcher_foreground),
            "Continue with Google"
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomButton(
            Modifier.clickable {},
            painterResource(R.drawable.ic_launcher_foreground),
            "Continue with Facebook"
        )
        Text(
            "Log in",
            fontWeight = Bold,
            color = Color.White,
            modifier = Modifier
                .padding(48.dp)
                .clickable {
                    navigateToLogin()
                }
        )
        Spacer(modifier = Modifier.weight(1f))
    }

}

@Composable
fun CustomButton(
    modifier: Modifier,
    painter: Painter,
    title: String
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 32.dp)
            .background(BackgroundButton)
            .border(2.dp, ShapeButton, CircleShape),
        contentAlignment = Alignment.CenterStart
    ) {
        Image(
            painter = painter,
            contentDescription = "",
            modifier = Modifier
                .padding(start = 10.dp)
                .size(48.dp)
        )
        Text(
            text = title,
            fontWeight = Bold,
            color = Color.White,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}