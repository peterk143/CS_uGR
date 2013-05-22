import java.util.*;
import java.io.*;

public class ReverseString
{
  public static void main(String[] args)
  {
    String word;
    int length;
    Scanner takein = new Scanner(System.in);
    
    System.out.println();
  }
  
  public static void rString(String forward, int n)
  {
    if(n == 1)
    {
      System.out.print(forward.charAt(0));
    }
      else
      {
        System.out.print(forward.charAt(n-1));
        rString(forward, (n-1));
      }
    }
}