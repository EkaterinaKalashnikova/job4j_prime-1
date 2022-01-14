package ru.job4j.io.exadel;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class Dog {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> input1 = new ArrayList<>();
        ArrayList<Integer> input2 = new ArrayList<>();
        int x = 0;
        int y = 0;
        try (BufferedReader in = new BufferedReader(new FileReader("C:\\projects\\job4j_primera\\src\\main\\java\\ru\\job4j\\io\\exadel\\input1.txt"))) {
            String str;
            while ((str = in.readLine()) != null) {
                String[] list = str.split(",");
                input1.add(Integer.parseInt(list[0]));
                input1.add(Integer.parseInt(list[1]));
                in.readLine();
                System.out.println(input1);
            }
            x = input1.get(0);
            y = input1.get(1);
            System.out.println(x);
            System.out.println(y);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try (BufferedReader in = new BufferedReader(new FileReader("C:\\projects\\job4j_primera\\src\\main\\java\\ru\\job4j\\io\\exadel\\input2.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\projects\\job4j_primera\\src\\main\\java\\ru\\job4j\\io\\exadel\\output.txt"))) {
                    String str;
                    while((str =in.readLine())!=null) {
                        for (int i = 0; i < str.length(); i++) {
                            if (i / x == 0) {
                                bw.write("Hot ");
                            }
                            if (i / y == 0) {
                                bw.write("Dog ");
                            }
                            if (i / x == 0 && i / y == 0) {
                                bw.write("HotDog ");
                            } else {
                                bw.write(i + " ");
                            }
                        }
                    }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/*1) Прочитайте X и Y из файла "input1.txt"

2) Перебрать целые числа из файла "input2.txt" и:

- Если целое число можно разделить на X, напечатайте "Hot" в "output.txt"

- Если целое число можно разделить на Y, напечатайте «Собака» в «output.txt».

- Если целое число можно разделить как на X, так и на Y, напечатайте «HotDog» в «output.txt».

- В противном случае вывести само целое число в "output.txt"

Результаты в файле "output.txt" должны быть разделены пробелом.

 */