package com.stlang.dreamshops.service.category;

import com.stlang.dreamshops.exceptions.AlreadyExistsException;
import com.stlang.dreamshops.exceptions.ResourceNotFoundException;
import com.stlang.dreamshops.model.Category;
import com.stlang.dreamshops.repository.CategoryRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.rmi.AlreadyBoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategorySevice implements ICategorySevice{
    private final CategoryRepositry categoryRepositry;
    @Override
    public Category getCategoryById(Long id) {
        return categoryRepositry.findById(id)
                .orElseThrow(() ->new ResourceNotFoundException("Category  not found !"));
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepositry.findByName(name);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepositry.findAll();
    }

    @Override
    public Category addCategory(Category category) {
        return Optional.ofNullable(category).filter( c -> !categoryRepositry.existsByName(c.getName()))
                .map(categoryRepositry::save)
                .orElseThrow(() -> new AlreadyExistsException(category.getName() + " already exists"));
    }

    @Override
    public Category updateCategory(Category category, Long id) {
        return Optional.ofNullable(getCategoryById(id)).map(oldCagory ->{
            oldCagory.setName(category.getName());
            return categoryRepositry.save(oldCagory);
        }).orElseThrow( () -> new ResourceNotFoundException("Category  not found !"));
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepositry.findById(id).ifPresentOrElse(categoryRepositry::delete,()->{
            throw new ResourceNotFoundException("Category not found !");
        });
    }
}
