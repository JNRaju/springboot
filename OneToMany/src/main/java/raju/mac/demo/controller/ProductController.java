package raju.mac.demo.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import raju.mac.demo.entity.Product;
import raju.mac.demo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	private static Logger logger = Logger.getLogger(ProductController.class);
	
	@GetMapping(value = "/getProductDetails/{productId}")
	public ResponseEntity<Product> getproductById(@PathVariable("productId") Integer productId){
		logger.info("## inside productController getproductById() ##");
		Product product= null;
		
		try {
			product = productService.getProductDetailsById(productId);
			
		}catch(Exception e){
			logger.error("## Exception in getproductById() ##" + e);
			return new ResponseEntity<>(product,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		  return new ResponseEntity<Product>(product,HttpStatus.OK);
		
	}
	
	
	@PostMapping(value = "/createProduct")
	public ResponseEntity<Product> createproduct(@RequestBody Product product){
		logger.info("## inside productController createproduct() ##");
		Product saveproduct= null;
		
		try {
			
			saveproduct = productService.saveProduct(product);
		}catch(Exception e){
			logger.error("## Exception in createproduct() ##" + e);
			return new ResponseEntity<>(saveproduct,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		  return new ResponseEntity<Product>(saveproduct,HttpStatus.OK);
		
	}
	
	
	@PostMapping(value = "/updagteProduct/{productId}")
	public ResponseEntity<Product> updateproduct(@PathVariable("productId") Integer productId, @RequestBody Product product){
		logger.info("## inside productController updateproduct() ##");
		Product updateproduct= null;
		
		try {
			updateproduct = productService.updateProductById(product, productId);
		}catch(Exception e){
			logger.error("## Exception in updateproduct() ##" + e);
			return new ResponseEntity<>(updateproduct,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		  return new ResponseEntity<Product>(updateproduct,HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/getAllproducts")
	public ResponseEntity<List<Product>> getAllproducts(){
		logger.info("## inside productController getAllproducts() ##");
		List<Product> products = null;
		
		try {
			products = productService.getAllProducts();
			
		}catch(Exception e){
			logger.error("## Exception in getAllproducts() ##" + e);
			return new ResponseEntity<>(products,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		  return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/deleteproduct/{productId}")
	public ResponseEntity<Product> deleteproductById(@PathVariable("productId") Integer productId){
		logger.info("## inside productController deleteproductById() ##");

		
		try {
			productService.deleteProductById(productId);
			
		}catch(Exception e){
			logger.error("## Exception in deleteproductById() ##" + e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		  return new ResponseEntity<Product>(HttpStatus.OK);
		
	}



}
