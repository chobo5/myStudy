package com.example.webexam;

import ch.qos.logback.classic.pattern.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.List;

@SpringBootApplication
public class WebexamApplication {

	@Autowired
	List<HttpMessageConverter> messageConverters;

	public static void main(String[] args) {
		SpringApplication.run(WebexamApplication.class, args);

	}

	public void run(String... args) throws Exception {
		for (HttpMessageConverter messageConverter : messageConverters) {
			System.out.println(messageConverter.getClass().getName());
		}
	}

}
