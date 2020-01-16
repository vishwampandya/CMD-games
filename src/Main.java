//java libraries
import java.util.Scanner;
//my libraries
import games.TicTacToe;

public class Main {
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] agrs){
		
		int gameChoice=0,noOfGamesPlayed = 0,chance=0,wrongAns=0,mainChance=0;
		boolean check=true;
		char ans='a';
		do {
			if(noOfGamesPlayed==0) {
				System.out.println("------------------CMD GAMES------------------");
			}
			else {
				System.out.println("------------------TRY MORE GAMES------------------");
			}
			
			System.out.println("CHOOSE A GAME");
			System.out.println("1. Tic tac toe");
			System.out.println("** enter \"2\" to exit...");
			do {
				//plays/repeats game till user wants
				//no_of_tictactoe_played++;
				try {
					gameChoice = input.nextInt();
					switch(gameChoice) {
					case 1 :
						TicTacToe ticTacToe = new TicTacToe();//here constructor will ask for game mode
						mainChance=0;
						do {
							//plays game one time
							chance=mainChance;//for every time new game to begin
							do {
								//multiplayer mode
								if(TicTacToe.p2Name!="computeR") {
									//calling structure
									ticTacToe.structure();
									//getting data
									ticTacToe.getData(chance);//chance even -> player 1  and chance odd -> player 2
									chance++;
									check = ticTacToe.check();
									check=!check;
								}
								//play with computer mode
								else {
									
									System.out.println("So you think you can beat computer ahh!");
								}
							}while(check);//put boolean expression
							//re-initializing option array
							ticTacToe.reInitialize();
							wrongAns=0;
							do {
								if(wrongAns==0) {
									System.out.println("Wanna rematch?(y/n)");
								}
								else {
									System.out.println("please enter either y(yes) or n(no)");
								}
								try {
									ans = input.next().charAt(0);
									ans = Character.toLowerCase(ans);
									wrongAns++;
								}
								catch(Exception e){
									System.out.println("please enter either y(yes) or n(no)");
									input.nextLine();
								}
								
							}while(ans!='y'&&ans!='n');
							mainChance++;
						}while(ans=='y');//ans=='y'
						
						//result
						ticTacToe.result();
						break;
					
						//for exit	
					case 2 :
						System.exit(0);
				
					
					default :
						System.out.println("Please enter a valid choice.");
					
					
					}
				}
				catch(Exception e) {
					System.out.println("Please enter a valid choice.");
					input.nextLine(); 
				}
			}while(gameChoice>1 || gameChoice<1);
			
			
			
			System.out.println("Press \"enter\" to continue...");
			input.nextLine();
			input.nextLine();
			
			noOfGamesPlayed++;
		}while(true);//enter condition
	}
}
