//*******************************************************************************
//Programmer:          Peter Kirkpatrick
//Date:                November 21, 2008
//Program Description: This program uses analyzes the element-by-element product
//							  for two matrices A and B.  The result is placed in matrix
//							  C.  This program is based on a user-defined method called
//							  matrixElementCompute()
//*******************************************************************************

import java.util.*;

public class SqRtProgram
{
	public static final int N = 5;
	
	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		int i, j;
		double[][] arrayA = new double[N][N];
		double[][] arrayB = new double[N][N];
		double[][] arrayC = new double[N][N];
		
		//not part of the answer
		for(i = 0; i < N; i++)
		{
			for(j = 0; j < N; j++)
			{
				arrayA[i][j] = console.nextDouble();
				arrayB[i][j] = console.nextDouble();
			}
		}
		
		arrayC = matrixElementCompute(arrayA, arrayB, N);
		
		print2DMatrix(arrayC);
	}
	
	public static double[][] matrixElementCompute(double[][] arrayA, double[][] arrayB, int N)
	{
		int i, j;
		double[][] arrayC = new double[N][N];
		
		for(i = 0; i < N; i++)
		{
			for(j = 0; j < N; j++)
			{
				arrayC[i][j] = Math.sqrt(arrayA[i][j] * arrayB[i][j]);
			}
		}
		
		return arrayC;
	}
	
	public static void print2DMatrix(double[][] arrayC)
	{
		int i, j;
		
		for(i = 0; i < N; i++)
		{
			for(j = 0; j < N; j++)
			{
				System.out.print("\t" + arrayC[i][j]);
			}
			
			System.out.println();
		}
	}
}