package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshman freshman = new Freshman();
        Student st = freshman;
        Object obj = freshman;
        st.music();
        obj.getClass().getName();
        System.out.println(obj);
    }
}

