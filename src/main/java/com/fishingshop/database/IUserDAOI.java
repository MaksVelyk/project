package com.fishingshop.database;

import com.fishingshop.model.User;

import java.util.Optional;

public interface IUserDAOI {
    Optional<User> getUserByLogin(String login);
    void addUser(User user);
    Optional<User> getUserById(int id);
}
