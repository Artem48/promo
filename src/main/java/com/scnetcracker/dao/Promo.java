package com.scnetcracker.dao;

import java.util.List;

public interface Promo {
    List getUserPromo(int userId);
    void createPromo(String Promo, String Description, String Shop, String Category, String ExpireDate, String User);
}
