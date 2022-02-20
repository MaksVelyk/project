package com.fishingshop.service.impl;

import com.fishingshop.database.IGearDAOI;
import com.fishingshop.model.Gear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fishingshop.service.IGearServI;

import java.util.List;
import java.util.Optional;

@Service
public class GearServ implements IGearServI {

    @Autowired
    IGearDAOI gearDAO;

    public List<Gear> getAllGears() {
        return this.gearDAO.getGears();
    }

    @Override
    public Gear getGearById(int gearId) {
        Optional<Gear> gearOptional = gearDAO.getGearById(gearId);

        if (gearOptional.isEmpty()) {
            return null;
        }

        return gearOptional.get();
    }

    public void updateGear(Gear gear) {
        this.gearDAO.updateGear(gear);

    }
}
