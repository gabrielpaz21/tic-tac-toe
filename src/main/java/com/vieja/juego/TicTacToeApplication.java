package com.vieja.juego;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vieja.juego.gui.Frame;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.swing.*;

@SpringBootApplication
public class TicTacToeApplication {

	public static void main(String[] args) {

		System.setProperty("java.awt.headless", "false");
		SpringApplication.run(TicTacToeApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> SwingUtilities.invokeLater(() -> ctx.getBean(Frame.class));
	}

}
