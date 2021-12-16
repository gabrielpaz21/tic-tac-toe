package com.vieja.juego;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vieja.juego.gui.Marco;

@SpringBootApplication
public class LaViejaApplication {
	
	@Autowired
	private Marco marco;

	public static void main(String[] args) {
		
		System.setProperty("java.awt.headless", "false");
		SpringApplication.run(LaViejaApplication.class, args);
		
	}

}
