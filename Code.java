import java.util.*;

//Cindy driving, Charmara watching
public class Code {
  private static final int maxSize = 4;
	
	//instance variable
	private ArrayList<Peg> code;
	
	//default constructor generates a random code from the computer using an arraylist
	public Code(){
		code = new ArrayList<Peg>();
		//adds maxSize random pegs into arraylist of code
		for(int i = 0; i < maxSize; i++){
			Peg p1 = new Peg();
			code.add(p1);
		}
	}
	
	//construct generates a code based on string passed in
	//pre: input.length must match maxSize 
	//post: constructs code based on input
	public Code(String input){
		//pre: check that input length matches maxSize
		if(input.length() != maxSize){
			throw new IllegalArgumentException("Violation of precondition: Your input is not the correct length!");
		}
		
		this.code = new ArrayList<Peg>();
		
		//add pegs with color and add them to arraylist code
		for(int i = 0; i < maxSize; i++){
			Peg peg = new Peg(input.charAt(i));
			this.code.add(peg);
		}
		
		
	}
	
	//pre: position has to be greater than or equal to 0 and less than maxSize
	//post: returns peg at position
	public Peg getPeg(int pos){
		if(pos < 0 || pos >= maxSize)
		{
			throw new IllegalArgumentException("Violation of precondition: pos is out of bounds.");
		}
		return this.code.get(pos);
	}
	
	//pre: none
	//post: returns whether the two codes are equal
	public boolean equals(Object other){
		if(other instanceof Code){
			Code otherCode = (Code)other;
			for(int i = 0; i < maxSize; i++){
				if(!this.getPeg(i).equals(otherCode.getPeg(i))){
					return false;
				}
			}
		}
		return true;
		
	}
	
	//pre: none
	//post: returns a string version of the code
	public String toString() {
		String str = "";
		//loop through Code, get Peg and get its color
		for(int i = 0; i < maxSize; i++){
			
			Peg p1 = this.getPeg(i);
			char c = p1.getColor();
			str += c;
		}
		return str;
	}
	
	//pre: none
	//post: returns maxSize of Code
	public int size(){
		return maxSize;
	}
}
