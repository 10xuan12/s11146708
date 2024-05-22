package tw.edu.pu.s1114670.s11146708

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    var isAuthorView by remember { mutableStateOf(false) }
    var imageRes by remember { mutableIntStateOf(R.drawable.service) }
    val alpha: Float by animateFloatAsState(
        targetValue = if (isAuthorView) 1f else 0f,
        animationSpec = tween(durationMillis = 3000), label = ""
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = if (isAuthorView) "關於App作者" else "瑪利亞基金會服務總覽")

        val image: Painter = painterResource(id = if (isAuthorView) R.drawable.author else imageRes)

        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.alpha(alpha)
        )

        Button(onClick = {
            isAuthorView = !isAuthorView
            imageRes = if (isAuthorView) {
                R.drawable.author
            } else {
                R.drawable.service
            }
        }) {
            Text(text = if (isAuthorView) "服務總覽" else "作者：資管系黃玟瑄")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun S11146708Preview() {
    MyApp()
}