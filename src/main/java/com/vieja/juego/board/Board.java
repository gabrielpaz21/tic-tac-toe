package com.vieja.juego.board;

import java.awt.Point;

import org.springframework.stereotype.Component;

@Component
public class Board {

	private static final String[][] board = new String[3][3];

	public void setPoint(Point point, String player) {
		board[point.x][point.y] = player;
	}

	private boolean checkIfPlayerWon(String player) {

		return checkBoxesVertically(player) || checkBoxesHorizontally(player) || checkBoxesDiagonallyUp(player)
				|| checkBoxesDiagonallyDown(player);
	}

	private boolean checkBoxes(String player, boolean checkVertically) {
		boolean check = false;
		int count = 0;

		for (int i = 0; i < board.length && !check; i++) {
			for (int j = 0; j < board.length; j++) {
				String cell = checkVertically ? board[j][i] : board[i][j];
				if (cell != null && cell.equalsIgnoreCase(player)) {
					count++;
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

	private boolean checkBoxesVertically(String player) {
		return checkBoxes(player, true);
	}

	private boolean checkBoxesHorizontally(String player) {
		return checkBoxes(player, false);
	}

	private boolean checkBoxesDiagonallyUp(String player) {

		boolean check = false;

		if (board[2][0] != null && board[1][1] != null && board[0][2] != null) {
			if (board[0][2].equalsIgnoreCase(player) && board[1][1].equalsIgnoreCase(player)
					&& board[2][0].equalsIgnoreCase(player)) {
				check = true;
			}
		}
		return check;
	}

	private boolean checkBoxesDiagonallyDown(String player) {
		boolean check = false;
		if (board[0][0] != null && board[1][1] != null && board[2][2] != null) {
			if (board[0][0].equalsIgnoreCase(player) && board[1][1].equalsIgnoreCase(player)
					&& board[2][2].equalsIgnoreCase(player)) {
				check = true;
			}
		}
		return check;
	}

	private boolean areAllBoxesFilled() {
		boolean allBoxesFilled = true;

        for (String[] strings : board) {
            for (int j = 0; j < board.length; j++) {
                if (strings[j] == null) {
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

	public boolean hasFinished() {
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
