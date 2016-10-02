package com.pato;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Pato on 10/2/16.
 */
public class SolverTests {

    private Fixture fixture;

    @Before
    public void setUp() {
        this.fixture = new Fixture();
    }

    @Test
    public void testASolverCanSolveSimpleSudokus() {
        Solver solver = new Solver();

        Sudoku sudoku = solver.solveSudoku(fixture.almostCompleteSudoku);

        assertEquals(0, sudoku.locateEmptyPositions().size());
    }

    @Test
    public void testASolverCanSolveHardSudokus() {
        Solver solver = new Solver();

        Sudoku sudoku = solver.solveSudoku(fixture.hardSudoku);

        assertEquals(0, sudoku.locateEmptyPositions().size());
    }
}
