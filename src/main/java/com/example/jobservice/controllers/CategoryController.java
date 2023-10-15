package com.example.jobservice.controllers;

import com.example.jobservice.dto.request.category.CreateCategoryRequestBody;
import com.example.jobservice.dto.response.category.CreateCategoryResponseBody;
import com.example.jobservice.dto.response.category.GetAllCategoryResponseBody;
import com.example.jobservice.dto.response.category.GetCategoryResponseBody;
import com.example.jobservice.entities.Category;
import com.example.jobservice.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("")
    public ResponseEntity<CreateCategoryResponseBody> createCategory(@RequestBody CreateCategoryRequestBody requestBody){
        return ResponseEntity.ok().body(categoryService.createCategory(requestBody));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCategoryResponseBody> getCategory(@PathVariable Long id){
        return ResponseEntity.ok().body(categoryService.getCategory(id));
    }

    @GetMapping("")
    public ResponseEntity<List<Category>> getAllCategory(){
        return ResponseEntity.ok().body(categoryService.getAllCategory());
    }
}
