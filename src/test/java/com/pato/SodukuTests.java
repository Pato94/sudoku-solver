package com.pato;

import org.junit.Before;
import org.junit.Test;

import java.util.OptionalInt;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Pato on 10/2/16.
 */
public class SodukuTests {

    @Before
    public void setUp() {

    }

    @Test
    public void testCanGetHorizontalLine() {
        Square square = new Square(new OptionalInt[][] {
                { OptionalInt.of(1), OptionalInt.of(2), OptionalInt.of(3) },
                { OptionalInt.of(4), OptionalInt.of(5), OptionalInt.of(6) },
                { OptionalInt.of(7), OptionalInt.of(8), OptionalInt.of(9) }
        });

        Sudoku sudoku = new Sudoku(new Square[][] {
                { square.duplicate(), square.duplicate(), square.duplicate() },
                { square.duplicate(), square.duplicate(), square.duplicate() },
                { square.duplicate(), square.duplicate(), square.duplicate() }
        });

        assertEquals(9, sudoku.getHorizontalLine(0).size());

        assertArrayEquals(new OptionalInt[] {
                OptionalInt.of(1), OptionalInt.of(2), OptionalInt.of(3),
                OptionalInt.of(1), OptionalInt.of(2), OptionalInt.of(3),
                OptionalInt.of(1), OptionalInt.of(2), OptionalInt.of(3)
        }, sudoku.getHorizontalLine(0).toArray());


        assertArrayEquals(new OptionalInt[] {
                OptionalInt.of(7), OptionalInt.of(8), OptionalInt.of(9),
                OptionalInt.of(7), OptionalInt.of(8), OptionalInt.of(9),
                OptionalInt.of(7), OptionalInt.of(8), OptionalInt.of(9)
        }, sudoku.getHorizontalLine(8).toArray());
    }

    @Test
    public void testCanGetVerticalLine() {
        Square square = new Square(new OptionalInt[][] {
                { OptionalInt.of(1), OptionalInt.of(2), OptionalInt.of(3) },
                { OptionalInt.of(4), OptionalInt.of(5), OptionalInt.of(6) },
                { OptionalInt.of(7), OptionalInt.of(8), OptionalInt.of(9) }
        });

        Sudoku sudoku = new Sudoku(new Square[][] {
                { square.duplicate(), square.duplicate(), square.duplicate() },
                { square.duplicate(), square.duplicate(), square.duplicate() },
                { square.duplicate(), square.duplicate(), square.duplicate() }
        });

        assertEquals(9, sudoku.getVerticalLine(0).size());

        assertArrayEquals(new OptionalInt[] {
                OptionalInt.of(1), OptionalInt.of(4), OptionalInt.of(7),
                OptionalInt.of(1), OptionalInt.of(4), OptionalInt.of(7),
                OptionalInt.of(1), OptionalInt.of(4), OptionalInt.of(7)
        }, sudoku.getVerticalLine(0).toArray());

        assertArrayEquals(new OptionalInt[] {
                OptionalInt.of(3), OptionalInt.of(6), OptionalInt.of(9),
                OptionalInt.of(3), OptionalInt.of(6), OptionalInt.of(9),
                OptionalInt.of(3), OptionalInt.of(6), OptionalInt.of(9)
        }, sudoku.getVerticalLine(8).toArray());
    }
}
