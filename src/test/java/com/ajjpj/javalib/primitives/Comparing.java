package com.ajjpj.javalib.primitives;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

/**
 * @author arno
 */
public class Comparing {
    @Test
    void testComparator() {
        // *nicht* Comparable implementieren

        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0; // TODO kontextabhängige Reihenfolge implementieren
            }
        };
    }
}
