package de.cka.rockpaperscissors

/**
 * Encapsulates the choosing logic. Extension point for more sophisticated strategies.
 */
interface ChoosingStrategy {
    val name: String
    fun choose(): GameElement
}

object OnlyRockChoosingStrategy : ChoosingStrategy {
    override val name: String = "Only Rock"
    override fun choose() = GameElement.ROCK
}

object RandomChoosingStrategy : ChoosingStrategy {
    override val name: String = "Random"
    override fun choose() = GameElement.values().random()
}
