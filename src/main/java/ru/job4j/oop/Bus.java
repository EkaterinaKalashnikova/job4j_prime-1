package ru.job4j.oop;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " везет пассажиров.");
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
