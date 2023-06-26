package com.ecommerce.demo.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.demo.CategoryProductApplication;
import com.ecommerce.demo.Service.ProductService;
import com.ecommerce.demo.entity.Category;
import com.ecommerce.demo.entity.Product;


@RestController
@RequestMapping("/api/products")
public class ProductController {
	 
	private static final Logger logger=LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private  ProductService productService;

	@GetMapping(value = "/Paging/{pageNumber}/{pageSize}")
    public Page<Product> getProductPagination(@PathVariable Integer pageNumber, @PathVariable Integer pageSize){
    	logger.info("\"Product Rest Controller Implementation : getProductPagination() method\"");
    	return productService.getProductPagination(pageNumber,pageSize);
    }

    @GetMapping //http://localhost:8080/api/products?page=2
    public ResponseEntity<List<Product>> getAllProducts( @RequestParam("page") int page) {
    	List<Product> Allproduct= productService.getAllProducts();
    	logger.info("\"Product Rest Controller Implementation : getAllProducts() method\"");
        return ResponseEntity.ok().body(Allproduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
       Product getProduct=  productService.getProductById(id);
   	logger.info("\"Product Rest Controller Implementation : getProductById() method\"");
         return ResponseEntity.ok().body(getProduct);
    }

    @PostMapping("/save")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
         Product cProduct=productService.saveProduct(product);
        	logger.info("\"Product Rest Controller Implementation : createProduct() method\"");
         return ResponseEntity.ok().body(cProduct);
    }
    
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product ) {
    	Product Productupdate= productService.saveProduct(product);
    	logger.info("\"Product Rest Controller Implementation : updateProduct() method\"");
    	 return ResponseEntity.ok().body(Productupdate);
    }
    
}
