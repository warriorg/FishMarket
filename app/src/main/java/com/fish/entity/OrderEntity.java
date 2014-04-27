package com.fish.entity;

import java.util.Date;

/**
 * Created by warrior on 14-4-24.
 */
public class OrderEntity {
    private int id;
    private String name;
    private float price;
    private float weight;
    private Date orderDt;
    private int status;

    public int getId() {
        return id;
    }

    public OrderEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderEntity setName(String name) {
        this.name = name;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public OrderEntity setPrice(float price) {
        this.price = price;
        return this;
    }

    public float getWeight() {
        return weight;
    }

    public OrderEntity setWeight(float weight) {
        this.weight = weight;
        return this;
    }

    public Date getOrderDt() {
        return orderDt;
    }

    public OrderEntity setOrderDt(Date orderDt) {
        this.orderDt = orderDt;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public OrderEntity setStatus(int status) {
        this.status = status;
        return this;
    }

}
