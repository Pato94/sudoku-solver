package com.pato;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Pato on 10/2/16.
 */
public class Guesser {

    private final List<SudokuRule> rules;

    public Guesser() {
        this.rules = Arrays.asList(new LineRule(), new SquareRule());
    }

    public List<List<Guess>> guess(Sudoku sudoku) {
        List<AbsoluteCoordinate> emptyPositions = sudoku.locateEmptyPositions();

        return emptyPositions.stream()
                .map(coordinate -> doGuessing(coordinate, sudoku))
                .collect(Collectors.toList());
    }

    private List<Guess> doGuessing(AbsoluteCoordinate coordinate, Sudoku sudoku) {
        return Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .stream()
                .map(value -> new Guess(coordinate, value))
                .filter(guess ->
                    rules.stream().allMatch(rule -> rule.isSatisfiedBy(guess.apply(sudoku))))
                .collect(Collectors.toList());
    }
}
