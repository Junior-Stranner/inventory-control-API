package com.jujubaprojects.controleestoquethymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.jujubaprojects.controleestoquethymeleaf")
public class ControleEstoqueThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleEstoqueThymeleafApplication.class, args);
	}

}
