package com.kolay.repository;

import com.kolay.model.User;

import java.util.List;

public class UserRepository {
    public List<User> findAll() {
        return List.of(new User("johndoe", "John Doe", "123"),
                new User("julialucero", "Julia Lucero", "123"),
                new User("michael07", "Michael Loomis", "123"),
                new User("barbara", "Barbara Perrine", "123"),
                new User("craven_s", "Sam Craven", "123"),
                new User("bonnieowen", "Bonnie Owen", "123"),
                new User("kyle_carroll", "Kyle Carroll", "123"));
    }
}
