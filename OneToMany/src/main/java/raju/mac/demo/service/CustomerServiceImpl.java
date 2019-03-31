package raju.mac.demo.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import raju.mac.demo.entity.Customer;
import raju.mac.demo.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private static Logger logger = Logger.getLogger(CustomerServiceImpl.class);

	
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public Customer getCustomerDetailsById(Integer id) {
		return customerRepo.getOne(id);
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		
		return customerRepo.save(customer);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepo.findAll();
	}

	@Override
	public void deleteCustomerById(Integer id) {
		customerRepo.deleteById(id);
	}

	@Override
	public Customer updateCustomerById(Customer customer, Integer id) {
		logger.info("## inside UserServiceImpl updateUserById() ##" );
		Customer retrievedCustomer = customerRepo.getOne(id);
		logger.info("##  given  ##" + retrievedCustomer);

		if(!retrievedCustomer.equals(null) ) {
			customer.setId(id);
			logger.info("##  given USER_ID ##" + retrievedCustomer);
			return customerRepo.save(customer);
		}else {
			logger.error("## No records found with the given USER_ID ##");
			return null;
		}
	}

}
