//***********************************************************
//Programmer:          Peter Kirkpatrick
//Date:                March 12, 2009
//Program Description: This program uses postfix notation
//                     to complete operations on numbers.
//***********************************************************

import java.util.*;

public class PostfixExpr
{
	static Scanner console = new Scanner(System.in);
  
	public static void main(String [] args)
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
		  			result = rand1 + rand2;
          
         	else if(ch == '-')
          		result = rand1 - rand2;
          
          			else if(ch == '*')
					 		result = rand1 * rand2;
          
          					else if(ch == '/')
			 					{
			 						if(rand2 == 0)
										System.out.println("ERROR:  divide by zero");
			 	
									else
            						result = rand1 / rand2;
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
	}//end of main
}//end PostfixExpr