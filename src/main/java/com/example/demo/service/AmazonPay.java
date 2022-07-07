package com.example.demo.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PaymentRequest;

@Service()
@Primary
public class AmazonPay implements PaymentService {

	@Override
	public String pay(PaymentRequest request) {
		// TODO Auto-generated method stub
		return request.getAmount() +"Amazon Pay Paid Amount Sucessfully "+request.getPaymentMethod();
	}

}
