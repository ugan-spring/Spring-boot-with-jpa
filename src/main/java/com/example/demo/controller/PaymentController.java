package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MailProps;
import com.example.demo.dto.PaymentRequest;
import com.example.demo.service.AmazonPay;
import com.example.demo.service.GooglePay;
import com.example.demo.service.PaymentRegistry;
import com.example.demo.service.PaymentService;
import com.example.demo.service.PhonePe;

@RestController
@RequestMapping("/payment")
@PropertySource("classpath:custom.properties")
public class PaymentController {

	/*
	 * @Autowired GooglePay google;
	 * 
	 * @Autowired AmazonPay amzon;
	 * 
	 * @Autowired PhonePe phone;
	 */
	

	@Autowired PaymentRegistry registry;
	 
	
	
	public PaymentController() {
		// TODO Auto-generated constructor stub
		
		System.out.println("Invocking Paymentcontroller ******************");
	}
	@PostMapping("/pay")
	public String paymentProcess(@RequestBody PaymentRequest request) {
		System.out.println("Am Inside /Pay API **********************");
		String result = "";
		/*
		 * if("GooglePe".equals(request.getPaymentMethod())) { result =
		 * google.pay(request); } else if("PhonePe".equals(request.getPaymentMethod()))
		 * { result = phone.pay(request); } else
		 * if("AmzonPay".equals(request.getPaymentMethod())) { result =
		 * amzon.pay(request); }
		 */
		
		return registry.getServiceBean(request.getPaymentMethod()).pay(request);
		
	}
	
	@Autowired
	private PaymentService paymentService;
	
	@Value("${mail.from}")
	private String from;
	
	@Value("${mail.cc}")
	private String cc;
	
	@Value("${mail.subject}")
	private String subject;

	@Value("${gmail.from}")
	private String gmailFrom;
	
	@Value("${gmail.sub}")
	private String gmailSubject;
	
	@Autowired
	private MailProps mailProps;
	
	@GetMapping("/call")
	public String check(@RequestParam("id") int id, @RequestParam(value= "name", required = false) String name  ) {
		
		//LazyLoading lazyLoading = new LazyLoading();
		System.out.println(" This for ConfigProps : " +mailProps.getFrom() + " Request param : "+id + "  :: name : "+name);
		System.out.println("custome properties Gmail : "+gmailFrom +" :: Gmail Sub : " +gmailSubject);
		return "From : "+from + "  CC :: "+cc + "  Subject :: "+subject;
//		PaymentRequest obj = new PaymentRequest();
//		obj.setAmount(1.00);
//		obj.setPaymentMethod("paaaay");
//		return paymentService.pay(obj);
		
	}
	
	@PostMapping("/ctrl")
	public PaymentRequest paymentProcessCtrl(@RequestBody PaymentRequest request) {
		System.out.println("Am Inside /paymentProcessCtrl API ********************** :: "+request.getPaymentMethod());
		
		return request;
		
	}
}
