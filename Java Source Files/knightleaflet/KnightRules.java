package knightleaflet;

public class KnightRules {
	
	public static String prevMoves[] = new String[25];
	
	public static int LegalMove (int File, int LastFile, int Rank, int LastRank){
		
		/**
		 * Taking the current move file, previous move file current Rank and previous move rank this procedure
		 * will check to make sure the current move is a legal move.
		 */
		
		int legal = 0;
		
		if(File != 7){		// this external if statement is to ensure the legality of the move isn't put into question if the user wishes to reset or undo
			if(((File == LastFile + 1 || File == LastFile - 1) && (Rank == LastRank + 2 || Rank == LastRank - 2)) ||
				((File == LastFile + 2 || File == LastFile - 2) && (Rank == LastRank + 1 || Rank == LastRank - 1)) ){			
															// Legal move checker code																																										
				legal = 1;									// The extremely long If statement above simply checks the entered data to check if it is 
															// a legal move and then changes the Legal Variable to 1 if it is and if it is not it sets
			}else{											// it to 0
				legal= 0;
			}
	}
		return legal;
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

	public static int UndoLast(int LastFile, int LastRank, int turn,boolean Dead){
		/**
		 * Taking the last file and last rank from the main class this procedure resets the location on the board and reduces the turn counter by one unless
		 * the user decides instead to not undo their last move in which case it simply returns to the main method without changing any variables. 
		 */
		
		boolean undo = false;
		
		if(Dead = false){
		
		TextIO.putln("");
		TextIO.putln("Are you sure you would like to undo your last move?(enter 'y' if yes)");//a final check to ensure the user is sure that they want to undo their previous move
		undo = !TextIO.getlnBoolean();
		
		}
		
		if(undo != true){
			
			knight.Board[LastRank-1][LastFile-1] = 0;
			turn--;
			return turn;
		
		}else{
			
			return turn;
		
		}
		
	}
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

	public static boolean DeadEnd(int File, int LastFile, int Rank, int LastRank){
		int PosRank;
		int PosFile;
		int used = 0;
		boolean Dead = false;
		/**
		 * this procedure is to detect that there is a dead end in the program, checking that the user can move to another position on the board
		 * and that they have not in fact landed somewhere where they can not move to any other location on the board, and then proceed to ask if
		 * they would like to undo their turn or reset the board.
		 */
		
		PosRank = Rank + 1;
/*1*/	PosFile = File + 2;
		if((PosRank <= 5 && PosFile <= 5) && (PosRank >=1 && PosFile >=1)){
			if(knight.Board[PosFile-1][PosRank-1] != 0){
				used = used + 1;
			}
		}
		PosRank = Rank - 1;
/*2*/	PosFile = Rank - 2;
		if((PosRank <= 5 && PosFile <= 5) && (PosRank >=1 && PosFile >=1)){
			if(knight.Board[PosFile-1][PosRank-1] != 0){
				used = used + 1;
			}
		}
		PosRank = Rank + 1;
/*3*/	PosFile = File - 2;
		if((PosRank <= 5 && PosFile <= 5) && (PosRank >=1 && PosFile >=1)){
			if(knight.Board[PosFile-1][PosRank-1] != 0){
				used = used + 1;
			}
		}
		PosRank = Rank - 1;
/*4*/	PosFile = File + 2;
		if((PosRank <= 5 && PosFile <= 5) && (PosRank >=1 && PosFile >=1)){
			if(knight.Board[PosFile-1][PosRank-1] != 0){
				used = used + 1;
			}
		}
		PosRank = Rank + 2;
/*5*/	PosFile = File + 1;
		if((PosRank <= 5 && PosFile <= 5) && (PosRank >=1 && PosFile >=1)){
			if(knight.Board[PosFile-1][PosRank-1] != 0){
				used = used + 1;
			}
		}
		PosRank = Rank - 2;
/*6*/	PosFile = File - 1;
		if((PosRank <= 5 && PosFile <= 5) && (PosRank >=1 && PosFile >=1)){
			if(knight.Board[PosFile-1][PosRank-1] != 0){
				used = used + 1;
			}
		}
		PosRank = Rank + 2;
/*7*/	PosFile = File - 1;
		if((PosRank <= 5 && PosFile <= 5) && (PosRank >=1 && PosFile >=1)){
			if(knight.Board[PosFile-1][PosRank-1] != 0){
				used = used + 1;
			}
		}
		PosRank = Rank - 2;
/*8*/	PosFile = File + 1;
		if((PosRank <= 5 && PosFile <= 5) && (PosRank >=1 && PosFile >=1)){
			if(knight.Board[PosFile-1][PosRank-1] != 0){
				used = used + 1;
			}
		}
		
		if(used >= 8){
			Dead = true;
		}else if(used < 8){
			Dead = false;
		}
		
		return Dead;
		
	}
	
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

	public static void Boardproc(){ 
		/**
		 * this procedure is used to print out the board for the user to see. as it is repeated several times in the code i thought it best
		 * just to represent the board's code in its own procedure
		 */
		
		TextIO.putln("");
		TextIO.putln("");
		TextIO.putln("|   | A | B | C | D | E |");
		TextIO.putln("| 1 | " + knight.Board[0][0] + " | " + knight.Board[0][1] + " | " + knight.Board[0][2] + " | " + knight.Board[0][3] + " | " + knight.Board[0][4] + " |");
		TextIO.putln("| 2 | " + knight.Board[1][0] + " | " + knight.Board[1][1] + " | " + knight.Board[1][2] + " | " + knight.Board[1][3] + " | " + knight.Board[1][4] + " |");
		TextIO.putln("| 3 | " + knight.Board[2][0] + " | " + knight.Board[2][1] + " | " + knight.Board[2][2] + " | " + knight.Board[2][3] + " | " + knight.Board[2][4] + " |");
		TextIO.putln("| 4 | " + knight.Board[3][0] + " | " + knight.Board[3][1] + " | " + knight.Board[3][2] + " | " + knight.Board[3][3] + " | " + knight.Board[3][4] + " |");
		TextIO.putln("| 5 | " + knight.Board[4][0] + " | " + knight.Board[4][1] + " | " + knight.Board[4][2] + " | " + knight.Board[4][3] + " | " + knight.Board[4][4] + " |");
		TextIO.putln("");
		TextIO.putln("");
		return;
	}
		
		
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=



}



