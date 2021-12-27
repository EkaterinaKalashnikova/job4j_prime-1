package ru.job4j.lambda;

import java.util.Arrays;
import java.util.stream.Stream;

import static ru.job4j.lambda.Suit.*;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(suit1 -> Stream.of(Value.values()))
                .map(value1 -> Arrays.toString(values()) + " " + value1)
                .forEach(System.out::println);
    }
}

