package y2025

import com.vhra.aoc.y2025.PuzzleDay02
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PuzzleDay02Test {
    @Test
    fun testSample01() {
        val result = PuzzleDay02().execute(getResource("/y2025/day02-sample01.txt"))
        assertEquals("1227775554", result)
    }

    @Test
    fun testInput01() {
        val result = PuzzleDay02().execute(getResource("/y2025/day02-input01.txt"))
        assertEquals("24747430309", result)
    }

    @Test
    fun testSample01Part2() {
        val result = PuzzleDay02().execute(getResource("/y2025/day02-sample01.txt"), isPart2 = true)
        assertEquals("4174379265", result)
    }
}