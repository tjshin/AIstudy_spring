package com.example.sample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.sample.bean.Member;

@Controller
public class HelloController {
	
	@GetMapping
	public @ResponseBody String hello() {
		return "Hello World";
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
	//http://localhost:8000/test1?id=hong&name=홍길동
	@RequestMapping("/test1")
	public String test1(HttpServletRequest request, Model model) {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		
		return "test1";
	}
	
	//http://localhost:8000/test2?id=hong&name=홍길동
	@RequestMapping("/test2")
	public String test2(@RequestParam("id") String id, String name, Model model) {
		
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		
		return "test2";
	}
	
	//http://localhost:8000/test3?id=hong&name=홍길동
	@RequestMapping("/test3")
	public String test3(Member member) {//, Model model) {
		
		//model.addAttribute(member);	
		return "test3";
	}
	
	//http://localhost:8000/test4/hong/홍길동
	@RequestMapping("/test4/{studentid}/{name}")
	public String test4(@PathVariable String studentid, @PathVariable String name, Model model) {
		model.addAttribute("id", studentid);
		model.addAttribute("name", name);
		
		return "test4";
	}

}
