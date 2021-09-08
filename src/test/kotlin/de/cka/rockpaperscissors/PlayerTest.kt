package de.cka.rockpaperscissors

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

internal class PlayerTest {

    @Test
    internal fun `should get choice from strategy`() {

        // GIVEN
        val returnedGameElement = GameElement.PAPER
        val strategyMock = mock<Strategy> {
            on { choose() } doReturn returnedGameElement
        }

        val player = Player(
            strategy = strategyMock,
            name = "Test"
        )

        // WHEN
        val result = player.choose()

        // THEN
        assertThat(result).isEqualTo(returnedGameElement)
        verify(strategyMock).choose()
    }

    @Test
    internal fun `should produce correct statistics`() {

        // GIVEN
        val strategyName = "Test Strategy"
        val playerName = "Test Player"
        val player = Player(
            strategy = mock { on { name } doReturn strategyName },
            name = playerName
        )

        // WHEN
        player.wins()
        player.wins()
        player.draws()
        player.loses()
        player.loses()
        player.loses()
        val result = player.getStatistics()

        // THEN
        assertThat(result).isEqualTo(
            "Name:     $playerName\n" +
            "Strategy: $strategyName\n" +
            "Wins:     2\n" +
            "Draws:    1\n" +
            "Losses:   3"
        )
    }
}
