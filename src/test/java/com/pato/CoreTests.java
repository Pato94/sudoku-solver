package com.pato;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.OptionalInt;

import static org.junit.Assert.assertEquals;

/**
 * Created by Pato on 10/2/16.
 */
public class CoreTests {

    @Before
    public void setUp() {

    }

    @Test
    public void testCanFindEmptyPositionsForASquare() {
        Square square = new Square(
                OptionalInt.of(1), OptionalInt.empty(), OptionalInt.empty(),
                OptionalInt.empty(), OptionalInt.of(2), OptionalInt.of(4),
                OptionalInt.of(9), OptionalInt.empty(), OptionalInt.of(7)
        );

        List<Coordinate> emptyPositions = square.locateEmptyPositions();

        assertEquals(4, emptyPositions.size());
        assertEquals(new Integer(0), emptyPositions.get(0).getX());
        assertEquals(new Integer(1), emptyPositions.get(0).getY());
        assertEquals(new Integer(0), emptyPositions.get(1).getX());
        assertEquals(new Integer(2), emptyPositions.get(1).getY());
        assertEquals(new Integer(1), emptyPositions.get(2).getX());
        assertEquals(new Integer(0), emptyPositions.get(2).getY());
        assertEquals(new Integer(2), emptyPositions.get(3).getX());
        assertEquals(new Integer(1), emptyPositions.get(3).getY());
    }
}
