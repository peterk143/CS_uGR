import java.io.*;

public class MazeTest
{
  public static void main (String[] args) throws FileNotFoundException
  {
    Maze StudentMaze = new Maze(5,5,'A','B'); //This will create your maze with the correct 
                                              //number of rows and columns and the Wall
                                              //character along with the Path character.
    
    StudentMaze.fillMaze();  //This should ask me to input a filename and then fill the
                             //maze created above.
    
    System.out.println("The filled array looks like the following:");
    StudentMaze.printMaze();  //This should print out your maze without it solved
    System.out.println("");
    
    StudentMaze.traverseMaze(0,0); //This will take in your starting coordinates and 
                                   //traverse the maze
    
    System.out.println("The path to take in this maze is as follows:");
    StudentMaze.printMaze();  //This print should now have a solved version of the maze
                              //That has all places visited with a 3, unless it is the
                              //correct path, in which case it should be a 7.
  }
}
