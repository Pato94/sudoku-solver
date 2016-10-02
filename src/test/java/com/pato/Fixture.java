package com.pato;

import java.util.OptionalInt;

/**
 * Created by Pato on 10/2/16.
 */
public class Fixture {

    public Sudoku emptySudoku;
    public Sudoku wrongSudoku2;
    public Sudoku completeSudoku;
    public Sudoku wrongSudoku1;
    public Square square1;
    public Square square2;
    public Square square3;
    public Square square4;
    public Square square5;
    public Square square6;
    public Square square7;
    public Square square8;
    public Square square9;
    public Square squareWrong1;
    public Square squareWrong3;
    public Square squareWrong2;
    public Square emptySquare;

    public Fixture() {
        createSquares();

        completeSudoku = new Sudoku(new Square[][] {
                { square1, square2, square3 },
                { square4, square5, square6 },
                { square7, square8, square9 }
        });

        wrongSudoku1 = new Sudoku(new Square[][] {
                { square4, square2, square3 },
                { square4, square5, square6 },
                { square7, square8, square9 }
        });

        wrongSudoku2 = new Sudoku(new Square[][] {
                { squareWrong1, squareWrong2, squareWrong3 },
                { squareWrong2, squareWrong3, squareWrong1 },
                { squareWrong3, squareWrong1, squareWrong2 }
        });

        emptySudoku = new Sudoku(new Square[][] {
                { emptySquare, emptySquare, emptySquare },
                { emptySquare, emptySquare, emptySquare },
                { emptySquare, emptySquare, emptySquare }
        });
    }

    private void createSquares() {
        emptySquare = new Square(
                OptionalInt.empty(), OptionalInt.empty(), OptionalInt.empty(),
                OptionalInt.empty(), OptionalInt.empty(), OptionalInt.empty(),
                OptionalInt.empty(), OptionalInt.empty(), OptionalInt.empty());

        square1 = new Square(
                OptionalInt.of(4), OptionalInt.of(3), OptionalInt.of(5),
                OptionalInt.of(6), OptionalInt.of(8), OptionalInt.of(2),
                OptionalInt.of(1), OptionalInt.of(9), OptionalInt.of(7));

        square2 = new Square(
                OptionalInt.of(2), OptionalInt.of(6), OptionalInt.of(9),
                OptionalInt.of(5), OptionalInt.of(7), OptionalInt.of(1),
                OptionalInt.of(8), OptionalInt.of(3), OptionalInt.of(4));

        square3 = new Square(
                OptionalInt.of(7), OptionalInt.of(8), OptionalInt.of(1),
                OptionalInt.of(4), OptionalInt.of(9), OptionalInt.of(3),
                OptionalInt.of(5), OptionalInt.of(6), OptionalInt.of(2));

        square4 = new Square(
                OptionalInt.of(8), OptionalInt.of(2), OptionalInt.of(6),
                OptionalInt.of(3), OptionalInt.of(7), OptionalInt.of(4),
                OptionalInt.of(9), OptionalInt.of(5), OptionalInt.of(1));

        square5 = new Square(
                OptionalInt.of(1), OptionalInt.of(9), OptionalInt.of(5),
                OptionalInt.of(6), OptionalInt.of(8), OptionalInt.of(2),
                OptionalInt.of(7), OptionalInt.of(4), OptionalInt.of(3));

        square6 = new Square(
                OptionalInt.of(3), OptionalInt.of(4), OptionalInt.of(7),
                OptionalInt.of(9), OptionalInt.of(1), OptionalInt.of(5),
                OptionalInt.of(6), OptionalInt.of(2), OptionalInt.of(8));

        square7 = new Square(
                OptionalInt.of(5), OptionalInt.of(1), OptionalInt.of(9),
                OptionalInt.of(2), OptionalInt.of(4), OptionalInt.of(8),
                OptionalInt.of(7), OptionalInt.of(6), OptionalInt.of(3));

        square8 = new Square(
                OptionalInt.of(3), OptionalInt.of(2), OptionalInt.of(6),
                OptionalInt.of(9), OptionalInt.of(5), OptionalInt.of(7),
                OptionalInt.of(4), OptionalInt.of(1), OptionalInt.of(8));

        square9 = new Square(
                OptionalInt.of(8), OptionalInt.of(7), OptionalInt.of(4),
                OptionalInt.of(1), OptionalInt.of(3), OptionalInt.of(6),
                OptionalInt.of(2), OptionalInt.of(5), OptionalInt.of(9));

        squareWrong1 = new Square(
                OptionalInt.of(1), OptionalInt.empty(), OptionalInt.empty(),
                OptionalInt.empty(), OptionalInt.of(1), OptionalInt.empty(),
                OptionalInt.empty(), OptionalInt.empty(), OptionalInt.of(1));

        squareWrong2 = new Square(
                OptionalInt.of(2), OptionalInt.empty(), OptionalInt.empty(),
                OptionalInt.empty(), OptionalInt.of(2), OptionalInt.empty(),
                OptionalInt.empty(), OptionalInt.empty(), OptionalInt.of(2));

        squareWrong3 = new Square(
                OptionalInt.of(3), OptionalInt.empty(), OptionalInt.empty(),
                OptionalInt.empty(), OptionalInt.of(3), OptionalInt.empty(),
                OptionalInt.empty(), OptionalInt.empty(), OptionalInt.of(3));
    }
}