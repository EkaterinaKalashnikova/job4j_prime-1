package ru.job4j.tracker;

public interface Output {

    String name();

    boolean execute(Input input, Tracker tracker);
}
