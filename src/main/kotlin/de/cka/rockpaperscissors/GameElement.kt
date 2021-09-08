package de.cka.rockpaperscissors

enum class GameElement(
    private val beatingRule: (GameElement) -> Boolean
) {
    ROCK(beatingRule = { it == SCISSORS }),
    PAPER(beatingRule = { it == ROCK }),
    SCISSORS(beatingRule = { it == PAPER });

    fun beats(other: GameElement) = beatingRule.invoke(other)
}
