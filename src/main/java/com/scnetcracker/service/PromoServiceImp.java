package com.scnetcracker.service;

import com.scnetcracker.dao.PromoImp;

import javax.print.DocFlavor;
import java.util.List;

public class PromoServiceImp implements PromoService {

    PromoImp promo = new PromoImp();
    @Override
    public List getUserPromo(int userId) {
        return promo.getUserPromo(userId);
    }
    public List getPromosByIssueDate() {
        return promo.getPromosByIssueDate();
    }
//    public void createPromo(String Promo, String Description, String Shop, String Category, String ExpireDate){
//        promo.createPromo(Promo, Description, Shop, Category, ExpireDate);
//    }
}
