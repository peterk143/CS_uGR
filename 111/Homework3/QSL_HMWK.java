//****************************************************************
//Programmer:          Peter Kirkpatrick
//Date:                March 13, 2009
//Program Description: This program performs various tasks on 
//                     the ADT List.
//****************************************************************

import java.util.*;

public class QSL_HMWK
{
	static Scanner console = new Scanner(System.in);

	public static void main(String [] args)
	{
		int maxSize = 11;
		List someList = new List(maxSize);
		
		for(int a = 1; a < maxSize; a++)
			someList.elements[a] = a;
		
		print(someList);
		
		System.out.println();
		System.out.println();
		
		someList = swap(someList, 2, 9);
		
		print(someList);
			
		System.out.println();
		
		someList = replace(someList, 11, 2);
		
		print(someList);
		
		System.out.println();
		System.out.println();
		
		postfix();
	}
	
	public static List replace(List a, int newVal, int position)
	{
		a.insert(newVal, position);
		
		return a;
	}
	
	public static List swap(List a, int from, int to)
	{
		int temp, temp2;
		
		temp = a.getValue(from + 1);
		
		temp2 = a.getValue(to + 1);
		
		a.elements[from] = temp2;
		
		a.elements[to] = temp;
		
		return a;
	}
	
	public static void print(List a)
	{
		for(int i = 1; i < 11; i++)
			System.out.print(a.elements[i] + " ");
	}
	
	public static void postfix()
	{
		char ch = 0;
      int rand1 = 0;
      int rand2 = 0;
      int temp;
      int result = 0;
      String str;
    
      System.out.print("Enter the expression: ");
      str = console.nextLine();
    
    
      Stack aStack = new Stack(str.length());
    
      //enters the string into the stack and
      //converts the appropriate char to digits;
      //and then completes the appropriate 
      //operations 
      for(int i = 0; i < str.length(); i++)
      {
	 		ch = str.charAt(i);
      
      	if(Character.isDigit(ch))
      	{
				temp = Character.getNumericValue(ch);
      		aStack.push(temp);
      	}//end if
      
      	if((ch == '+' || ch == '-' || ch == '*' || ch == '/'))
      	{
      		rand2 = aStack.pop();
      		rand1 = aStack.pop();
          
        		if(ch == '+')
				{
		  			result = rand1 + rand2;			
          	}
         	else if(ch == '-')
				{
          		result = rand1 - rand2;
				}
           			else if(ch == '*')
						{
					 		result = rand1 * rand2;	
						}   
          					else if(ch == '/')
			 					{
			 						if(rand2 == 0)
										System.out.println("ERROR:  divide by zero");
			 	
									else
									{
            						result = rand1 / rand2;
										
									}
			 					}
							
			 	aStack.push(result);
			}//end if
    	}//end for
	 	if(aStack.count() == 1)
	 	{
    		result = aStack.pop();
    		System.out.print("The result is: " + result);
	 	}
		
		else
			System.out.println("ERROR:  not enough operands");
	}
}