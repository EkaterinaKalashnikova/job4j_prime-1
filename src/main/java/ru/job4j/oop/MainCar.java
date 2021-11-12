package ru.job4j.oop;

public class MainCar {
    public static void main(String[] args) {
        Airplane airplane = new Airplane();
        Train train = new Train();
        Bus bus = new Bus();
        Vehicle vehicle1 = airplane;
        Vehicle vehicle2 = train;
        Vehicle vehicle3 = bus;
        Vehicle[] vehicles = new Vehicle[] {vehicle1, vehicle2, vehicle3};
        for (int i = 0; i < vehicles.length; i++) {
            vehicles[i].move();
            System.out.println(vehicles[i].colorDraw("white") + ", " + vehicles[i].marcaCar("mercedes"));
        }
    }
}

