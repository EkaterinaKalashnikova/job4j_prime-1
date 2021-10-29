package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Consuelo", 3);
        Book book2 = new Book("Kashtanka", 2);
        Book book3 = new Book("Taiga", 5);
        Book book4 = new Book("Clean code", 1);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getCount());
        }
        System.out.println("Replace Consuelo to Clean code.");
        Book book = new Book("Clean code", 1);
        Book bks = new Book("Consuelo", 3);
        books[0] = book;
        books[3] = bks;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getCount());
        }
        System.out.println("Shown only product.name \"Clean code\"");
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            if (bk.getName().equals("Clean code")) {
                System.out.println(bk.getName() + " - " + bk.getCount());
            }
        }
    }
}


