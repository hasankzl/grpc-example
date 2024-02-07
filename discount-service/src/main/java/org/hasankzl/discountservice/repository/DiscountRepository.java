package org.hasankzl.discountservice.repository;

import org.hasankzl.discountservice.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiscountRepository extends JpaRepository<Discount,Integer> {

    Optional<Discount> findByCodeAndCategoryId(String code,Integer categoryId);
}
