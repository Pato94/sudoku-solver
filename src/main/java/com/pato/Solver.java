package com.pato;

import java.util.List;
import java.util.Stack;

/**
 * Created by Pato on 10/2/16.
 */
public class Solver {

    private final Guesser guesser;

    public Solver() {
        this.guesser = new Guesser();
    }

    public Sudoku solveSudoku(Sudoku sudoku) {
        Stack<Step> steps = new Stack<>();

        Sudoku solved = rSolveSudoku(steps, sudoku);

        System.out.print("SE RESOLVIO!");

        return solved;
    }

    private Sudoku rSolveSudoku(Stack<Step> steps, Sudoku sudoku) {
        List<AbsoluteCoordinate> emptyPositions = sudoku.locateEmptyPositions();

        if (emptyPositions.isEmpty()) {
            return sudoku; //The sudoku has been solved
        }

        Stack<Guess> guesses = findMinGuessingList(sudoku);

        if (guesses.isEmpty()) {
            while(steps.peek().getGuesses().isEmpty()) {
                steps.pop();
            }

            Step currentStep = steps.peek();
            Guess guess = currentStep.getGuesses().pop();
            Sudoku newSudoku = guess.apply(currentStep.getSudoku());

            return rSolveSudoku(steps, newSudoku);
        }

        Step step = new Step(guesses, sudoku);

        Guess guess = guesses.pop();
        Sudoku newSudoku = guess.apply(sudoku);
        steps.add(step);

        return rSolveSudoku(steps, newSudoku);
    }

    private Stack<Guess> findMinGuessingList(Sudoku sudoku) {

        List<Guess> guesses = guesser.guess(sudoku)
                .stream()
                .min((lhs, rhs) -> lhs.size() - rhs.size())
                .orElseThrow(() -> new RuntimeException("The sudoku was completed"));

        Stack<Guess> stack = new Stack<>();
        stack.addAll(guesses);

        return stack;
    }
}
