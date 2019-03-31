package raju.mac.demo.service;

import java.util.List;

import raju.mac.demo.entity.Customer;

public interface CustomerService {
	
	Customer getCustomerDetailsById(Integer id);
	
	Customer saveCustomer(Customer customer);
	
	List<Customer> getAllCustomer();
	
	void deleteCustomerById(Integer Id);
	
	Customer updateCustomerById(Customer customer,Integer Id);

}
