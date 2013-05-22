//****************************************************************
//Programmer:          Peter Kirkpatrick
//Date:                March 5, 2009
//Program Description: This program checks to see if a string 
//                     contains a balanced amount of square
//                     brackets.
//****************************************************************

import java.util.*;

public class StackBrackets
{
  static Scanner console = new Scanner(System.in);
  
  public static void main(String [] args)
  {
    String someString;
    Stack aStack;
    
    System.out.print("Input the String: ");
    someString = console.next();
    
    aStack = new Stack(someString.length()); 
    
    for(int i = 1; i <= someString.length(); i++)
    {
      if(someString.charAt(i-1) == '[')
        aStack.push(1);
    }
    
    for(int a = 1; a <= someString.length(); a++)
    {
      if(someString.charAt(a-1) == ']')
        aStack.pop();
    }
    
    if(aStack.isEmpty())
      System.out.println("The string is balanced.");
      
      else
        System.out.println("The string is NOT balanced.");
      
  }
}