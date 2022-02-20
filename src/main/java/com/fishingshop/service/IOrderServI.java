package com.fishingshop.service;

import com.fishingshop.model.Order;

import java.util.List;

public interface IOrderServI {
    void confirmOrder();
    List<Order> getOrdersForCurrentUser();
}
