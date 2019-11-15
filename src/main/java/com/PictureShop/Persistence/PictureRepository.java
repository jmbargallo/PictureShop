package com.PictureShop.Persistence;

import com.PictureShop.Domain.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PictureRepository {

    private static List<Picture> repository = new ArrayList<>();

    @Autowired
    private ShopRepository shopRepository;

    public PictureRepository(){}

    public void savePicture(Picture picture) throws Exception {
        if (picture == null || !shopRepository.shopExistById(picture.getShop()))
            throw new Exception();
        if (picture.getShop().getCapacity() <= pictureCountByShop(picture.getShop().getId()))
            throw new Exception();

        repository.add(picture);
    }

    public List<Picture> getAllPictureByShopId(int shopId){
        List<Picture> pictureList = new ArrayList<>();
        for (Picture picture : repository) {
            if (picture.getShop().getId().equals(shopId))
                pictureList.add(picture);
        }
        return pictureList;
    }

    private int pictureCountByShop(int shopId){
        List<Picture> pictureList = new ArrayList<>();
        for (Picture picture : repository) {
            if (picture.getShop().getId().equals(shopId))
                pictureList.add(picture);
        }
        return pictureList.size();
    }

    public void deleteAllPicturesByShop(int shopId){
        for (Picture picture : repository) {
            if (picture.getShop().getId().equals(shopId))
                repository.remove(picture);
        }
    }
}
