package com.spring.ProductManagementApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public String createProduct(@RequestBody Product products) {
		productService.addProducts(products);
		return "Product \"" + products.getProduct() + "\" created Successfully";
	}
	
	@GetMapping
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public Object getProductById(@PathVariable int id) {
		Product product = productService.getProductById(id);
		
		if(product != null) {
			return  product;
		}else {
			return "Product with ID " +  id + " not found!";
		}
	}
	
	@PutMapping("/{id}")
	public String updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
		boolean updated = productService.updateProduct(id, updatedProduct);
		
		if(updated) {
			return "Product with ID " + id + " updated successfully!";
		}else {
			return "Product with ID " + id + " not found!";
		}
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable int id) {
		boolean deleted = productService.deleteProduct(id);
		if(deleted) {
			return "Product with ID " + id + " deleted successfully!";
		}
		return "Product with ID " + id + " not found!";
	}
	
	
}
