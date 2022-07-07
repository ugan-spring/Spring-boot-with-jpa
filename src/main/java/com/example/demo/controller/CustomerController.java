package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Customer;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.service.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	@GetMapping("/findByCustom/{name}/{pincode}")
	public Customer getCustomerByNameAndPinCode(@PathVariable("name") String name, @PathVariable("pincode") String pinCode) {
		return customerServiceImpl.getCustomerByNameAndPinCode(name, pinCode);
	}
	
	@GetMapping("/findByQuery/{name}/{pincode}")
	public Customer getCustomerByQuery(@PathVariable("name") String name, @PathVariable("pincode") String pinCode) {
		return customerServiceImpl.getCustomerByQuery(name, pinCode);
	}
	
	
	@GetMapping
	public List<Customer> getAllCustomer(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "5") int pageSize,
			@RequestParam(defaultValue = "name") String sortBy){
		
		customerServiceImpl.getAllCustByPage(pageNo, pageSize, sortBy);
		return null;
		
	}
	
	@GetMapping("/findAll")
	public List<Customer> getAllCust(){
		return customerServiceImpl.getAllCust();
	}
	
	@GetMapping("/findById/{id}")
	public Customer findById(@PathVariable("id") int id){
		return customerServiceImpl.findById(id);
	}
	
	
	@PostMapping("/save")
	public Customer saveCustomer(@RequestBody Customer customer){
		return customerServiceImpl.saveCustomer(customer);
	}
	
	@PutMapping("/update/{id}")
	public Customer updateCustomer(@RequestBody Customer customer , @PathVariable("id") int id) throws CustomerNotFoundException {
		return customerServiceImpl.updateCustomer(customer, id);
	}

	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable("id") int id) {
		return customerServiceImpl.deleteById(id);
	}
	
}
