package com.example.springtutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NumberListController {
	@GetMapping("/numbers")
	public String showNumberList() {
		return "numberList";
	}
}
