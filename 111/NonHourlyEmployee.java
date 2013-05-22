public class NonHourlyEmployee extends Employee
{
  public NonHourlyEmployee(String fn, String ln)
  {
    this.setFirstName(fn);
    this.setLastName(ln);
    this.setPay(5000);
  }// end NonHourlyEmployee constructor
  
  public int pay()
  {
    return this.getPay();
  }// end getPay()
}// end NonHourlyEmployee class