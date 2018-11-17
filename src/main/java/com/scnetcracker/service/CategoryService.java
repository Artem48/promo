package com.scnetcracker.service;

import java.util.List;

public interface CategoryService {
    List getCategory(int id);
    List getCategories();
    List getChildrenCategory(int Id);
}
