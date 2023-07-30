package files.app.roulette

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import files.app.roulette.ui.theme.DarkGreen
import files.app.roulette.ui.theme.Red
import kotlin.math.roundToInt

@Preview(showBackground = true)
@Composable
fun RouletteScreen() {
    var rotationValue by remember { mutableStateOf(0f) }
    var number by remember { mutableStateOf(0) }
    var indicatorColor by remember { mutableStateOf(DarkGreen) }
    val angle: Float by animateFloatAsState(
        targetValue = rotationValue,
        animationSpec = tween(durationMillis = 2000, easing = LinearOutSlowInEasing),
        finishedListener = {
            number = Numbers.getNumber(it)
            indicatorColor = Numbers.getColor(number)
        }
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight(0.25f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = number.toString(),
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .background(color = indicatorColor)
                        .padding(start = 5.dp)
                )
            }

        }
        Box(contentAlignment = Alignment.TopCenter, modifier = Modifier.fillMaxHeight(0.75f)) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(400.dp)
                    .rotate(angle),
                painter = painterResource(id = R.drawable.roulette),
                contentDescription = "Roulette"
            )
            Image(
                modifier = Modifier.size(70.dp),
                painter = painterResource(id = R.drawable.triangle),
                contentDescription = "triangle"
            )
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f), Alignment.BottomCenter
        ) {
            Button(
                onClick = {
                    rotationValue = (720..1080).random().toFloat() + angle
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Red)
            ) {
                Text(text = "Start", color = Color.White, fontSize = 25.sp)
            }
        }
    }
}