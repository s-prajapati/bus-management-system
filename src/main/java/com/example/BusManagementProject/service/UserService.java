package com.example.BusManagementProject.service;

import com.example.BusManagementProject.model.User;

public interface UserService {
    void addUser(User user);

    String login(String username, String password);

    boolean isLoggedIn(String token);

    boolean isAdmin(String token);

    void logOut(String token);
}
