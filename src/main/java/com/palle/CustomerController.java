package com.palle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//handle all httprequest
@RestController
@RequestMapping("/api/customers")
public class CustomerController 
{
	//cus con depend on cus service(dependency Injection)
	@Autowired
	private CustomerService customerService;
	
	//read all data
	@GetMapping
	public List<Customer> getAllCustomers()
	{
		return customerService.getAllCustomers();
	}
	
	//based on id i want to read data
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable Integer id)
	{
		return customerService.getCustomerById(id) ;
	}
	
	
	//create data and add to cus table
	@PostMapping
	public Customer createCustomer(@RequestBody Customer customer)
	{
		return customerService.saveCustomer(customer);
	}
	
	
	//update the data based on id
	//2 parameter (1 is for get that data and 2 is for post that data)
	@PutMapping("/{id}")
	public Customer updateCustomer(@PathVariable Integer id,@RequestBody Customer customer)
	{
		//for updating first want to read(get) data 
		 Customer existingCustomer=customerService.getCustomerById(id);
		 if(existingCustomer==null)
		 {
			 return null;
		 }
		 existingCustomer.setFirstname(customer.getFirstname());
		 existingCustomer.setLastname(customer.getLastname());
		 existingCustomer.setEmail(customer.getEmail());
		 
		 //2nd ly send(read) that data
		 return customerService.saveCustomer(existingCustomer);
	}
	
	
	//delete customer based on id
	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable Integer id)
	{
		customerService.deleteCustomer(id);
	}
	

}
