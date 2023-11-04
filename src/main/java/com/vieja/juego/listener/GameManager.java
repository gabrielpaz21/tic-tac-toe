package com.vieja.juego.listener;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vieja.juego.tablero.Board;

@Component
public class GameManager extends MouseAdapter{

	@SuppressWarnings("unused")
	@Autowired
	private Board board;

 	private boolean turn = true;

 	private static final ImageIcon x = new ImageIcon("src/main/resources/x.png");
 	
 	private static final ImageIcon o = new ImageIcon("src/main/resources/o.png");

	@Override
	public void mouseClicked(MouseEvent arg0) {
		JButton clickedButton = (JButton) arg0.getComponent();

		if(turn) {
			doMovement(new MovementDTO(clickedButton,x,"x"));
			turn = false;
		}else {
			doMovement(new MovementDTO(clickedButton,o,"o"));
			turn = true;
		}

		if(board.hasFinished()){

			if(board.isDraw()) {
				showTheGameEndedInADraw();
			}else{
				showWhoWon(board.whoWon());
			}

		}

	}

	private void showTheGameEndedInADraw() {
		JOptionPane.showMessageDialog(null, "El juego ha terminado en empate.");
		System.exit(-1);
	}

	private void doMovement(MovementDTO movementDTO) {
		JButton   clickedButton = movementDTO.getClickedButton();
		Point     pointSet      = new Point((Integer) clickedButton.getClientProperty("row"), (Integer) clickedButton.getClientProperty("col"));
		System.out.println("x,y: " + pointSet);
		String    player        = movementDTO.getPlayer();
		ImageIcon imageIcon     = movementDTO.getImageIcon();
		
		clickedButton.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(clickedButton.getWidth(), clickedButton.getHeight(),Image.SCALE_SMOOTH)));
		clickedButton.removeMouseListener(this);
		
		board.setPoint(pointSet, player);
	}
	
	private void showWhoWon(String player) {
		JOptionPane.showMessageDialog(null, "Ha terminado el juego, ha ganado el jugador '" + player +"'");
		System.exit(0);
	}

}
