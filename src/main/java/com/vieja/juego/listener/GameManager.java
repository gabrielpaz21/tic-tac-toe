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

import com.vieja.juego.tablero.Tablero;

@Component
public class GameManager extends MouseAdapter{
	
	@Autowired
	private Tablero tablero;
	
 	private boolean turn = true;
 	
 	private static final ImageIcon x = new ImageIcon("src/main/resources/x.png");
 	
 	private static final ImageIcon o = new ImageIcon("src/main/resources/o.png");
 	
	private static final Point point1 = new Point(0,0);
	private static final Point point2 = new Point(162,0);
	private static final Point point3 = new Point(324,0);
	private static final Point point4 = new Point(0,154);
	private static final Point point5 = new Point(162,154);
	private static final Point point6 = new Point(324,154);
	private static final Point point7 = new Point(0,308);
	private static final Point point8 = new Point(162,308);
	private static final Point point9 = new Point(324,308);
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		JButton clicked_button = (JButton) arg0.getComponent();
		
		if(turn) {
			doMovement(new MovementDTO(clicked_button,x,"x"));
			turn = false;
		}else {
			doMovement(new MovementDTO(clicked_button,o,"o"));
			turn = true;
		}	
		
		if(tablero.hasFiniched()){	
			
			if(!tablero.isDraw()) {
				showWhoWon(tablero.whoWon());
			}
			
			showTheGameEndedInADraw();
		}
		
	}
	
	private void showTheGameEndedInADraw() {
		JOptionPane.showMessageDialog(null, "El juego ha terminado en empate.");
		System.exit(-1);
	}

	private void doMovement(MovementDTO movementDTO) {
		JButton clicked_button = movementDTO.getClicked_button();
		Point adjusted_point = setLocation(clicked_button.getLocation());
		String player = movementDTO.getPlayer();
		ImageIcon imageIcon = movementDTO.getImageIcon();
		
		clicked_button.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(clicked_button.getWidth(), clicked_button.getHeight(),Image.SCALE_SMOOTH)));
		clicked_button.removeMouseListener(this);
		
		tablero.setPoint(adjusted_point, player);
	}
	
	private void showWhoWon(String player) {
		JOptionPane.showMessageDialog(null, "Ha terminado el juego, ha ganado el jugador '" + player +"'");
		System.exit(-1);
	}

	private Point setLocation(Point old_point) {
		
		Point new_point = null;
		
		if(old_point.equals(point1)) {
			new_point = new Point(0,0);
		}else if(old_point.equals(point2)) {
			new_point = new Point(0,1);
		}else if(old_point.equals(point3)) {
			new_point = new Point(0,2);
		}else if(old_point.equals(point4)) {
			new_point = new Point(1,0);
		}else if(old_point.equals(point5)) {
			new_point = new Point(1,1);
		}else if(old_point.equals(point6)) {
			new_point = new Point(1,2);
		}else if(old_point.equals(point7)) {
			new_point = new Point(2,0);
		}else if(old_point.equals(point8)) {
			new_point = new Point(2,1);
		}else if(old_point.equals(point9)) {
			new_point = new Point(2,2);
		}else {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error.");
			System.exit(-1);
		}
			
		return new_point;
	}

}
