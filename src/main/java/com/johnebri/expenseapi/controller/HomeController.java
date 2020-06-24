package com.johnebri.expenseapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String home() {
		return (
				"<div style=margin:200px auto;><h2>Expense REST API developed by John Ebri</h2>"
				+ "<a href='https://documenter.getpostman.com/view/9082520/SzzrWtcX'>"
				+ "<button style=background:#6CA76E;color:white;padding:9px;text-decoration:none;>Go to Documentation</button></a></div>"	
		);
	}

}
