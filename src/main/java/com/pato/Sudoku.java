package com.pato;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

/**
 * Created by Pato on 10/2/16.
 */
public class Sudoku {

    private final Square[][] data;

    public Sudoku(Square first, Square second, Square third,
                  Square fourth, Square fifth, Square sixth,
                  Square seventh, Square eighth, Square ninth) {
        this(new Square[][]{
                { first, second, third },
                { fourth, fifth, sixth },
                { seventh, eighth, ninth }
        });
    }

    public Sudoku(Square[][] data) {
        this.data = data;
    }

    public Square[][] getData() {
        return data;
    }

    public Sudoku duplicate() {
        Square[][] copiedData = new Square[3][3];
        for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++)
            copiedData[i][j] = data[i][j].duplicate();

        return new Sudoku(copiedData);
    }

    public List<AbsoluteCoordinate> locateEmptyPositions() {
        List<AbsoluteCoordinate> results = new LinkedList<>();

        for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) {
            Coordinate sudokuCoordinate = new Coordinate(i, j);

            List<AbsoluteCoordinate> absoluteCoordinates = data[i][j].locateEmptyPositions().stream()
                    .map(coordinate -> new AbsoluteCoordinate(sudokuCoordinate, coordinate))
                    .collect(Collectors.toList());

            results.addAll(absoluteCoordinates);
        }

        return results;
    }

    public List<List<OptionalInt>> lines() {
        List<List<OptionalInt>> lines = new LinkedList<>();

        for (int i = 0; i < 9; i++) {
            lines.add(getHorizontalLine(i));
            lines.add(getVerticalLine(i));
        }

        return lines;
    }

    public List<OptionalInt> getHorizontalLine(int verticalIndex) {
        List<OptionalInt> line = new LinkedList<>();
        int quotient = verticalIndex / 3;
        int rest = verticalIndex % 3;
        for (int i = 0; i < 3; i++)
            line.addAll(data[quotient][i].getHorizontalLine(rest));

        return line;
    }

    public List<OptionalInt> getVerticalLine(int horizontalIndex) {
        List<OptionalInt> line = new LinkedList<>();
        int quotient = horizontalIndex / 3;
        int rest = horizontalIndex % 3;
        for (int i = 0; i < 3; i++)
            line.addAll(data[i][quotient].getVerticalLine(rest));

        return line;
    }

    public List<Square> getSquares() {
        List<Square> squares = new LinkedList<>();

        for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++)
            squares.add(data[i][j]);

        return squares;
    }


    public Sudoku set(AbsoluteCoordinate coordinate, Integer value) {
        Coordinate sudokuC = coordinate.getSudokuCoordinate();
        Coordinate squareC = coordinate.getSquareCoordinate();
        getData()[sudokuC.getX()][sudokuC.getY()].getData()[squareC.getX()][squareC.getY()] = OptionalInt.of(value);
        return this;
    }

    public void printStatus() {
        for (int i = 0; i < 9; i++) {
            getHorizontalLine(i)
                    .stream()
                    .map(optionalInt -> {
                        if (optionalInt.isPresent()) {
                            return String.valueOf(optionalInt.getAsInt());
                        } else {
                            return "-";
                        }
                    }).forEach(System.out::print);

            System.out.print("\n");
        }

    }
}
