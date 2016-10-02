package com.pato;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Pato on 10/2/16.
 */
public class SquareRuleTests {

    private Fixture fixture;

    @Before
    public void setUp() {
        fixture = new Fixture();
    }

    @Test
    public void testAGoodSudokuShouldPass() {
        SquareRule squareRule = new SquareRule();

        assertTrue(squareRule.isSatisfiedBy(fixture.completeSudoku));
    }

    @Test
    public void testAWrongSudokuShouldNotPass() {
        SquareRule squareRule = new SquareRule();

        assertFalse(squareRule.isSatisfiedBy(fixture.wrongSudoku2));
    }

    @Test
    public void testAWrongSudokuWithoutSquareProblemShouldPass() {
        SquareRule squareRule = new SquareRule();

        assertTrue(squareRule.isSatisfiedBy(fixture.wrongSudoku1));
    }

    @Test
    public void testAnEmptySudokuShouldPass() {
        SquareRule squareRule = new SquareRule();

        assertTrue(squareRule.isSatisfiedBy(fixture.emptySudoku));
    }
}
