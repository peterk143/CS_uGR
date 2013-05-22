//******************************************************************
//Programmer:          Peter Kirkpatrick
//Date:                October 15, 2008
//Program Description: This program asks the user to enter the number
//                     and names of students in a course.
//******************************************************************

import java.util.*;
import java.io.*;

public class CounterWhile
{
 static Scanner console = new Scanner(System.in);
  
 public static void main(String[ ] args) throws IOException
 {
   String name;
   int students, counter;
   
   {
     try
     {
       PrintWriter outFile = new PrintWriter("prog.out");
       
       System.out.println("This program asks the user to enter the");
       System.out.println("number and names of students in a course.");
       
       System.out.print("How many students are registered for this class?  ");
       students = console.nextInt();
       String trash = console.nextLine();
       counter = 10 - students;
       
       while(counter<10)
       {
         System.out.print("Enter the student's name:  ");
         name = console.nextLine();
         outFile.println(name);
         counter++;
       }
       if(students==10)
         System.out.println("This class is full.");
       
       System.out.println();
       System.out.println("Program Completed.");
       
       outFile.close();
     }
     catch(IOException exception)
     {  
       System.out.println("Error Opening Files" + exception);
     }
   }
 }
}
   
   