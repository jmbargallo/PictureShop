package com.PictureShop.Domain;

import com.PictureShop.Application.DTO.PictureDTO;

import java.util.Calendar;

public class Picture {

    private Integer id;
    private String name;
    private String author;
    private double price;
    private Calendar date;
    private Shop shop;
    private static int COUNTER=1;

    public Picture(Shop shop, PictureDTO picture) throws Exception {
        if (picture == null || picture.getName().equals("") || picture.getPrice() < 0 || shop == null)
            throw new Exception();

        this.id = COUNTER;
        this.name = picture.getName();
        this.author = picture.getAuthor();
        this.price = picture.getPrice();
        this.date = Calendar.getInstance();
        this.shop = shop;
        ++COUNTER;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public Calendar getDate() {
        return date;
    }

    public Shop getShop() {
        return shop;
    }
}
