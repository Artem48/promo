package com.scnetcracker.dao;

import java.util.List;

public interface Shops {
    List getShop(int id);
    List getShops();
    List getShop(String name);
}
