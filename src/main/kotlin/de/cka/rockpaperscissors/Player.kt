package de.cka.rockpaperscissors

class Player(
    private val name: String,
    private val strategy: ChoosingStrategy,
) {

    private enum class GameResult {
        WIN, DRAW, LOSE;
    }

    private val results = mutableListOf<GameResult>()

    fun choose() = strategy.choose()

    fun wins() = results.add(GameResult.WIN)
    fun loses() = results.add(GameResult.LOSE)
    fun draws() = results.add(GameResult.DRAW)

    fun getStatistics(): String {
        return """
            Name:     $name
            Strategy: ${strategy.name}
            Wins:     ${results.count { it == GameResult.WIN }}
            Draws:    ${results.count { it == GameResult.DRAW }}
            Losses:   ${results.count { it == GameResult.LOSE }}
        """.trimIndent()
    }
}
