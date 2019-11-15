package com.PictureShop.Domain;

import com.PictureShop.Application.DTO.ShopDTO;

public class Shop {

    private Integer id;
    private String name;
    private Integer capacity;
    private static int COUNTER=1;

    public Shop(ShopDTO shop) throws Exception {
        if (shop.getName().equals("") || shop.getCapacity() <=0)
            throw new Exception();

        this.id = COUNTER;
        this.name = shop.getName();
        this.capacity = shop.getCapacity();
        ++COUNTER;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCapacity() {
        return capacity;
    }
}
