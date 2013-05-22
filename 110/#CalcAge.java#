//*********************************************************************************
//Programmer:          Peter Kirkpatrick
//Date:                October 22, 2008
//Program Description: This program asks the user to enter today's year in 4-digits,
//							  today's month number, the user's 4-digit year of birth, and
//							  month number.  Then the program will calculate and display 
//							  how old the user is in years and months.                 
//*********************************************************************************

import java.util.Scanner;
import java.lang.Math;

public class CalcAge
{
	static Scanner console = new Scanner(System.in);
	
	public static void main(String[ ] args)
	{
		int currentYear = 0, currentMonth = 0, year, month;
		int age = 0;
		String line;
		char again = 'y';
				
		System.out.println("This program asks you to enter today's");
		System.out.println("year in 4-digits.");
		System.out.println("Then it asks you to enter today's month number.");
		System.out.println("In the next step you will be asked to enter");
		System.out.println("the 4-digit year of your birth.");
		System.out.println("Then you will be asked to enter the month number");
		System.out.println("of your birth.");
		System.out.println("The program will then calculate and display how old you");
		System.out.println("are in years and months.");
			
		while(currentYear < 2002 || currentMonth < 1 || currentMonth >12)
		{
			currentYear = getValue("Enter today's 4-digit year: ");
			
			if(currentYear < 2002)
				System.out.println("You did not enter current year.\n");
			else
			{
				currentMonth = getValue("Enter today's month number: ");
				
				if(currentMonth < 1 || currentMonth > 12)
					System.out.println("You did not enter a month "
						+ "between 1 and 12.\n");
			}
		}
		
		while(again == 'y')
		{
			year = getValue("Enter the 4-digit year of your birth: ");
			
			if(year > currentYear || year < 1)
			{
				System.out.println("You did not enter a valid year.\n");
				continue;
			}
			
			month = getValue("Enter the month number of your birth: ");
			
			if(month < 1 || month > 12)
			{
				System.out.println("You did not enter a valid month.\n");
				continue;
			}
			
			if(currentMonth > month)
			{
				age = currentYear - year;
				month = currentMonth - month;
			}
			
				else if(currentMonth == month)
				{
					age = currentYear - year;
					month = 0;
				}
					else if(currentMonth < month)
					{
						age = currentYear - year - 1;
						month = 12 - month + currentMonth;
					}
			
			if( (age < 0 || age > 120) || (age == 0 && month < 0) )
			{
				System.out.println("You did not enter valid dates.\n");
				continue;
			}
			
			System.out.println("You are " + age + " years and " + month + " months old.");
			
			again = getLetter("Do you want to enter more data? y/n ");
			
		}
	}
	
	public static int getValue(String message)
	{
		int value;
		System.out.print(message);
		System.out.flush();
		value = console.nextInt();
		return value;
	}
	
	public static char getLetter(String message)
	{
		char letter;
		String line;
		System.out.print(message);
		System.out.flush();
		line = console.next();
		letter = line.charAt(0);
		return letter;
	}
}