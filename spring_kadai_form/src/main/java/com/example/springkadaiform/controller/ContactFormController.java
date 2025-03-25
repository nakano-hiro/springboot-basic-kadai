package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {
	
	//初期画面の表示
	@GetMapping("/form")
	public String showContactForm(Model model) {
		model.addAttribute("contactForm", new ContactForm());
		//Modelオブジェクトにて、空のContactFormオブジェクトをビューに渡す
		return "contactFormView";// contactFormView.htmlを表示
	}
	
	//送信後の処理
	@PostMapping("/confirm")
	public String submitContactForm(@Validated @ModelAttribute ContactForm contactForm,
			                        BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "contactFormView";
		}
		
		//フォームで入力されたデータを確認ページへ渡す
		model.addAttribute("contactForm", contactForm);
		return "confirmView";// confirm.htmlを表示	
	}
}
