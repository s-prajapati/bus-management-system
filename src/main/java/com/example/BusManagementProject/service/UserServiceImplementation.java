package com.example.BusManagementProject.service;

import com.example.BusManagementProject.model.User;
import com.example.BusManagementProject.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    public UserRepository userRepository;
    @Override
    public void addUser(User user) {
        Optional<User> existingUser= userRepository.findByUsername(user.getUsername());
        if(existingUser.isPresent()) {
            throw new RuntimeException("User already exist");
        }
        else {
            userRepository.save(user);
        }

    }

    @Override
    public String login(String username, String password) {
        Optional<User> user= userRepository.findByUsername(username);
        if(user.isPresent()) {
            if(Objects.equals(user.get().getPassword(), password)) {
                String token = user.get().generateToken();
                User newUser = new User(username,user.get().getEmail(),password,user.get().getRole(),token);
                newUser.setId(user.get().getId());
                userRepository.save(newUser);
                return token;
            }
            else {
                throw new RuntimeException("Incorrect credentials");
            }
        }
        else {
            throw new RuntimeException("User does not exist");
        }
    }

    @Override
    public boolean isLoggedIn(String token) {
        Optional<User> user= userRepository.findUserByToken(token);
        return user.isPresent();
    }

    @Override
    public void logOut(String token) {
        Optional<User> user= userRepository.findUserByToken(token);
        if(user.isPresent()){
            user.get().setToken(null);
        }
        else {
            throw new RuntimeException("User doesn't exist");
        }
    }
}
