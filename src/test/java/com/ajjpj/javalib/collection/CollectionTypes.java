package com.ajjpj.javalib.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionTypes {

    @Test
    public void testListAdd(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(5);
        list.add(1);
        list.add(2);
        list.add(2);
        System.out.println(list.get(3));
    }

    @Test
    public void testListOf(){
        List<Integer> list = List.of(1,1,1,2,3,5,23);
        System.out.println(list.get(3));
    }

    @Test
    public void testListUnmod() {
        List<Integer> list = List.of(1,1,1,2,3,5,23);
//        list.add(21);
        list = List.copyOf(list);
//                list.add(21);
        list = new ArrayList<>(list);
        list.add(21);
    }

    @Test
    public void testSetUnique() {
        Set<Integer> set = Set.of(1, 2, 3, 4, 1, 2, 3, 5);
        System.out.println(set.size());
    }

    @Test
    public void testSetUnique2() {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set.size());
    }

}
