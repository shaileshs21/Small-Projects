package tic_tac_toe_v1;

import java.util.Random;

public class Game {

	
	private static String convention ="ABC";
	private static String board[][]=new String[3][3];
	String values[]=new String[] {"A1","B1","C1","A2","B2","C2","A3","B3","C3"};
	String line="    =================";
	
	Game(){
		//Initialize all board values to blank
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				board[i][j]=" ";
			}
		}
	}

	//====================================================================================================================================
	void computer_turn() {
		boolean flag = check_already_items("O");
		if(!flag) {
			flag = check_already_items("X");
				if(!flag) {
					randomize();
				}
		}
	}
	boolean check_already_items(String c) {
		//---------------------- Horizontal lines check-----------------
		for(int i=0;i<3;i++) {
			if(board[i][0]==c && board[i][1]==c && board[i][2]==" ") {
				board[i][2]="O";
				return true;
			}
			if(board[i][0]==c && board[i][2]==c && board[i][1]==" ") {
				board[i][1]="O";
				return true;
			}
			if(board[i][1]==c && board[i][2]==c && board[i][2]==" ") {
				board[i][2]="O";
				return true;
			}
		}
		//-------------------------- Vertical line checking-----------------
		for(int j=0;j<3;j++) {
			if(board[0][j]==c && board[1][j]==c && board[2][j]==" ") {
				board[2][j]="O";
				return true;
			}
			if(board[0][j]==c && board[2][j]==c && board[1][j]==" ") {
				board[1][j]="O";
				return true;
			}
			if(board[1][j]==c && board[2][j]==c && board[0][j]==" ") {
				board[0][j]="O";
				return true;
			}
		}
		//------------------------cross 1-----------------------------------------
		if(board[0][2]==c && board[1][1]==c && board[2][0]==" ") {
			board[2][0]="O";
			return true;
		}
		if(board[0][2]==c && board[2][0]==c && board[1][1]==" ") {
			board[1][1]="O";
			return true;
		}
		if(board[2][0]==c && board[1][1]==c && board[0][2]==" ") {
			board[0][2]="O";
			return true;
		}
		//-------------------------cross 2-----------------------------------------
		if(board[0][0]==c && board[1][1]==c && board[2][2]==" ") {
			board[2][2]="O";
			return true;
		}
		if(board[0][0]==c && board[2][2]==c && board[1][1]==" ") {
			board[1][1]="O";
			return true;
		}
		if(board[2][2]==c && board[1][1]==c && board[0][0]==" ") {
			board[0][0]="O";
			return true;
		}
		return false;
	}
	
	void randomize() {
		
		Random rand = new Random();
		char row;
		int col;
		boolean success=false;
		while(!success) {
			int row_col = rand.nextInt(9);
			row = values[row_col].charAt(0);
			col = Integer.parseInt(String.valueOf(values[row_col].charAt(1)));
			success=add_value('O', row, col);
		}
	}
	
	//====================================================================================================================================
	boolean add_value(char P,char row,int col){
		
		if(row == 'A') {
			 row =0;
		}else if(row == 'B') {
			 row =1;
		}else if(row == 'C') {
			 row =2;
		}else
		{
			return false;
		}
		
		if(board[row][col-1] == " ") {
			if(P=='X') {
				board[row][col-1] = "X";
			}
			if(P=='O') {
				board[row][col-1] = "O";
			}		
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	boolean isWon(String c) {
		
		for(int i=0;i<3;i++) {
			if(board[i][0]==c && board[i][1]==c && board[i][2]==c) {
				return true;
			}
		}
		for(int j=0;j<3;j++) {
			if(board[0][j]==c && board[1][j]==c && board[2][j]==c) {
				return true;
			}
		}
		if((board[0][0]==c && board[1][1]==c && board[2][2]==c)||(board[0][2]==c && board[1][1]==c && board[2][0]==c)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	void fill_last_blank_space() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(board[i][j]==" ") {
					board[i][j]="X";
					break;
				}
			}
		}
	}
	void display_board() {
		System.out.println("     1  "+"   2  "+"   3  ");
		for(int i=0;i<3;i++) {
			System.out.println(line);
			for(int j=0;j<3;j++) {
				if(j==0) {
					System.out.print(convention.charAt(i)+"  |");
				}
				System.out.print("  "+board[i][j]+"  |");	
			}
			System.out.println("");
		}	
		System.out.println(line);
	}
	void display_intro() {
		System.out.println("==================================================================================");
		System.out.print("                      -----INSTRUCTIONS---- ");
		System.out.println("");System.out.println("");
		display_board();System.out.println("");
		System.out.println("===================================================================================");
		System.out.println("");System.out.println("Player 1: X");
		System.out.println("Player 2: O");System.out.println("");
		System.out.println("The board works like a Coordinate grid. Typing A1 would result in a character being \n"
				+ "placed in the top left corner.Please Make Sure Caps Lock is ON");
		System.out.println("");
		System.out.println("___________________________________________________________________________________");
		System.out.println("");
	}
	void display_over(){
		System.out.println("                                ==========================");
		System.out.println("                                =    G-A-M-E  O-V-E-R    =");
		System.out.println("                                ==========================");
		
	}
		
	}

