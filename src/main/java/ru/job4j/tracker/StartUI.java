package ru.job4j.tracker;

import java.time.LocalDateTime;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        LocalDateTime created = item.getCreated();
        System.out.println(created);
    }
}
