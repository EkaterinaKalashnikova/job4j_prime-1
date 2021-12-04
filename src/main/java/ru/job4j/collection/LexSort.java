package ru.job4j.collection;

import java.util.*;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftStr = left.split(". ");
        String[] rightStr = right.split(". ");
        int numberLeft = Integer.parseInt(leftStr[0]);
        int numberRight = Integer.parseInt(rightStr[0]);
        int result = Integer.compare(numberLeft, numberRight);
        int rsl = (numberLeft == numberRight) ? 0 : -2;
        return (rsl == 0) ? rsl : result;
    }
}


