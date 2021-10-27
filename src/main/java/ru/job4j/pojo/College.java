package ru.job4j.pojo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ekaterina");
        student.setSurname("Kalashnikova");
        student.setGroup(1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        Calendar data = new GregorianCalendar(2018, Calendar.AUGUST, 25, 13, 24, 56);
        data.set(2018, Calendar.AUGUST, 25);
        student.setStart(sdf.format(data.getTime()));
        System.out.println("Имя студента: " + student.getName());
        System.out.println("Фамилия студента: " + student.getSurname());
        System.out.println("Номер группы: " + student.getGroup());
        System.out.println("Дата поступления: " + student.getStart());
    }
}

