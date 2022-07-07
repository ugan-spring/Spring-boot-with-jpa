package com.example.demo.service;

public interface PaymentRegistry {

	public PaymentService getServiceBean(String paymentMethod);
	
}
