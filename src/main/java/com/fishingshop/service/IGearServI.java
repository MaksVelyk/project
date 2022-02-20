package com.fishingshop.service;

import com.fishingshop.model.Gear;

import java.util.List;

public interface IGearServI {
    List<Gear> getAllGears();
    Gear getGearById(int gearId);
    void updateGear(Gear gear);
}
