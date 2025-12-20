package y2025

import com.vhra.aoc.y2025.PuzzleDay05
import com.vhra.aoc.y2025.TestUtils.getResource
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PuzzleDay05Test {
    @Test
    fun testSample01() {
       val result = PuzzleDay05().execute(getResource("/y2025/day05-sample01.txt"))
       assertEquals("3", result)
    }

    @Test
    fun testInput01() {
        val result = PuzzleDay05().execute(getResource("/y2025/day05-input01.txt"))
        assertEquals("848", result)
    }

    @Test
    fun testSample01Part2() {
        val result = PuzzleDay05().execute(getResource("/y2025/day05-sample01.txt"), isPart2 = true)
        assertEquals("14", result)
    }

    @Test
    fun testInput01Part2() {
        val result = PuzzleDay05().execute(getResource("/y2025/day05-input01.txt"), isPart2 = true)
        assertEquals("334714395325710", result)
    }
}