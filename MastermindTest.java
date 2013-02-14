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
		
		
	}
	
	public static void testIntro(int testNum, String desc)
	{
		System.out.println("Test #: " + testNum + " Description: " + desc);
	}
	
	public static void fail(int testNum)
	{
		System.out.println("Failed test " + testNum + ".");
	}
	
	public static void pass()
	{
		System.out.println("Passed.");
	}
}
