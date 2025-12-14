package y2025

import com.vhra.aoc.y2025.PuzzleDay03
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import y2025.TestUtils.getResource

class PuzzleDay03Test {
    @Test
    fun testSample01() {
        val result = PuzzleDay03().execute(getResource("/y2025/day03-sample01.txt"))
        assertEquals("357", result)
    }

    @Test
    fun testInput01() {
        val result = PuzzleDay03().execute(getResource("/y2025/day03-input01.txt"))
        assertEquals("17346", result)
    }
 }