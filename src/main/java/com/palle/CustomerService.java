package com.palle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//uses the repository to perform db operation
@Service
public class CustomerService 
{
	//cus ser depend on cus repo(dependency Injection)
	@Autowired
	private CustomerRepository customerRepository;
	
	//read
	public List<Customer> getAllCustomers()
	{
		return customerRepository.findAll();
	}
	
	//read data by using id
	public Customer getCustomerById(Integer id)
	{
		return customerRepository.findById(id).orElse(null);
	}
	
	//save
	public Customer saveCustomer(Customer customer)
	{
		return customerRepository.save(customer);
	}
	
	//delete 
	public void deleteCustomer(Integer id)
	{
		customerRepository.deleteById(id);
	}
}
