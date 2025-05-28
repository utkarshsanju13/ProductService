package com.scaler.ProductService.repositories;

import com.scaler.ProductService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long product_id);

    //HQL : where we use Product as model in the query
    @Query("SELECT p FROM Product p WHERE p.id = :id")
    Product getProductUsingIdByHQL(@Param("id") Long id);

    @Query(value = "SELECT * FROM products WHERE id = :id" , nativeQuery = true)
    Product getProductUsingIdByNativeQuery(@Param("id") Long id);

}
