package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int count) {
        this.load = count;
    }

    public void exchange(Battery another) {
        this.load = this.load - another.load;
        another.load += another.load;
    }

    public static void main(String[] args) {
        Battery first = new Battery(100);
        Battery second = new Battery(15);
        Battery thrid = new Battery(75);
        Battery fourth = new Battery(30);
        System.out.println("first : " + first.load + ". second : " + second.load);
        first.exchange(second);
        System.out.println("first : " + first.load + ". second : " + second.load);
        System.out.println();
        System.out.println("thrid : " + thrid.load + ". fourth : " + fourth.load);
        thrid.exchange(fourth);
        System.out.println("thrid : " + thrid.load + ". fourth : " + fourth.load);
    }
}

