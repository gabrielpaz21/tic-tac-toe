package com.vieja.juego.listener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MovementDTO {

	private JButton clickedButton;
	
	private ImageIcon imageIcon;
	
	private String player;
}
