package de.cka.rockpaperscissors

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResultTest{

    @Test
    internal fun `Rock should beat Scissors`() {

        // GIVEN
        val rock = Result.ROCK
        val scissors = Result.SCISSORS

        // WHEN
        val result = rock.beats(scissors)

        // THEN
        assertThat(result).isTrue
    }

    @Test
    internal fun `Rock should not beat Paper`() {

        // GIVEN
        val rock = Result.ROCK
        val paper = Result.PAPER

        // WHEN
        val result = rock.beats(paper)

        // THEN
        assertThat(result).isFalse

    }

    @Test
    internal fun `Scissors should beat Paper`() {
        // GIVEN
        val scissors = Result.SCISSORS
        val paper = Result.PAPER

        // WHEN
        val result = scissors.beats(paper)

        // THEN
        assertThat(result).isTrue
    }

    @Test
    internal fun `Scissors should not beat Rock`() {
        // GIVEN
        val scissors = Result.SCISSORS
        val rock = Result.ROCK

        // WHEN
        val result = scissors.beats(rock)

        // THEN
        assertThat(result).isFalse
    }

    @Test
    internal fun `Paper should beat Rock`() {
        // GIVEN
        val paper = Result.PAPER
        val rock = Result.ROCK

        // WHEN
        val result = paper.beats(rock)

        // THEN
        assertThat(result).isTrue
    }

    @Test
    internal fun `Paper should not beat Scissors`() {
        // GIVEN
        val paper = Result.PAPER
        val scissors = Result.SCISSORS

        // WHEN
        val result = paper.beats(scissors)

        // THEN
        assertThat(result).isFalse
    }
}
