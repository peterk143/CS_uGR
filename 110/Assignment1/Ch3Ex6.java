//******************************************************************
//Programmer:          Peter Kirkpatrick
//Date:                September 25, 2008
//Program Description: Chapter 3 Exercise 6 Page 175                
//******************************************************************

import java.util.*;
import java.io.*;

public class Ch3Ex6
{
	static Scanner console = new Scanner(System.in);
	
	public static void main(String[ ] args) throws IOException
	{
		double grossAmt,fedTax, stateTax, socialTax, mediTax;
		double pension, netPay, health, temp;
		String name;
		{
			try
			{		
				PrintWriter outFile = new PrintWriter("prog.out");
		
				System.out.print("Enter Employee Name: ");
				name = console.nextLine();
		
				System.out.print("Enter Gross Amount: ");
				grossAmt = console.nextDouble();
		
				fedTax = grossAmt * 0.15;
				stateTax = grossAmt * 0.035;
				socialTax = grossAmt * 0.0575;
				mediTax = grossAmt * 0.0275;
				pension = grossAmt * 0.05;
				health = 75.00;
				temp = grossAmt - fedTax - stateTax - socialTax;
				netPay = temp - mediTax - pension - health;
		
				outFile.println(name);
				outFile.printf("Gross Amount:          $   %.2f %n", grossAmt);
				outFile.printf("Federal Tax:           $   %.2f %n", fedTax);
				outFile.printf("State Tax:             $   %.2f %n", stateTax);
				outFile.printf("Social Security Tax:   $   %.2f %n", socialTax);
				outFile.printf("Medicare/Medicaid Tax: $   %.2f %n", mediTax);
				outFile.printf("Pension Plan:          $   %.2f %n", pension);
				outFile.printf("Health Insurance:      $   %.2f %n", health);
				outFile.printf("Net Pay:               $   %.2f %n", netPay);
		
				outFile.close();
		
			} 
		
		catch(IOException exception)
		{
			System.out.println("Error Opening Files" + exception);
		}
		}
	}
}
