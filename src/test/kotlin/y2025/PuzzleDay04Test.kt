package y2025

import com.vhra.aoc.y2025.PuzzleDay04
import com.vhra.aoc.y2025.TestUtils.getResource
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PuzzleDay04Test {
    @Test
    fun testSample01() {
        val result = PuzzleDay04().execute(getResource("/y2025/day04-sample01.txt"))
        assertEquals("13", result)
    }

    @Test
    fun testSInput01() {
        val result = PuzzleDay04().execute(getResource("/y2025/day04-input01.txt"))
        assertEquals("1393", result)
    }
}