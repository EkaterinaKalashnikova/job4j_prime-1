package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс, описывающий счет клиента в банке. Каждый клиент
 * может иметь неограниченное количество счетов в банке.
 *
 * @author
 * @since
 */
public class Account {

    /**
     * Количество денежных средств на счете клиента.
     */
    private double balance;

    /**
     * Реквизиты счета клиента
     */
    private String requisite;

    /**
     * Конструктор, инициализирующий банковский счет.
     *
     * @param balance
     * @param requisite
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }

    @Override
    public String toString() {
        return "Account{"
                + "requisite='" + requisite + '\''
                + ", balance=" + balance
                + '}';
    }
}
