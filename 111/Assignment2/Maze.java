//****************************************************************
//Programmer:          Peter Kirkpatrick
//Date:                February 22, 2009
//Program Description: This program will create a "Maze" abstract
//                     data type.  It will also read, print, and 
//							  traverse said maze.
//****************************************************************

//import statements
import java.util.*;
import java.io.*;

public class Maze
{
	//global variables
	private int maxRows;
	private int maxCols;
	private char wall;
	private char path;
	private char[][] myMaze;
	
	//class data member
	static Scanner console = new Scanner(System.in);
	
	/************************************************************
	Maze constructor - automatically executes when an object
								of the class is created; guarentees
								that the instance variables of the class
								are initialized and sometimes allocates
								memory space for them
	Input Parameters - the maximum number of rows and columns,
								the characters for the walls and pathways,
								and instantiates 2D maze of characters
	Output			  - none
	*************************************************************/
	public Maze(int r, int c, char w, char p)
	{
		//global variables
		maxRows = r;
		maxCols = c;
		wall = w;
		path = p;
		
		//sets the 2D array to a certain number
		//of rows and columns
	 	myMaze = new char[maxRows][maxCols];
		
	}// end Maze constructor
	
	/************************************************************
	fillMaze()		  - reads a preset maze from a file and puts it
							 	into the 2D character array instantiated
							 	by the Maze constructor
	Input Parameters - none, reads characters from a text file(.txt)
	Output			  - none, creates a 2D character array
	************************************************************/
	public void fillMaze() throws FileNotFoundException
	{	
		//instance variables
		String inData;
		String temp;
		char temp2;
		
		//inputs the infile name
		System.out.print("Where is the Maze data located: ");
		inData = console.next();
		
		//inputs the .txt file 
		Scanner inFile = new Scanner(new FileReader(inData));
	
		//places each individual character into its
		//correct position in the 2D array
		for(int i = 0; i < maxRows; i++)
		{	
			for(int j = 0; j < maxCols; j++)
			{
				//takes each character from the inFile
				//and places it into 2D array
				temp = inFile.next();
				temp2 = temp.charAt(0);
				myMaze[i][j] = temp2;
			}
		}
		
		//closes the inFile
		inFile.close();
	}// end fillMaze
	
	/************************************************************
	printMaze()		  - prints off the 2D array of characters in a
							 	matrix format							 	
	Input Parameters - none, uses the maze
	Output			  - none, prints of the maze
	************************************************************/
	public void printMaze()
	{
		for(int i = 0; i < maxRows; i++)
		{
			for(int j = 0; j < maxCols; j++)
			{
				System.out.print(myMaze[i][j] + " ");
			}
			
			System.out.println();
		}
		
	}// end printMaze
	
	/************************************************************
	traverseMaze()	  - checks the array element by element 
								determining if said element is part of 
							 	a path, a wall, a path already traveled
							 	or within the array; during the first 
								pass of the method, it changes the 
								relevant paths to 3s until it reaches 
								the end of the maze; during the second
								pass, on the way back it changes the 3s
								in the actual path to 7s
	Input Parameters - rows and columns are inputed to indicate
								the element in the array that the method
								is checking
	Output			  - boolean variable; true or false; indicating
								if the element was part of a desirable
								path, a wall, a path already traveled, 
								or within the array itself
	************************************************************/
	public boolean traverseMaze(int rows, int cols)
	{
		//instance variables
		char beenThere = '3';
		char solution = '7';
		boolean done = false;
		
		//determines if the reference is inside of the array
		if((rows < 0 || rows >= maxRows) || (cols < 0 || cols >= maxCols))
			return done = false;
		
		//determine if the reference is a wall or
		//if it has already been visited
		if(myMaze[rows][cols] == beenThere || myMaze[rows][cols] == wall)
			return done = false;
			
			//if the element is in bounds and isn't a wall
			//this sets the cell to a 3
			else
				myMaze[rows][cols] = beenThere;
		
		//determines if the end of the maze has been reached
		if(rows == maxRows - 1 && cols == maxCols - 1)
		{
			//sets the cell to a 7 and then returns true
			myMaze[rows][cols] = solution;
			return done = true;
		}
			else
				done = false;
		
		//recursive calls to the traverseMaze method
		//		with different parameters
		//moves up one element
		if(!done)
			done = traverseMaze(rows - 1, cols);
		
		//moves down one element
		if(!done)
			done = traverseMaze(rows + 1, cols);
		
		//moves left one element
		if(!done)
			done = traverseMaze(rows, cols - 1);
		
		//moves right one element
		if(!done)
			done = traverseMaze(rows, cols + 1);
			
		//after traverseMaze reaches the end of the maze
		//this sets all the activations of traverseMaze 
		//that were returned as true to the number 7
		if(done)
		{
			myMaze[rows][cols] = solution;
			return done = true;
		}
				
		return done;
	}// end traverseMaze
}// end Maze
