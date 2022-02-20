package com.fishingshop.service.impl;

import com.fishingshop.database.IUserDAOI;
import com.fishingshop.model.User;
import com.fishingshop.service.IUserServI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServ implements IUserServI {

    @Autowired
    IUserDAOI userDAO;

    @Override
    public User getUserById(int userId) {
        Optional<User> userOptional = userDAO.getUserById(userId);

        if (userOptional.isEmpty()) {
            return null;
        }

        return userOptional.get();
    }

    @Override
    public void addUser(User user) {
        this.userDAO.addUser(user);

    }
}