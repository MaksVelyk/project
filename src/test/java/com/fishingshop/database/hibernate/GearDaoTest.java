package com.fishingshop.database.hibernate;

import com.fishingshop.database.IGearDAOI;
import com.fishingshop.model.Gear;

import java.util.List;
import java.util.Optional;

public class GearDaoTest implements IGearDAOI {
    @Override
    public List<Gear> getGears() {
        return null;
    }

    @Override
    public Optional<Gear> getGearById(int gearId) {
        return Optional.empty();
    }

    @Override
    public void updateGear(Gear gear) {
    }
}

