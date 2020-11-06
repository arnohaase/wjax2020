package com.ajjpj.javalib.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

public class ReflectionApi {

    @Test
    void testHolMirEineKlasse() throws ClassNotFoundException {
        Class<?> forName = Class.forName("java.lang.Exception");
        Class<?> contextClass = Thread.currentThread().getContextClassLoader().loadClass("java.lang.Exception");
        Class<Exception> asClass = Exception.class;

        System.out.println(forName.getName());
        System.out.println(contextClass.getSimpleName());
        System.out.println(asClass.getSimpleName());
    }

    @Test
    void testMethods() {
        Arrays.stream(Exception.class.getMethods()).forEach(System.out::println);
    }

    @Test
    void testDeclaredMethods() {
        Arrays.stream(HashMap.class.getDeclaredMethods()).forEach(System.out::println);
        // ähnlich auch mit fields
    }

    @Test
    void testAccess() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method method = ReflectionApi.class.getDeclaredMethod("testDeclaredMethods");
        System.out.println(method);
        method.setAccessible(true);
        method.invoke(new ReflectionApi());
    }

    @Test
    void testHierarchy() {
        Arrays.stream(MyImpl.class.getInterfaces()).forEach(System.out::println);
        Arrays.stream(MyImpl.class.getInterfaces()[0].getDeclaredAnnotations()).forEach(System.out::println);
        Arrays.stream(MyImpl.class.getInterfaces()[0].getAnnotations()).forEach(System.out::println);
        Arrays.stream(MyImpl.class.getDeclaredAnnotations()).forEach(System.out::println);
        Arrays.stream(MyImpl.class.getAnnotations()).forEach(System.out::println);
    }

}
