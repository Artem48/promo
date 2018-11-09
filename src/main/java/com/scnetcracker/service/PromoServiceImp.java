package com.scnetcracker.service;

import com.scnetcracker.dao.PromoImp;

import java.util.List;

public class PromoServiceImp implements PromoService {

    PromoImp promo = new PromoImp();
    @Override
    public List getUserPromo(int userId) {
        return promo.getUserPromo(userId);
    }
}
