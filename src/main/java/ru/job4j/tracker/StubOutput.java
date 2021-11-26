package ru.job4j.tracker;

public class StubOutput implements Output {
    private boolean call = false;

    @Override
    public String name() {
        return "Stub output";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        call = true;
        return false;
    }

    public boolean isCall() {
        return call;
    }
}
