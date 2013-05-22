//******************************************************************
//Programmer:          Peter Kirkpatrick
//Date:                September 22, 2008
//Program Description: Chapter 2 Exercise 4 Page 114                 
//******************************************************************


import java.util.*;

public class Ch2Ex4
{
	static final int SECRET = 11;
	static final double RATE = 12.50;
	
	static Scanner console = new Scanner(System.in);
	
	public static void main(String[ ] args)
	{		
		int num1, num2, newNum;
		double hoursWorked, wages;
		String name;
		
		System.out.print("Enter First Number: ");
		num1 = console.nextInt();
		
		System.out.print("Enter Second Number: ");
		num2 = console.nextInt();
		
		System.out.println();
		System.out.println("The value of num1 = " + num1
							  + " and the value of num2 = " + num2 + ".");
		
		System.out.println();
		newNum = num1 * 2 + num2;
		System.out.println("newNum = " + newNum);
		
		newNum = newNum + SECRET;
		System.out.println("newNum updated = " + newNum);
		
		System.out.println();
		System.out.print("Enter Last Name: ");
		name = console.next();
		
		System.out.println("Decimal Number of Hours");
		System.out.print(" Worked between 0 and 70: ");
		hoursWorked = console.nextDouble();
		
		wages = RATE * hoursWorked;
		
		System.out.println("Name: " + name);
		System.out.printf("Pay Rate: $%.2f %n" , RATE);
		System.out.printf("Hours Worked: %.2f %n" , hoursWorked);
		System.out.printf("Salary: $%.2f %n" , wages);
	}
}