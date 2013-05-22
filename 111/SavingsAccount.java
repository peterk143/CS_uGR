public class SavingsAccount extends Account
{
  private double interest;
  
  public SavingsAccount(int a)
  {
    super(a);
    interest = 0.0;
  }// end SavingsAccount constructor
  
  public void addInterest(int b)
  {
    double num;
    
    num = getBalance();
    
    deposit(num * b);
  }// end addInterest()
}// end 