//*****************************************************************************
//Programmer:          Peter Kirkpatrick
//Date:                October 16, 2008
//Program Description: Thie program asks the user for a positive integer number,
//							  computes the factorial value, and displays the answer.
//******************************************************************************

import java.util.*;

public class ForLoop
{
	static Scanner console = new Scanner(System.in);
	
	public static void main(String[ ] args)
	{
		int num, factorial, counter;

		counter = 0;
		
				
		System.out.println("This program asks the user for a positive integer number,");
		System.out.println("computes the factorial value, and displays the answer.");
		System.out.println();
		System.out.print("Please enter a positive number: ");
		num = console.nextInt();
		
		if(num < 0)
		{
			System.out.print("Please enter a POSITIVE number: ");
			num = console.nextInt();
		}
				
		factorial = 1;
		
		for(counter = 2; counter <= num; counter++)
		{
			factorial = factorial * counter;
		}
		
		System.out.println("The factorial of " + num + " is " + factorial + ".");
	}
}