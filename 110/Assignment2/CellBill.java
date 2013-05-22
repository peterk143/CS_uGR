//***********************************************************
//Programmer:          Peter Kirkpatrick
//Date:                October 28, 2008
//Program Description: This program calculates and prints the
//							  bill for a cellular telephone company.  
//Question:				  Ch 4, Ex 15, Pg 235
//***********************************************************

import java.util.*;

public class CellBill
{
	//reads user inputs
	static Scanner console = new Scanner(System.in);
	
	public static void main(String[ ] args)
	{
		//instance variables
		char serCode;
		double numMin, dayTime, nightTime, newTime;
		double amtDue, dayAmt, nightAmt, newAmt;
		int accNum;
		String str, tySer;
		
		//program description
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
					tySer = "Regular";
				
					//prompts the user for the number of minutes used
					System.out.print("Minutes Used: ");
					numMin = console.nextDouble();
				
					if(numMin <= 50)
						amtDue = 0.00;
				
					else
						amtDue = (((numMin - 50) * 0.20) + 10);
				
					//outputs
					System.out.println();
					System.out.println("Account Number:             " + accNum);
					System.out.println("Type of Service:            " + tySer);
					System.out.printf("Number of Minutes Used:     %.2f %n", numMin);
					System.out.printf("Amount Due:             $   %.2f %n", amtDue);
				}
		
			else if(serCode == 'p' || serCode == 'P')
				{
					tySer = "Premium";
				
					//prompts the user for the number of minutes used during the day 
					System.out.println("Minutes Used Between");
					System.out.print("	6:00 a.m. and 6:00 p.m.: ");
					dayTime = console.nextDouble();
					
					//prompts the user for the number of minutes used during the night
					System.out.println("Minutes Used Between");
					System.out.print("	6:00 p.m. and 6:00 a.m.: ");
					nightTime = console.nextDouble();
				
					if(dayTime <= 75)
						dayAmt = 0.00;
					
					else
						dayAmt = ((dayTime - 75) * 0.10);
					
					if(nightTime <= 100)
						nightAmt = 0.00;
				
					else
						nightAmt = ((nightTime - 100) * 0.05);
				
					newTime = dayTime + nightTime;
					amtDue = dayAmt + nightAmt;
				
					//outputs
					System.out.println();
					System.out.println("Account Number:                              " + accNum);
					System.out.println("Type of Service:                             " + tySer);
					System.out.printf("Number of Minutes Used During the Day:       %.2f %n", dayTime);
					System.out.printf("Number of Minutes Used During the Night:     %.2f %n", nightTime);
					System.out.printf("Total Number of Minutes Used:                %.2f %n", newTime);
					System.out.printf("Amount Due:                              $    %.2f %n", amtDue);
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
Service Code: p
Minutes Used Between
	6:00 a.m. and 6:00 p.m.: 205
Minutes Used Between
	6:00 p.m. and 6:00 a.m.: 400
	
Account Number:                              123456789
Type of Service:                             Premium
Number of Minutes Used During the Day:       205.00 
Number of Minutes Used During the Night:     400.00 
Total Number of Minutes Used:                605.00 
Amount Due:                              $    28.00 
*/


// second output
/*
This program calculates and prints the bill
for a cellular telephone company.

Please enter the following items.
Account Number: 123456789
Service Code: R
Minutes Used: 6000
  
Account Number:             123456789
Type of Service:            Regular
Number of Minutes Used:     6000.00 
Amount Due:             $   1200.00 
*/