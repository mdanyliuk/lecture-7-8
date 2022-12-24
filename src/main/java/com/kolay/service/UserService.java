package com.kolay.service;

import com.kolay.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAllUsers();
    Optional<User> checkCredentials(String username, String password);

}
