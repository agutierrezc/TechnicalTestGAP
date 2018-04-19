package com.gap.piggyBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Clase principal con la que se inicia la aplicacion de SpringBoot
 * 
 * @author felipe.gutierrez
 *
 */
@SpringBootApplication
@ComponentScan
public class PiggyBankApplication {
	public static void main(String[] args) {
		SpringApplication.run(PiggyBankApplication.class, args);
	}
}
