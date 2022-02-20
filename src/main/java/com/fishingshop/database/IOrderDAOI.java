package com.fishingshop.database;

import com.fishingshop.model.Order;

import java.util.List;

public interface IOrderDAOI {
    void addOrder(Order order);
    List<Order> getOrdersByUserId(int userId);
}
