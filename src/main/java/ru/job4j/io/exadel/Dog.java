package ru.job4j.io.exadel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dog {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> input1 = new ArrayList<>();
        ArrayList<Integer> input2 = new ArrayList<>();
        int x = 0;
        int y = 0;
        try (BufferedReader in = new BufferedReader(new FileReader("C:\\projects\\job4j_primera\\src\\main\\java\\ru\\job4j\\io\\exadel\\input1.txt"))) {
            in.lines().forEach(System.out::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try (BufferedReader in = new BufferedReader(new FileReader("C:\\projects\\job4j_primera\\src\\main\\java\\ru\\job4j\\io\\exadel\\input2.txt"))) {
            in.lines().forEach(System.out::println);
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