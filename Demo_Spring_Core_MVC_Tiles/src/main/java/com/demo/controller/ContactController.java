package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.demo.bean.Contact;

@Controller
@SessionAttributes
public class ContactController {

	@RequestMapping("/")
	public String hello() {
		return "index";
	}

	@RequestMapping("/hello")
	public String helloWorld(Model m) {
		String message = "Hello World, I am trying to lean Spring MVC";
		m.addAttribute("message", message);
		return "hello";
	}

	@RequestMapping("/contact")
	public String showContacts(Model m) {
		m.addAttribute("command", new Contact());
		return "contact";
	}

	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact") Contact contact, BindingResult result) {

		return "redirect:contact.html";
	}
}
