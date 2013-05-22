//******************************************************************
//Programmer:          Peter Kirkpatrick
//Date:                October 28, 2008
//Program Description: This program reads an initial amount, and 
//							  then computes the total in the account after 
//							  a period of time.
//Question:				  Ch 5, Ex 18, Pg 315
//******************************************************************

import java.util.*;

public class CompoundInterest
{
	//takes inputs from the user
	static Scanner console = new Scanner(System.in);
	
	//constant value
	static final double INT = 0.10;
			
	public static void main(String[ ] args)
	{
		//instance variables
		double intAmt, mthInt, yrInt, newYrInt, newMthInt;
		double amtAcc, newAcc;
		int counter = 1; 
		int years, year;
		
		//program description
		System.out.println("This program reads an initial amount,");
		System.out.println("and then computes the total an account");
		System.out.println("after a period of time.");
		
		//prompts the user for the initial investment amount
		System.out.println();
		System.out.print("Enter Initial Amount: $");
		intAmt = console.nextDouble();

		//determines the amount accumulated after 44 years of being compounded
		amtAcc = intAmt * (1 + INT);
	
		while(counter < 44)
		{
			counter++;
			amtAcc = amtAcc * (1 + INT);		
		}		
		
		years = counter;
		yrInt = amtAcc - intAmt;
		mthInt = yrInt / 12;
		
		//determines the amount accumulated after 45 years of being compounded
		newAcc = amtAcc * (1 + INT);
				
		newYrInt = newAcc - intAmt;
		newMthInt = newYrInt / 12;
		year = years + 1;
		
		//outputs
		System.out.println();
		System.out.printf("The initial investment was $%.2f", intAmt);
		System.out.println(".  The total amount");
		System.out.print("accumulated after " + years);
		System.out.printf(" years, if $%.2f %n", intAmt);
		System.out.println("is allowed to compound with an interest of 10.00%,");
		System.out.printf("comes to $%.2f", amtAcc);
		System.out.print(".  ");
		System.out.println("The total amount accumulated after " + year);
		System.out.printf("years, if $%.2f", intAmt);
		System.out.println(" is allowed to compound with");
		System.out.print("an interest of 10%,");
		System.out.printf(" comes to $%.2f", newAcc);
		System.out.println(".  ");
		System.out.printf("The interest earned during this year is $%.2f", newYrInt);
		System.out.println(".  ");
		System.out.println("If interest is withdrawn each year thereafter,");
		System.out.printf("my income is $%.2f", newMthInt);
		System.out.println(" per month.");
	}
}


// output
/*
This program reads an initial amount,
and then computes the total an account
after a period of time.
  
Enter Initial Amount: $1700
 
The initial investment was $1700.00.  The total amount
accumulated after 44 years, if $1700.00 
is allowed to compound with an interest of 10.00%,
comes to $112648.93.  The total amount accumulated after 45
years, if $1700.00 is allowed to compound with
an interest of 10%, comes to $123913.82.  
The interest earned during this year is $122213.82.  
If interest is withdrawn each year thereafter,
my income is $10184.49 per month.
*/