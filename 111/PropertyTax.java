//***********************************************************
//Programmer:          Peter Kirkpatrick
//Date:                January 15, 2009
//Program Description: This program calculates property tax.
//Question:				  2
//***********************************************************

//import statement
import java.util.*;

public class PropertyTax
{
  //new scanner
  static Scanner console = new Scanner(System.in);
  
  //constants
  static final double RATE = 1.05;
  static final double TAX = .92;
  
  //main method
  public static void main(String[] args)
  {
    //reference variables
    double asVal, taxAmt, temp;
    double proTax = 0;
    
    //retrieving input from the user
    System.out.print("Please enter the assessed value: $ ");
    asVal = console.nextDouble();
    
    //determines taxable amounts
    taxAmt = asVal * TAX;
    temp = taxAmt;
    
    //adds up property taxes
    while(temp >= 100)
    {
      temp = temp - 100;
      proTax = proTax + RATE;
    }
    
    //outputs
    System.out.printf("Assessed Value:   $ %.2f\n" , asVal);
    System.out.printf("Taxable Amount:   $ %.2f\n" , taxAmt);
    System.out.println("Tax Rate for      $ " + RATE);
    System.out.println(" each $100.00");
    System.out.printf("Property Tax:     $ %.2f" , proTax);
  }//end of main
}//end of program
