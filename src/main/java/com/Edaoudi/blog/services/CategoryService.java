package com.Edaoudi.blog.services;

import com.Edaoudi.blog.domain.entities.Category;

import java.util.List;

@SuppressWarnings("unused")
public interface CategoryService {

    List<Category> listCategories();
    Category createCategory(Category category);

}
