package files.app.roulette

import androidx.compose.ui.graphics.Color
import files.app.roulette.ui.theme.DarkGreen
import files.app.roulette.ui.theme.LightRed
import kotlin.math.roundToInt

object Numbers {
    private val list = listOf(
        0, 32, 15, 19, 4, 21, 2, 25, 17, 34, 6, 27, 13, 36, 11, 30, 8, 32, 10,
        5, 24, 16, 33, 1, 20, 14, 31, 9, 22, 18, 29, 7, 28, 12, 35, 3, 26
    )

    fun getNumber(angle: Float): Int {
        val index = (360 - (angle % 360)) / (360.0 / Numbers.list.size)
        return list[index.roundToInt()]
    }

    fun getColor(number: Int): Color {
        val index = list.indexOf(number)
        return if (index == 0) DarkGreen else if (index % 2 == 0) Color.Black else LightRed
    }
}