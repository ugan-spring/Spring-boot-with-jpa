package com.example.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Customer;

@Repository
public interface CustomerPagingRepository extends PagingAndSortingRepository<Customer, Integer>{

}
