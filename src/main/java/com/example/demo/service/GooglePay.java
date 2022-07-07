package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.PaymentRequest;

@Service()
public class GooglePay implements PaymentService{

	@Override
	public String pay(PaymentRequest request) {
		// TODO Auto-generated method stub
		return request.getAmount() +" Google PAy Paid Amount Sucessfully "+request.getPaymentMethod();
	}
}
