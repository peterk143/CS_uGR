//***********************************************************
//Programmer:          Peter Kirkpatrick
//Date:                February 12, 2009
//Program Description: This program calculates the GCD of
//                     two numbers using recursion.
//***********************************************************

import java.util.*;
import java.io.*;

public class CommonDivisor
{
  public static void main(String[] args)
  {
    int large = 120;
    int small = 60;
    
    cDivisor(large, small);
  }
  
  public static void cDivisor(int large, int small)
  {
    int remainder = large % small;
    
    if(remainder == 0)
    {
      System.out.println("GCD = " + small);
    }
      else
      {
        cDivisor(small, remainder);
      }
  }
}