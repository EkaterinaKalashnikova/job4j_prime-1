package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        return  "Неизвестное слово. " + eng;
    }

    public static void main(String[] args) {
        DummyDic dummyDic = new DummyDic();
        String eng = dummyDic.engToRus("+ eng");
        System.out.println(eng);
    }
}

