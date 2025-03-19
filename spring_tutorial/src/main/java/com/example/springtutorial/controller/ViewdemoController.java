package com.example.springtutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewdemoController {
	@GetMapping("/view")
	public String viewdemo() {
		return "tutorialview";
	}

}
