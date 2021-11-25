package ru.job4j.ex;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(User user) {
        super(String.valueOf(user));
    }
}
