package com.pato;

import org.jetbrains.annotations.Contract;

import java.util.LinkedList;
import java.util.List;
import java.util.OptionalInt;

/**
 * Created by Pato on 10/2/16.
 */
public class Square {

    private final OptionalInt[][] data;

    public Square(OptionalInt first, OptionalInt second, OptionalInt third,
                  OptionalInt fourth, OptionalInt fifth, OptionalInt sixth,
                  OptionalInt seventh, OptionalInt eighth, OptionalInt ninth) {
        this(new OptionalInt[][] {
                { first, second, third },
                { fourth, fifth, sixth },
                { seventh, eighth, ninth }
        });
    }

    public Square(OptionalInt[][] data) {
        this.data = data;
    }

    public OptionalInt[][] getData() {
        return data;
    }

    public Square duplicate() {
        OptionalInt[][] copiedData = new OptionalInt[3][3];
        for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++)
            copiedData[i][j] = data[i][j];

        return new Square(copiedData);
    }

    public List<Coordinate> locateEmptyPositions() {
        List<Coordinate> emptyPositions = new LinkedList<>();
        for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++)
            if (!data[i][j].isPresent()) emptyPositions.add(new Coordinate(i, j));

        return emptyPositions;
    }
}
