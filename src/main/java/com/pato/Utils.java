package com.pato;

import java.util.List;

/**
 * Created by Pato on 10/2/16.
 */
public class Utils {

    public static boolean hasDuplicates(List<?> list) {
        return list.stream().distinct().count() < list.size();
    }
}
