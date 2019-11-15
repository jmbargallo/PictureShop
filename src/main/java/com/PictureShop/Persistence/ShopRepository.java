package com.PictureShop.Persistence;

import com.PictureShop.Domain.Shop;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ShopRepository {

    private static List<Shop> repository = new ArrayList<>();

    public ShopRepository(){}

    public void saveShop(Shop shop) throws Exception {
        if (shop == null)
            throw new Exception();
        if (shopExistById(shop))
            throw new Exception();

        repository.add(shop);
    }

    public List<Shop> getAllShops(){ return repository; }
    
    public Shop getShopById(int shopId){
        for (Shop shop : repository) {
            if (shop.getId().equals(shopId))
                return shop;
        }
        return null;
    }

    public boolean shopExistById(Shop shop){
        for (Shop shop1 : repository) {
            if (shop1.getId().equals(shop.getId()))
                return true;
        }
        return false;
    }
}
