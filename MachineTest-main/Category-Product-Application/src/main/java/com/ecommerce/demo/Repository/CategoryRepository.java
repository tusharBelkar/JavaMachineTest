package com.ecommerce.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.demo.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
