package com.scnetcracker.dao;

import java.util.List;

public interface Category {
    List getCategory(int id);
    List getCategories();
    List getChildrenCategory(int Id);
    List getCategory(String name);
}
