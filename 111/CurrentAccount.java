public class CurrentAccount extends Account
{
  private double overDraft;
  
  public CurrentAccount(int a)
  {
    super(a);
    overDraft = 0.0;
  }// end CurrentAccount constructor
}// end CurrentAccount class