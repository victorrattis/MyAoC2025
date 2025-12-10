package y2025

import com.vhra.aoc.y2025.PuzzleDay01
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.net.URL

fun getResource(resPath: String): URL = {}.javaClass.getResource(resPath)!!

class PuzzleDay01Test {
    @Test
    fun testSample01() {
        val result = PuzzleDay01().execute(getResource("/y2025/day01-sample01.txt"))
        assertEquals("3", result)
    }

    @Test
    fun testInput01() {
        val result = PuzzleDay01().execute(getResource("/y2025/day01-input01.txt"))
        assertEquals("1086", result)
    }

    @Test
    fun testSample01Part2() {
        val result = PuzzleDay01().execute(getResource("/y2025/day01-sample01.txt"), isPart2 = true)
        assertEquals("6", result)
    }

    @Test
    fun testInput01Part2() {
        val result = PuzzleDay01().execute(getResource("/y2025/day01-input01.txt"), isPart2 = true)
        assertEquals("6268", result)
    }
}