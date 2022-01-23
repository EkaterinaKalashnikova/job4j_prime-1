package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key)  {
        if (!values.containsKey(key)) {
            throw new  IllegalArgumentException(String.format("Not key %s", values.isEmpty()));
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        for (String s : args) {
            String[] parts = s.split("=");
            String key = parts[ 0 ].substring(1);
            values.put(key, parts[ 1 ]);
        }
    }

    public static ArgsName of(String[] args, int i, String s) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"}, 4, "Something went wrong!!!");
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"}, 4, "Something went wrong!!!");
        System.out.println(jvm.get("out"));
    }
}
