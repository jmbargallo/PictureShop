package com.PictureShop.Application.DTO;

import com.PictureShop.Domain.Shop;
import com.google.gson.annotations.Expose;

public class ShopDTO {

    @Expose
    private int id;
    @Expose
    private String name;
    @Expose
    private int capacity;

    public ShopDTO(Shop shop) throws Exception {
        if (shop == null)
            throw new Exception();

        this.id = shop.getId();
        this.name = shop.getName();
        this.capacity = shop.getCapacity();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        if (name == null)
            return "";
        return name;
    }

    public int getCapacity() {
        if (capacity <= 0)
            return 1;
        return capacity;
    }
}
