//***********************************************************
//Programmer:          Peter Kirkpatrick
//Date:                February 13, 2009
//Program Description: This program implements a program to
//                     manage an instructor's grade book.
//***********************************************************

//import staetments
import java.util.*;
import java.io.*;

public class GradeBook
{ 
	//main 
	public static void main(String[] args) throws FileNotFoundException
 	{
		//instance variables
  		int num, i;
		
		//reference variables
  		Scanner console = new Scanner(System.in);
  		Scanner infile = new Scanner(new FileReader("ReadStudent.txt"));
		
		//determines how many students are in the class
  		System.out.print("Class Size: ");
  		num = console.nextInt();
		
		//instintiates the array book to the number 
		//of students in the class
  		CSStudent[] book = new CSStudent[num];
  

  		for(i = 0; i < num; i++)
  		{
			//reads the information from the .txt file
			//into the program
   		CSStudent stdnt = new CSStudent(infile.next(), infile.next(), infile.nextDouble(),
     		         								infile.nextDouble(), infile.nextDouble(), infile.nextDouble(),
       		       								infile.nextDouble(), infile.nextDouble(), infile.nextDouble());
   		
			//places each new student into a different
			//element of the book array
 			book[i] = stdnt;
			
			//calls the compute method which determines
			//the semester average and the letter grade
   		book[i].compute();
			
			//prints each student in the array, their 
			//grades, and their letter grade
   		book[i].print();
  		}// end for loop
 	}// end main
}// end program