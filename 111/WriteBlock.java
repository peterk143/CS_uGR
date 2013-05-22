//***********************************************************
//Programmer:          Peter Kirkpatrick
//Date:                February 12, 2009
//Program Description: This program uses the LineWriter class
//                     to make blocks of these lines.
//***********************************************************

import java.util.*;
import java.io.*;

public class WriteBlock
{
  public static void main(String[] args)
  {
    char a = '*';
    int col = 5;
    int row = 3;
    
    wBlock(a, col, row);
  }
  
  public static void wBlock(char a, int col, int row)
  {
    if(row == 1)
    {
      LineWriter.writeLine(a, col);
    }
      else
      {
        LineWriter.writeLine(a, col);
        wBlock(a, col, (row - 1));
      }
  }
}