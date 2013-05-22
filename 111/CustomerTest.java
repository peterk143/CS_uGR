//*******************************************************************
//Programmer:          Peter Kirkpatrick
//Date:                April 3, 2009
//Program Description: This program test the Customer Class.
//*******************************************************************

//import statements
import java.util.*;
import java.io.*;

public class CustomerTest
{
  static Scanner console = new Scanner(System.in);
  
  public static void main(String[] args)throws FileNotFoundException
  {
    //reference variables
    Customer temp;
    String inData;
    
    //instantiation of a new queue
    QueueC aQueue = new QueueC(10);
    
    //inputs the file name
    System.out.print("Where is the file located: ");
    inData = console.next();
  
    //inputs the .txt file
    Scanner inFile = new Scanner(new FileReader(inData));
    
    //creates a new Customer for while there is 
    //still information in the .txt file
    while(inFile.hasNext())
    {      
      String id = inFile.next();
      String fn = inFile.next();
      String ln = inFile.next();
     
      Customer aDude = new Customer(id, fn, ln);
      
      aQueue.enqueue(aDude);
    }// end while
    
    //prints off each Customer while aQueue is not empty
    while(aQueue.count() != 0)
    {  
      temp = aQueue.dequeue();
    
      temp.Display();
    }// end while
  }// end main
}// end CustomerTest