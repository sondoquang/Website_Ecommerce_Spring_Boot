package com.stlang.dreamshops.service.category;

import com.stlang.dreamshops.model.Category;

import java.util.List;

public interface ICategorySevice {
    Category getCategoryById(Long id);
    Category getCategoryByName(String name);
    List<Category> getAllCategories();
    Category addCategory(Category category);
    Category updateCategory(Category category, Long id);
    void deleteCategory(Category category);
}
