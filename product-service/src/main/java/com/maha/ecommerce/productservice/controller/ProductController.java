package com.maha.ecommerce.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maha.ecommerce.productservice.exceptions.CategoryNotFoundException;
import com.maha.ecommerce.productservice.models.Product;
import com.maha.ecommerce.productservice.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
		ResponseEntity<Product> responseEntity = null;
		try {
			Product product = productService.getProductById(id);
			responseEntity = new ResponseEntity<Product>(product, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@GetMapping
	public Page<Product> getAllProducts(@RequestParam("pageNumber") int pageNumber,
			@RequestParam("pageSize") int pageSize) {

		return productService.getAllProducts(pageNumber, pageSize);
	}

	@PutMapping
	public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {

		return productService.replaceProduct(id, product);
	}

	@PostMapping
	public Product createProduct(@RequestBody Product product) throws CategoryNotFoundException {

		return productService.createProduct(product);
	}

}
