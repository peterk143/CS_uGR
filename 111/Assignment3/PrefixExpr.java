//*******************************************************************
//Programmer:          Peter Kirkpatrick
//Date:                March 29, 2009
//Program Description: This program will evaluate prefix expressions
//                     utilizing a Queue.
//*******************************************************************

//import statements
import java.util.*;
import java.io.*;

public class PrefixExpr
{
	//class data memeber
	static Scanner console = new Scanner(System.in);

	public static void main(String[] args)throws FileNotFoundException
	{
		//instance variables
		String inData;
		String temp = "";
		String tempStr = "";
		int num;
		int ans = 0;
		
		//inputs the file name
		System.out.print("Where is the file located: ");
		inData = console.next();
		
		//inputs the .txt file
		Scanner inFile = new Scanner(new FileReader(inData));
		
		//reads the inFile into an instance variable string
		while(inFile.hasNext())
			tempStr = tempStr + inFile.next();
		
		num = tempStr.length();
		
		//instantiates a new Queue
		Queue aQueue = new Queue(num);
				
		//places the values in the string into the Queue
		for(int j = 0; j < tempStr.length(); j++)
		{
			temp = tempStr.charAt(j) + "";
			aQueue.enqueue(temp);	
		}// end for
		
		//method call
		ans = calcPre(aQueue);
		
		//if the answer comes back to be -999 than 
		//it was an invalid expression to begin with;
		//if not then this will display the answer
		if(ans != -999)
			System.out.println(tempStr + " = " + ans);
	}// end main
	
	/************************************************************
	calcPre()		  - uses prefix notation to calculate the 
								result of certain operations
	Input Parameters - the name of the Queue
	Output			  - integer, the result of the operations
	*************************************************************/
	public static int calcPre(Queue q)
	{
		//instance variables
		String a, b, c, r, ch;
		char aa, bb, cc;
		boolean done = false;
		boolean invalid = false;
		int result = 0;
		int s = 0;
		int B = 0;
		int C = 0;
		
		//checks the first value in the Queue
		ch = q.peek();
		
		//if the Queue count() is less then 3 then
		//it is invalid and will return -999
		if(q.count() < 3)
		{
			System.out.println("ERROR:  invalid expression");
			done = true;
			invalid = true;
		}// end if
			
		//if the first character in the Queue is not an
		//operator it is invalid and will return -999
		else if(!isOperator(ch))
		{
			System.out.println("ERROR:  invalid expression");
			done = true;
			invalid = true;
		}// end else if
		
				//if it is a valid expression then these 
				//actions will be performed
				else
				{
					a = q.dequeue();
					b = q.dequeue();
					c = q.dequeue();
					
					//changes the strings dequeued to characters
					aa = a.charAt(0);
					bb = b.charAt(0);
					cc = c.charAt(0);
		
					while(!done)
					{
						//if the first character is not an operator and
						//the next two are not digits then it will 
						//enqueue the first character; change b to a and
						//c to b and then dequeue another value for c
						if((!isOperator(a)) || (!Character.isDigit(bb) || !Character.isDigit(cc)))
						{
							q.enqueue(a);
						
							a = b;
							b = c;
							c = q.dequeue();
							
							aa = a.charAt(0);
							bb = b.charAt(0);
							cc = c.charAt(0);
						}// end if
							
						else
						{
							//changes the String a to char aa
							aa = a.charAt(0);
							//parses b and c to integers
							B = Integer.parseInt(b);
							C = Integer.parseInt(c);
							
							//if aa is one of these 4 operators 
							//then this will perform the necessary
							//operations and then enqueue the result							
							if(aa == '+')
							{
								result = B + C;
								r = Integer.toString(result);
								q.enqueue(r);
							}// end if
							
							else if(aa == '-')
							{
								result = B - C;
								r = Integer.toString(result);
								q.enqueue(r);
							}// end else if
								
									else if(aa == '*')
									{
										result = B * C;
										r = Integer.toString(result);
										q.enqueue(r);
									}// end else if
										
											else if(aa == '/')
											{
												result = B / C;
												r = Integer.toString(result);
												q.enqueue(r);
											}// end else if
							
							//if the Queue count() is equal to 1
							//then the calculations are completed;
							//it will then dequeue the value, parse 
							//it to an integer and then return that value 
							if(q.count() == 1)
							{
								done = true;
								String str = q.dequeue();
								s = Integer.parseInt(str);
							}// end if
							
							//otherwise it will dequeue 3 more values
							//and start the process all over again
							else
							{
								a = q.dequeue();
								b = q.dequeue();
								c = q.dequeue();
								
								aa = a.charAt(0);
								bb = b.charAt(0);
								cc = c.charAt(0);
							}// end else
						}// end else
					}// end while
				}// end else
				
	//if the expression was valid then it will
	//return the last number in the Queue
	if(invalid == false)
		return s;
	
	//otherwise it will return -999
	else
		return -999;
	}// end calcPre
	
	/***************************************************************
	isOperator()	  - determines if the string does in fact contain
								an operator
	Input Parameters - the string containing what may be an operator
	Output			  - boolean variable
	****************************************************************/
	public static boolean isOperator(String t)
	{
		boolean op = false;
	
		if(t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/"))
			op = true;
			
		return op;
	}// end isOperator
}// end PrefixExpr