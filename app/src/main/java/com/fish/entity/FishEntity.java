package com.fish.entity;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by warrior on 14-4-23.
 */
public class FishEntity implements Serializable {
    private int id;
    private String name;
    private String area;
    private float lowPrice;
    private float highPrice;

    private Random random = new Random();

    public FishEntity()
    {
        highPrice = random.nextFloat() * 200;
        lowPrice = random.nextFloat() * 50;
        if(highPrice < lowPrice)
            highPrice += 50;
    }

    public FishEntity setHighPrice(float highPrice) {
        this.highPrice = highPrice;
        return this;
    }

    public float getLowPrice() {
        return lowPrice;
    }

    public FishEntity setLowPrice(float lowPrice) {
        this.lowPrice = lowPrice;
        return this;
    }

    public float getHighPrice() {
        return highPrice;
    }


    public int getId() {
        return id;
    }

    public FishEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public FishEntity setName(String name) {
        this.name = name;
        return this;
    }


    public String getArea() {
        return area;
    }

    public FishEntity setArea(String area) {
        this.area = area;
        return this;
    }

}
