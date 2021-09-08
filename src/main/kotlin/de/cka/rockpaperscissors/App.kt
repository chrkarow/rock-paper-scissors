package de.cka.rockpaperscissors

fun main() {
    val game = TwoPlayerGame(
        player1 = Player(strategy = OnlyRockStrategy, name = "Player 1"),
        player2 = Player(strategy = RandomStrategy, name = "Player 2"),
        numberOfRounds = 100
    )

    game.simulate()
    println(game.getStatistics())
}
