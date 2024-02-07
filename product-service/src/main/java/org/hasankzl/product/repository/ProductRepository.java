package org.hasankzl.product.repository;

import org.hasankzl.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product,Integer> {

}
