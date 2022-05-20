package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.model.Product;
import com.ibm.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepo;

	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}

	public Product getProductById(int id) {
		return productRepo.findById(id);
	}

	public Product getProductByname(String productname) {
		return productRepo.findByProductname(productname);
	}

	public Product addProduct(Product product) {
		return productRepo.saveAndFlush(product);
	}

	public void deleteById(int id) {
		productRepo.deleteById(id);
	}

}
