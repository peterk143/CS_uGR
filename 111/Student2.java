//***********************************************************
//Programmer:          Peter Kirkpatrick
//Date:                April 9, 2009
//Program Description: This program implements the Comparable 
//                     class using interfaces and compares
//                     one students ID to another.
//***********************************************************

public class Student2 implements Comparable
{
  //global variables
  private int StudentID;
  private String firstName;
  private String lastName;
  
  //studetn constructor
  public Student2(int id, String fn, String ln)
  {
    StudentID = id;
    firstName = fn;
    lastName = ln;
  }// end Student constructor
  
  //returns the studentID
  public int getID()
  {
    return this.StudentID;
  }// end getID()
  
  public int compareTo(Object st)
  {
    Student2 in = (Student2) st;
    
    //if the ids are the equal 0 is returned
    //if this id is greater than 1 is returned
    //if this id is less than -1 is returned
    if(this.getID() == in.getID())
      return 0;
    else if(this.getID() > in.getID())
      return 1;
    else
      return -1;
  }// end compareTo()
  
  public static void main(String[] args)
  {
    int result;
    
    Student2 a = new Student2(123, "Peter", "Kirkpatrick");
    Student2 b = new Student2(123, "Charles", "Kirkpatrick");
    
    result = a.compareTo(b);
    
    System.out.println(result);
  }// end main
}// end Student