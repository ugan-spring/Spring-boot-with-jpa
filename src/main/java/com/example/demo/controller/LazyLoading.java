package com.example.demo.controller;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class LazyLoading {

	public LazyLoading() {
		// TODO Auto-generated constructor stub
		System.out.println("Am inside lazy annotation*************");
	}
}
