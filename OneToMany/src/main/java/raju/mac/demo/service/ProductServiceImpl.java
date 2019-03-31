package raju.mac.demo.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import raju.mac.demo.entity.Product;
import raju.mac.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	private static Logger logger = Logger.getLogger(CustomerServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product getProductDetailsById(Integer id) {
		return productRepository.getOne(id);
	}

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public void deleteProductById(Integer id) {
		productRepository.deleteById(id);
		
	}

	@Override
	public Product updateProductById(Product product, Integer id) {
		logger.info("## inside ProductServiceImpl updateProductById() ##" );
	Product retrievedProduct = productRepository.getOne(id);
	logger.info("##  given  ##" + retrievedProduct);

	if(!retrievedProduct.equals(null) ) {
		product.setId(id);
		logger.info("##  given USER_ID ##" + retrievedProduct);
		return productRepository.save(product);
	}else {
		logger.error("## No records found with the given PRODUCT_ID ##");
		return null;
	}
}

}
