package com.PictureShop.Application;

import com.PictureShop.Application.DTO.PictureDTO;
import com.PictureShop.Application.DTO.ShopDTO;
import com.PictureShop.Domain.Picture;
import com.PictureShop.Domain.Shop;
import com.PictureShop.Persistence.PictureRepository;
import com.PictureShop.Persistence.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShopController {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private PictureRepository pictureRepository;

    public ShopController(){}

    public ShopDTO createShop(ShopDTO shopDTO) throws Exception {
        Shop shop = new Shop(shopDTO);
        shopRepository.saveShop(shop);
        return new ShopDTO(shop);
    }

    public List<ShopDTO> getAllShops() throws Exception {
        List<ShopDTO> shopDTOList = new ArrayList<>();
        for (Shop shop : shopRepository.getAllShops()) {
            ShopDTO shopDTO = new ShopDTO(shop);
            shopDTOList.add(shopDTO);
        }
        return shopDTOList;
    }

    public PictureDTO addPicture(int shopId, PictureDTO pictureDTO) throws Exception {
        Shop shop = shopRepository.getShopById(shopId);
        Picture picture = new Picture(shop, pictureDTO);
        pictureRepository.savePicture(picture);
        return new PictureDTO(picture);
    }

    public List<PictureDTO> getAllPicturesByShop(int shopId) throws Exception {
        List<PictureDTO> pictureDTOList = new ArrayList<>();
        for (Picture picture : pictureRepository.getAllPictureByShopId(shopId)) {
            PictureDTO pictureDTO = new PictureDTO(picture);
            pictureDTOList.add(pictureDTO);
        }
        return pictureDTOList;
    }

    public void policePanicBottom(int shopId){
        pictureRepository.deleteAllPicturesByShop(shopId);
    }
}
