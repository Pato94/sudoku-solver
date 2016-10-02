package com.pato;

import org.junit.Before;
import org.junit.Test;

import java.util.OptionalInt;

import static org.junit.Assert.assertEquals;

/**
 * Created by Pato on 10/2/16.
 */
public class CopyTests {

    @Before
    public void setUp() {

    }

    @Test
    public void testCanCopyASquare() {
        Square square = new Square(
                    OptionalInt.empty(), OptionalInt.empty(), OptionalInt.empty(),
                    OptionalInt.empty(), OptionalInt.empty(), OptionalInt.empty(),
                    OptionalInt.empty(), OptionalInt.empty(), OptionalInt.empty());

        OptionalInt[][] data = square.getData();

        Square newSquare = new Square(data);

        for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++)
            assertEquals(square.getData()[i][j], newSquare.getData()[i][j]);
    }

    @Test
    public void testCanCopyASudoku() {
        Square square = new Square(
                OptionalInt.empty(), OptionalInt.empty(), OptionalInt.empty(),
                OptionalInt.empty(), OptionalInt.empty(), OptionalInt.empty(),
                OptionalInt.empty(), OptionalInt.empty(), OptionalInt.empty());

        Sudoku sudoku = new Sudoku(
                square, square, square,
                square, square, square,
                square, square, square);

        Sudoku newSudoku = sudoku.duplicate();

        for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++)
            for (int k = 0; k < 3; k++) for (int l = 0; l < 3; l++)
                assertEquals(newSudoku.getData()[i][j].getData()[k][l],
                        sudoku.getData()[i][j].getData()[k][l]);
    }

    @Test
    public void testModifyingACopyDontModifyOriginalSquare() {
        Square square = new Square(
                OptionalInt.empty(), OptionalInt.empty(), OptionalInt.empty(),
                OptionalInt.empty(), OptionalInt.empty(), OptionalInt.empty(),
                OptionalInt.empty(), OptionalInt.empty(), OptionalInt.empty());

        Square newSquare = square.duplicate();

        newSquare.getData()[0][0] = OptionalInt.of(3);

        assertEquals(OptionalInt.empty(), square.getData()[0][0]);
        assertEquals(OptionalInt.of(3), newSquare.getData()[0][0]);
    }

    @Test
    public void testModyfingACopyDontModifyOriginalSudoku() {
        Square square = new Square(
                OptionalInt.empty(), OptionalInt.empty(), OptionalInt.empty(),
                OptionalInt.empty(), OptionalInt.empty(), OptionalInt.empty(),
                OptionalInt.empty(), OptionalInt.empty(), OptionalInt.empty());

        Sudoku sudoku = new Sudoku(
                square, square, square,
                square, square, square,
                square, square, square);

        Sudoku newSudoku = sudoku.duplicate();

        newSudoku.getData()[0][0].getData()[0][0] = OptionalInt.of(3);

        assertEquals(OptionalInt.empty(), sudoku.getData()[0][0].getData()[0][0]);
        assertEquals(OptionalInt.of(3), newSudoku.getData()[0][0].getData()[0][0]);
    }
}
