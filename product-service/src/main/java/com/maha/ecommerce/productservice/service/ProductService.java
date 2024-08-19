package com.maha.ecommerce.productservice.service;

import org.springframework.data.domain.Page;

import com.maha.ecommerce.productservice.exceptions.CategoryNotFoundException;
import com.maha.ecommerce.productservice.models.Product;

public interface ProductService {
	Product getProductById(Long id);

	Page<Product> getAllProducts(int pageNumber, int pageSize);

	Product updateProduct(Long id, Product product);

	Product replaceProduct(Long id, Product product);

	Product createProduct(Product product) throws CategoryNotFoundException;
}
