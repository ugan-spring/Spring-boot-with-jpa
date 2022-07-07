package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.PaymentRequest;

@Service("WhatsAppPay")
public class WhatsAppPay implements PaymentService{

	@Override
	public String pay(PaymentRequest request) {
		// TODO Auto-generated method stub
		return request.getAmount() +" Paid Amount Sucessfully "+request.getPaymentMethod();
	}
}
