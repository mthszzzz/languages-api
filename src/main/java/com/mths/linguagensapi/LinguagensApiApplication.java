package com.mths.linguagensapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.mths.linguagensapi"})
@SpringBootApplication
public class LinguagensApiApplication {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(LinguagensApiApplication.class, args);


	}

}
