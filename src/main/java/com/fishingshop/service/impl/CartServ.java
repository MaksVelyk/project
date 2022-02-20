package com.fishingshop.service.impl;

import com.fishingshop.model.Gear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fishingshop.database.IGearDAOI;
import com.fishingshop.model.OrderPosition;
import com.fishingshop.service.ICartServI;
import com.fishingshop.session.SessionObject;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class CartServ implements ICartServI {

    @Autowired
    IGearDAOI gearDAO;

    @Resource
    SessionObject sessionObject;

    public void addGearToCart(int gearId) {
        Optional<Gear> gearBox = this.gearDAO.getGearById(gearId);

        if(gearBox.isEmpty()) {
            return;
        }

        Gear gear = gearBox.get();
        if(gear.getQuantity() <= 0) {
            return;
        }

        for(OrderPosition orderPosition : this.sessionObject
                .getCart().getOrderPositions()) {
            if(orderPosition.getGear().getId() == gearId) {
                orderPosition.incrementQuantity();
                return;
            }
        }

        OrderPosition orderPosition = new OrderPosition(0, gear, 1);
        this.sessionObject.getCart().getOrderPositions().add(orderPosition);
    }
}
