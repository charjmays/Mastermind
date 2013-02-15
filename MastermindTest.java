import java.util.*;

public class MastermindTest {
	public static void main(String[] args)
	{
		//Tests for Peg class
		int testNum = 0;
		
		//Constructor Test #1
		
		testNum++;
		
		testIntro(testNum, "A test for the constructor that takes in one Character.");
		Peg p1 = new Peg();
		
		try
		{
			p1 = new Peg('X');
		}
		catch(IllegalArgumentException e)
		{
			pass();
		}
		
		if(p1.getColor() == 'X')
		{
			fail(testNum);
		}
		
		//Test for getColor() method
		testNum++;
		
		testIntro(testNum, "Test for getColor() method.");
		
		p1 = new Peg('R');
		
		if(p1.getColor() != 'R')
		{
			fail(testNum);
		}
		else
		{
			pass();
		}
		
		//Test #1 for equals() method
		testNum++;
		
		testIntro(testNum, "Test for equals() method.");
		
		Peg p2 = new Peg('B');
		
		if(p1.equals(p2))
		{
			fail(testNum);
		}
		else
		{
			pass();
		}
		
		//Test #2 for equals() method
		testNum++;
		
		testIntro(testNum, "Second test for equals() method.");
		
		p2 = new Peg('R');
		
		if(p1.equals(p2))
		{
			pass();
		}
		else
		{
			fail(testNum);
		}
		
		/**************************/
		
		//Tests for Result class
		
		//Test #1 for getResults() method
		testNum++;
		
		testIntro(testNum, "First test for Result getResults() method.");
		
		Result r = new Result();
		Code comp = new Code("BBBB");
		Code user = new Code("RRRR");
		
		boolean winner = r.getResults(comp, user);
		
		String expected = "No pegs";
		String actual = r.toString();
		
		if(!expected.equals(actual))
		{
			fail(testNum);
		}
		else if(winner)
		{
			fail(testNum);
		}
		else
		{
			pass();
		}
		
		//Test #2 for getResults() method
		testNum++;
		
		testIntro(testNum, "Second test for Result getResults() method.");
		
		user = new Code("BBBB");
		
		winner = r.getResults(comp, user);
		
		expected = "Black Black Black Black ";
		actual = r.toString();
		
		if(!expected.equals(actual))
		{
			fail(testNum);
		}
		else if(!winner)
		{
			fail(testNum);
		}
		else
		{
			pass();
		}
		
		//Test #3 for getResults() method
		testNum++;
		
		testIntro(testNum, "Third test for Result getResults() method.");
		
		comp = new Code("RBRB");
		user = new Code("BRBR");
		
		winner = r.getResults(comp, user);
		
		expected = "White White White White ";
		actual = r.toString();
		
		if(!expected.equals(actual))
		{
			fail(testNum);
		}
		else if(winner)
		{
			fail(testNum);
		}
		else
		{
			pass();
		}
		
	}
	
	public static void testIntro(int testNum, String desc)
	{
		System.out.println("Test " + testNum + " | Description: " + desc);
	}
	
	public static void fail(int testNum)
	{
		System.out.println("*****Failed Test " + testNum + "*****");
	}
	
	public static void pass()
	{
		System.out.println("Passed.");
	}
}
