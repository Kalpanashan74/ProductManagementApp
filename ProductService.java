package com.spring.ProductManagementApp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	private List<Product> products = new ArrayList<>();

	public ProductService() {
		products.add(new Product(1, "Ice Cream", 150.00, 10));
		products.add(new Product(2, "Cakes", 350.00, 20));
		products.add(new Product(3, "Chocolate", 50.00, 13));
		products.add(new Product(4, "Biscuits", 30.00, 19));
		products.add(new Product(5, "Cookies", 15.00, 25));
	}
	
	public List<Product> getAllProducts(){
		return products;
	}
	
	public Product getProductById(int id) {
		for(Product product: products) {
			if(product.getId() == id) {
				return product;
			}
		}
		return null;
	}
	
	public void addProducts(Product prod) {
		products.add(prod);
	}
	
	public boolean updateProduct(int id, Product prod) {
		for(Product product : products) {
			if(product.getId() == id) {
				product.setPrice(prod.getPrice()); 
				product.setProduct(prod.getProduct());
				product.setQuantity(prod.getQuantity());
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteProduct(int id) {
		return products.removeIf(product -> product.getId() == id);
	}
}
