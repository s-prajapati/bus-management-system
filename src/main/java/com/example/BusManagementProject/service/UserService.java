package com.example.BusManagementProject.service;

import com.example.BusManagementProject.model.User;

public interface UserService {
    void addUser(User user);

    String Login(String username, String password);

    boolean isLoggedIn(String token);

    void logOut(String token);
}
