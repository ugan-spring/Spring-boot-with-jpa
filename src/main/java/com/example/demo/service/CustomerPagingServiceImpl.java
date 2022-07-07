package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Customer;
import com.example.demo.repository.CustomerPagingRepository;

@Service
public class CustomerPagingServiceImpl {

	@Autowired
	private CustomerPagingRepository customerPagingRepository;
	
	public List<Customer> getAllDetails(int pageNo, int pageSize, String sortBy) {
		
	Pageable page	= PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
	
	Page<Customer>  custs = customerPagingRepository.findAll(page);
		
	return custs.getContent();
		
	}

	
}
