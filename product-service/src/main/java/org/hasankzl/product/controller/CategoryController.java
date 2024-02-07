package org.hasankzl.product.controller;


import lombok.RequiredArgsConstructor;
import org.hasankzl.product.model.Category;
import org.hasankzl.product.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/categories")
@RequiredArgsConstructor
public class CategoryController {

private final   CategoryService categoryService;


    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoryService.save(category));
    }
}
