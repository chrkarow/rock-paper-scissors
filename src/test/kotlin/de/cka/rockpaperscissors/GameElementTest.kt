package de.cka.rockpaperscissors

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GameElementTest{

    @Test
    internal fun `rock should beat scissors`() {

        // GIVEN
        val rock = GameElement.ROCK
        val scissors = GameElement.SCISSORS

        // WHEN
        val result = rock.beats(scissors)

        // THEN
        assertThat(result).isTrue
    }

    @Test
    internal fun `rock should not beat paper`() {

        // GIVEN
        val rock = GameElement.ROCK
        val paper = GameElement.PAPER

        // WHEN
        val result = rock.beats(paper)

        // THEN
        assertThat(result).isFalse

    }

    @Test
    internal fun `scissors should beat paper`() {
        // GIVEN
        val scissors = GameElement.SCISSORS
        val paper = GameElement.PAPER

        // WHEN
        val result = scissors.beats(paper)

        // THEN
        assertThat(result).isTrue
    }

    @Test
    internal fun `scissors should not beat rock`() {
        // GIVEN
        val scissors = GameElement.SCISSORS
        val rock = GameElement.ROCK

        // WHEN
        val result = scissors.beats(rock)

        // THEN
        assertThat(result).isFalse
    }

    @Test
    internal fun `paper should beat rock`() {
        // GIVEN
        val paper = GameElement.PAPER
        val rock = GameElement.ROCK

        // WHEN
        val result = paper.beats(rock)

        // THEN
        assertThat(result).isTrue
    }

    @Test
    internal fun `paper should not beat scissors`() {
        // GIVEN
        val paper = GameElement.PAPER
        val scissors = GameElement.SCISSORS

        // WHEN
        val result = paper.beats(scissors)

        // THEN
        assertThat(result).isFalse
    }
}
