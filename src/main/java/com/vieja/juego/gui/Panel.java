package com.vieja.juego.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.annotation.PostConstruct;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vieja.juego.listener.GameManager;

@Component 
public class Panel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	@Autowired
	private GameManager gameManager;

	@SuppressWarnings("unused")
	@PostConstruct 
	public void init() {
		
		setBackground(Color.white);
		setLayout(new GridLayout(3,3));
		
		addButtonWithImageIcon();
		addListenerToButtons();
	}
	
	private void addButtonWithImageIcon() {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				JButton new_button = new JButton();
				new_button.putClientProperty("row", i);
				new_button.putClientProperty("col", j);
				ImageIcon white = new ImageIcon("src/main/resources/white.png");
				new_button.setIcon(new ImageIcon(white.getImage().getScaledInstance(160, 151,Image.SCALE_SMOOTH)));
				add(new_button);
			}
		}
	}
	
	private void addListenerToButtons() {
		for(java.awt.Component component : this.getComponents()) {
			component.addMouseListener(gameManager);
		}
	}

}
