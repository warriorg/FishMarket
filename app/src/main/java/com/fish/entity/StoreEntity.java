package com.fish.entity;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by warrior on 14-4-24.
 */
public class StoreEntity implements Serializable {
    private int id;
    private String name;
    private float price;
    private float weight;

    public StoreEntity()
    {
        Random random = new Random();
        price = random.nextFloat() * 80;
        weight = random.nextInt(200);
        while(weight < 20)
            weight = random.nextInt(300);
    }

    public int getId() {
        return id;
    }

    public StoreEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StoreEntity setName(String name) {
        this.name = name;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public StoreEntity setPrice(float price) {
        this.price = price;
        return this;
    }

    public float getWeight() {
        return weight;
    }

    public StoreEntity setWeight(float weight) {
        this.weight = weight;
        return this;
    }
}
