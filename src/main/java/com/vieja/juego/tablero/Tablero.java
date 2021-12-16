package com.vieja.juego.tablero;

import java.awt.Point;

import org.springframework.stereotype.Component;

@Component
public class Tablero {

	private String tablero[][] = new String[3][3];

	public void setPoint(Point point, String player) {
		tablero[point.x][point.y] = player;
	}

	public String getPlayer(Point point) {
		return tablero[point.x][point.y];
	}

	public String getPlayer(int x, int y) {
		return tablero[x][y];
	}

	private boolean checkIfPlayerWon(String player) {

		return checkBoxesVertically(player) || checkBoxesHorizontally(player) || checkBoxesDiagonallyUp(player)
				|| checkBoxesDiagonallyDown(player);
	}

	private boolean checkBoxesVertically(String player) {

		boolean check = false;
		int count = 0;

		for (int i = 0; i < tablero.length && !check; i++) {
			for (int j = 0; j < tablero.length; j++) {
				if (tablero[j][i] != null) {
					if (tablero[j][i].equalsIgnoreCase(player)) {
						count++;
					}
				}
			}

			if (count < 3) {
				count = 0;
			} else {
				check = true;
			}
		}

		return check;
	}

	private boolean checkBoxesHorizontally(String player) {

		boolean check = false;
		int count = 0;

		for (int i = 0; i < tablero.length && !check; i++) {
			for (int j = 0; j < tablero.length; j++) {
				if (tablero[i][j] != null) {
					if (tablero[i][j].equalsIgnoreCase(player)) {
						count++;
					}
				}
			}

			if (count < 3) {
				count = 0;
			} else {
				check = true;
			}
		}

		return check;
	}

	private boolean checkBoxesDiagonallyUp(String player) {

		boolean check = false;

		if (tablero[2][0] != null && tablero[1][1] != null && tablero[0][2] != null) {
			if (tablero[0][2].equalsIgnoreCase(player) && tablero[1][1].equalsIgnoreCase(player)
					&& tablero[2][0].equalsIgnoreCase(player)) {
				check = true;
			}
		}
		return check;
	}

	private boolean checkBoxesDiagonallyDown(String player) {
		boolean check = false;
		if (tablero[0][0] != null && tablero[1][1] != null && tablero[2][2] != null) {
			if (tablero[0][0].equalsIgnoreCase(player) && tablero[1][1].equalsIgnoreCase(player)
					&& tablero[2][2].equalsIgnoreCase(player)) {
				check = true;
			}
		}
		return check;
	}

	private boolean areAllBoxesFilled() {
		boolean allBoxesFilled = true;

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				if (tablero[i][j] == null) {
					allBoxesFilled = false;
					break;
				}
			}
		}

		return allBoxesFilled;
	}

	public boolean isDraw() {
		return areAllBoxesFilled() && !checkIfPlayerWon("x") && !checkIfPlayerWon("o");
	}

	public boolean hasFiniched() {
		return 	checkIfPlayerWon("x") || checkIfPlayerWon("o") || isDraw();
	}
	
	public String whoWon() {
		
		if(checkIfPlayerWon("x")) {
			return "x";
		}
		
		if(checkIfPlayerWon("o")) {
			return "o";
		}
		
		// d means that the game is in draw
		return "d";
	}	

}
