package org.hasankzl.product.service;

import lombok.RequiredArgsConstructor;
import org.hasankzl.product.model.Product;
import org.hasankzl.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public Product save(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAll(){

        return productRepository.findAll();
    }

    public Product getById(int productId) {

    return productRepository.findById(productId).get();
    }
}
