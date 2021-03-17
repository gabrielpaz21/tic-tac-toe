package com.vieja.juego.tablero;

import java.awt.Point;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class Tablero {
	
	private String tablero[][] = new String [3][3];
	
	public void setPoint(Point point, String jugador) {
		tablero[point.x][point.y] = jugador;
	}
	
	public String getJugador(Point point) {
		return tablero[point.x][point.y];
	}
	
	public String getJugador(int x , int y) {
		return tablero[x][y];
	}
	
	public boolean isFiniched() {
		
		boolean validate = false;
		
		int count_x=0;
		int count_o=0;
		
		//verificando horizontalmente
		for(int i=0;i<tablero.length && (count_x<3 || count_o<3) ;i++) {
			
			for(int j=0;j<tablero.length;j++) {
				
				if(tablero[i][j]!=null) {
					if(tablero[i][j].equalsIgnoreCase("x")) {
						count_x++;
					}
					
					if(tablero[i][j].equalsIgnoreCase("o")) {
						count_o++;
					}
					
				}
			
			}
			
			if(count_x<3 && count_o<3) {
				count_x=0;
				count_o=0;
			}else {
				validate = true;
			}
		}
		
		//verificando verticalmente
		for(int i=0;i<tablero.length && (count_x<3 || count_o<3) ;i++) {
					
			for(int j=0;j<tablero.length;j++) {
						
				if(tablero[j][i]!=null) {
					
					if(tablero[j][i].equalsIgnoreCase("x")) {
						count_x++;
					}
							
					if(tablero[j][i].equalsIgnoreCase("o")) {
						count_o++;
					}
							
				}
					
			}
					
			if(count_x<3 && count_o<3) {
				count_x=0;
				count_o=0;
			}else {
				validate = true;
			}
		}	
		
		if(tablero[0][0]!=null && tablero[1][1]!=null && tablero[2][2]!=null) {
			if(tablero[0][0].equalsIgnoreCase("x") && tablero[1][1].equalsIgnoreCase("x") && tablero[2][2].equalsIgnoreCase("x")) {
				validate = true;
			}else if(tablero[0][0].equalsIgnoreCase("o") && tablero[1][1].equalsIgnoreCase("o") && tablero[2][2].equalsIgnoreCase("o")) {
				validate = true;
			}
		}	
		
		if(tablero[0][2]!=null && tablero[1][1]!=null && tablero[2][0]!=null) {
			if(tablero[0][2].equalsIgnoreCase("x") && tablero[1][1].equalsIgnoreCase("x") && tablero[2][0].equalsIgnoreCase("x")) {
				validate = true;
			}else if(tablero[0][2].equalsIgnoreCase("o") && tablero[1][1].equalsIgnoreCase("o") && tablero[2][0].equalsIgnoreCase("o")) {
				validate = true;
			}
		}	
		
		return validate;
	}
	
	@PostConstruct 
	public void init() {
		
	}

}
