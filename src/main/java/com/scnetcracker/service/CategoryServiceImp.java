package com.scnetcracker.service;

import com.scnetcracker.dao.CategoryImp;

import java.util.List;

public class CategoryServiceImp implements CategoryService{

    CategoryImp category = new CategoryImp();

    @Override
    public List getCategory(int id) {
        return category.getCategory(id);
    }

    public List getCategories() {
        return category.getCategories();
    }

    public List getChildrenCategory(int Id) {
        return category.getChildrenCategory(Id);
    }


}
