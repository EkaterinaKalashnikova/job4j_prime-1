package ru.job4j.bank;

import java.util.*;

public class BankServiceOpt {
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Method of adding a bank client to the system
     * default: an empty list of bank accounts at the beginning
     *
     * @param user - a bank client
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Method of adding to a new account of a bank client
     *
     * @param passport - passport a bank client
     * @param account  - bank account
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
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
    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(p -> p.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Method search account requisite
     *
     * @param passport  - passport a bank client
     * @param requisite - requisite a bank client
     * @return received list of accounts by index
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        return findByPassport(passport).flatMap(user -> users.get(user).stream()
                .filter(account -> account.getRequisite().equals(requisite))
                .findFirst());
    }

    /**
     * Method transfers from one account to another
     *
     * @param srcPassport  - Passport data of the client account pull
     * @param srcRequisite - Requisite data of the client account pull
     * @param destPassport - Passport data of the client account put
     * @param dstRequisite - Requisite data of the client account put
     * @param amount       - amount of money transferred
     * @return rsl
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dstRequisite, double amount) {
        Optional<Account> src = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> dest = findByRequisite(destPassport, dstRequisite);
        if (amount > 0 && src.isPresent() && dest.isPresent() && amount <= src.get().getBalance()) {
            src.get().setBalance(src.get().getBalance() - amount);
            dest.get().setBalance(dest.get().getBalance() + amount);
           return true;
        }
        return false;
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

