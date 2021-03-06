package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return x - y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int a) {
        return x / a;
    }

    public int sumAllOperation(int x) {
        return divide(x) + minus(x) + multiply(x) + sum(x);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = sum(10);
        System.out.println(result);
        int result1 = minus(3);
        System.out.println(result1);
        int result2 = calculator.multiply(10);
        System.out.println(result2);
        int result3 = calculator.divide(5);
        System.out.println(result3);
        int result4 = calculator.sumAllOperation(2);
        System.out.println(result4);
    }
}
