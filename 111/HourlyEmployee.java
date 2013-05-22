public class HourlyEmployee extends Employee
{
  public HourlyEmployee(String fn, String ln, int num, int pay)
  {
    this.setFirstName(fn);
    this.setLastName(ln);
    this.setHours(num);
    this.setPay(pay);
  }// end HourlyEmployee constructor
  
  public int pay()
  {
    int temp;
    
    temp = this.getHours() * this.getPay();
    return temp;
  }// end pay()
}// end HourlyEmployee class