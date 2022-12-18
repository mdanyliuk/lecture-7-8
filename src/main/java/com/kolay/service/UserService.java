package com.kolay.service;

import com.kolay.model.User;
import com.kolay.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {

    private UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> checkCredentials(String username, String password) {
        return userRepository.findAll()
                .stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst();
    }
}
