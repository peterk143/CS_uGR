//******************************************************************
//Programmer:          Peter Kirkpatrick
//Date:                September 25, 2008
//Program Description: Chapter 2 Exercise 13 Page 116                 
//******************************************************************

import java.util.*;

public class Ch2Ex13
{
	static Scanner console = new Scanner(System.in);
	
	public static void main(String[ ] args)
	{
		double originalPrice, markedPrice, taxRate;
		double sellingPrice, salesTax, fPrice;
		
		System.out.print("Enter Original Price: $");
		originalPrice = console.nextDouble();
		
		System.out.print("Enter Marked-Up Price Percentage: ");
		markedPrice = console.nextDouble();
		
		System.out.print("Enter Sales Tax Rate: ");
		taxRate = console.nextDouble();
		
		sellingPrice = originalPrice * (markedPrice/100) + originalPrice;
		salesTax = sellingPrice * (taxRate/100);
		fPrice = sellingPrice + salesTax;
		
		System.out.println();
		System.out.printf("Original Price:               %.2f %n" , originalPrice);
		System.out.printf("Marked-Up Price Percentage:   %.2f %n" , markedPrice);
		System.out.printf("Store's Selling Price:        %.2f %n" , sellingPrice);
		System.out.printf("Sales Tax Rate:               %.2f %n" , taxRate);
		System.out.println("Sales Tax:                    " + salesTax);
		System.out.printf("Final Price:                  %.2f %n" , fPrice);
	}
}
		
