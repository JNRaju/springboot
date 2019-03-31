package raju.mac.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import raju.mac.demo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
