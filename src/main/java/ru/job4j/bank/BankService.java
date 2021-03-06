package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Method of adding a bank client to the system
     * default: an empty list of bank accounts at the beginning
     *
     * @param user - a bank client
     */
    public void addUser(User user) {
        this.users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Method of adding to a new account of a bank client
     *
     * @param passport - passport a bank client
     * @param account  - bank account
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = this.users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Method search for a bank client by passport number
     *
     * @param passport - passport a bank client
     * @return user
     */
    public User findByPassport(String passport) {
        User user = null;
        for (User key : users.keySet()) {
            if (key != null) {
                if (key.getPassport().equals(passport)) {
                    user = key;
                    break;
                }
            }
        }
        return user;
    }

    /**
     * Method search account requisite
     *
     * @param passport  - passport a bank client
     * @param requisite - requisite a bank client
     * @return received list of accounts by index
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        Account result = null;
        List<Account> accounts = users.get(user);
        int index = accounts.indexOf(new Account(requisite, 0));
        if (index != -1) {
            result = accounts.get(index);
        }
        return result;
    }

    /**
     * Method transfers from one account to another
     *
     * @param srcPassport   - Passport data of the client account pull
     * @param srcRequisite  - Requisite data of the client account pull
     * @param destPassport  - Passport data of the client account put
     * @param dstRequisite - Requisite data of the client account put
     * @param amount        - amount of money transferred
     * @return rsl
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dstRequisite, double amount) {
        boolean rsl = false;
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, dstRequisite);
        if (amount > 0 && amount <= src.getBalance() && dest != null) {
            src.setBalance(src.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        String requisite = "3fdsbb9";
        accounts.add(new Account("3fdsbb9", 140));
        int index = accounts.indexOf(new Account(requisite, -1));
        Account find = accounts.get(index);
        System.out.println(find.getRequisite() + " -> " + find.getBalance());
    }
}
