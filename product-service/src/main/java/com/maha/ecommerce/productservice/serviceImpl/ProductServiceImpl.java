package com.maha.ecommerce.productservice.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.maha.ecommerce.productservice.exceptions.CategoryNotFoundException;
import com.maha.ecommerce.productservice.models.Category;
import com.maha.ecommerce.productservice.models.Product;
import com.maha.ecommerce.productservice.repository.CategoryRepository;
import com.maha.ecommerce.productservice.repository.ProductRepository;
import com.maha.ecommerce.productservice.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Product getProductById(Long id) {

		return productRepository.findById(id).get();
	}

	@Override
	public Page<Product> getAllProducts(int pageNumber, int pageSize) {

		return productRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("price").ascending()));
	}

	@Override
	public Product updateProduct(Long id, Product product) {

		return null;
	}

	@Override
	public Product replaceProduct(Long id, Product product) {

		return null;
	}

	@Override
	public Product createProduct(Product product) throws CategoryNotFoundException {

		Category category = product.getCategory();
		if (category.getId() == null) {
			// we need to save the category.
			Category savedCategory = categoryRepository.save(category);
			product.setCategory(savedCategory);
		} else {
			// we should check if the category is id valid or not.
			Optional<Category> fetchedCategory = categoryRepository.findById(category.getId());
			if (!fetchedCategory.isPresent())
				throw new CategoryNotFoundException(category.getId(), "Category not found.");
		}

		Product savedProduct = productRepository.save(product);
		Optional<Category> optionalCategory = categoryRepository.findById(savedProduct.getCategory().getId());
		Category category2 = optionalCategory.get();
		savedProduct.setCategory(category2);
		return savedProduct;
	}

}
