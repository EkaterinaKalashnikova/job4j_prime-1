package ru.job4j.ex;

public class FindEl {
    public static void main(String[] args) {
        String[] data = new String[] {"one", "two", "three"};
        String findEl = "two";
        try {
            indexOf(data, findEl);
            System.out.println(findEl);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i] != null && value[i].equals(key) || key == null && value[i] == null) {
                return i;
            }
        }
        return rsl;
    }
}
