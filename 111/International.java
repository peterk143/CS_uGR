//********************************************************
//Programmer:          Peter Kirkpatrick
//Date:                January 16, 2009
//Program Description: This program prompts the user for 
//							  the number of minutes a call lasted
//							  and outputs the billed amount due.
//Question:				  3
//*********************************************************

//import statements
import java.util.*;

public class International
{
	//new scanner
	static Scanner console = new Scanner(System.in);
	 
	//constants
	public static final double CON = 1.99;
	public static final double TRI = 2.00;
	public static final double ADD = 0.45;
	
	//main method
	public static void main(String[] args)
	{
		//variable declaration
		int min;
		double total = 0;
		
		//user prompt
		System.out.println("Please enter the");
		System.out.print("  number of minutes used: ");
		min = console.nextInt();
		
		//adds .45 to the total for each
		//additional minute over 3 minutes
		while(min > 3)
		{
			total = total + ADD;
			min = min - 1;
		}
		
		//adds 2.00 to the total for each
		//minute under 3 minutes
		while(min <= 3 && min > 0)
		{
			total = total + TRI;
			min = min - 1;
		}
		
		//adds 1.99 to the total for
		//the connection fee
		total = total + CON;
		
		//output
		System.out.printf("$ %.2f" , total);
	}//end of main
}//end of program