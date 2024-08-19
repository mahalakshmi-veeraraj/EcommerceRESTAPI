package com.maha.ecommerce.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maha.ecommerce.productservice.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
