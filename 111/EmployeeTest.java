public class EmployeeTest
{
  public static void main(String[] args)
  {
    int p1 = 0;
    int p2 = 0;
    HourlyEmployee hrEmp;
    NonHourlyEmployee nHrEmp;
    
    hrEmp = new HourlyEmployee("Peter", "Kirkpatrick", 40, 8);
    nHrEmp = new NonHourlyEmployee("Tiffany", "Cline");
    
    p1 = hrEmp.pay();
    p2 = nHrEmp.pay();
    
    System.out.println("HourlyEmployee pay: " + p1);
    System.out.println("NonHourlyEmployee pay: " + p2);
  }// end main
}// end EmployeeTest class