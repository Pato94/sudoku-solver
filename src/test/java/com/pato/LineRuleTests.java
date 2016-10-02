package com.pato;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Pato on 10/2/16.
 */
public class LineRuleTests {
    private Fixture fixture;

    @Before
    public void setUp() {
        this.fixture = new Fixture();
    }

    @Test
    public void testAWrongSudokuShouldNotPassTheLineRule() {
        LineRule lineRule = new LineRule();

        assertFalse(lineRule.isSatisfiedBy(fixture.wrongSudoku1));
    }

    @Test
    public void testARightSudokuShouldPassTheLineRule() {
        LineRule lineRule = new LineRule();

        assertTrue(lineRule.isSatisfiedBy(fixture.completeSudoku));
        assertTrue(lineRule.isSatisfiedBy(fixture.wrongSudoku2));
    }

    @Test
    public void anEmptySudokuShouldPassTheLineRule() {
        LineRule lineRule = new LineRule();

        assertTrue(lineRule.isSatisfiedBy(fixture.emptySudoku));
    }
}
