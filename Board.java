//Cindy driving, Charmara watching

import java.util.*;

public class Board {
  public static void main(String[] args)
	{
		Board b = new Board();
		b.addDots();
		Code userGuess = new Code("PPPP");
		Code compGuess = new Code("PPPP");
		Result r = new Result();
		r.getResults(compGuess, userGuess);
		
		b.changeRow(userGuess,  r);
		
		System.out.println(b.winnerToString());
		
	}

	//class constants
	private static final int NUM_GUESSES = 12;

	//instance variables
	private ArrayList<String> board;
	private int index; //keeps track of what the row on the board that your'e changing as the user guesses

	//constructor generates a board out of an arraylist of strings
	//intializes board and index and adds the first row displaying secret code of computer
	//index++
	public Board(){
		board = new ArrayList<String>();
		index = 0;
		board.add(".... Secret Code");
		index++;
	}

	//pre: none
	//post: iterates through board rows and sets them to hold four dots while the user still hasn't guessed for that row
	public void addDots(){
		for(int i = 1; i <= NUM_GUESSES; i++){
			board.add("....");
		}
	}
	

	//pre: user != null && r != null || r != ""
	//post: changes the row intially set to dots to the user code and the result from it
	//index++
	public void changeRow(Code user, Result r){
		//pre-condition:
		if(user == null || r == null){
			throw new IllegalArgumentException("Violation of precondition: The user code and result cannot be null");
		}
		
		String str = "";
		str += user.toString() + " "; //adds user code to string
		str += "Result: " + r.toString(); //adds result to string
		board.set(index, str); //sets the board row to new string
		index++; 
	}
	
	public int getNumGuesses()
	{
		return NUM_GUESSES;
	}

	//pre: none
	//post returns a string version of the board
	public String toString(){
		String str = "";
		for(int i = 0; i <= NUM_GUESSES; i++){ //iterates through board and adds each row to the string
			str += board.get(i) + "\n";
		}
		return str;
	}

	//pre: none
	//post: returns a string version of the board rows when and before the user won
	public String winnerToString(){
		String str = "";
		for(int i = 1; i <= index; i++){ //iterates through board until index that the user won in and adds those rows to the string
			str += board.get(i) + "\n"; 
		}
		return str;
	}
}
