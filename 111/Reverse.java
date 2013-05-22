//**********************************************************
//Programmer:          Peter Kirkpatrick
//Date:                January 17, 2009
//Program Description: This program prompts the user for an 
//							  integer and the outputs that number
//							  in reverse order.
//Question:				  4
//**********************************************************

//import statement
import java.util.*;

public class Reverse
{
	//new scanner
	static Scanner console = new Scanner(System.in);
	
	//main method
	public static void main(String[] args)
	{
		//variable declaration
		String str;
		int j, length;
		
		//user prompt
		System.out.println("Please enter a number: ");
		str = console.nextLine();
		
		//set the variable "length" to
		//one less the than length of 
		//the String str
		length = str.length() - 1;
		
		//prints the String str
		//in reverse
		for(j = length; j >= 0; j--)
		{
			System.out.print(str.charAt(j));
		}
	}//end of main
}//end of program