package raju.mac.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import raju.mac.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
