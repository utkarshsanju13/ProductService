package com.scaler.ProductService.repositories;

import com.scaler.ProductService.Projection.ProductProjection;
import com.scaler.ProductService.model.Category;
import com.scaler.ProductService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
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

    @Query("select p.title, p.price from Product p where p.title = 'iphone' and p.price < 10000.0")
    void findTitleAndPriceBYId();

    //select * from product where title = ""
    List<Product> findByTitle(String title);

    //select * from product where title LIKE '%title%'
    List<Product> findByTitleContainsIgnoreCase(String title);

    //select * from product where title LIKE '%str%' and price >= start and price <= end
//    List<Product> findByTitleContainsIgnoreCaseAndPriceBetween(Date start, Date end);

    void deleteById(Long id);

    //Join query provide by hibernate
    //Hibernate will execute the left join query on product and category table
    //select * from product left join category on product.id = category.id where category.title = "?"
    Optional<Product> findByCategory_title(String title);

    ProductProjection findFirstByTitle(String title);

}
