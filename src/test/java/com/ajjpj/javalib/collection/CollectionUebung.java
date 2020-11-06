package com.ajjpj.javalib.collection;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionUebung {

    @Test
    public void findDuplicates(){
        List<Integer> list = List.of(1, 2, 3, 4, 5, 3, 4, 2, 3, 4);
        System.out.println("--- duplicates ---");
        for (int duplicate : duplicates(list)) {
            System.out.println(duplicate);
        }
        System.out.println("--- duplicatesSet ---");
        for (int duplicate : duplicatesSet(list)) {
            System.out.println(duplicate);
        }
        System.out.println("--- duplicateIndecies ---");
        for (int duplicate : duplicateIndecies(list)) {
            System.out.println(duplicate);
        }
    }

    /**
     * @return alle ellemente die es in der Liste mehr als einmal gibt
     */
    private Set<Integer> duplicates (List<Integer> list) {
        Set<Integer> duplicates = new HashSet<>();
        for (Integer value : list) {
            // nicht sehr performant aber wenn man die Indizes weiter braucht durchaus nützlich
            if (list.indexOf(value) != list.lastIndexOf(value)) {
                duplicates.add(value);
            }
        }
        return duplicates;
    }

    /**
     * @return alle ellemente die es in der Liste mehr als einmal gibt
     */
    private Set<Integer> duplicatesSet (List<Integer> list) {
        Set<Integer> duplicates = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        for (Integer value : list) {
            if (!seen.add(value)) {
                // war schon in dem set wurde also schon gesehen
                duplicates.add(value);
            }
        }
        return duplicates;
    }

    /**
     * @return alle index an denen duplikate vorkommen
     */
    private Set<Integer> duplicateIndecies (List<Integer> list) {
        Set<Integer> duplicateIndex = new HashSet<>();
        Map<Integer, Integer> valueToLastIndex = new HashMap<>();
        for (int index=0; index<list.size(); index++) {
            Integer value = list.get(index);
            Integer lastIndex = valueToLastIndex.put(value, index);
            if (lastIndex!=null) {
                // war schon mal gesehen worden mit dem index
                duplicateIndex.add(lastIndex);
                duplicateIndex.add(index);
            }
        }
        return duplicateIndex;
    }

}
