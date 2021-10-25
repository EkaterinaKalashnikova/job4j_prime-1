package ru.job4j.tracker;

import java.time.LocalDateTime;

public class Item {
    int id;
    String name;
    LocalDateTime created = LocalDateTime.now();

    public Item() {

    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }
}



