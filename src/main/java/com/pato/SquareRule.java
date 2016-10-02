package com.pato;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

/**
 * Created by Pato on 10/2/16.
 */
public class SquareRule implements SudokuRule {
    @Override
    public boolean isSatisfiedBy(Sudoku sudoku) {
        //This should return false if theres a duplicate number in any square
        return !sudoku.getSquares().stream().anyMatch(square -> {
            List<OptionalInt> nonOptionals = square.getValues().stream()
                    .filter(OptionalInt::isPresent)
                    .collect(Collectors.toList());

            return Utils.hasDuplicates(nonOptionals);
        });
    }
}
