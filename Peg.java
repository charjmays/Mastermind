import java.util.*;

//Charmara driving, Cindy watching
public class Peg {
  
	//class constants
	private static final char BLACK = 'K';
	private static final char WHITE = 'W';
	private static final char BLUE = 'B';
	private static final char GREEN = 'G';
	private static final char ORANGE = 'O';
	private static final char PURPLE = 'P';
	private static final char RED = 'R';
	private static final char YELLOW = 'Y';
//	private static final ArrayList<Character> ALL_COLORS = new ArrayList<Character>(Arrays.asList(new Character[]
//										{BLACK,
//										WHITE,
//										BLUE,
//										GREEN,
//										ORANGE,
//										PURPLE,
//										RED,
//										YELLOW
//									}));
//	private static ArrayList<Character> USER_COLORS = new ArrayList<Character>(ALL_COLORS);
	
	
	//instance variables
	private char color;
	
	//default constructor generates a peg
	//with a random color B, G, O, P, R, or Y
	public Peg()
	{
		Character[] colors = {BLUE, GREEN, ORANGE, PURPLE, RED, YELLOW};
		
		Random rand = new Random();
		
		int randomNum = rand.nextInt(colors.length);
		
		color = colors[randomNum];
	}
	
	//constructor that assigns color to the peg
	//pre: the color must be an available color
	//post: constructs a Peg of the color
	public Peg(Character c)
	{
		ArrayList<Character> colors = new ArrayList<Character>();
		colors.add(BLACK);
		colors.add(WHITE);
		colors.add(BLUE);
		colors.add(GREEN);
		colors.add(ORANGE);
		colors.add(PURPLE);
		colors.add(RED);
		colors.add(YELLOW);
		
		if(!colors.contains(c))
		{
			throw new IllegalArgumentException("Violation of precondition: " +
					"that is not a correct peg color.");
		}
		
		color = c;
	}
	
	//pre: none
	//post: returns the color of the peg
	public char getColor()
	{
		return color;
	}
	
	public boolean equals(Object obj)
	{
		if(obj instanceof Peg)
		{
			Peg other = (Peg)obj;
			if(this.color == other.color)
			{
				return true;
			}
		}
		return false;
	}
}
