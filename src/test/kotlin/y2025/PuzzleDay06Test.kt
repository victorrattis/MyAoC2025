package y2025

import com.vhra.aoc.y2025.PuzzleDay06
import com.vhra.aoc.y2025.TestUtils.getResource
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PuzzleDay06Test {
    @Test
    fun testSample01() {
       val result = PuzzleDay06().execute(getResource("/y2025/day06-sample01.txt"))
       assertEquals("4277556", result)
    }

    @Test
    fun testInput01() {
        val result = PuzzleDay06().execute(getResource("/y2025/day06-input01.txt"))
        assertEquals("5877594983578", result)
    }
}