package tw.edu.pu.s1114670.s11146708

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun IntroductionScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "嘿我是簡介",
            color = Color.Blue
        )
    }
}

@Composable
fun OrganizationScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "嘿我是主要機構",
            color = Color.Red
        )
    }
}

@Composable
fun SecondScreen(screenType: String) {
    when (screenType) {
        "簡介" -> IntroductionScreen()
        "主要機構" -> OrganizationScreen()
    }
}
