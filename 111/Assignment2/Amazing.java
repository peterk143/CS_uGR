//****************************************************************
//Programmer:          Peter Kirkpatrick
//Date:                February 22, 2009
//Program Description: This is a test program for the Maze class.							  
//****************************************************************

import java.io.*;

public class Amazing
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Maze maze1 = new Maze(5, 5, 'A', 'B');
		
		maze1.fillMaze();
		
		maze1.printMaze();
		
		System.out.println();
		
		maze1.traverseMaze(0, 0);
		
		maze1.printMaze();
	}// end main
}// end Amazing