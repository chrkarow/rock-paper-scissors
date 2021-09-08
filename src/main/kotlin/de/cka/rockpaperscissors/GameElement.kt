package de.cka.rockpaperscissors

/**
 * A GameElement (as it is called on wikipedia) of Rock-Paper-Scissors.
 * Each GameElement contains a rule in which case it wins.
 */
enum class GameElement(
    private val beatingRule: (GameElement) -> Boolean
) {
    ROCK(beatingRule = { it == SCISSORS }),
    PAPER(beatingRule = { it == ROCK }),
    SCISSORS(beatingRule = { it == PAPER });

    fun beats(other: GameElement) = beatingRule.invoke(other)
}
