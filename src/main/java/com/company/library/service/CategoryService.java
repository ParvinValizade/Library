package com.company.library.service;

import com.company.library.dto.CategoryDto;
import com.company.library.dto.converter.CategoryDtoConverter;
import com.company.library.dto.request.CreateCategoryRequest;
import com.company.library.model.Category;
import com.company.library.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository repository;
    private final CategoryDtoConverter converter;

    public CategoryService(CategoryRepository repository, CategoryDtoConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public CategoryDto createCategory(CreateCategoryRequest request){
        Category category = new Category(
                request.getName()
        );
        return converter.convert(repository.save(category));
    }

    public List<CategoryDto> getAllCategories(){
        return converter.convert(repository.findAll());
    }
}
