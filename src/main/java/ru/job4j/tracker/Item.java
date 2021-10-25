package ru.job4j.tracker;

public class Item {
    int id;
    String name;

    public Item() {

    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }
}



