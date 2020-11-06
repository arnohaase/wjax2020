package com.ajjpj.javalib.primitives;

import java.util.Optional;

import org.junit.jupiter.api.Test;

/**
 * @author arno
 */
public class Optionals {
    Optional<String> optionalField = Optional.of("asdf");

    void myMethod(Optional<String> optionalAsParameter) {
        System.out.println(optionalAsParameter);
    }

    @Test
    void testOptional() {
        Optional<?> o1 = Optional.empty();
        System.out.println(o1.isEmpty());

        Optional<String> o2 = Optional.of("hi");
        System.out.println(o2.isPresent());
        System.out.println(o2.get());

        // NullPointerException Optional.of(null);
        Optional<?> o3 = Optional.ofNullable(null);
        System.out.println(o3.isEmpty());

        System.out.println("---------------");

        o2.filter(s -> s.startsWith("h")) //x"))
                .map(s -> s.toUpperCase())
                .ifPresent(System.out::println);
    }
}
