package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query(value="SELECT * FROM CUSTOMER  WHERE name=:name and pincode=:pinCode ", nativeQuery = true)
	Customer findCustomerByNameAndPinCode(@Param("name") String name, @Param("pinCode") String pinCode);

	Customer findByNameOrPincode(String name, String pinCode);

}
