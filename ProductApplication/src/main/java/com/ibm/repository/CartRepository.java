package com.ibm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.model.Cart;
import com.ibm.model.Product;

public interface CartRepository extends JpaRepository<Cart, Integer> {
	public List<Cart> findAll();

	public Cart findById(int id);

	public Cart saveAndFlush(Product product);
}
