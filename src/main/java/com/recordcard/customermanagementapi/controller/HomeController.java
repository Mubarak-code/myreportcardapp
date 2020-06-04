package com.recordcard.customermanagementapi.controller;

import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public String homePage() {
		
		return "/home/index";
		
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "/home/login";
	}  
	
	@RequestMapping(value = "/logout")
	public String logOutPage() {
		
		return "/home/logout";
	}

}
