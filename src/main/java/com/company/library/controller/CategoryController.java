package com.company.library.controller;

import com.company.library.dto.CategoryDto;
import com.company.library.dto.request.CreateCategoryRequest;
import com.company.library.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("createCategory")
    @Operation(summary = "Create Category", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CreateCategoryRequest request){
        return ResponseEntity.ok(categoryService.createCategory(request));
    }

    @GetMapping("getAllCategories")
    @Operation(summary = "Show All Categories", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }


}
