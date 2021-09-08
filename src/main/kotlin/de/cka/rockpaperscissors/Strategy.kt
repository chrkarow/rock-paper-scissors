package de.cka.rockpaperscissors

interface Strategy {
    val name: String
    fun choose(): GameElement
}

object OnlyRockStrategy : Strategy {
    override val name: String = "Only Rock"
    override fun choose() = GameElement.ROCK
}

object RandomStrategy : Strategy {
    override val name: String = "Random"
    override fun choose() = GameElement.values().random()
}
