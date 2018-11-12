package com.scnetcracker.service;

import com.scnetcracker.dao.ShopImp;

import java.util.List;

public class ShopServiceImp implements ShopService{

    ShopImp shop = new ShopImp();

    @Override
    public List getShop(int id) {
        return shop.getShop(id);
    }

    public List getShops() {
        return shop.getShops();
    }
//    public int getShopIdByName(String name){
//
//    }
}
