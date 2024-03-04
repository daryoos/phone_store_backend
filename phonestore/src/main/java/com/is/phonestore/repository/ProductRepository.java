package com.is.phonestore.repository;

import com.is.phonestore.model.Product;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAll();
    @Query(value = "select prdct from Product prdct where prdct.productId = :productId")
    Product findProductByProductId(@Param("productId") Long productId);

    List<Product> getProductsBySoldIsFalse();

    @Query(value = "select prdct from Product prdct where prdct.userId = :userId")
    List<Product> findProductsByUserId(@Param("userId") Long userId);
}
