//adding subsequent numbers using recursion

public class AddRecursion
{
	public static void main(String[] args)
	{
		int n = 9;
		
		System.out.print(add(n));
	}
	
	public static int add(int n)
	{
		if(n == 0)
			return n;
			
		if(n == 1)
			return n;
		
			else
				return n + add(n - 1);
	}
}