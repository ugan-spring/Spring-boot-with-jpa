package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Customer;
import com.example.demo.service.CustomerPagingServiceImpl;
import com.example.demo.service.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerCtrl {

	@Autowired
	private CustomerPagingServiceImpl customerPagingServiceImpl;
	
	@GetMapping("findAllPage")
	public List<Customer> getAllDetails(
			@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "5") int pageSize,
			@RequestParam(defaultValue = "id") String sortBy){
		System.out.println("Am inside Pagination concept");
		return customerPagingServiceImpl.getAllDetails(pageNo, pageSize, sortBy);
	}
	
}
