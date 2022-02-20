package com.fishingshop.database;

import com.fishingshop.model.Gear;

import java.util.List;
import java.util.Optional;

public interface IGearDAOI {
    List<Gear> getGears();
    Optional<Gear> getGearById(int gearId);
    void updateGear(Gear gear);
}
