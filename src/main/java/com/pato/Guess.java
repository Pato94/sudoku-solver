package com.pato;

/**
 * Created by Pato on 10/2/16.
 */
public class Guess {
    private final Integer value;
    private final AbsoluteCoordinate coordinate;

    public Guess(AbsoluteCoordinate coordinate, Integer value) {
        this.coordinate = coordinate;
        this.value = value;
    }

    public Sudoku apply(Sudoku sudoku) {
        Sudoku newSudoku = sudoku.duplicate();
        return newSudoku.set(coordinate, value);
    }

    public Integer getValue() {
        return value;
    }

    public AbsoluteCoordinate getCoordinate() {
        return coordinate;
    }
}
