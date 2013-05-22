public class Employee
{
  private String firstName;
  private String lastName;
  private int numHours;
  private int payPerHour;
  
  public Employee()
  {
  }// end Employee constructor
  
  public Employee(String fn, String ln, int num, int pay)
  {
    firstName = fn;
    lastName = ln;
    numHours = num;
    payPerHour = pay;
  }// end Employee constructor
  
  public String getFirstName()
  {
    return this.firstName;
  }// end getFirstName()
  
  public String getLastName()
  {
    return this.lastName;
  }// end getLastName()
  
  public int getHours()
  {
    return this.numHours;
  }// end getHours()
  
  public int getPay()
  {
    return this.payPerHour;
  }// end getPay()
  
  public void setFirstName(String fn)
  {
    firstName = fn;
  }// end setFirstName()
  
  public void setLastName(String ln)
  {
    lastName = ln;
  }// end setLastName()
  
  public void setHours(int num)
  {
    numHours = num;
  }// end setHours()
  
  public void setPay(int pay)
  {
    payPerHour = pay;
  }// end setPay()
}// end Employee class