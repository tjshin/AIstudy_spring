package com.study.prtc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.study.*"})
public class WebPrtcStjApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebPrtcStjApplication.class, args);
	}

}
