package com.example.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CalcValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// 검증할 객체의 클래스 타입 정보 명시
		return CalcVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		CalcVO calcvo = (CalcVO)target;
		
		String menu = calcvo.getMenu();
		if(menu == null || menu.trim().isEmpty()) {
			System.out.println("menu 등록 누락");
			errors.rejectValue("menu","error");
		}
		
		int price = calcvo.getPrice();
		if(price < 1000 || price >= 10000000) {
			System.out.println("금액은 1000원 이상 천만원 이하여야합니다.");
			errors.rejectValue("price","error");
		}
		
		int count = calcvo.getCount();
		if(count <= 0 || count >= 1000) {
			System.out.println("수량은 1개 이상 천개 이하여야합니다.");
			errors.rejectValue("count","error");
		}
		
	}
	
	

}
