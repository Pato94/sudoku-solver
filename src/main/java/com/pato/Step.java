package com.pato;

import java.util.Stack;

/**
 * Created by Pato on 10/2/16.
 */
public class Step {

    private final Stack<Guess> guesses;
    private final Sudoku sudoku;

    public Step(Stack<Guess> guesses, Sudoku sudoku) {
        this.guesses = guesses;
        this.sudoku = sudoku;
    }

    public Stack<Guess> getGuesses() {
        return guesses;
    }

    public Sudoku getSudoku() {
        return sudoku;
    }
}
