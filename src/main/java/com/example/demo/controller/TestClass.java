package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;

public class TestClass {

	@Value("${mail.cc}")
	private String cc;
	
	@Value("${mail.subject}")
	private String subject;
	
	public static void main(String args[]) {
		TestClass obj = new TestClass();
		System.out.println(obj.cc);
	}
}
