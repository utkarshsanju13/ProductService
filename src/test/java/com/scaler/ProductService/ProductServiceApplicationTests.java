package com.scaler.ProductService;

import com.scaler.ProductService.model.Product;
import com.scaler.ProductService.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceApplicationTests {

	@Autowired
	private ProductRepository productRepository;


	@Test
	void contextLoads() {
	}

	@Test
	void testProductById(){
		Product product = productRepository.getProductUsingIdByHQL(Long.valueOf(1));
		System.out.println("DEBUG..");
	}

	@Test
	void testProductByIdUsingNativeQuey(){
		Product product = productRepository.getProductUsingIdByNativeQuery(Long.valueOf(1));
		System.out.println("DEBUG..");
	}



}
