package files.app.roulette

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import files.app.roulette.ui.theme.Green
import files.app.roulette.ui.theme.RouletteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RouletteTheme {
                Surface(
                    Modifier.fillMaxSize(),
                    color = Green
                ) {
                    RouletteScreen()
                }
            }
        }
    }
}