package com.ajjpj.javalib.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
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

    @Test
    public void testadding(){
        Set<Integer> set = new HashSet<>();
        System.out.println(set.add(1));
        System.out.println(set.add(2));
        System.out.println(set.add(3));
        System.out.println(set.add(1));
        System.out.println(set.add(2));
        System.out.println(set.add(3));
    }

    @Test
    public void testContainsSet(){
        Set<Integer> set = new HashSet<>();
        System.out.println(set.add(1));
        System.out.println(set.add(2));
        System.out.println(set.add(3));
        System.out.println(set.contains(2));
        System.out.println(set.contains(4));
    }

    @Test
    public void testContainsList(){
        Collection<Integer> list = new ArrayList<>();
        System.out.println(list.add(1));
        System.out.println(list.add(2));
        System.out.println(list.add(3));
        System.out.println(list.add(3));
        System.out.println(list.contains(2));
        System.out.println(list.contains(4));
    }

    @Test
    public void testCollectionApi(){
        Collection<Integer> collection = new ArrayList<>();
        System.out.println(collection.add(1));
        System.out.println(collection.add(2));
        System.out.println(collection.add(3));

//        collection.remove()
        for (Integer i : collection) {
            System.out.println(i);
        }
    }

    @Test
    public void testCollectionIterable () {
        Collection<Integer> collection = new ArrayList<>();
        System.out.println(collection.add(1));
        System.out.println(collection.add(2));
        System.out.println(collection.add(3));

        Iterator<Integer> iterator = collection.iterator();
        while(iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
            iterator.remove();
        }

    }

    @Test
    public void testCollectionFor () {
        List<Integer> list = new ArrayList<>();
        System.out.println(list.add(1));
        System.out.println(list.add(2));
        System.out.println(list.add(3));

        for (int i=list.size()-1; i>=0; i--) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void testSort() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        Collections.sort(list);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    @Test
    public void testIndexOf() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(3);

        System.out.println(list.indexOf(2));
        System.out.println(list.lastIndexOf(2));
    }

//    ## Übung: Funktion für eine Liste welche duplicate (und idixes?) zurückliefert

}
