//***********************************************************
//Programmer:          Peter Kirkpatrick
//Date:                February 13, 2009
//Program Description: This program makes a class to be used
//                     in conjunction with a CS Grade Book.
//***********************************************************

public class CSStudent
{
	private String firstName = "unknown";
	private String lastName = "unknown";
	private double test1 = 0;
 	private double test2 = 0;
 	private double test3 = 0;
 	private double hmwk1 = 0;
 	private double hmwk2 = 0;
 	private double hmwk3 = 0;
 	private double semFinal = 0;
 	private double semAvg = 0;
 	private char letGrade = '-';
   
 	//constructor
 	public CSStudent(String first, String last,
      					double t1, double t2, double t3,
      					double h1, double h2, double h3,
      					double fin)
 	{
  		firstName = first;
  		lastName = last;
  		test1 = t1;
  		test2 = t2;
  		test3 = t3;
  		hmwk1 = h1;
  		hmwk2 = h2;
  		hmwk3 = h3;
  		semFinal = fin;
  		semAvg = 0;
  		letGrade = '-';
 	}// end of constructor
 
 	//computes the semester average 
	//and the letter grade
 	public void compute()
 	{
		//semester average
 		semAvg = (test1 * .20) + (test2 * .20) + (test3 * .20) + 
   				  (((hmwk1 + hmwk2 + hmwk3) / 3) * .15) + (semFinal * .25);
  
  		//letter grade
  		if(semAvg >= 90)
  		{
   		letGrade = 'A';
  		}
			else if(semAvg >= 80)
  			{
   	 		letGrade = 'B';
   		}
    			else if(semAvg >= 70)
    			{
     				letGrade = 'C';
    			}
     				else if(semAvg >= 60)
     				{
      				letGrade = 'D';
     				}
   	   			else if(semAvg < 60)
    		  			{
      	 				letGrade = 'F';
      				}
 	}// end of compute
 
 	//prints off all the information involving
	//the student including names and grades
 	public void print()
 	{
		//formats the output into columns and rows
  		System.out.printf("%-12s %-12s  %-6.1f %-6.1f %-6.1f %-6.1f %-6.1f %-6.1f %-6.1f %-8.1f %-1c%n", 
		 						firstName, lastName, test1, test2, test3, hmwk1, hmwk2, hmwk3, semFinal, semAvg, letGrade);
 	}// end of print
}// end of class