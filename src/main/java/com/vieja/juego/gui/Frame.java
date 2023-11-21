package com.vieja.juego.gui;

import javax.swing.JFrame;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.Serial;

@Component 
public class Frame extends JFrame{

	@Serial
	private static final long serialVersionUID = 1L;

	private final Panel panel;

	public Frame(Panel panel) {
		this.panel = panel;
	}

	@PostConstruct
	public void init() {
		
		setSize(500,500);
		setTitle("tic-tac-toe");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		add(panel);
		
	}

}
