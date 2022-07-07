package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Customer;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerServiceImpl {

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getAllCust(){
		return customerRepository.findAll(); 
	}

	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	public Customer updateCustomer(Customer customer, int id) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		Optional<Customer> cust = customerRepository.findById(id);
		if(cust.isPresent()) {
			Customer custObj = cust.get();
			custObj.setId(id);
			custObj.setName(customer.getName());
			custObj.setLastName(customer.getLastName());
			custObj.setPincode(customer.getPincode());
			return customerRepository.save(custObj);
		} else {
			throw new CustomerNotFoundException("Customer Not present for this ID");
		}
	}

	public Customer findById(int id) {
		// TODO Auto-generated method stub
		Optional<Customer> customer = customerRepository.findById(id);
		return customer.get();
	}

	public String deleteById(int id) {
		// TODO Auto-generated method stub
		try {
			customerRepository.deleteById(id);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "record deleted sucessfully";
	}

	public List<Customer> getAllCustByPage(int pageNo, int pageSize, String sortBy) {
		// TODO Auto-generated method stub
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<Customer> page = customerRepository.findAll(paging);
		return page.getContent();
	}

	public Customer getCustomerByNameAndPinCode(String name, String pinCode) {
		// TODO Auto-generated method stub
		return customerRepository.findCustomerByNameAndPinCode(name, pinCode);
	}

	public Customer getCustomerByQuery(String name, String pinCode) {
		// TODO Auto-generated method stub
		return customerRepository.findByNameOrPincode(name, pinCode);
	}
}
