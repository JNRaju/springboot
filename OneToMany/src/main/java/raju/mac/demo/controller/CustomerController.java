package raju.mac.demo.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import raju.mac.demo.entity.Customer;
import raju.mac.demo.service.CustomerService;


@RequestMapping("/customer")
@RestController
@CrossOrigin
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	private static Logger logger = Logger.getLogger(CustomerController.class);
	
	@GetMapping(value = "/getCustomerDetails/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") Integer customerId){
		logger.info("## inside CustomerController getCustomerById() ##");
		Customer Customer= null;
		
		try {
			Customer = customerService.getCustomerDetailsById(customerId);
			
		}catch(Exception e){
			logger.error("## Exception in getCustomerById() ##" + e);
			return new ResponseEntity<>(Customer,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		  return new ResponseEntity<Customer>(Customer,HttpStatus.OK);
		
	}
	
	
	@PostMapping(value = "/createCustomer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		logger.info("## inside CustomerController createCustomer() ##");
		Customer saveCustomer= null;
		
		try {
			
			saveCustomer = customerService.saveCustomer(customer);
		}catch(Exception e){
			logger.error("## Exception in createCustomer() ##" + e);
			return new ResponseEntity<>(saveCustomer,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		  return new ResponseEntity<Customer>(saveCustomer,HttpStatus.OK);
		
	}
	
	
	@PostMapping(value = "/updagteCustomer/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") Integer customerId, @RequestBody Customer customer){
		logger.info("## inside CustomerController updateCustomer() ##");
		Customer updateCustomer= null;
		
		try {
			updateCustomer = customerService.updateCustomerById(customer, customerId);
		}catch(Exception e){
			logger.error("## Exception in updateCustomer() ##" + e);
			return new ResponseEntity<>(updateCustomer,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		  return new ResponseEntity<Customer>(updateCustomer,HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		logger.info("## inside CustomerController getAllCustomers() ##");
		List<Customer> customers = null;
		
		try {
			customers = customerService.getAllCustomer();
			
		}catch(Exception e){
			logger.error("## Exception in getAllCustomers() ##" + e);
			return new ResponseEntity<>(customers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		  return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/deleteCustomer/{customerId}")
	public ResponseEntity<Customer> deleteCustomerById(@PathVariable("customerId") Integer customerId){
		logger.info("## inside CustomerController deleteCustomerById() ##");

		
		try {
			customerService.deleteCustomerById(customerId);
			
		}catch(Exception e){
			logger.error("## Exception in deleteCustomerById() ##" + e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		  return new ResponseEntity<Customer>(HttpStatus.OK);
		
	}

}
