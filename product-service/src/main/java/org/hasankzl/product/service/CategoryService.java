package org.hasankzl.product.service;

import lombok.RequiredArgsConstructor;
import org.hasankzl.product.model.Category;
import org.hasankzl.product.repository.CategoryRepository;
import org.hasankzl.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;


    public Category save(Category category){
        return categoryRepository.save(category);
    }
}
