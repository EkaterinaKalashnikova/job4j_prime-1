package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passengers(int number) {
        System.out.println("Количество пассажиров: " + number);
    }

    @Override
    public int refuel(int fuel) {
        int price = 0;
        int tank = 50;
        if (fuel != 0) {
            price = fuel * tank;
        }
        return price;
    }
}
