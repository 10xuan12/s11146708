package tw.edu.pu.s1114670.s11146708

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    var selectedOption by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { selectedOption = "TaichungLoveHome" }) {
                Text("台中市愛心家園")
            }
            Button(onClick = { selectedOption = "MariaAcademy" }) {
                Text("瑪利亞學園")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        when (selectedOption) {
            "TaichungLoveHome" -> {
                Text(
                    "台中市愛心家園經市政府公開評選後，委託瑪利亞基金會經營管理，於91年啟用，整棟建築物有四個樓層，目前開辦就醫、就養、就學、就業四大領域的十項業務，提供身心障礙者全方位的服務。",
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "長按以下圖片，可以觀看愛心家園地圖",
                    color = Color.Blue,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                val contextState by rememberUpdatedState(newValue = context)

                Image(
                    painter = painterResource(id = R.drawable.lovehome),
                    contentDescription = "Love Home",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onLongPress = {
                                    val intent = Intent(Intent.ACTION_VIEW).apply {
                                        data = Uri.parse("https://www.google.com/maps?q=台中市南屯區東興路一段450號")
                                    }
                                    contextState.startActivity(intent)
                                }
                            )
                        }
                )
            }
            "MariaAcademy" -> {
                Text(
                    "瑪利亞學園提供重度以及極重度多重障礙者日間照顧服務，以健康照護為基礎，支持生活多面向參與及學習概念，輔助發展重度身心障礙者自我概念為最終服務目標。",
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "雙擊以下圖片，可以觀看瑪利亞學園地圖",
                    color = Color.Blue,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.campus),
                    contentDescription = "Campus",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clickable {
                            val intent = Intent(Intent.ACTION_VIEW).apply {
                                data = Uri.parse("https://www.google.com/maps?q=台中市北屯區經貿東路365號")
                            }
                            context.startActivity(intent)
                        }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    S11146708Theme {
        MainScreen()
    }
}
