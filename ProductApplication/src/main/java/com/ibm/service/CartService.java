package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.model.Cart;
import com.ibm.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepo;

	public List<Cart> getAllProduct() {
		return cartRepo.findAll();
	}

	public Cart getProductById(int id) {
		return cartRepo.findById(id);
	}

	public Cart addProduct(Cart cart) {
		return cartRepo.saveAndFlush(cart);
	}
}
