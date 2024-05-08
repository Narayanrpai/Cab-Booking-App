package com.example.cabBookingApp.repository;

import com.example.cabBookingApp.models.Driver;
import com.example.cabBookingApp.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users = new ArrayList<>();
    public void addUser(User user) {
        users.add(user);
    }
    public List<User> getUsers() {
        return users;
    }
}
