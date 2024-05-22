package tw.edu.pu.s1114670.s11146708

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tw.edu.pu.s1114670.s11146708.ui.theme.S11146708Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            S11146708Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    var selectedScreen by remember { mutableStateOf("簡介") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()
    ) {
        TopImage()

        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { selectedScreen = "簡介" }) {
                Text("顯示簡介")
            }
            Button(onClick = { selectedScreen = "主要機構" }) {
                Text("顯示主要機構")
            }
        }

        SecondScreen(selectedScreen)
    }
}

@Composable
fun TopImage() {
    Image(
        painter = painterResource(id = R.drawable.maria),
        contentDescription = null,
        modifier = Modifier
            .width(150.dp)
            .height(100.dp),
        contentScale = ContentScale.Fit
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    S11146708Theme {
        MainScreen()
    }
}
