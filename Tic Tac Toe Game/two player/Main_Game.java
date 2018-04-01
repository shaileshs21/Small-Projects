package tic_tac_toe;

import java.util.Scanner;

public class Main_Game {
		static char row;
		static int col;
	  
	    static boolean validate_input(char row,int col) {
		
		if((row=='A' || row=='B' || row== 'C')&&(col==1 || col==2 || col==3)) {
			return true;
		}
		else
		{
			return false;
		}
	
	}
	    static boolean take_input(){        
			Scanner in = new Scanner(System.in);	
	    	String input = in.nextLine();
			row = input.charAt(0);
		//	in.close();
			try {
				col = Integer.parseInt(String.valueOf(input.charAt(1)));
			}catch(NumberFormatException e) {}
			return validate_input(row, col); 	
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final int MAX_TURNS = 4;
	    int i=0;
	    boolean success=false;
	    boolean won=false;
	    char decision='Y';
	    Scanner in = new Scanner(System.in);
	
		
		
		
		while(decision=='Y') {
			
			Game game= new Game();
			game.display_intro();
			i=0;
			success=false;
			won = false;
			while(i<MAX_TURNS) {
				System.out.print("Player 1 Please select Where to Place X:");
				while(!success) {
					success =take_input();
					if(success) {
						success=game.add_value('X',row,col);			
					}
					if(!success) {
						System.out.println("Please Enter Valid Input");
					}
				}
				game.display_board();
				if(game.isWon("X"))
				{
					System.out.println("Game Won by Player 1");
					won=true;
					break;
				}
				success=false;
				System.out.print("Player 2 Please select Where to Place O:");
				while(!success) {
					success =take_input();
					if(success) {
						success=game.add_value('O',row,col);			
					}
					if(!success) {
						System.out.println("Please Enter Valid Input");
					}
									
				}
				game.display_board();
				if(game.isWon("O"))
				{
					System.out.println("Game Won by Player 2");
					won=true;
					break;
				}
				success=false;
				i++;
			}
			
			if(!won) {
				game.fill_last_blank_space();
				System.out.println("Auto Filling Last Space with Player 1 X");
				game.display_board();
				if(game.isWon("X"))
				{
					System.out.println("Game Won by Player 1");
				}
				else {
					game.display_over();
				}
			}
			
			System.out.println("Press 'Y' to continue playing...");
			decision = in.next().charAt(0);
	
						
		}
		in.close();
	}

}
