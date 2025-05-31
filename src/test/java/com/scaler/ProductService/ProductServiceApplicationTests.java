package com.scaler.ProductService;

import com.scaler.ProductService.model.Category;
import com.scaler.ProductService.model.Product;
import com.scaler.ProductService.repositories.ProductRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class ProductServiceApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private EntityManager entityManager;


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

	@Test
	@Transactional
	void testCascadeTypeReferesh(){

		Product product = entityManager.find(Product.class,1);
		System.out.println("Before refresh :  " + product.getCategory().getTitle());

		product.getCategory().setTitle("New clothes");
		System.out.println("In-memory change " + product.getCategory().getTitle());

		entityManager.refresh(product);

		System.out.println("Before refresh :  " + product.getCategory().getTitle());
	}

	@Test
	@Transactional
	void testCascadeTypeDetach(){

		Product product = entityManager.find(Product.class,1);
		Category category = product.getCategory();

		System.out.println("before detach ..");
		System.out.println("Context has product object ?" + entityManager.contains(product));
		System.out.println("Context has category object ?" + entityManager.contains(category));

		//Detach
		entityManager.detach(product);

		System.out.println("after detach ..");
		System.out.println("Context has product object ?" + entityManager.contains(product));
		System.out.println("Context has category object ?" + entityManager.contains(category));
	}
}
