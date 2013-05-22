//simple recursive program

public class Recursion
{
	public static void main(String[] args)
	{
		int x = 5;
		int y = 3;
		
		recurse(x,y);
	}
	
	public static void recurse(int x, int y)
	{
		if(y > 0)
		{
			++x;
			--y;
			
			System.out.println(x + " " + y);
			recurse(x,y);
			System.out.println(x + " " + y);
		}
	}
}
