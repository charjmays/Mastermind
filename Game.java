//Charmara driving, Cindy watching

import java.util.*;

public class Game {
  public static void main(String[] args)
	{
		Game g = new Game(false);
		g.runGames();
	}


	// if showCode is true then the secret code is revealed before
	// the game starts. This will be used by graders of the program
	// to test the feedback of guesses
    private boolean showCode;

    public Game(boolean easy){
        showCode = easy;
    }

    public void runGames(){
    	printInstructions(); //prints the instructions for the game
    	
    	Board board = new Board(); //creates the Board object for the game
    	board.addDots(); //adds the correct number of dots for the Board object
    	Result results = new Result(); //the results object that will generate the results
    	
    	int numGuesses = board.getNumGuesses(); //The max number of guesses the player has
    	
    	System.out.println("You have " + numGuesses + " guesses to guess the correct answer.\n");
    	
    	boolean anotherGame = true; //checks if another game will be played
    	
    	while(anotherGame)
    	{
    		anotherGame = false;
    		
    		System.out.println("Generating secret code ....");
        	
        	Code compCode = new Code(); //the secret code to be used throughout the game
        	Scanner keyboard = new Scanner(System.in);
        	

        	boolean canContinue = true; //checks if the game can continue playing
        	
        	numGuesses = board.getNumGuesses(); //resets the number of guesses back
        	
    		while(canContinue)
    		{
    			//shows the secret code if showCode is true
    			if(showCode)
    			{
    				System.out.println("The secret code is: " + compCode);
    			}
    		
    			System.out.println("You have " + numGuesses + " guesses left.\n");
    		
    			boolean badCode = true; //checks if the user puts in a bad code
    			Code userCode = new Code(); //creates temporary userCode object
    		
    			//runs while the user puts in a bad code
    			while(badCode)
    			{
    				badCode = false;
    				System.out.println("What is your next guess?");
    				System.out.println("Type in the characters for your guess and press enter.");
    				System.out.print("Enter guess: ");
    			
    				String guess = keyboard.nextLine(); //gets the code from the user
    			
    				try
    				{
    					userCode = new Code(guess); //creates user code with correct input
    				}
    				catch(IllegalArgumentException e)
    				{
    					badCode = true; //sets badCode to true if the user's code was bad
    				}
    			}
    		
    			boolean winner = results.getResults(compCode, userCode); //boolean that stores if the user won; also gets the results for the round
    		
    			//shows secret code is showCode is true
    			if(showCode)
    			{
    				System.out.println("The secret code is: " + compCode + "\n");
    			}
    		
    			board.changeRow(userCode, results); //changes the row of the board
    		
    			//if boolean winner is false, this will print out the board that winners see
    			//else it will print out the default board
    			if(winner)
    			{
    				System.out.println(board.winnerToString());
    			}
    			else
    			{
    				System.out.println(board);
    			}
    		
    			numGuesses--; //decreases 
    		
    			if(numGuesses == 0 || winner)
    			{
    				canContinue = false;
    				if(numGuesses == 0)
    				{
    					System.out.println("You did not solve the puzzle. Too bad.");
    				}
    				if(winner)
    				{
    					System.out.println("You solved the puzzle! Good job.");
    				}
    				System.out.print("Enter Y for another game or anything else to quit: ");
    				String input = keyboard.next();
    				if(input.equals("Y"))
    				{
    					anotherGame = true;
    				}
    			}
    		
    		}
    	}
    	
    	
    }
    
    public static void printInstructions()
    {
    	System.out.println("Welcome to Mastermind.\n" +
    			"This is a text version of the classic board game Mastermind.\n" +
    			"The computer will think of a secret code.\n" +
    			"The code consists of 4 colored pegs.\n" +
    			"The pegs may be one of six colors: blue, green , orange, purple, red, or yellow.\n" +
    			"A color may appear more than once in the code.\n\n" +
    			"You try to guess what colored pegs are in the code and what order they are in.\n" +
    			"After making a guess the result will be displayed.\n" +
    			"A result consists of a black peg for each peg you have exactly correct (color and position) in your guess.\n" +
    			"For each peg in the guess that is the correct color, but is out of position, you get a white peg.\n\n" +
    			"Only the first letter of the color is displayed. B for Blue, R for Red, and so forth.\n" +
    			"When entering guesses you only need to enter the first character of the color as a capital letter.\n"
    			);
    }
}
