public class Test
{
	public static void main(String[] args)
	{
		int[][] numbers = new int[4][4];
		int k, j, count;
		
		count = 0;
		for(k = 0; k < 4; k++)
			for(j = 0; j < 4; j++)
			{
				numbers[k][j] = 1;
				count++;
			}
		
		for(k = 0; k < 4; k++)
		{
			for(j = 0; j < 4; j++)
			{
				if(j != k)
					numbers[k][j] = (k + j) * (k + j);
				System.out.print(" " + numbers[k][j]+ " ");
			}
			
			//System.out.println();
		}
	}
}