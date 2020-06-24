package com.johnebri.expenseapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String home() {
		return (
				"<div style=margin:200px auto;><h3>Expense REST API</h3>"
				+ "<a href='https://documenter.getpostman.com/view/9082520/SzzrWtcX?version=latest#8b25dc18-d89b-46a8-a38d-924446387ac3'"
				+ "<button style=background:#6CA76E;color:white;padding:9px;text-decoration:none;>Go to Documentation</button></a></div>"	
		);
	}

}
