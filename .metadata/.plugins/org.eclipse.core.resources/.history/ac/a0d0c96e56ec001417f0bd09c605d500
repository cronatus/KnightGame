package knightleaflet;

public class knight {
	/**
	 * from some chosen starting square on the board, 
	 * is it possible to construct a sequence of Knight moves such that it visits every 
	 * square on the board exactly once?
	 * 
	 * Check-list
	 * -=-=-=-=-=-=-
	 * 1 -=- Basic Board - implemented -- documented
	 * 2 -=- reset procedure - implemented --
	 * 3 -=- used location check - implemented --
	 * 4 -=- successful completion check - implemented --
	 * 5 -=- legal knight move check - implemented --
	 * -=-=-=-=-=-=-
	 * Unnecessary additions check list
	 * -=-=-=-=-=-=-
	 * 6 -=- allow user to choose starting square - implemented --
	 * 7 -=- detect dead end - implemented --
	 * 8 -=- undo last move - implemented --
	 * 9 -=- undo a series of moves - possibility(not planned)
	 * 10 -=- end-game replay of players moves - possibility(not planned)
	 * 11 -=- ^ allow deviation in replay to attempt different route - possibility(not planned)
	 * 12 -=- extend to 5x5 board - Implemented --
	 * 13 -=- provide option to save the path to a text file for analysis - Implemented --
	 * -=-=-=-=-=-=-
	 * Mandatory extras(non functional)
	 * -=-=-=-=-=-=-
	 * 14 -=- Development report - in progress
	 * 15 -=- well structured code(readability) - in progress
	 * 16 -=- comments - in progress
	 * -=-=-=-=-=-=-
	 * 
	 */
	public static int[][] Board = 	{ 	{0,0,0,0,0}, 	// A1, B1, C1, D1, E1 - These represent the top row of the board
										{0,0,0,0,0}, 	// A2, B2, C2, D2, E2 - these represent the second row,
										{0,0,0,0,0},  	// A3, B3, C3, D3, E3 - these represent the Middle row,
										{0,0,0,0,0},	// A4, B4, C4, D4, E4 - these represent the fourth row.
										{0,0,0,0,0}		// A5, B5, C5, D5, E5 - and these represent the last row.
									}; 				//This array is used to represent the board
	public static int File; 				//variable to Represent the File from the Input String
	public static int Rank; 				//Variable To Represent the Rank from the Input String
	public static String input;				//Variable to represent the input taken in by the program.
	public static boolean reset = true;		//variable to represent the users answer to trying a new route
	public static int turn = 1; 			//Variable declared to keep track of the current turn
	public static int LastRank = 0;			//Variable to represent the Rank from the previous move
	public static int LastFile = 0;			//Variable to represent the File from the previous move
	
	public static void main(String[] args) {
		
		int temp1 = 0; 			//This variable is to control the inner Loop.
		int temp2 = 0;			//This variable is to control the outer loop	
		int legal = 1;			//Variable to represent that the next location is a legal move
		boolean save = false;	
		boolean Dead = false;
		
		
		TextIO.putln("Welcome to the open Knight’s tour problem! This program allows you to move "); 	//these lines are used to give the user a
		TextIO.putln("a Knight around a 3 by 4 chessboard. Your task it to have it visit each of");		//description of their aim in this game
		TextIO.putln("the 12 squares on the board exactly once without visiting any square twice");
		TextIO.putln("");
		
		TextIO.putln("Here is the board as it will be shown while in play,");				//These lines are used to insure the user is aware of
		TextIO.putln("please note all positions are currently represented as 0;");			//how the game represents the information to them
		TextIO.putln("this represents that it has not been visited by the night,");
		TextIO.putln("Each turn you make will be represented with the turn number");
		TextIO.putln("in place of the 0(1 appearing in the top left when play begins)");
		TextIO.putln("");
		
		KnightRules.Boardproc();
		
		legal = 1;
		
		do{
		temp1 = 1;
		TextIO.putln("Let's Begin, shall we?");
		TextIO.putln("Please enter the location you would like to start on the board");
		startingloc();
		
		if(File <= 0 || Rank <= 0){														
			TextIO.putln("The Location entered is not valid please try again.");		
		} else if((File > 0 && Rank > 0) && (File <= 5 && Rank <= 5)){
			Board[Rank - 1][File - 1] = turn;
			turn = turn + 1;
			temp1 = 0;
		}
		
		while(temp1 != 1){
			
			
			if(legal == 1){
				LastRank = Rank;
				LastFile = File;
				legal = 0;
			}
			
			KnightRules.Boardproc();
			
			TextIO.putln("Please enter the square you would like to move to next.");
			TextIO.putln("(enter in the form of:'A1')Please note anything entered ");
			TextIO.putln("after the first two characters will be ignored. enter ");
			TextIO.putln("'q' to end the game and reset the board or enter 'u' to");
			TextIO.putln("undo your last move");
			TextIO.putln("");
			
			startingloc();
				
				legal = KnightRules.LegalMove(File, LastFile, Rank, LastRank);
				
				if(legal != 0){
					
				if(File <= 0 || Rank <= 0){														// this code is the second last check before altering the
																								// playing board, it will check for an invalid number
					TextIO.putln("The Location entered is not valid please try again.");		// if it is invalid then it will negate the turn
																								// if it is valid however it will find the wanted location
				}else if((File > 0 && Rank > 0) && (File <= 5 && Rank <= 5)){					// in the board array and alter it to fit the turn.
																								
					if(Board[Rank-1][File-1] != 0 ){																//This code is the final check, it is designed 
						TextIO.putln("");																			//to ensure that the location the user is trying
						TextIO.putln("The location you are trying to move to has already been used");				//to go to has not already been moved too
						TextIO.putln("the selected move is invalid and therefore will not be counted");				//it checks if the location has been used and if it has
																													//it negates the turn and if it has not it continues and
					}else if(Board[Rank-1][File-1] == 0){															//changes the board to fit.
						
						Board[Rank-1][File-1] = turn;																
						turn++;
					}											
				}
				}else if(legal == 0){
					
					TextIO.putln("");
					TextIO.putln("The Location entered is not a legal Knight move");
					TextIO.putln("This attempt will not be counted");
					TextIO.putln("");
					
				}
				
				Dead = KnightRules.DeadEnd(File, LastFile, Rank, LastRank);
				
				if(turn >= 26){																							//The code within this statement
																														//is put in place to detect that
					TextIO.putln("");																					//the user has completed the Game,
					TextIO.putln("Congratulations you have completed the Knights Tour on a 3x4 board");					//in this it simply detects that the
					TextIO.putln("Here is you final board:");															//turn variable has been raised above
					TextIO.putln("");																					//the number of places on the board.
					TextIO.putln("");																					//and then it prints out the congratulations
																														//message followed by a reset of the code
					KnightRules.Boardproc();
						
					TextIO.putln("Would you like to save your route  to a text file for analysis?(Enter 'y' if so");
					save = TextIO.getlnBoolean();
						
					if(save = true){
					Writer();
					}else {
						
					}
						
					TextIO.putln("if you would like to try a different route enter 'y'");
					reset = !TextIO.getlnBoolean();
					TextIO.putln("");
					TextIO.putln("");
					
					if(reset = true){
						reset = false;
					}else if(reset = false){
						temp2 = 1;
					}
					
				}
				
				if(Dead == true){		// This statement is activated if the user has reached a dead end on the board
					
					boolean undo = false; // this declares and initialises the Variable undo, as it is only used in this statement
						
						TextIO.putln("");
						TextIO.putln("You have run into a Dead end, there are no available moves");
						TextIO.putln("Would you like to undo your last move?(Enter 'y' if yes)");
						TextIO.putln("if not the Board will be reset");
						TextIO.putln("");
						
						undo = TextIO.getBoolean();
						
						if(undo == true){
							
							KnightRules.UndoLast(File, Rank, turn, Dead);
							
						}else if(undo == false){
							
							reset();
							
						}
						
						TextIO.getln(); //this is used to reset TextIO's getln procedure as while testing the above statement caused the next getln to be skipped.
						
					}
				
				if(reset != true){
					reset = true;
					temp1 = 1;
					turn = 1;
					Rank = 1;
					File = 1;
					legal = 1;
					
					TextIO.putln("Would you like to save your route  to a text file for analysis?(Enter 'y' if yes");
					save = !TextIO.getlnBoolean();
					
					if(save != true){
					Writer();
					save = true;
					}else {
								
					}
					reset();			
					
				}
			
		}
		temp1 = 0;
		}while(temp2 != 1);
		
	}
	
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-	
	
	public static void reset(){	
		/**
		 * this procedure is set up simply to reset the board to a blank slate and print out a blank copy of the
		 * board before continuing with a new game.
		 */
		int one = 0;						
		int two = 0;
		
	
		
		
		for(one = 0 ; one <= 4 ; one++){
			for(two = 0 ; two <= 4 ; two++){
				Board[one][two] = 0;			//This area of the reset procedure directly reset's each individual integer in the Board Array. 
			}
		}
		
		TextIO.putln("");
		TextIO.putln("The board has been reset");
		TextIO.putln("");
		TextIO.putln("");
		TextIO.putln("	*** Warning: there is a high possibility that the program will not allow certain legal movements after reset");
		TextIO.putln("");
		TextIO.putln("________________________________________________________________________________");
		
		return;
	}
	
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-	
	
	public static void startingloc(){
		/**
		 * This procedure takes in the users input and splits it into two separate strings which are then checked exclusively and
		 * set an integer to the correct Array location + 1 
		 */
		
		String Row;
		String Column;
		boolean dead = false;
		
		input = TextIO.getln() + "1";	//Variable for the users input  to be used and separated below
		
			Column = input.substring(0,1);
			Row = input.substring(1,2);
			
			switch(Column){							//this switch statement is to check the Column or File which is to be altered and set that into an
			case "a":							//integer for the array to find the specific location easily
			case "A":
				File = 1;
				break;
			case "b":
			case "B":
				File = 2;
				break;
			case "c":
			case "C":
				File = 3;
				break;
			case "d":
			case "D":
				File = 4;
				break;
			case "e":
			case "E":
				File = 5;
				break;
			case "q":
			case "Q":
				File = 7;
				reset = false;
				break;
			case "u":
			case "U":
				File = 7;
				turn = KnightRules.UndoLast(LastFile,  LastRank, turn, dead); // calls upon the undo method from the Rules Class
				break;
			case "f":		// this is a control case, anything which is not one of the above will default to this case
				File = 0;
				break;
		}
		
		switch(Row){							//This switch statement does the same as the above one for the Rank or Row
			case "1":
				Rank = 1;
				break;
			case "2":
				Rank = 2;
				break;
			case "3":
				Rank = 3;
				break;
			case "4":		
				Rank = 4;
				break;
			case "5":
				Rank = 5;
				break;
			case "6": 			// this is the control case. ^^
				Rank = 0;
				break;
		}
		
	
	return;

	}
	
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-	

	
	public static void Writer(){	
		/**
		 *  This procedure is for the creation of an external file which contains a printout of the board
		 */
		
		String FileName;
		
		TextIO.putln("");
		TextIO.putln("Please enter the name you would like to save your file under");
		TextIO.putln("WARNING: If the name entered is the same as a current file it will be overwritten");
		FileName = TextIO.getln();
		
		TextIO.writeFile(FileName + ".txt"); 	// this designates the name of the file to be written to, creating it if it doesn't exist
												// and overwriting it if it does.
		KnightRules.Boardproc();
		
		TextIO.writeStandardOutput();		//this sets the program to now set all output to the standard output location instead of the file indicated
		
		return;
	}
	
	
}
		

/*  Temporary Pseudocode storage
 * -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
 * 
 * 
 * 
 * 
 * 
 */
