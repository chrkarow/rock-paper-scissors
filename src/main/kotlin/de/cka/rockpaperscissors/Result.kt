package de.cka.rockpaperscissors

enum class Result(private val beatingRule: (Result) -> Boolean) {
    ROCK(beatingRule = { it == SCISSORS }),
    PAPER(beatingRule = { it == ROCK }),
    SCISSORS(beatingRule = { it == PAPER });

    fun beats(other: Result) = beatingRule.invoke(other)
}
