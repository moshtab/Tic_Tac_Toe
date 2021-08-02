package bridgelabz;

import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		// create an array of charcters with '3' rows and '3' columns
		char[][] board = new char[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = '-';
			}
		}
		// take the player1 name and player2 name from user input
		System.out.println("Welcome to the Tic Tac Toe Game");
		Scanner s = new Scanner(System.in);
		System.out.println("enter the name of player1 :");
		String p1 = s.nextLine();
		System.out.println("enter the name of player2 :");
		String p2 = s.nextLine();

		// for choosing player1's turn or player2's turn
		boolean player1 = true;
		// for checking game has ended or not
		boolean gameEnded = true;

		while (gameEnded) {
			showBoard(board);
			if (player1) {
				System.out.println(p1 + "'s turn (x)");

			} else {
				System.out.println(p2 + "'s turn (o)");

			}
			// for selecting 'x' or 'o' for players
			char c = '-';
			if (player1) {
				c = 'x';
			} else {
				c = 'o';
			}
			int row = 0;
			int column = 0;
			// break the while loop when user enters the valid option
			while (true) {
				// giving position for x or o as per user input
				System.out.println("Enter a row number (0,1 or 2)");
				row = s.nextInt();
				System.out.println("Enter a column number (0,1 or 2) ");
				column = s.nextInt();

				if (row < 0 || column < 0 || row > 2 || column > 2) {
					System.out.println("This is not a valid position ");
				} else if (board[row][column] != '-') {
					System.out.println("Someone has already moved");
				} else {
					break;

				}

			}
			// set the position on the board at row ,column to c
			board[row][column] = c;

			// check to see who won the game
			if (playerWonCondition(board) == 'x') {
				System.out.println(p1 + " has won");
				gameEnded = true;
				showBoard(board);
				System.exit(c);

			} else if (playerWonCondition(board) == 'o') {
				System.out.println(p2 + " has won");
				gameEnded = true;
				showBoard(board);
				System.exit(c);

			} else if (boardIsFull(board)) {
				System.out.println("it's a tie, let's play again");
				gameEnded = true;
				showBoard(board);
				System.exit(c);
			} else {
				// make player1 false for making player2's turn and vice versa
				player1 = !player1;
			}

		}
		s.close();

	}

	public static void showBoard(char[][] board) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print("\t" + board[i][j]);
			}
			System.out.println();
		}
	}

	public static char playerWonCondition(char[][] board) {
		// check each row
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
				return board[i][0];
			}
		}
		// check each column
		for (int j = 0; j < 3; j++) {
			if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[j][0] != '-') {
				return board[j][0];
			}
		}
		// check diagonals
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
			return board[0][0];
		}
		if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != '-') {
			return board[2][0];
		}
		return ' ';

	}

	public static boolean boardIsFull(char[][] board) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == '-') {
					return false;
				}

			}

		}
		return true;
	}

}
