//*********************************************************************************
//Programmer:          Peter Kirkpatrick
//Date:                October 22, 2008
//Program Description: This program calculates a paycheck for each employee.  A text
//                     file containing the employee's information will be created.
//*********************************************************************************

import java.util.*;
import java.io.*;

public class Payroll1
{
  public void intructions()
  {
    System.out.println("Instructions for Payroll Report Program");
    System.out.print("This program calculates a paycheck for each employee.  "
                       + "A text file containing the following information will "
                       + "be created:  name, pay rate, hours worked, and tax "
                       + "percentage to be deducted.");
    System.out.println();
    System.out.print("The program will create a report in columnar format showing "
                       + "the employee name, hourly rate, number of hours worked, "
                       + "tax rate, gross pay, and net pay.");
    System.out.println();
    System.out.print("After all employees are processed, totals will be displayed "
                       + "including total gross amount and total net pay.");
  }
  
  public void reportTitle()
  {
                   //1234567890123456789012345678901234567890123456789012345678901234567890123456789
    outFile.println("Employee               Hourly    Hours      Tax      Gross      Net");
    outFile.println("  Name                  Rate     Worked     Rate     Amount    Amount");
    outFile.println("--------------------  --------  --------  --------  --------  --------");
  }
  
  public void printEmployeeInfo(String employeeName,double hourlyRate,double hoursWorked,double taxRate,double grossAmount,double netAmount)
  {
    String overTime = "OT";
    
    employeeName = employeeName;
    hourlyRate = hourlyRate;
    hoursWorked = hoursWorked;
    taxRate = taxRate;
    grossAmount = grossAmount;
    netAmount = netAmount;    
    
    
    outFile.printf("%-20d  %8.2f  %8.2f  %8.2f  %8.2f  %8.2f", employeeName, hourlyRate, hoursWorked, taxRate, grossAmount, netAmount);
  
    if(hoursWorked > FULL_TIME)
      outFile.printf("%8f", overTime);
  
  }
}
  
  
  
  
  public static void main(String[ ] args)
  {
  	double hourlyRate, hoursWorked, taxRate, grossAmount, netAmount;
	String employeeName, overTime;
	{
		try
		{
			static Scanner console = new Scanner(System.in);
     
			static final double FULL_TIME = 40.0;

			PrintWriter outFile = new PrintWriter("payroll.dat");
		  
			hoursWorked = 0;
        
      	if(hoursWorked > FULL_TIME)
  				System.out.print("OT");
				
		}
		
      catch(IOException exception
		{
			System.out.println("Error Opening Files" + exception);
		}
	}
}  