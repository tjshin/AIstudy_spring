package com.example.sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/")
	public String loginCheck() {
		
		return "test1";
	}
}
