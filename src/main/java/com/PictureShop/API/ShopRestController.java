package com.PictureShop.API;

import com.PictureShop.Application.DTO.PictureDTO;
import com.PictureShop.Application.DTO.ShopDTO;
import com.PictureShop.Application.ShopController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopRestController {

    @Autowired
    private ShopController controller;

    @PostMapping(value = "/shop", produces = "application/json;charset=UTF-8")
    public String register(@RequestBody String jShop) throws Exception {

        ShopDTO newShop = new Gson().fromJson(jShop, ShopDTO.class);

        ShopDTO shop = controller.createShop(newShop);

        return toJson(shop);
    }

    @GetMapping(value = "/shop", produces = "application/json;charset=UTF-8")
    public String listShop() throws Exception {

        List<ShopDTO> shops = controller.getAllShops();

        return toJson(shops);
    }

    @PostMapping(value = "/shop/{shopId}/pictures", produces = "application/json;charset=UTF-8")
    public String addPicture(@PathVariable int shopId, @RequestBody String jPicture) throws Exception{

        PictureDTO newPicture = new Gson().fromJson(jPicture, PictureDTO.class);

        PictureDTO picture = controller.addPicture(shopId, newPicture);

        return toJson(picture);
    }

    @GetMapping(value = "/shop/{shopId}/pictures", produces = "application/json;charset=UTF-8")
    public String listPicture(@PathVariable int shopId) throws Exception {

        List<PictureDTO> pictureList = controller.getAllPicturesByShop(shopId);

        return toJson(pictureList);
    }

    @DeleteMapping (value="/shop/{shopId}/pictures",produces="application/json;charset=UTF-8")
    public void removeAllPictures(@PathVariable int shopId) throws Exception {
        controller.policePanicBottom(shopId);

    }

    private String toJson(Object object){

        Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(object);
    }
}
