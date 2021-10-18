package com.example.validator;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalcController3 {

	public CalcController3() {
		System.out.println("--> CalcController3 created.");
	}
	
	// http://localhost:8000/calc3
	@GetMapping("/calc3")
	public String calc() {
		return "/calc/form3";
	}
	
	@PostMapping("/calc3")
	public String calc(@Valid CalcVOAnnotation calcVO, BindingResult result, Model model) {
		
		Map < String, String > errors = new HashMap < String, String >();
		
		if(result.hasErrors()) { //에러 발생시
			if(result.getFieldError("menu") != null) { // 구체적인 필드 별 에러 확인
				System.out.println("menu" + result.getFieldError("menu").getDefaultMessage());
				errors.put("menu", result.getFieldError("menu").getDefaultMessage());
			}
			
			if(result.getFieldError("price") != null) { // 구체적인 필드 별 에러 확인
				System.out.println("price" + result.getFieldError("price").getDefaultMessage());
				errors.put("price", result.getFieldError("price").getDefaultMessage());
			}
			
			if(result.getFieldError("count") != null) { // 구체적인 필드 별 에러 확인
				System.out.println("count" + result.getFieldError("count").getDefaultMessage());
				errors.put("count", result.getFieldError("count").getDefaultMessage());
			}
			
			model.addAllAttributes(errors);			
			
			return "/calc/form3";
		} else { //에러 미발생
			int payment = calcVO.getPrice() * calcVO.getCount();
			model.addAttribute("payment", payment);
			return "/calc/proc";
		}
		
	}
	
	

}
