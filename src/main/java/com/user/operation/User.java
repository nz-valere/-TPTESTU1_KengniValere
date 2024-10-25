package com.user.operation;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private int age;
    private String email;
    private String phone;
    private String city;
    private double balancePersonnel;

    public User(int i, String johnDoe, int i1, String s, String s1, String city, double v) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static ArrayList<User> users = new ArrayList<>();

    public static void add(User user) {
        if (isValidEmail(user.getEmail())) {
            users.add(user);
        } else {
            throw new EmailInvalidException("Invalid email: " + user.getEmail());
        }
    }

    public void delete(int id) {
        boolean removed = users.removeIf(user -> user.getId() == id);
        if (!removed) {
            throw new DeletionInvalidException("User with ID " + id + " not found.");
        }
    }

    public static List<User> list() {
        return new ArrayList<>(users);
    }

    public User display(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(() -> new DeletionInvalidException("User with ID " + id + " not found."));
    }


    private static boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    public class EmailInvalidException extends RuntimeException {
        public EmailInvalidException(String message) {
            super(message);
        }
    }

    public class DeletionInvalidException extends RuntimeException {
        public DeletionInvalidException(String message) {
            super(message);
        }
    }


}
