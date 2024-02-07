package org.hasankzl.product.controller;


import lombok.RequiredArgsConstructor;
import org.hasankzl.product.model.Product;
import org.hasankzl.product.repository.ProductRepository;
import org.hasankzl.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> add(@RequestBody Product product){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.save(product));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.getAll());
    }
}
