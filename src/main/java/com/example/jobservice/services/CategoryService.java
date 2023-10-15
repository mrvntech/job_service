package com.example.jobservice.services;

import com.example.jobservice.dto.request.category.CreateCategoryRequestBody;
import com.example.jobservice.dto.response.category.CreateCategoryResponseBody;
import com.example.jobservice.dto.response.category.GetCategoryResponseBody;
import com.example.jobservice.entities.Category;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CategoryService {
    @Transactional
    CreateCategoryResponseBody createCategory(CreateCategoryRequestBody requestBody);
    @Transactional
    GetCategoryResponseBody getCategory(Long id);
    @Transactional
    List<Category> getAllCategory();
}
