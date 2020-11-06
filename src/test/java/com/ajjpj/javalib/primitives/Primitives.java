package com.ajjpj.javalib.primitives;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.jupiter.api.Test;

/**
 * @author arno
 */
public class Primitives {
    @Test
    void testPrimitives() {
        boolean bool = false;

        byte b = 0;
        short s = 0b0010_0010;
        int i = 1_000_000_000;
        long l = 0x1234;

        float f = 0;
        double d = 0;

        char ch = 0;

        l = i;
        d = f;
        d = i;

        i = (int) l;
    }

    @Test
    void testBoxing() {
        a(Integer.valueOf(99));
        b(10);

        Integer i=null;
        a(i);
    }

    void a(int i) {
        System.out.println(i);
    }
    void b(Integer i) {
        System.out.println(i);
    }

    @Test
    void testNumber() {
        Number n = Integer.valueOf(12);
    }

    @Test
    void testArrays() {
        int[] ints = new int[] {1, 2, 3};
        // geht nicht        Integer[] i2 = ints;

        // geht nicht       new ArrayList<int>();


        String[] strings = new String[] {"a", "b", "c"};
        Object[] objects = strings;

        objects[0] = 99;
    }

    @Test
    void testCharacter() {
        char ch = 'A'; //'\u1234';
        System.out.println(Character.getName(ch));
        System.out.println(Character.getDirectionality(ch));
        System.out.println(Character.isUpperCase(ch));
        System.out.println(Character.isWhitespace(ch));
    }

    Map<String,String> cache = new ConcurrentHashMap<>();

    @Test
    void testString() {
        String s = """
                Hallo
                   ihr 
                  alle                
                """;

        System.out.println(s);

        String name = "a.bc.def";
        System.out.println(name.replaceAll(".", "/"));        
        System.out.println(name.replaceAll("\\.", "/"));
        System.out.println(name.replace(".", "/"));

        String s2 = "a.bc.def";

        System.out.println(name == s2);

        String s3 = new StringBuilder("a.bc").append(".def").toString();
        String s4 = s3.intern();
        System.out.println(name == s3);
        System.out.println(name == s4);

        String s5 = cache.computeIfAbsent(s3, key -> key);

        String middle = name.substring(2, 4);
        System.out.println(middle);
        String whole = name.substring(0, name.length());
    }
}
