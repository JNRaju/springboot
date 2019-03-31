package raju.mac.demo.service;

import java.util.List;

import raju.mac.demo.entity.Product;

public interface ProductService {
	
	
	Product getProductDetailsById(Integer id);
	
	Product saveProduct(Product product);
	
	List<Product> getAllProducts();
	
	void deleteProductById(Integer Id);
	
	Product updateProductById(Product product,Integer Id);

}
