package ru.job4j.io.exadel;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Text {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        try (Scanner scan = new Scanner(new FileInputStream("src/main/resources/input.txt"));
             BufferedWriter out2 = new BufferedWriter(new FileWriter("src/main/resources/output2.txt"));
             BufferedWriter out1 = new BufferedWriter(new FileWriter("src/main/resources/output1.txt"))
        ) {
            String string = scan.nextLine();
            String[] str = string.replaceAll(" ", "").split("");
            for (int i = 0; i < str.length; i++) {
                map.putIfAbsent(str[i], 0);
                map.replace(str[i], map.get(str[i]) + 1);
            }
            List<Map.Entry<String, Integer>> sortList = map.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .collect(Collectors.toList());
            sortList.forEach(m -> {
                try {
                    out2.write(m.getKey() + ":" + m.getValue() + " ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            Integer max = sortList.get(0).getValue();
            Set<String> deleteLetter = new HashSet<>();
            for (Map.Entry<String, Integer> entry : sortList) {
                if (max.equals(entry.getValue())) {
                    deleteLetter.add(entry.getKey());
                }
            }
            if (sortList.size() != deleteLetter.size()) {
                for (String t : deleteLetter) {
                    string = string.replaceAll(t, "");
                }
            }
            out1.write(string);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}

