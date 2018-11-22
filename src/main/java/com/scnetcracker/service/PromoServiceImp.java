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
    public List getShopPromo(int id){return promo.getShopPromo(id); }
    public List getCategoryPromo(int id){return promo.getCategoryPromo(id); }


    public void createPromo(String Promo, String Description, String Shop, String Category, String ExpireDate, String User){
        promo.createPromo(Promo, Description, Shop, Category, ExpireDate, User);
    }
    public void deletePromo(String id){
        promo.deletePromo(id);
    }
    public boolean checkUser(String promoID, int userID){
        return promo.checkUser(promoID, userID);
    }
}
