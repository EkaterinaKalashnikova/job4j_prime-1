package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            Item name = items[index];
            if (name != null) {
                itemsWithoutNull[size] = name;
                size++;
            }
        }
        itemsWithoutNull = Arrays.copyOf(itemsWithoutNull, size);
        for (int index = 0; index < itemsWithoutNull.length; index++) {
            System.out.println(itemsWithoutNull[index]);
        }
        return itemsWithoutNull;
    }

    public Item[] findByName(String key) {
        Item[] itemsNamesKey = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                if (items[i].getName().equals(key)) {
                    itemsNamesKey[size] = items[i];
                    size++;
                }
            }
        }
        itemsNamesKey = Arrays.copyOf(itemsNamesKey, size);
        for (int i = 0; i < itemsNamesKey.length; i++) {
            System.out.println(itemsNamesKey[i]);
        }
        return itemsNamesKey;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        for (int i = 0; i < items.length; i++) {
            if (index != 0) {
                if (items[i].getId() == index) {
                    items[index].setName(item.getName());
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Весь метод replace будет состоять из 5-6 строчек кода.
 * <p>
 * 1. Найти индекс ячейки по id.
 * <p>
 * 2. Проставить id с item. При замене нужно сохранять старый id.
 * <p>
 * 3. Записать в ячейку с найденным индексом объект item. Это входящий параметр.
 * <p>
 * 4. Вернуть true, если замена произведена или false, если index по id не найден.
 */