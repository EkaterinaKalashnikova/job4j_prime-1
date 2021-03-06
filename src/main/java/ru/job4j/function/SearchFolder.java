package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SearchFolder {
    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        return new ArrayList<>(list).stream()
                .filter(pred)
                .collect(Collectors.toList());
    }
}

