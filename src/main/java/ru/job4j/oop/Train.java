package ru.job4j.oop;

public class Train implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " и вагонов 15 штук.");
    }

    @Override
    public String colorDraw(String color) {
        return color;
    }

    @Override
    public String marcaCar(String model) {
        return model;
    }
}
