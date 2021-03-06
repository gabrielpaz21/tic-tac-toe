package com.vieja.juego.gui;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component 
public class Marco extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Panel panel;
	
	@PostConstruct 
	public void init() {
		
		setSize(500,500);
		setTitle("La Vieja");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		add(panel);
		
	}

}
