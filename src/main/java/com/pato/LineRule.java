package com.pato;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

/**
 * Created by Pato on 10/2/16.
 * This rules will return false if theres a line
 * which
 */
public class LineRule implements SudokuRule {

    @Override
    public boolean isSatisfiedBy(Sudoku sudoku) {
        // This should return false if theres a duplicate number for any line
        return !sudoku.lines().stream().anyMatch(line -> {
            List<OptionalInt> nonOptionals = line.stream()
                    .filter(OptionalInt::isPresent)
                    .collect(Collectors.toList());

            return Utils.hasDuplicates(nonOptionals);
        });
    }
}
