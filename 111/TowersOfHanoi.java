//Towers of Hanoi

public class TowersOfHanoi
{
	public static void main(String[] args)
	{
		move(3, 'A','B','C');
	}
	
	public static void move(int n, char from, char to, char aux)
	{
		if(n == 1)
		{
			System.out.println("Move disk " + n + " from tower " + from +
										" to tower " + to);
		}
			else
			{
				move(n - 1, from, aux, to);
				
				System.out.println("Move disk " + n + " from tower " + from +
											" to tower " + to);
				
				move(n - 1, aux, to, from);
			}
	}
}			