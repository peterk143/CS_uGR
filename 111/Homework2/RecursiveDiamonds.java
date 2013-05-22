//***********************************************************
//Programmer:          Peter Kirkpatrick
//Date:                February 16, 2009
//Program Description: This program draws a diamond using 
//                     recursion, given the number of levels.
//***********************************************************

import java.util.*;

public class RecursiveDiamonds
{
	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		String a = "* ";
		int level;
		int spaces;
		
		System.out.print("Enter the number of levels: ");
		level = console.nextInt();
		
		spaces = level - 1;
		
		
		if(level > 1)
		{
			//recursive calling methods
			top(a, level - 1, spaces - 1);
			middle(a, level, spaces);
			bottom(a, level - 1, spaces - 1);
		}
			else
				System.out.println(a);
	}
	
	//prints the top of the diamond
	public static void top(String a, int level, int spaces)
	{	
		//determines the number of stars to be printed
		int stars = level - spaces;
		
		//prints the spaces to the left of the diamond
		for(int i = 0; i <= spaces; i++)
			System.out.print(" ");
		
		//prints the stars
		for(int j = 0; j < stars; j++)
			System.out.print(a);
	
		System.out.println();
		
		//recursive call 
		if(spaces > 0)
			top(a, level, spaces - 1);
	}// end of top
	
	//prints the middle row of the diamond
	public static void middle(String a, int level, int spaces)
	{
		for(int i = 0; i < level; i++)
			System.out.print(a);
		
		System.out.println();
	}// end of middle
	
	//prints the bottom of the diamond
	public static void bottom(String a, int level, int spaces)
	{	
		//determines the number of stars to be printed
		int stars = level - spaces;
		
		//recursive call
		if(spaces > 0)
			bottom(a, level, spaces - 1);
		
		//prints the spaces to the left of the diamond
		for(int i = 0; i <= spaces; i++)
			System.out.print(" ");
		
		//prints the stars
		for(int j = 0; j < stars; j++)
			System.out.print(a);
	
		System.out.println();
	}// end of bottom
}