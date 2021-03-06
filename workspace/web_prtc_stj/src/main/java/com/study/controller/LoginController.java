package com.study.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.model.LoginMapper;

@Controller
public class LoginController {

	@Autowired
	private LoginMapper mapper;

	@RequestMapping("/")
	public String loginCheck(@RequestParam Map<String, String> map, Model model) {
		int cnt = mapper.loginCheck(map);
		String userName = mapper.read(map.get("id"));
		if (cnt > 0) {
			model.addAttribute("msg", userName + "님 login ok Status Success");
		} else {
			model.addAttribute("msg", "login fail");
		}
		
		
		return "test1";
	}

}
