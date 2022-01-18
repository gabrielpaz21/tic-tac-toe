package com.vieja.juego.listener;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Clock;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vieja.juego.tablero.Board;

@Component
public class GameManager extends MouseAdapter{
	
	@Autowired
	private Board board;

 	private boolean turn = true;

 	private static final ImageIcon x = new ImageIcon("src/main/resources/x.png");
 	
 	private static final ImageIcon o = new ImageIcon("src/main/resources/o.png");

	private static final Point point1 = new Point(1,0);
	private static final Point point2 = new Point(161,0);
	private static final Point point3 = new Point(321,0);
	private static final Point point4 = new Point(1,151);
	private static final Point point5 = new Point(161,151);
	private static final Point point6 = new Point(321,151);
	private static final Point point7 = new Point(1,302);
	private static final Point point8 = new Point(161,302);
	private static final Point point9 = new Point(321,302);

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
		System.out.println("x,y: "+ clickedButton.getLocation());
		Point     pointSet      = setLocation(clickedButton.getLocation());
		String    player        = movementDTO.getPlayer();
		ImageIcon imageIcon     = movementDTO.getImageIcon();
		
		clickedButton.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(clickedButton.getWidth(), clickedButton.getHeight(),Image.SCALE_SMOOTH)));
		clickedButton.removeMouseListener(this);
		
		board.setPoint(pointSet, player);
	}
	
	private void showWhoWon(String player) {
		JOptionPane.showMessageDialog(null, "Ha terminado el juego, ha ganado el jugador '" + player +"'");
		System.exit(-1);
	}

	private Point setLocation(Point pointNotSet) {
		
		Point pointSet = null;
		
		if(pointNotSet.equals(point1)) {
			pointSet = new Point(0,0);
		}else if(pointNotSet.equals(point2)) {
			pointSet = new Point(0,1);
		}else if(pointNotSet.equals(point3)) {
			pointSet = new Point(0,2);
		}else if(pointNotSet.equals(point4)) {
			pointSet = new Point(1,0);
		}else if(pointNotSet.equals(point5)) {
			pointSet = new Point(1,1);
		}else if(pointNotSet.equals(point6)) {
			pointSet = new Point(1,2);
		}else if(pointNotSet.equals(point7)) {
			pointSet = new Point(2,0);
		}else if(pointNotSet.equals(point8)) {
			pointSet = new Point(2,1);
		}else if(pointNotSet.equals(point9)) {
			pointSet = new Point(2,2);
		}else {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error.");
			System.exit(-1);
		}
			
		return pointSet;
	}

}
