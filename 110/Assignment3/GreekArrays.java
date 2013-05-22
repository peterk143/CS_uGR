//***********************************************************
//Programmer:			  Peter Kirkpatrick
//Date:					  November 14,	2008
//Program Description: This program	manipulates multiple 
//							  arrays and prints a 2D array.
//Question:				  Ch 9, Ex 9, Pg 621
//***********************************************************

import java.util.*;

public class GreekArrays
{
	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		//declarations and instintiations
		int[][] inStock = new int[10][4];
		int[] alpha = new int[20];
		int[] beta = new int[20];
		int[] gamma = {11, 13, 15, 17};
		int[] delta = {3, 5, 2, 6, 10, 9, 7, 11, 1, 8};
		
		//calling the methods
		alpha = inputArray();
		
		beta = doubleArray(alpha);
		
		copyGamma(beta, gamma);
		
		copyAlphaBeta(alpha, beta, inStock);
		
		printArray(alpha);
		System.out.println();
		printArray(beta);
		System.out.println();
		printArray(gamma);
		System.out.println();
		printArray(delta);
		
		setInStock(inStock, delta);
	}
	
	public static int[] inputArray()
	{
		//declarations and instintiations
		int a;
		int[] alpha = new int[20];
		
		//output information
		System.out.println("Please enter numbers to");
		System.out.println("	 be inputed into the array:");
		
		//obtains information from the user
		for(a = 0; a < 20; a++)
		{
			alpha[a] = console.nextInt();
		}
		
		return alpha;
	}
	
	public static int[] doubleArray(int[] alpha)
	{
		//declarations and instintiations
		int b;
		int[] beta = new int[20];
		
		//obtains information from the user
		for(b = 0; b < 20; b++)
		{
			beta[b] = alpha[b] * 2;
		}
		
		return beta;
	}
	
	public static void copyGamma(int[] beta, int[] gamma)
	{
		//declarations and instintiations
		int i = 10;
		int j = 4;
		int[] gamma2 = gamma;
		int[][] inStock = new int[i][j];
		
		//sets the first row of inStock to
		//the array int[] gamma
		for(i = 0; i < 10; i++)
		{
			for(j = 0; j < 4; j++)
			{
				inStock[i][j] = gamma[j];
			}
			
			break;
		}
		
		//takes and multiples the previous row 
		//of inStock by 3
		for(i = 1; i < 10; i++)
		{
			for(j = 0; j < 4; j++)
			{
				inStock[i][j] = inStock[i - 1][j] * 3;
			}
		}
	}
	
	public static void copyAlphaBeta(int[] alpha, int[] beta, int[][] inStock)
	{
		//declarations
		int i = 0;
		int j = 0;
		int r = 0;
		
		//sets the first 5 rows of inStock to
		//the array int[] alpha
		for(i = 0; i < 5; i++)
		{
			for(j = 0; j < 4; j++)
			{
				inStock[i][j] = alpha[r];
				r++;
			}
		}
		
		r = 0;
		
		//sets the last 5 rows of inStock to
		//the array int[] beta
		for(i = 5; i < 10; i++)
		{
			for(j = 0; j < 4; j++)
			{
				inStock[i][j] = beta[r];
				r++;
			}
		}
	}
	
	public static void printArray(int[] arrayB)
	{
		//declarations and instintiations
		int index;
		int[] arrayA = arrayB;
		
		//prints any one dimensional array
		if(arrayA.length <= 15)
		{
			for(index = 0; index < arrayA.length; index++)
			{
				System.out.print(arrayA[index] + "\t");
			}
		}
		
		//prints any one dimensional array
		//15 elements per line
		else
		{
			for(index = 0; index < 15; index++)
			{
				System.out.print(arrayA[index] + "\t");
			}
	
			System.out.println();
			
			for(index = 15; index < 20; index++)
			{
				System.out.print(arrayA[index] + "\t");
			}
		}
		
		System.out.println();
	}
	
	public static void setInStock(int[][] inStock, int[] delta)
	{	
		//declarations
		int row = 0;
		int col = 0;
		int r = 0;
		
		//output information
		System.out.println("Please enter numbers to");
		System.out.println("	 be inputed into the array:");

		//obtains information from the user
		//and sets the first row of inStock
		//to this information
		for(row = 0; row < 10; row++)
		{
			inStock[row][col] = console.nextInt();
		}
					
		//sets inStock to the previous 
		//column multiplied by 2 subtracted
		//from the corresponding element in int[] delta
		for(row = 0; row < 10; row++)
		{
			for(col = 1; col < 4; col++)
			{
				inStock[row][col] = (inStock[row][col - 1] * 2) - delta[r];
			}
			
			r++;
		}		
	}
}


/*outputs
Please enter numbers to
	 be inputed into the array:
    1
    2
    3
    4
    5
    6
    7
    8
    9
    10
    11
    12
    13
    14
    15
    16
    17
    18
    19
    20
    1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	
    16	17	18	19	20	
    
    2	4	6	8	10	12	14	16	18	20	22	24	26	28	30	
    32	34	36	38	40	
    
    11	13	15	17	
    
    3	5	2	6	10	9	7	11	1	8	
    Please enter numbers to
    	 be inputed into the array:
    1
    2
    3
    4
    5
    6
    7
    8
    9
    10
*/