//***********************************************************
//Programmer:          Peter Kirkpatrick
//Date:                October 28, 2008
//Program Description: This program calculates and prints the
//							  bill for a cellular telephone company.
//Question:				  Ch 7, Ex 8, Pg 460
//***********************************************************

import java.util.*;

public class CellBillMethod
{
	//methods
	private static double Regular(double min)
	{
		//instance variables
		double amtDue;
		double numMin = min;
		
		if(numMin <= 50)
			amtDue = 0.00;
				
		else
			amtDue = (((numMin - 50) * 0.20) + 10);
				
		//returns the number for the amount due through the regular plan
		return amtDue;
	}		
		
	private static double Premium(double day, double night)
	{
		//instance variables
		double dayTime = day;
		double nightTime = night;
		double dayAmt = 0.00;
		double nightAmt = 0.00;
		double amtDue = 0.00;
		
		if(dayTime <= 75)
			dayAmt = 0.00;
				
		else
			dayAmt = ((dayTime - 75) * 0.10);
				
		if(nightTime <= 100)
			nightAmt = 0.00;
		
		else
			nightAmt = ((nightTime - 100) * 0.05);
		
		amtDue = dayAmt + nightAmt;
		
		//returns the number for the amount due through the premium plan
		return amtDue;
		
	}

	//reads user inputs
	static Scanner console = new Scanner(System.in);
	
	public static void main(String[ ] args)
	{
		//instance variables
		char serCode;
		double numMin, dayTime, nightTime, newTime = 0.00;
		double amtDue = 0;
		double dayAmt, nightAmt;
		int accNum;
		String str, tySer;
		
		//outputs program description
		System.out.println("This program calculates and prints the bill");
		System.out.println("for a cellular telephone company.");
		System.out.println();
		System.out.println("Please enter the following items.");
		
		//prompts the user for the account number
		System.out.print("Account Number: ");
		accNum = console.nextInt();
		
		//prompts the user for the service code
		System.out.print("Service Code: ");
		serCode = console.next().charAt(0);
		
		if(serCode == 'r' || serCode == 'R' || serCode == 'p' || serCode == 'P')
		{		
			if(serCode == 'r' || serCode == 'R')
				{
					//instance variables
					tySer = "Regular";
					double ins = 0.00;
				
					//prompts the user for the number of minutes used
					System.out.print("Minutes Used: ");
					numMin = console.nextDouble();
					amtDue = Regular(numMin);
					System.out.println();
							
					//outputs
					System.out.println("Account Number:          " + accNum);
					System.out.println("Type of Service:         " + tySer);
					System.out.printf("Number of Minutes Used:   %.2f %n", numMin);
					System.out.printf("Amount Due:             $ %.2f %n", amtDue);
				}
		
			else if(serCode == 'p' || serCode == 'P')
				{
					//instance variables
					tySer = "Premium";
					double inc = 0.00;
					
					//prompts the user for the number of minutes used
					System.out.println("Minutes Used Between");
					System.out.print("	6:00 a.m. and 6:00 p.m.: ");
					dayTime = console.nextDouble();
					
					System.out.println("Minutes Used Between");
					System.out.print("	6:00 p.m. and 6:00 a.m.: ");
					nightTime = console.nextDouble();
					System.out.println();
					
					newTime = dayTime + nightTime;
					amtDue = Premium(dayTime, nightTime);
								
					//outputs
					System.out.println("Account Number:                 " + accNum);
					System.out.println("Type of Service:                " + tySer);
					System.out.printf("Day Time Minutes Used:          %.2f %n", dayTime);
					System.out.printf("Night Time Minutes Used:        %.2f %n", nightTime);
					System.out.printf("Total Number of Minutes Used:   %.2f %n", newTime);
					System.out.printf("Amount Due:                   $  %.2f %n", amtDue);
				}
			}
			
		//error output			
		else
			System.out.println("You entered an incorrect service code.");
	}
}


// first output
/*
This program calculates and prints the bill
for a cellular telephone company.
  
Please enter the following items.
Account Number: 123456789
Service Code: r
Minutes Used: 6000
 
Account Number:          123456789
Type of Service:         Regular
Number of Minutes Used:   6000.00 
Amount Due:             $ 1200.00 
*/


// second output
/*
This program calculates and prints the bill
for a cellular telephone company.

Please enter the following items.
Account Number: 123456789
Service Code: p
Minutes Used Between
	6:00 a.m. and 6:00 p.m.: 205
Minutes Used Between
 	6:00 p.m. and 6:00 a.m.: 400

Account Number:                 123456789
Type of Service:                Premium
Day Time Minutes Used:          205.00 
Night Time Minutes Used:        400.00 
Total Number of Minutes Used:   605.00 
Amount Due:                   $  28.00 
*/