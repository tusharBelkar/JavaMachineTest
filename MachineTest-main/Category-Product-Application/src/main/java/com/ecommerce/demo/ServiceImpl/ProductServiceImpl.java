package com.ecommerce.demo.ServiceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ecommerce.demo.CategoryProductApplication;
import com.ecommerce.demo.Repository.ProductRepository;
import com.ecommerce.demo.Service.ProductService;
import com.ecommerce.demo.entity.Product;

@Service
public class ProductServiceImpl implements ProductService{

	private static final Logger logger=LoggerFactory.getLogger(CategoryProductApplication.class);

	@Autowired
	private ProductRepository productRepository;
	

	
	@Override
	public Product saveProduct(Product product) {
		logger.info("Product Service Implementation : saveProduct() method");

		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		logger.info("Product Service Implementation : getAllProducts() method");

		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		logger.info("Product Service Implementation : getProductById() method");
		return productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException ("Product not found"));
	}

	@Override
	public void deleteProduct(Long id) {
		logger.info("Product Service Implementation : deleteProduct() method");
		productRepository.deleteById(id);
		
	}

	@Override
	public Page<Product> getProductPagination(Integer pageNumber, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return productRepository.findAll(pageable);
	
	}

}
