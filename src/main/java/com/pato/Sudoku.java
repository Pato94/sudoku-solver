package com.pato;

import java.util.LinkedList;
import java.util.List;
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
}
