package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biCon = (s, s1) -> System.out.println(s1);
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        int i = 1;
        for (Map.Entry<Integer, String> s : map.entrySet()) {
            biCon.accept(i++, " " + s);
        }

        BiPredicate<Integer, String> biPred = (j, s) -> j % 2 == 0 || s.length() == 4;
        for (Integer j : map.keySet()) {
            System.out.println(biPred.test(j, map.get(j)) + ": " + "key: " + j + " value: " + map.get(j));
        }

        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
        List<String> strings = sup.get();

        Consumer<String> con = System.out::println;
        Function<String, String> func = String::toUpperCase;
        for (String s : strings) {
            con.accept(s);
            System.out.println("Заменили на " + func.apply(s));
        }
    }
}

