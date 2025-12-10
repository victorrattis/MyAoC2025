package com.vhra.aoc.y2025

import java.net.URL

private const val DIAL_RANGE = 100
private const val INITIAL_DIAL = 0

class PuzzleDay01 {
    fun execute(file: URL, isPart2: Boolean = false): String {
        return if (!isPart2) executePart1(file) else executePart2(file)
    }

    private fun executePart1(file: URL): String = file.readText()
        .split(System.lineSeparator())
        .map { it.first() to it.drop(1).toInt() }
        .map { Step(if (it.first == 'L') -1 else 1, it.second) }
        .fold(50 to 0) { acc, step ->
            var nextDial = acc.first + (step.rotate * step.side)
            nextDial %= DIAL_RANGE
            if (nextDial < INITIAL_DIAL) nextDial += DIAL_RANGE
            nextDial to (if (nextDial == INITIAL_DIAL) 1 else 0) + acc.second
        }.second.toString()

    private fun executePart2(file: URL): String = file.readText()
        .split(System.lineSeparator())
        .map { it.first() to it.drop(1).toInt() }
        .map { Step(if (it.first == 'L') -1 else 1, it.second) }
        .map { (side, rotate) -> (rotate / DIAL_RANGE) to Step(side, rotate % DIAL_RANGE) } // normalize and compute the rotation
        .fold(/* initial dial */ 50 to 0) { (dial, total), (count, step) ->
            var nextDial = dial + (step.rotate * step.side)
            var nextCount = total + count
            if (nextDial >= DIAL_RANGE) {
                if (dial != INITIAL_DIAL) nextCount++
                nextDial -= DIAL_RANGE
            } else if (nextDial < INITIAL_DIAL) {
                if (dial != INITIAL_DIAL) nextCount++
                nextDial += DIAL_RANGE
            } else if (nextDial == INITIAL_DIAL){
                if (dial != INITIAL_DIAL) nextCount++
            }
            nextDial to nextCount
        }.second.toString()

        private data class Step(val side: Int, val rotate: Int)
    }