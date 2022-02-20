package com.fishingshop.database.hibernate;

import com.fishingshop.database.IUserDAOI;
import com.fishingshop.model.User;

import java.util.Optional;

public class UserDaoTest implements IUserDAOI {
    @Override
    public void addUser(User user) {

    }

    @Override
    public Optional<User> getUserById(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        User user = new User();
        user.setId(2);
        user.setLogin("root");
        user.setPass("63a9f0ea7bb98050796b649e85481845");
        user.setName("Maksym");
        user.setSurname("Velykozhon");

        return Optional.of(user);
    }
}
