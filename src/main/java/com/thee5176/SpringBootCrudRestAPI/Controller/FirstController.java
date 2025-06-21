package com.thee5176.SpringBootCrudRestAPI.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
	
	@GetMapping("/health-check")
	public String getHealthCheck() {
		return "healthcheck";
	}
}
