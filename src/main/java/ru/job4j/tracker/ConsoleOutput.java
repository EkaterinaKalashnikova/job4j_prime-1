package ru.job4j.tracker;

public class ConsoleOutput implements Output {
    private boolean call = false;

    public boolean isCall() {
        return call;
    }

    @Override
    public String name() {
        return " Console output";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        call = true;
        return false;
    }
}

