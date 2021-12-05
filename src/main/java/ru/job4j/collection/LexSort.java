package ru.job4j.collection;

import java.util.*;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftStr = left.split(". ");
        String[] rightStr = right.split(". ");
        int numberLeft = Integer.parseInt(leftStr[0]);
        int numberRight = Integer.parseInt(rightStr[0]);
        return Integer.compare(numberLeft, numberRight);
    }
}


