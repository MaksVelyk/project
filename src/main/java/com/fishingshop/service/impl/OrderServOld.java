package com.fishingshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.fishingshop.database.IGearDAOI;
import com.fishingshop.database.IOrderDAOI;
import com.fishingshop.model.Gear;
import com.fishingshop.model.Order;
import com.fishingshop.model.OrderPosition;
import com.fishingshop.service.IOrderServI;
import com.fishingshop.session.SessionObject;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;
import java.util.Optional;

public class OrderServOld implements IOrderServI {

    @Resource
    SessionObject sessionObject;

    @Autowired
    IOrderDAOI orderDAO;

    @Autowired
    IGearDAOI gearDAO;

    @Override
    public void confirmOrder() {
        Order order = new Order(this.sessionObject.getUser(), new HashSet<>(this.sessionObject.getCart().getOrderPositions()));
        this.orderDAO.addOrder(order);
        for (OrderPosition orderPosition : order.getOrderPositions()) {
            Optional<Gear> gearBox = gearDAO.getGearById(orderPosition.getGear().getId());
            if(gearBox.isPresent()) {
                gearBox.get().setQuantity(gearBox.get().getQuantity() - orderPosition.getQuantity());
            }
        }
        this.sessionObject.getCart().clearOrderPositions();
    }

    @Override
    public List<Order> getOrdersForCurrentUser() {
        return this.orderDAO.getOrdersByUserId(this.sessionObject.getUser().getId());
    }
}
