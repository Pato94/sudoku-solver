package com.pato;

/**
 * Created by Pato on 10/2/16.
 */
public class AbsoluteCoordinate {

    private final Coordinate sudokuCoordinate;
    private final Coordinate squareCoordinate;

    public AbsoluteCoordinate(Coordinate sudokuCoordinate,
                              Coordinate squareCoordinate) {
        this.sudokuCoordinate = sudokuCoordinate;
        this.squareCoordinate = squareCoordinate;
    }

    public Coordinate getSudokuCoordinate() {
        return sudokuCoordinate;
    }

    public Coordinate getSquareCoordinate() {
        return squareCoordinate;
    }
}
