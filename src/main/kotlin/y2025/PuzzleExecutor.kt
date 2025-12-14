package com.vhra.aoc.y2025

import java.net.URL
import kotlin.time.measureTime

abstract class PuzzleExecutor {
    fun execute(file: URL, isPart2: Boolean = false): String =
        executeInput(file.readText(), isPart2)

    protected abstract fun executeInput(file: String, isPart2: Boolean): String

    fun measureExecution(file: URL, isPart2: Boolean): String {
        val input = file.readText()
        return measureExecutionInternal {
            executeInput(input, isPart2)
        }
    }

    private fun measureExecutionInternal(execute: () -> String): String {
        var result: String
        return measureTime {
            result = execute()
        }.let {
            "{ time: $it, result: $result }"
        }
    }
}
