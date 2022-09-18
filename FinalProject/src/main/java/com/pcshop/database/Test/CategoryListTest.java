package com.pcshop.database.Test;

import java.util.List;

import com.pcshop.database.entity.Category;
import com.pcshop.database.manager.CategoryManager;

public class CategoryListTest {
    public static void main(String[] args) throws Exception {
        CategoryManager categoryManager = new CategoryManager();
        List<Category> categoryList = categoryManager.list();
        for (Category category : categoryList) {
            System.out.println(category.getCategoryId()+ " "+ category.getCategoryName());
        }
        
    }
}
