package com.example.weatherappui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherappui.R
import com.example.weatherappui.ui.theme.ColorGradient1
import com.example.weatherappui.ui.theme.ColorGradient2
import com.example.weatherappui.ui.theme.ColorGradient3
import com.example.weatherappui.ui.theme.ColorImageShadow
import com.example.weatherappui.ui.theme.ColorSurface
import com.example.weatherappui.ui.theme.ColorTextPrimary
import com.example.weatherappui.ui.theme.ColorTextSecondary

@Composable
fun ActionBar(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ) {
        ControlButton()
        LocationInfo(
            modifier = Modifier.padding(top = 10.dp),
            location = "Rome"
        )
        ProfileButton()
    }
}

@Composable
fun LocationInfo(location: String, modifier: Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_location_pin),
                contentDescription = "location pin",
                modifier = Modifier
                    .height(18.dp),
                contentScale = ContentScale.FillHeight
            )
            Text(
                text = location,
                style = MaterialTheme.typography.titleLarge,
                color = ColorTextPrimary,
                fontWeight = FontWeight.Bold
            )
        }
        ProgressBar()
    }
}

@Composable
fun ProgressBar() {
    Box(
        modifier = Modifier
            .background(
                Brush.linearGradient(
                    0f to ColorGradient1,
                    0.25f to ColorGradient2,
                    1f to ColorGradient3
                ),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(vertical = 2.dp, horizontal = 10.dp)
    ) {
        Text(
            text = "Updating •",
            style = MaterialTheme.typography.labelSmall,
            color = ColorTextSecondary.copy(alpha = 0.7f)
        )
    }
}

@Composable
fun ProfileButton(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(48.dp)
            .border(
                width = 1.5.dp,
                color = ColorSurface,
                shape = CircleShape
            )
            .customShadow(
                color = ColorImageShadow,
                alpha = 0.7f,
                shadowRadius = 12.dp,
                borderRadius = 48.dp,
                offsetY = 6.dp
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_profile),
            contentDescription = "profile image",
            modifier = modifier
                .fillMaxSize()
                .clip(CircleShape)
        )
    }
}

@Composable
fun ControlButton() {
    Surface(
        color = ColorSurface,
        shape = CircleShape,
        modifier = Modifier
            .size(48.dp)
            .customShadow(
                color = Color.Black,
                alpha = 0.15f,
                shadowRadius = 16.dp,
                borderRadius = 48.dp,
                offsetY = 4.dp
            )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_control),
                contentDescription = "control button",
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Preview
@Composable
private fun ProgressBarPreview() {
    ProgressBar()
}

@Preview
@Composable
private fun LocationInfoPreview() {
    LocationInfo(
        location = "Rome",
        modifier = Modifier.padding(top = 10.dp)
    )
}

@Preview
@Composable
private fun ProfileButtonPreview() {
    ProfileButton()
}

@Preview
@Composable
private fun ControlButtonPreview() {
    ControlButton()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ActionBarPreview() {
    ActionBar()
}