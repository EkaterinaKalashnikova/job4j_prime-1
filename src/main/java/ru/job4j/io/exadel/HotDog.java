package ru.job4j.io.exadel;

import java.io.*;
import java.util.Arrays;

public class HotDog {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        try (BufferedReader in = new BufferedReader(new FileReader("src/main/resources/input1.txt"))) {
            String str = in.readLine();
            String[] strings = str.split(",");
            x = Integer.parseInt(strings[0]);
            y = Integer.parseInt(strings[1]);
            System.out.println(x);
            System.out.println(y);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader in = new BufferedReader(new FileReader("src/main/resources/input2.txt"));
             BufferedWriter out = new BufferedWriter(new FileWriter("src/main/resources/output.txt"))) {
            String str = in.readLine();
            String[] strings = str.split(" ");
            System.out.println(Arrays.toString(strings));
            for (int i = 0; i < strings.length; i++) {
                int rsl = Integer.parseInt(strings[i]);
                if (rsl % x == 0) {
                    out.write("Hot");
                }
                if (rsl % y == 0) {
                    out.write("Dog");
                }
                if (rsl % x != 0 && rsl % y != 0) {
                    out.write(rsl + "");
                }
                out.write(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
