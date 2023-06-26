package com.ecommerce.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommerce.demo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
