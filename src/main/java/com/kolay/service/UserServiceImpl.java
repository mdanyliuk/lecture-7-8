package com.kolay.service;

import com.kolay.model.User;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final List<User> users;

    public UserServiceImpl() {
        users = List.of(new User("johndoe", "John Doe", "123"),
                new User("julialucero", "Julia Lucero", "123"),
                new User("michael07", "Michael Loomis", "123"),
                new User("barbara", "Barbara Perrine", "123"),
                new User("craven_s", "Sam Craven", "123"),
                new User("bonnieowen", "Bonnie Owen", "123"),
                new User("kyle_carroll", "Kyle Carroll", "123"));
    }

    public List<User> findAllUsers() {
        return users;
    }

    public Optional<User> checkCredentials(String username, String password) {
        return users.stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst();
    }
}
