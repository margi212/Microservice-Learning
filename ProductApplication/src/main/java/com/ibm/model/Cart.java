package com.ibm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	int id;

	@Column(name = "product_name")
	String productname;

	@Column(name = "Catagory")
	String catagory;

	@Column(name = "price")
	int price;

	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(int id, String productname, String catagory, int price) {
		super();
		this.id = id;
		this.productname = productname;
		this.catagory = catagory;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", productname=" + productname + ", catagory=" + catagory + ", price=" + price + "]";
	}

}
