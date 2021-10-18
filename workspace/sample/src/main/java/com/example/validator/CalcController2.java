package com.example.validator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalcController2 {

	public CalcController2() {
		System.out.println("--> CalcController2 created.");
	}
	
	// http://localhost:8000/calc
	@GetMapping("/calc2")
	public String calc() {
		return "/calc/form2";
	}
	
	@PostMapping("/calc2")
	public String calc(CalcVO calcVO, BindingResult result, Model model) {
		
		CalcValidator calcValidator = new CalcValidator();
		calcValidator.validate(calcVO, result); // 검증
		Map < String, String > errors = new HashMap < String, String >();
		
		if(result.hasErrors()) { //에러 발생시
			if(result.getFieldError("menu") != null) { // 구체적인 필드 별 에러 확인
				System.out.println("menu" + result.getFieldError("menu").getCode());
				errors.put("menu", "menu 등록 누락");
			}
			
			if(result.getFieldError("price") != null) { // 구체적인 필드 별 에러 확인
				System.out.println("price" + result.getFieldError("price").getCode());
				errors.put("price", "금액은 1000원 이상 천만원 이하여야합니다.");
			}
			
			if(result.getFieldError("count") != null) { // 구체적인 필드 별 에러 확인
				System.out.println("count" + result.getFieldError("count").getCode());
				errors.put("count", "수량은 1개 이상 천개 이하여야합니다.");
			}
			
			model.addAllAttributes(errors);			
			
			return "/calc/form2";
		} else { //에러 미발생
			int payment = calcVO.getPrice() * calcVO.getCount();
			model.addAttribute("payment", payment);
			return "/calc/proc";
		}
		
	}
	
	

}
