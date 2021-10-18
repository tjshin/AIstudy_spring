package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ioc.TV;

@SpringBootApplication
public class HelloAppApplication {

	public static void main(String[] args) {
		//SpringApplication.run(HelloAppApplication.class, args);
		
		//ioc 컨테이너 생성
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(TVConfig.class);
		
		//LgTV Bean 가져온다.
		TV lg = (TV)context.getBean("lgCreate");
		lg.powerOn();
		lg.volumeUp();
		lg.volumeDown();
		lg.powerOff();
		
		//SamsungTV Bean 가져온다.
		TV samsung = (TV)context.getBean("samsung");
		samsung.powerOn();
		samsung.volumeUp();
		samsung.volumeDown();
		samsung.powerOff();
	}

}
