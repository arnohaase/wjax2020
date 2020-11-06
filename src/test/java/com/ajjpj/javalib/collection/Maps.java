package com.ajjpj.javalib.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * @author arno
 */
public class Maps {
    @Test
    void testMaps() {
        Map<String, Integer> m = new HashMap<>();
        m.put("eins", 1);
        m.put("zwei", 2);

        System.out.println(m);
        System.out.println(m.get("eins"));
        System.out.println(m.get("drei"));
        System.out.println(m.containsKey("???"));
        m.put("???", null);
        System.out.println(m.get("drei"));
        System.out.println(m.containsKey("???"));

        Integer previous = m.put("eins", 1);
        System.out.println(previous);

        System.out.println(m.getOrDefault("drei", 3));
        System.out.println(m.containsKey("drei"));

        System.out.println(m.computeIfAbsent("drei", key -> 3));
        System.out.println(m.containsKey("drei"));
    }

    @Test
    void testMerge() {
        Map<String, Integer> m = new HashMap<>();
//        m.put("counter1", 0);
//        int old = m.get("counter1");
//        m.put("counter1", old + 5);

        System.out.println(m);
        m.merge("counter", 5, (prevValue, newValue) -> prevValue + newValue);
        System.out.println(m);
        m.merge("counter", 3, (prevValue, newValue) -> prevValue + newValue);
        System.out.println(m);
    }

    @Test
    void testInit() {
        Map<String, Long> numOfa = new HashMap<>();

        long l = numOfa.computeIfAbsent("Hallo ihr alle!", this::numberOfAs);
        System.out.println(l);
        l = numOfa.computeIfAbsent("Hallo ihr alle!", this::numberOfAs);
        System.out.println(l);
    }

    private long numberOfAs(String s) {
        System.out.println("calculating");
        return s.chars()
                .filter(i -> i == 'a')
                .count();
    }

    @Test
    void testOtherMethods() {
        Map<String,Integer> m = new HashMap<>();
        m.putIfAbsent("a", 1);
        m.replace("b", 1, 2);
//        m.computeIfPresent()
    }

    @Test
    void testCollections() {
        Map<String,Integer> m = Map.of("a", 1, "b", 2);

        for (Map.Entry<String,Integer> entry: m.entrySet()) {
            System.out.println(entry);
        }

        System.out.println(m.keySet());
        System.out.println(m.values());
        System.out.println(m.values().contains(2));
        System.out.println(m.containsValue(1));
    }

    // Übung: Teilnehmerverwaltung: eine Map mit "Veranstaltung" als Key, "Teilnehmerliste" als Value
    //  --> Teilnehmer einer Veranstaltung abfragen (--> nie null)
    //  --> Teilnehmer hinzufügen / entfernen (einzeln oder Listen von Teilnehmern)

    static class Teilnehmerverwaltung {
        private final Map<String, Set<String>> teilnehmerListen = new HashMap<>();

        Set<String> getTeilnehmer(String veranstaltung) {
            return teilnehmerListen.getOrDefault(veranstaltung, Set.of());
        }

        void addTeilnehmer(String veranstaltung, String teilnehmer) {
            addTeilnehmer(veranstaltung, Set.of(teilnehmer));
        }

        void addTeilnehmer(String veranstaltung, Set<String> teilnehmer) {
            // wir kopieren die Teilnehmer-Collection in ein neues Set um, damit sichergestellt ist,
            //  dass die Teilnehmerliste in der Map veränderlich ist
            teilnehmerListen
                    .computeIfAbsent(veranstaltung, key -> new HashSet<>())
                    .addAll(teilnehmer);
        }

        void removeTeilnehmer(String veranstaltung, String teilnehmer) {
            removeTeilnehmer(veranstaltung, Set.of(teilnehmer));
        }

        void removeTeilnehmer(String veranstaltung, Set<String> teilnehmer) {
            // wenn es die Veranstaltung noch nicht gibt, brauchen wir auch nichts zu tun
            teilnehmerListen
                    .computeIfPresent(veranstaltung, (key, aktuelleTeilnehmer) -> {
                        aktuelleTeilnehmer.removeAll(teilnehmer);
                        // Speicher aufräumen: wenn die Veranstaltung leer ist, dann entfernen wir sie aus der Map
                        return aktuelleTeilnehmer.isEmpty() ? null : aktuelleTeilnehmer;
                    });
        }
    }
}
