//*******************************************************************
//Programmer:          Peter Kirkpatrick
//Date:                April 3, 2009
//Program Description: This is a class for Customers.
//*******************************************************************

public class Customer
{
  private String CustomerID;
  private String FirstName;
  private String LastName;
  
  public Customer(String id, String fn, String ln)
  {
    CustomerID = id;
    FirstName = fn;
    LastName = ln;
   }// end Customer constructor
  
  public void Display()
  {
    System.out.println("CustomerID: " + CustomerID);
    System.out.println("First Name: " + FirstName);
    System.out.println("Last Name : " + LastName);
  }// end Display()
}// end Customer class