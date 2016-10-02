package com.pato;

import org.junit.Before;
import org.junit.Test;

import java.util.OptionalInt;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Pato on 10/2/16.
 */
public class SquareTests {

    @Before
    public void setUp() {

    }

    @Test
    public void testCanGetHorizontalLineFromASquare() {
        Square square = new Square(new OptionalInt[][] {
                { OptionalInt.of(1), OptionalInt.of(2), OptionalInt.of(3) },
                { OptionalInt.of(4), OptionalInt.of(5), OptionalInt.of(6) },
                { OptionalInt.of(7), OptionalInt.of(8), OptionalInt.of(9) }
        });

        assertEquals(3, square.getHorizontalLine(2).size());
        assertArrayEquals(
                new OptionalInt[] { OptionalInt.of(7), OptionalInt.of(8), OptionalInt.of(9) },
                square.getHorizontalLine(2).toArray());
    }

    @Test
    public void testCanGetVerticalLineFromASquare() {
        Square square = new Square(new OptionalInt[][] {
                { OptionalInt.of(1), OptionalInt.of(2), OptionalInt.of(3) },
                { OptionalInt.of(4), OptionalInt.of(5), OptionalInt.of(6) },
                { OptionalInt.of(7), OptionalInt.of(8), OptionalInt.of(9) }
        });

        assertEquals(3, square.getVerticalLine(2).size());
        assertArrayEquals(
                new OptionalInt[] { OptionalInt.of(3), OptionalInt.of(6), OptionalInt.of(9) },
                square.getVerticalLine(2).toArray());
    }
}
