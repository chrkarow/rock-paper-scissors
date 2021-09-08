package de.cka.rockpaperscissors

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

internal class TwoPlayerGameTest {

    @Test
    internal fun `player 1 should win`() {

        // GIVEN
        val playerMock1 = mock<Player> { on { choose() } doReturn GameElement.PAPER }
        val playerMock2 = mock<Player> { on { choose() } doReturn GameElement.ROCK }

        val game = TwoPlayerGame(
            player1 = playerMock1,
            player2 = playerMock2,
            numberOfRounds = 1
        )

        // WHEN
        game.simulate()

        // THEN
        verify(playerMock1).wins()
        verify(playerMock2).loses()
    }

    @Test
    internal fun `player 2 should win`() {

        // GIVEN
        val playerMock1 = mock<Player> { on { choose() } doReturn GameElement.SCISSORS }
        val playerMock2 = mock<Player> { on { choose() } doReturn GameElement.ROCK }

        val game = TwoPlayerGame(
            player1 = playerMock1,
            player2 = playerMock2,
            numberOfRounds = 1
        )

        // WHEN
        game.simulate()

        // THEN
        verify(playerMock1).loses()
        verify(playerMock2).wins()
    }

    @Test
    internal fun `both player should draw`() {

        // GIVEN
        val playerMock1 = mock<Player> { on { choose() } doReturn GameElement.PAPER }
        val playerMock2 = mock<Player> { on { choose() } doReturn GameElement.PAPER }

        val game = TwoPlayerGame(
            player1 = playerMock1,
            player2 = playerMock2,
            numberOfRounds = 1
        )

        // WHEN
        game.simulate()

        // THEN
        verify(playerMock1).draws()
        verify(playerMock2).draws()
    }

    @Test
    internal fun `should produce correct statistics`() {
        // GIVEN
        val player1 = mock<Player> {
            on { getStatistics() } doReturn "Test1"
            on { choose() } doReturn GameElement.PAPER
        }
        val player2 = mock<Player> {
            on { getStatistics() } doReturn "Test2"
            on { choose() } doReturn GameElement.SCISSORS
        }

        val game = TwoPlayerGame(
            player1 = player1,
            player2 = player2,
            numberOfRounds = 2
        )

        // WHEN
        game.simulate()

        val result = game.getStatistics()

        // THEN
        assertThat(result).isEqualTo(
            "Played rounds: 2\n" +
            "\n" +
            "Test1\n" +
            "\n" +
            "Test2\n"
        )
    }
}
