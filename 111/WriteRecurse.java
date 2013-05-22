//prints the numbers 1,2 ...,n.

public class WriteRecurse
{
	public static void main(String[] args)
	{
		int i = 1;
		int n = 30;
		
		write(n, i);
	}
	
	public static void write(int n, int i)
	{
		if(i == n)
			System.out.print(n + ".");
			
			else
			{
				System.out.print(i + ",");
				write(n, i + 1);
			}
	}
}