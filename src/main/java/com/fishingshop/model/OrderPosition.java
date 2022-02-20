package com.fishingshop.model;

import javax.persistence.*;

@Entity(name = "torderposition")
public class OrderPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Gear gear;
    private int quantity;

    public OrderPosition(int id, Gear gear, int quantity) {
        this.id = id;
        this.gear = gear;
        this.quantity = quantity;
    }

    public OrderPosition() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void incrementQuantity() {
        this.quantity++;
    }

    public Gear getGear() {
        return gear;
    }

    public void setGear(Gear gear) {
        this.gear = gear;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
