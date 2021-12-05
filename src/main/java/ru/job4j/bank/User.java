package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс, описывающий клиента банка. Каждый клиент имеет
 * имя и паспорт.
 *
 * @author
 * @since
 */
public class User {

    private String id;
    /**
     * Имя клиента.
     */
    private String username;

    /**
     * Номер паспорта клиента
     */
    private String passport;

    /**
     * Конструктор, инициализирующий нового клиента
     *
     * @param username    - имя клиента.
     * @param passport - номер паспорта клиента.
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }

    @Override
    public String toString() {
        return "User{"
                + "passport='" + passport + '\''
                + ", username='" + username  + '\''
                + '}';
    }

    public  String getId() {
        return id;
    }
}
