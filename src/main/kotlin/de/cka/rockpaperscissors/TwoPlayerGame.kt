package de.cka.rockpaperscissors

/**
 * A game of Rock-Paper-Scissors for two players which is repeatedly
 * played over the given number of rounds.
 */
class TwoPlayerGame(
    private val player1: Player,
    private val player2: Player,
    private val numberOfRounds: Int
) {

    private var playedRounds = 0

    fun simulate() {
        repeat(numberOfRounds) { playRound() }
    }

    private fun playRound() {
        val choice1 = player1.choose()
        val choice2 = player2.choose()

        when {
            choice1.beats(choice2) -> {
                player1.wins()
                player2.loses()
            }
            choice2.beats(choice1) -> {
                player1.loses()
                player2.wins()
            }
            else -> {
                player1.draws()
                player2.draws()
            }
        }
        playedRounds++
    }

    fun getStatistics(): String =
        "Played rounds: $playedRounds\n\n${player1.getStatistics()}\n\n${player2.getStatistics()}\n"
}


