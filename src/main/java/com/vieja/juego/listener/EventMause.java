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
public class EventMause extends MouseAdapter{
	
	@Autowired
	private Tablero tablero;
 	boolean turn = true;
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
		JButton clicked_button = (JButton) arg0.getComponent();
		
		if(!tablero.isFiniched()) {
			
			if(turn) {
				ImageIcon x = new ImageIcon("src/main/resources/x.png");
				clicked_button.setIcon(new ImageIcon(x.getImage().getScaledInstance(clicked_button.getWidth(), clicked_button.getHeight(),Image.SCALE_SMOOTH)));
				clicked_button.removeMouseListener(this);
				Point point = setLocation(clicked_button.getLocation());
				tablero.setPoint(point, "x");
				
				turn = false;
			}else {
				ImageIcon x = new ImageIcon("src/main/resources/o.png");
				clicked_button.setIcon(new ImageIcon(x.getImage().getScaledInstance(clicked_button.getWidth(), clicked_button.getHeight(),Image.SCALE_SMOOTH)));
				clicked_button.removeMouseListener(this);
				Point point = setLocation(clicked_button.getLocation());
				tablero.setPoint(point, "o");
				
				turn = true;
			}	
			
			if(tablero.isFiniched()){		
				JOptionPane.showMessageDialog(null, "Ha terminado el juego");
			}
			
			//TODO mostrar cuando quede en empate la partida
			
		}else {
			JOptionPane.showMessageDialog(null, "Ha terminado el juego");
		}
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
			
		}
			
		return new_point;
	}

}
