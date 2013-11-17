package bsu.tp.model;

public class SavingsAccount extends BaseAccount 
{
   private double interestRate;
   
   public SavingsAccount(double initialBalance, double interestRate) 
   {
	   super(initialBalance);
	   this.interestRate = interestRate;
   }
   
   public void accrueInterest() 
   {
	   balance += balance * interestRate;
   }
}
