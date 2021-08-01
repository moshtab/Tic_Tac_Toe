package bridgelabz;

import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		System.out.println("Welcome to the Tic Tac Toe Game");
		Scanner s = new Scanner(System.in);
		System.out.println("enter the name of player1 :");
		String p1 = s.nextLine();
		System.out.println("enter the name of player2 :");
		String p2 = s.nextLine();
		s.close();
		char[][] board = new char[3][3];
		showBoard(board);
		choosingXY(p1,p2);

	}

	public static void showBoard(char[][] board) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = '-';
				System.out.print("\t" + board[i][j]);
			}
			System.out.println();
		}
	}
	public static void choosingXY(String p1,String p2) {
		char c = '-';
		boolean player1 = true;
		if(player1) {
			System.out.println(p1+"'s turn (x)");
			c='x';
		}
			else {
				System.out.println(p2+"'s turn (o)");
				c='o';
			}
		
	}

}
