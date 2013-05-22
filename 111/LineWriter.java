//draws stars a certain number of times
//using recursion

import java.util.*;
import java.io.*;

public class LineWriter
{
  public static void main(String[] args)
  {
    char chrctr = '*';
    int numTimes = 10;
    
    writeLine(chrctr, numTimes);
  }
  
  public static void writeLine(char a, int times)
  {
    if(times == 1)
    {
      System.out.println(a);
    }
      else
      {
        System.out.print(a);
        writeLine(a, (times - 1));
      }
   }
}
