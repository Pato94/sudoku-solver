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
        //Esto deberia preguntar dar false si hay repetidos en alguna linea
        return !sudoku.lines().stream().anyMatch(line -> {
            List<Integer> numbers = line.stream().filter(OptionalInt::isPresent)
                    .map(OptionalInt::getAsInt).collect(Collectors.toList());
            return numbers.stream().distinct().count() < numbers.size();
        });
    }
}
