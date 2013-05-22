//******************************************************************
//Programmer:          Peter Kirkpatrick
//Date:                September 30, 2008
//Program Description: Chapter 4 Exercise 8 Page 233                
//******************************************************************

import java.util.*;

public class Ch4Ex8
{
	static Scanner console = new Scanner(System.in);
	
	public static void main(String[ ] args)
	{
		int x, y;
		
		System.out.print("X-coordinate: ");
		x = console.nextInt();
		
		System.out.print("Y-coordinate: ");
		y = console.nextInt();
		
		if(x==0&&y==0)
		{
			System.out.print("(" + x + ", " + y + ")");
			System.out.print(" is the origin");
		}
		else if(x==0&&y!=0)
		{
			System.out.print("(" + x + ", " + y + ")");
			System.out.print(" is on the y-axis");
		}
		else if(x!=0&&y==0)
		{
			System.out.print("(" + x + ", " + y + ")");
			System.out.print(" is on the x-axis");
		}
		else if(x>0&&y>0)
		{
			System.out.print("(" + x + ", " + y + ")");
			System.out.print(" is in the first quadrant");
		}
		else if(x<0&&y>0)
		{
			System.out.print("(" + x + ", " + y + ")");
			System.out.print(" is in the second quadrant");
		}
		else if(x<0&&y<0)
		{
			System.out.print("(" + x + ", " + y + ")");
			System.out.print(" is in the third quadrant");
		}
		else if(x>0&&y<0)
		{
			System.out.println("(" + x + ", " + y + ")");
			System.out.print(" is in the fourth quadrant");
		}
	}
}
		