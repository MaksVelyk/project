package com.fishingshop.database.hibernate;

import com.fishingshop.database.IOrderDAOI;
import com.fishingshop.model.Order;

import java.util.List;

public class OrderDaoTest implements IOrderDAOI {

    @Override
    public void addOrder(Order order) {
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        return null;
    }
}

