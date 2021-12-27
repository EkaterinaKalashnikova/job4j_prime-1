package ru.job4j.lambda;

import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    private Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    public enum Value {
        V_6, V_7, V_8
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(suit1 -> Stream.of(Value.values()))
               /* .map(value1 -> new Card(suit1, value1))*/
                .forEach(System.out::println);
       /* for (Suit suit1 : Suit.values()) {
            for (Value value1 : Value.values()) {
                Card card = new Card(suit1, value1);
                System.out.println(card);
            }
        }*/
    }

    @Override
    public String toString() {
        return "Card {"
                + "suit =" + suit
                + ", value =" + value
                + '}';
    }
}

