package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Действие: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error error1 = new Error(true, 1, "отлично");
        Error error2 = new Error(true, 2, "хорошо");
        Error error3 = new Error(false, 10, "переделать");
        Error error4 = new Error();
        error1.printInfo();
        System.out.println();
        error2.printInfo();
        System.out.println();
        error3.printInfo();
        System.out.println();
        error4.printInfo();
    }
}


