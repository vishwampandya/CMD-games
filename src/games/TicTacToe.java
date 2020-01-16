package games;

import java.util.Scanner;

public class TicTacToe {
	public static Scanner input = new Scanner(System.in);
	public static String p1Name , p2Name;
	public static int draw,p1Won,p1Lost;
	public static char[][] option ={
										{' ',' ',' '},
										{' ',' ',' '},
										{' ',' ',' '}
									};
	public static int  nothing=0;
	public static TicTacToe ticTacToe2 = new TicTacToe(nothing);
	public TicTacToe(int nothing) {
		
	}
	
	public TicTacToe(){
		
		//initializing array and all scores to zero 
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				option[i][j]=' ';
			}
		}
		draw=0;
		p1Won=0;
		p1Lost=0;
		int gameModeChoice=0;
		System.out.println("Choose game mode - ");
		System.out.println("1. Multiplayer");
		System.out.println("2. Play with computer");
		do {
			
			try {
				gameModeChoice = input.nextInt();
				input.nextLine();
				switch(gameModeChoice) {
				case 1:
					//getting player names
					System.out.print("enter player 1 name : ");
					p1Name = input.nextLine();
					System.out.print("enter player 2 name : ");
					p2Name = input.nextLine();
					//converting string into Abc format
					p1Name = p1Name.substring(0,1).toUpperCase()+p1Name.substring(1).toLowerCase();
					p2Name = p2Name.substring(0,1).toUpperCase()+p2Name.substring(1).toLowerCase();
					break;
				case 2:
					//getting player name
					System.out.print("\nenter your name : ");
					p1Name = input.nextLine();
					//converting string into Abc format
					p1Name = p1Name.substring(0,1).toUpperCase()+p1Name.substring(1).toLowerCase();
					//setting p2 name as computeR
					p2Name = "computeR";//last letter capital with intention.
					break;
				default :
					System.out.println("please enter a valid choice");
					gameModeChoice = 0;
				}
			}
			catch(Exception e) {
				System.out.println("please enter a valid choice exception");
				input.nextLine();
			}
		}while(gameModeChoice!=1 && gameModeChoice!=2);
		
	}

	public void reInitialize() {
		//initializing array to ' ' 
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						option[i][j]=' ';
					}
				}
	}
	
	public void structure() {
		int i,j,m,position;
		//main structure part (left structure)
		System.out.print("-");	
		for(m=0;m<3;m++){
			System.out.print("----");			
		}
		//reference structure part (right structure)
		System.out.print("      ");
		System.out.print("-");	
		for(m=0;m<3;m++){
				System.out.print("----");			
		}
	
		System.out.println();
	 
		for(i=0;i<3;i++){
			//main structure part (left structure)
			for(j=0;j<3;j++){
				position = i*3+j+1;
				System.out.print("| "+option[i][j]+" ");	
			}
			System.out.print("|");
			//reference structure part (right structure)
			System.out.print("      ");
			for(j=0;j<3;j++){
				position = i*3+j+1;
				System.out.print("| "+position+" ");			
			}
			System.out.print("|");
			System.out.println();
			
			//main structure part (left structure)
			System.out.print("-");
			for(m=0;m<3;m++){
				System.out.print("----");			
			}
			//reference structure
			System.out.print("      ");
			System.out.print("-");
			for(m=0;m<3;m++){
				System.out.print("----");			
			}
			System.out.println();
		}
	}
	public void getData(int chance) {
		int attempt = 0,position=0,i=0,j=0;
		
		//chance even, means player 1 chance
		if(chance%2==0) {
			//(do) till there is a valid attempt
			do {
				if(attempt==0) {
					System.out.println(p1Name+" enter position for X : ");
				}
				attempt = 0;
				try {
					position = input.nextInt();

					//calculating i and j
					if(position%3==0){
						i = position/3-1;		
					}
					else {
						i =position/3;
					}
					j= position-(i*3)-1;	
					
					//if positions already occupied
					if(option[i][j]!=' ') {
						System.out.println("This position is already occupied , enter some other position : ");
						attempt++;
					}
					//if everything is fine then insert
					else if(attempt==0){
						option[i][j] = 'X';
						attempt=0;
					}
				}
				catch(Exception e) {
					System.out.println("Please enter a valid position");
					input.nextLine();
					attempt++;
				}
				
			}while(attempt!=0);
		}
		//chance odd, means player 2 chance
		else {
			//(do) till there is a valid attempt
			do {
				if(attempt==0) {
					System.out.println(p2Name+" enter position for O : ");
				}
				attempt = 0;
				try {
					position = input.nextInt();

					//calculating i and j
					if(position%3==0){
						i = position/3-1;		
					}
					else {
						i =position/3;
					}
					j= position-(i*3)-1;	
					
					//if positions already occupied
					if(option[i][j]!=' ') {
						System.out.println("This position is already occupied , enter some other position : ");
						attempt++;
					}
					//if everything is fine then insert
					else if(attempt==0){
						option[i][j] = 'O';
						attempt=0;
					}
				}
				catch(Exception e) {
					System.out.println("Please enter a valid position");
					input.nextLine();
					attempt++;
				}
				
			}while(attempt!=0);
		}
	}
	
	public boolean check() {
		
		int not_null_count = 0,count=0;
		//checking if all position are full
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(option[i][j]!=' ') {
					not_null_count++;
				}
			}
		}
		
		//if match draws (all places are full)
		if(not_null_count==9) {
			draw++;
			ticTacToe2.structure();
			System.out.println("Match Draw !");
			return true;
		}
		
		//if someone wins or looses
		//checking columns
		for(int j=0;j<3;j++){
			count=0;
			for(int i=0;i<3;i++){
				if(option[i][j]=='X')
					count++;
				else if(option[i][j]=='O')
					count=count+4;
			}		
			if(count==3){
				ticTacToe2.structure();
				System.out.println(p1Name+" won !");
				p1Won++;
				return true;
			}
			else if(count==12){
				ticTacToe2.structure();
				System.out.println(p2Name+" won !");
				p1Lost++;
				return true;			
			}
		}	

		//checking rows
		if(count!=3&&count!=12){
			for(int i=0;i<3;i++){
				count=0;
				for(int j=0;j<3;j++){
					if(option[i][j]=='X')
						count++;
					else if(option[i][j]=='O')
						count+=4;
				}		
				if(count==3){
					ticTacToe2.structure();
					System.out.println(p1Name+" won !");
					p1Won++;
					return true;
				}
				else if(count==12){
					ticTacToe2.structure();
					System.out.println(p2Name+" won !");
					p1Lost++;
					return true;
				}
			}
		}	
		//checking diagonal 1
		if(count!=3&&count!=12){
			count=0;
			if(option[0][0]=='X'&&option[1][1]=='X'&&option[2][2]=='X'){
				count=3;		
				ticTacToe2.structure();
				System.out.println(p1Name+" won !");
				p1Won++;
				return true;
			}
			else if(option[0][0]=='O'&&option[1][1]=='O'&&option[2][2]=='O'){
				count=12;		
				ticTacToe2.structure();
				System.out.println(p2Name+" won !");
				p1Lost++;
				return true;
			}
		}
		//checking diagonal 2
		if(count!=3&&count!=12){
			count=0;
			if(option[0][2]=='X'&&option[1][1]=='X'&&option[2][0]=='X'){
				count=3;		
				ticTacToe2.structure();
				System.out.println(p1Name+" won !");
				p1Won++;
				return true;
			}
			else if(option[0][2]=='O'&&option[1][1]=='O'&&option[2][0]=='O'){
				count=12;		
				ticTacToe2.structure();
				System.out.println(p2Name+" won !");
				p1Lost++;
				return true;
			}
		}
		
		
		return false;
	}
	
	public void result() {
		int p2Won = p1Lost;
		int p2Lost = p1Won;
		int maxNameLength,spaces,len,num;
		//calculating scores
		int p1Score,p2Score;
		p1Score = (2*p1Won + draw);
		p2Score = (2*p2Won + draw);
		
		//calculating maximum player name length
		if(p1Name.length()>p2Name.length()) {
			maxNameLength = p1Name.length();
		}
		else {
			maxNameLength = p2Name.length();
		}
		if(maxNameLength<4) {
			maxNameLength=4;
		}
		//making score board
		//line
		for(int i=0;i<maxNameLength+32;i++) {
			System.out.print("-");
		}
		System.out.println();
		//table head
		System.out.print("| Name");
		spaces=maxNameLength-4+1;
		for(int i=0;i<spaces;i++) {
			System.out.print(" ");
		}
		System.out.print("|");
		
		System.out.println(" Won | Lost | Draw | Score |");
		//line
		for(int i=0;i<maxNameLength+32;i++) {
			System.out.print("-");
		}
		System.out.println();
		
		
		//player 1 data
		spaces = maxNameLength-p1Name.length()+1;
		System.out.print("| "+p1Name);
		for(int i=0;i<spaces;i++) {
			System.out.print(" ");
		}
		//counting spaces for won p1
		len = 0;
		num = p1Won;
        while(num != 0)
        {
            // num = num/10
            num /= 10;
            ++len;
        }
        if(num==0) {
        	len=1;
        }
        System.out.print("| "+p1Won);
        spaces = 4 - len;
        for(int i=0;i<spaces;i++) {
			System.out.print(" ");
		}
      //counting spaces for lost p1
      		len = 0;
      		num = p1Lost;
              while(num != 0)
              {
                  // num = num/10
                  num /= 10;
                  ++len;
              }
              if(num==0) {
              	len=1;
              }
              System.out.print("| "+p1Lost);
              spaces = 5 - len;
              for(int i=0;i<spaces;i++) {
      			System.out.print(" ");
      		}
       //counting spaces for draw p1
       		len = 0;
       		num = draw;
            while(num != 0)
            	{
                 // num = num/10
                    num /= 10;
                    ++len;
                }
            if(num==0) {
            	len=1;
            }
            
            System.out.print("| "+draw);
            spaces = 5 - len;
            for(int i=0;i<spaces;i++) {
        		System.out.print(" ");
        	}              
        //counting spaces for score p1
      	len = 0;
      	num = p1Score;
        while(num != 0)
         {
           // num = num/10
             num /= 10;
              ++len;
         }
        if(num==0) {
        	len=1;
        }
          System.out.print("| "+p1Score);
          spaces = 6 - len;
          for(int i=0;i<spaces;i++) {
      	System.out.print(" ");
      		}  
		System.out.println("|");
		
		
		//line
				for(int i=0;i<maxNameLength+32;i++) {
					System.out.print("-");
				}
				System.out.println();
				
				
				//player 2 data
				spaces = maxNameLength-p2Name.length()+1;
				System.out.print("| "+p2Name);
				for(int i=0;i<spaces;i++) {
					System.out.print(" ");
				}
				//counting spaces for won p2
				len = 0;
				num = p2Won;
		        while(num != 0)
		        {
		            // num = num/10
		            num /= 10;
		            ++len;
		        }
		        if(num==0) {
		        	len=1;
		        }
		        System.out.print("| "+p2Won);
		        spaces = 4 - len;
		        for(int i=0;i<spaces;i++) {
					System.out.print(" ");
				}
		      //counting spaces for lost p2
		      		len = 0;
		      		num = p2Lost;
		              while(num != 0)
		              {
		                  // num = num/10
		                  num /= 10;
		                  ++len;
		              }
		              if(num==0) {
		              	len=1;
		              }
		              System.out.print("| "+p2Lost);
		              spaces = 5 - len;
		              for(int i=0;i<spaces;i++) {
		      			System.out.print(" ");
		      		}
		       //counting spaces for draw p2
		       		len = 0;
		       		num = draw;
		            while(num != 0)
		            	{
		                 // num = num/10
		                    num /= 10;
		                    ++len;
		                }
		            if(num==0) {
		            	len=1;
		            }
		            
		            System.out.print("| "+draw);
		            spaces = 5 - len;
		            for(int i=0;i<spaces;i++) {
		        		System.out.print(" ");
		        	}              
		        //counting spaces for score p2
		      	len = 0;
		      	num = p2Score;
		        while(num != 0)
		         {
		           // num = num/10
		             num /= 10;
		              ++len;
		         }
		        if(num==0) {
		        	len=1;
		        }
		          System.out.print("| "+p2Score);
		          spaces = 6 - len;
		          for(int i=0;i<spaces;i++) {
		      	System.out.print(" ");
		      		}  
				System.out.println("|");
				
				//line
				for(int i=0;i<maxNameLength+32;i++) {
					System.out.print("-");
				}
				System.out.println();
				
	}
	
}