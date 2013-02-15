import java.util.*;

public class gobleCharmara {
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


		
		/*****************/
		
		//Tests for Code class
		
		//test 1 for Code constructor
		testNum++;
		testIntro(testNum, "Test for Code constructor that takes in a string");
		String color = "BBRRY";
		Code userCode = new Code();
		try
		{
			userCode = new Code(color);
		}
		catch(IllegalArgumentException e)
		{
			pass();
		}

		if(userCode.toString().equals("BBRRY"))
		{
			fail(testNum);
		}


		//test 2 for getPeg() method
		testNum++;
		testIntro(testNum, "Test for getPeg() method that takes in a position");

		try
		{
			userCode.getPeg(5);
		}
		catch(IllegalArgumentException e)
		{
			pass();
		}
		catch(IndexOutOfBoundsException a)
		{
			fail(testNum);
		}

		//test 3 for getPeg() method
		testNum++;
		userCode = new Code("BBYY");
		Peg exp = new Peg('Y');
		Peg act = userCode.getPeg(2);
		if(act.equals(exp))
			pass();
		else
			fail(testNum);

		//test 4 for equals() method
		testNum++;
		Code compCode = new Code("BBYY");
		boolean expectBool = true;
		boolean actualBool = userCode.equals(compCode);
		if(expectBool == actualBool)
			pass();
		else
			fail(testNum);

		//test 5 for equals() method
		testNum++;
		compCode = new Code("BBBB");
		expectBool = false;
		actualBool = userCode.equals(compCode);
		if(expectBool == actualBool){
			pass();
		}
		else
			fail(testNum);

		//test 6 for toString()
		testNum++;
		String expectString = "BBBB";
		String actualString = compCode.toString();
		if(expectString.equals(actualString))
			pass();
		else
			fail(testNum);

		//test 7 for maxSize()
		testNum++;
		int expectInt = 4;
		int actualInt = compCode.size();
		if(expectInt == actualInt)
			pass();
		else
			fail(testNum);

		
		/*****************/
		
		//Tests for Board class
		
		//test 1 for BoardGame addDots()
		testNum++;
		Board b = new Board();
		b.addDots();
		String dots = "";
		for(int i = 0; i < 12; i++){
			dots += "....\n";
		}
		expectString = ".... Secret Code\n" + dots;
		actualString =b.toString();
		if(expectString.equals(actualString))
			pass();
		else
			fail(testNum);

		//test 2 for changeRow()
		testNum++;
		Result result = new Result();
		userCode = null;
		try
		{
		b.changeRow(userCode, result);
		}
		catch(IllegalArgumentException e)
		{
			pass();
		}
		catch(NullPointerException n)
		{
			fail(testNum);
		}


		//test 3 for getNumGuesses()
		expectInt = 12;
		actualInt = b.getNumGuesses();
		if(actualInt == expectInt)
			pass();
		else
			fail(testNum);

		//test 4 for toString()

		testNum++;
		compCode = new Code("BBBB");
		userCode = new Code("BBBB");
		Result res = new Result();
		res.getResults(compCode, userCode);
		b.changeRow(userCode, res);
		expectString = ("....Secret Code\n BlackBlackBlackBlack");
		dots = "";
		for(int i = 1; i < 12; i++){
			dots+= "....\n";
		}
		actualString = b.toString();
		if(actualString.equals(expectString))
			pass();
		else
			fail(testNum);
		
		

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

