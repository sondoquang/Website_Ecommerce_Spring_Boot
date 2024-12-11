package com.stlang.dreamshops.controller;


import com.stlang.dreamshops.exceptions.AlreadyExistsException;
import com.stlang.dreamshops.exceptions.ResourceNotFoundException;
import com.stlang.dreamshops.model.Category;
import com.stlang.dreamshops.response.ApiResponse;
import com.stlang.dreamshops.service.category.ICategorySevice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/categries")
public class CategoryController {
    private final ICategorySevice categorySevice;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllCategories() {
        try {
            List<Category> categories = categorySevice.getAllCategories();
            return ResponseEntity.ok().body(new ApiResponse("Found !",categories));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse("Error",INTERNAL_SERVER_ERROR));
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addCategory(@RequestBody Category name) {
        try {
            Category theCategory = categorySevice.addCategory(name);
            return ResponseEntity.ok().body(new ApiResponse("Added !",theCategory));
        } catch (AlreadyExistsException e) {
            return ResponseEntity.status(CONFLICT).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/category/{id}/category")
    public ResponseEntity<ApiResponse> getCategoryById(@PathVariable Long id) {
        try {
            Category category = categorySevice.getCategoryById(id);
            return ResponseEntity.ok().body(new ApiResponse("Found !",category));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/category/{name}/category")
    public ResponseEntity<ApiResponse> getCategoryByName(@PathVariable String name) {
        try {
            Category theCategory = categorySevice.getCategoryByName(name);
            return ResponseEntity.ok().body(new ApiResponse("Found !",theCategory));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @DeleteMapping("/category/{id}/delete")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Long categoryId) {
        try {
            categorySevice.deleteCategoryById(categoryId);
            return ResponseEntity.ok().body(new ApiResponse("Found !",null));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @PutMapping("/category/{id}/update")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable Long categoryId, @RequestBody Category updatedCategory) {
        try {
            Category category = categorySevice.updateCategory(updatedCategory,categoryId);
            return ResponseEntity.ok().body(new ApiResponse("Update success!",category));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }
    }

}
