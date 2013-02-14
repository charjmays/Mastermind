import java.util.*;

//Charmara driving, Cindy watching
public class Result {
  public static void main(String[] args)
	{
		Code comp = new Code("BRPR");
		Code user = new Code("BRRB");

		Result r = new Result();
		r.getResults(comp, user);
		System.out.println(r);
	}
	//instance variables
	String result;
	
	//pre: comp and user must not be null
	//post: constructs a new Result 
	public Result()
	{
		result = "";
	}
	
	public boolean getResults(Code comp, Code user)
	{
		//checks precondition
		if(comp == null || user == null)
		{
			throw new IllegalArgumentException("Violation of precondition: " +
								"comp must not be null and user must not be null.");
		}
		
		result = "";
		char black = 'B';
		char white = 'W';
		
		ArrayList<Peg> userCode = new ArrayList<Peg>();
		ArrayList<Peg> compCode = new ArrayList<Peg>();
		
		for(int i = 0; i < comp.size(); i++)
		{
			userCode.add(user.getPeg(i));
			compCode.add(comp.getPeg(i));
		}
		
		int maxSize = compCode.size(); 
		
		//these iterate through the two Codes and
		//checks if either black or white
		//should be added to the String result
		for(int i = 0; i < maxSize; i++)
		{
			//first checks if the position and color are the same
			if(compCode.get(i).equals(userCode.get(i)))
			{
				result += black;
				compCode.set(i, null);
				userCode.set(i, null);
			}
			else
			{
				
				for(int j = 0; j < maxSize; j++)
				{
					//checks if the color is the same, but position
					//is different
					if(compCode.get(i) != null && userCode.get(j) != null)
					{
						if(compCode.get(i).equals(userCode.get(j)))
						{
							result += white;
							compCode.set(i, null);
							userCode.set(j, null);
						}
					}
				}
			}
		}
		
		//method returns true if the user wins and false otherwise
		if(comp.equals(user))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	/**
	 * pre: none
	 * post: adds all the Blacks to the string, then all of the Whites
	 * then returns the string
	 */
	public String toString()
	{
		String str = "";
		if(result.length() == 0)
		{
			str += "No pegs";
		}
		else
		{
			for(int i = 0; i < result.length(); i++)
			{
				if(result.charAt(i) == 'B')
				{
					str += "Black ";
				}
			}
			
			for(int i = 0; i < result.length(); i++)
			{
				if(result.charAt(i) == 'W')
				{
					str += "White ";
				}
			}
		}
		
		return str;
	}
}
