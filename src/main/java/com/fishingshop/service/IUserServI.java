package com.fishingshop.service;


import com.fishingshop.model.User;

public interface IUserServI {
    User getUserById(int userId);
    void addUser(User user);
}