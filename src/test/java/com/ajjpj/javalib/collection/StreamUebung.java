package com.ajjpj.javalib.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Liste mit Namen, nach präfixen (optional mit Regex)
 * wie viele dieser namen gibt es in der Liste der Namen
 * Satz zerlegen un in eine map zu collection länge -> Set<wort>
 *     --> Collectors.toMap()
  */
public class StreamUebung {

    static String satz = "Die ist ein Satz mit mehreren Wörtern die kurz oder länglicher sind";

    @Test
    void names() {
        long namesWIthAl = Stream.of("Arno", "Heinz", "Alex", "Nico", "Alouise", "Alf")
                .filter(s -> s.startsWith("Al"))
                .count();
        System.out.println(namesWIthAl);
    }

    @Test
    void satzZerlegen() {
        Map<Integer, List<String>> laengeZuWort = Arrays.stream(satz.split(" "))
                .collect(Collectors.toMap(String::length, List::of, this::merge));
        System.out.println(laengeZuWort);
    }

    List<String> merge(List<String> l1, List<String> l2) {
        return Stream.of(l1, l2)
                     .flatMap(Collection::stream)
                     .collect(Collectors.toList());
    }

    @Test
    void satzZerlegenHinzufuegen() {
        // noch mal indem man eine mutable liste in der Map hat.
        // erlaubt nicht alles immer neu zusammenzuklopieren
        Map<Integer, List<String>> laengeZuWort = Arrays.stream(satz.split(" "))
                .collect(Collectors.toMap(String::length, this::mutableOf, this::mergeMutable));
        System.out.println(laengeZuWort);
    }

    List<String> mutableOf(String s) {
        List<String> l = new ArrayList<>();
        l.add(s);
        return l;
    }

    List<String> mergeMutable(List<String> l1, List<String> l2) {
        l1.addAll(l2);
        return l1;
    }

}
