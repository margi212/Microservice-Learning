package com.ibm.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.model.Cart;
import com.ibm.model.Product;
import com.ibm.service.CartService;
import com.ibm.service.ProductService;

@CrossOrigin(origins = "http://localhost:8080")
@Controller
@RequestMapping
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	CartService cartService;

	@GetMapping
	public String getAllProduct(Model model) {
		model.addAttribute("product", productService.getAllProduct());
		return "product";
	}

	@GetMapping("/addproduct")
	public String addProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "addproduct";
	}

	@GetMapping("/cart")
	public String getCart(Model model) {
		model.addAttribute("cart", cartService.getAllProduct());
		return "success";
	}

	@GetMapping("/cart/order")
	public String getOrder(Model model) {
		return "order";
	}

	@GetMapping("{id}")
	public Product getById(@PathVariable int id) {
		return productService.getProductById(id);
	}

	@GetMapping("/productname/{productname}")
	public Product getProductById(@PathVariable String productname) {
		return productService.getProductByname(productname);
	}

	@PostMapping("/saveproduct")
	public String saveProduct(@ModelAttribute("product") Product product) {
		productService.addProduct(product);
		return "redirect:/product";
	}

	@PostMapping("/savecart")
	public String saveProduct(@Valid @ModelAttribute("cart") Cart cart, BindingResult result, ModelMap model) {
		Product products = productService.getProductById(cart.getId());
		Cart cartinfo = (Cart) objectMapper(products);
		cartService.addProduct(cartinfo);
		model.addAttribute("cart", cartinfo);
		return "success";
	}

	public static Object objectMapper(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		Cart cartinfo = mapper.convertValue(object, Cart.class);
		return cartinfo;
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String updateProduct(@PathVariable(value = "id") int id, Model model) {
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		return "update";
	}

	@GetMapping("/deleteProduct/{id}")
	public String deleteThroughId(@PathVariable(value = "id") int id) {
		productService.deleteById(id);
		return "redirect:/product";

	}

	@PutMapping("{id}")
	public ResponseEntity<Product> updateConverionFactor(@PathVariable int id, @Valid @RequestBody Product product) {
		Product result = productService.addProduct(product);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(result.getId())
				.toUri();
		return ResponseEntity.created(location).body(result);
	}
}
