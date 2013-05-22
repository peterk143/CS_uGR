//***********************************************************
//Programmer:          Peter Kirkpatrick
//Date:                February 19, 2009
//Program Description: This program bubble sorting to sort
//                     an unsorted array of integers, and a 
//                     binary search which looks for a 
//                     certain number.
//***********************************************************

import java.util.*;
import java.io.*;

public class SortNSearch
{
  public static void main(String[] args) throws FileNotFoundException
  {    
    int low = 0;
    int val = 33;
    int valIndex;
    int num = 100;
    int high = num - 1;
    int[] array = new int[num];
    int[] sortedArray = new int[num];
    
    sortedArray = BubbleSort(array, num);
    
    valIndex = BinarySearch(sortedArray, low, high, val);
    
    System.out.println("The value's index is " + valIndex + ".");
  }// end of main
  
    public static int[] BubbleSort(int[] array, int num) throws FileNotFoundException
    {
      Scanner infile = new Scanner(new FileReader("BubbleSortArrayInput.txt"));
      
      int i, j, temp;
      
      //imports the numbers from the .txt
      //file into the array
      for(i = 0; i < num; i++)
        array[i] = infile.nextInt();
      
      //physically sorts the the array
      for(i = 0; i < num; i++){
        for(j = 0; j < num - 1; j++){
          if(array[j] > array[j + 1]){
            temp = array[j];
            array[j] = array[j + 1];
            array[j + 1] = temp;
          }// end if
        }// end for
      }// end for
      
      return array;
  }// end of BubbleSort
    
    public static int BinarySearch(int[] sortedArray, int low, int high, int val)
    {
      int index = 0;
      
      int mid = (low + high) / 2;
       
      if(sortedArray[mid] == val)
        index = mid;     
      
      else if(low == high)
        index = -1;      
     
      else if(val > sortedArray[mid])
        index = BinarySearch(sortedArray, mid + 1, high, val);
      
      else if(val < sortedArray[mid])
        index = BinarySearch(sortedArray, low, mid - 1, val);
      
      return index;
    }// end of BinarySearch
}// end of main