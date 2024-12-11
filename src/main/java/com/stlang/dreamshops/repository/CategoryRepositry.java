package com.stlang.dreamshops.repository;

import com.stlang.dreamshops.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface CategoryRepositry extends JpaRepository<Category, Long> {
    Category findByName(String name);
    boolean existsByName(String name);
}
