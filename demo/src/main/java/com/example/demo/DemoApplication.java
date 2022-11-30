package com.example.demo;
import com.example.entity.Product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entity.Category;
import com.example.entity.Product;
import com.example.entity.repo.ProductRepository;
import org.springframework.*;
@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private ProductRepository productRepository; 
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Product product = new Product(1, "ParleG",30);
		
		Category category = new Category(2, "biskit", "Tasty");
		Category category1 = new Category(3, "namkeen", "Tasty");
		Category category2 = new Category(4, "sev", "Tasty");
		
		product.getCategorius().add(category);
		product.getCategorius().add(category1);
		product.getCategorius().add(category2);
		
		
		//this.productRepository.saveAll(product);
		this.productRepository.save(product);
		
	}

}
