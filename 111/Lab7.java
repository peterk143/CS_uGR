import java.util.*;

  public class Lab7
  {
    public static void main(String [] args)
    {
      Random r = new Random();
      Lab7 lab = new Lab7();
      List someList = new List(20);
      
      for(int i = 1; i <= 20; i++)
      {
        someList.insert(r.nextInt(1000), i);
        System.out.print(someList.getValue(i) + " ");
      }
      
      System.out.println("");
      
      List revList = lab.reverse(someList);
      
      for(int a = 1; a <= revList.size(); a++)
        System.out.print(revList.getValue(a) + " ");
      
      //System.out.println();
      
      //String test = "[abc[[ end ]]]";
    }
    
    public List reverse (List l)
    {
      Stack s = new Stack(100);
      
      for(int i = 1; i <= l.size(); i++)
      {
        s.push(l.getValue(i));
      }
      
      List reverseList = new List (l.size());
      
      for(int a = 1; a <= l.size(); a++)
      {
        reverseList.insert(s.pop(), a);
      }
      
      return reverseList;
    }
  }
        