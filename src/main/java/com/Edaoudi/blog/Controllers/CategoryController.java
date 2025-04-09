package com.Edaoudi.blog.Controllers;


import com.Edaoudi.blog.domain.DTOs.CategoryDto;
import com.Edaoudi.blog.domain.entities.Category;
import com.Edaoudi.blog.mappers.CategoryMapper;
import com.Edaoudi.blog.repositories.CategoryRepository;
import com.Edaoudi.blog.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@AllArgsConstructor
@SuppressWarnings("unused")
public class CategoryController {


    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping("/listCategories")
    public ResponseEntity<List<CategoryDto>> listCategories() {
        List<Category> categories = categoryService.listCategories();
        return ResponseEntity.ok(
                categories.stream().map(categoryMapper::toDto).toList()
        );
    }
}
