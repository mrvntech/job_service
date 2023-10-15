package com.example.jobservice.services.impl;

import com.example.jobservice.dto.request.category.CreateCategoryRequestBody;
import com.example.jobservice.dto.response.category.CreateCategoryResponseBody;
import com.example.jobservice.dto.response.category.GetAllCategoryResponseBody;
import com.example.jobservice.dto.response.category.GetCategoryResponseBody;
import com.example.jobservice.entities.Category;
import com.example.jobservice.exception.exceptions.BadRequestException;
import com.example.jobservice.repositories.CategoryRepository;
import com.example.jobservice.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }
    public GetCategoryResponseBody getCategory(Long id){
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isEmpty())throw new BadRequestException();
        return modelMapper.map(category.get(), GetCategoryResponseBody.class);
    }
    public CreateCategoryResponseBody createCategory(CreateCategoryRequestBody requestBody){
        Category category = modelMapper.map(requestBody, Category.class);
        categoryRepository.save(category);
        return modelMapper.map(category, CreateCategoryResponseBody.class);
    }

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
}
