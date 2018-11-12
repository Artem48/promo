package com.scnetcracker.service;

import java.util.List;

public interface PromoService {
    List getUserPromo(int userId);
    public List getPromosByIssueDate();
    //public void createPromo(String Promo, String Description, String Shop, String Category, String ExpireDate);
}
