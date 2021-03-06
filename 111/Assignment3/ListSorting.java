//****************************************************************
//Programmer:          Peter Kirkpatrick
//Date:                March 29, 2009
//Program Description: This program sort data in two lists using
//                     bubble and insertion sorts and then print
//                     them off.
//****************************************************************

//import statements
import java.util.*;
import java.io.*;

public class ListSorting
{
 //class data member
 static Scanner console = new Scanner(System.in);
  
 public static void main(String[] args)throws FileNotFoundException
 {
  //instance variables
  int num;
      String inData;
      
      System.out.print("Number of elements in list: ");
      num = console.nextInt();
      
  //instantiates two new lists
      List aList = new List(num);
      List bList = new List(num);
      
  //inputs the file name
      System.out.print("Where is the file located: ");
      inData = console.next();
      
  //inputs the .txt file
      Scanner inFile = new Scanner(new FileReader(inData));
      
  //inserts each character into both lists
      for(int a = 1; a <= num; a++)
      {
   //takes each character from the inFile
   //and places it into the list
       String temp = inFile.next();
         char temp2 = temp.charAt(0);
         int temp3 = Character.getNumericValue(temp2);
         
         aList.insert(temp3, a);
         bList.insert(temp3, a);
       }
   
   //method calls
   System.out.println();
   System.out.println("Unsorted Lists");
   System.out.println("--------------");
       printList(aList, num);
       printList(bList, num);
   
   System.out.println("Bubble Sorted");
   System.out.println("-------------");
   bubbleSort(aList, num);
   printList(aList, num);
   
   System.out.println("Insertion Sorted");
   System.out.println("----------------");
   insertionSort(bList, num, 0);
   printList(bList, num);
 }// end main
   
 /************************************************************
 printList()    - prints off a list 10 characters per line
 Input Parameters - the name of the list and the number of 
        characters in the list
 Output     - none, prints off the list
 *************************************************************/
   public static void printList(List a, int n) 
   {
    for(int i = 1; i <= n; i++)
  {
       System.out.print(a.getValue(i));
   //prints off a new line every 10 characters
   if(i % 10 == 0)
    System.out.println();
  }
   
  System.out.println();      
   }// end printList
  
 /************************************************************
 bubbleSort()   - sorts a list using a bubble sort algorithm
 Input Parameters - the name of the list and the number of 
        characters in the list
 Output     - none
 *************************************************************/
 public static void bubbleSort(List a, int n)
 {
  for(int i = 0; i < n; i++)
  {
   for(int j = 0; j < n -1; j++)
   {
    if(a.elements[j] > a.elements[j +1])
    {
     int temp = a.elements[j];
     a.elements[j] = a.elements[j +1];
     a.elements[j +1] = temp;
    }// end if
   }// end for
  }// end for
 }// end bubbleSort
 
 /************************************************************
 bubbleSort()   - sorts a list using an insertion sort
        algorithm
 Input Parameters - the name of the list and the number of 
        characters in the list
 Output     - none
 *************************************************************/
 public static void insertionSort(List a, int n, int low)
 {
  //instance variables
  int temp, i, unsortedVal;
  
  if(low < n)
  {
   temp = low;
   unsortedVal = a.elements[temp];
   
   while(temp > 0 && (a.elements[temp -1] > unsortedVal))
   {
    a.elements[temp] = a.elements[temp -1];
    
    temp = temp -1;
   }// end while
   
   a.elements[temp] = unsortedVal;
   insertionSort(a, n, low +1);
  }// end if
 }// end insertionSort
}// end ListSorting