package com.pato;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Pato on 10/2/16.
 */
public class GuessTests {

    private Fixture fixture;

    @Before
    public void setUp() {
        this.fixture = new Fixture();
    }

    @Test
    public void testAGuessCanBeApplied() {
        Coordinate sudokuCoordinate = new Coordinate(0, 1);
        Coordinate squareCoordinate = new Coordinate(0, 2);
        AbsoluteCoordinate absCoordinate = new AbsoluteCoordinate(sudokuCoordinate, squareCoordinate);
        Guess aGuess = new Guess(absCoordinate, 5);

        assertEquals(2, fixture.almostCompleteSudoku.locateEmptyPositions().size());

        Sudoku newSudoku = aGuess.apply(fixture.almostCompleteSudoku);

        assertEquals(1, newSudoku.locateEmptyPositions().size());
    }

    @Test
    public void testAGuesserCanGuess() {
        Guesser guesser = new Guesser();
        List<List<Guess>> guesses = guesser.guess(fixture.almostCompleteSudoku);

        assertEquals(2, guesses.size());

        assertEquals(1, guesses.get(0).size());
        assertEquals(new Integer(5), guesses.get(0).get(0).getValue());

        assertEquals(1, guesses.get(1).size());
        assertEquals(new Integer(9), guesses.get(1).get(0).getValue());
    }
}
