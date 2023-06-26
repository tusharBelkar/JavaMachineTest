package com.ecommerce.demo.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ecommerce.demo.entity.Product;

public interface ProductService {

	public Product saveProduct(Product product);
	public List<Product> getAllProducts();
	public Product getProductById(Long id);
	public void deleteProduct (Long id);
	public Page<Product> getProductPagination(Integer pageNumber, Integer pageSize);
}
