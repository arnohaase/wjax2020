package com.ajjpj.javalib.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamUeberblick {

    @Test
    void stream() {
        List.of(1,2,3).stream(); // tut nichts
        List.of(1,2,3).stream().forEach(System.out::println);
        Stream.of(1,2,3).forEach(i -> System.out.println(i));
    }

    @Test
    void streamFilter() {
        Stream.of(1,2,3,4,5,6,7,8)
                .filter(i -> i%2==0)
                .forEach(System.out::println);
    }
    @Test
    void streamFilterMap() {
        Stream.of(1,2,3,4,5,6,7,8)
                .filter(i -> i%2==0)
                .map(i -> mapToString(i, " ist gerade"))
                .forEach(System.out::println);
    }

    String mapToString(int i, String nachricht) {
        String integertAsString = String.valueOf(i);
        return integertAsString + nachricht;
    }

    @Test
    void streamCollect() {
        List<Integer> gerade = Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
        gerade.stream().forEach(System.out::println);
    }

    @Test
    void streamCollectSet() {
        Set<Integer> gerade = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6)
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toSet());
        gerade.stream().forEach(System.out::println);
    }

    @Test
    void streamCollectDistinc() {
        List<Integer> gerade = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8)
                .filter(i -> i % 2 == 0)
                .distinct()
                .collect(Collectors.toList());
        gerade.stream().forEach(System.out::println);
    }

    @Test
    void streamCollectTypeCast() {
        List<Number> numbers = new ArrayList<>();
        numbers.add(Long.valueOf(1));
        numbers.add(Integer.valueOf(2));
        List<Long> longs = numbers.stream()
                .filter(i -> i != null)
                .filter(i -> i instanceof Long)
                .map(i -> (Long) i)
                .collect(Collectors.toList());
        longs.stream().forEach(System.out::println);
    }

    @Test
    void streamFindAndCount() {
        int any = Stream.of(1, 2, 3, 4, 5, 6, 7, 8).findAny().orElse(-1);
        int first = Stream.of(1, 2, 3, 4, 5, 6, 7, 8).findFirst().orElse(-1);
        long count = Stream.of(1, 2, 3, 4, 5, 6, 7, 8).count();
        System.out.println(any+"/"+first+"/"+count);
    }

    // Liste mit Namen, nach präfixen (optional mit Regex)
    // * wie viele dieser namen gibt es in der Liste der Namen
    // Satz zerlegen un in eine map zu collection länge -> Set<wort>
    // Collectors.toMap()

}

