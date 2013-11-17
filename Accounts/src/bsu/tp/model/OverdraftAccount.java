package bsu.tp.model;

public class OverdraftAccount extends BaseAccount 
{
   private Double interestRate;

   public OverdraftAccount(double initialBalance, double interestRate) 
   {
	   super(initialBalance);
	   this.interestRate = interestRate;
   }
   
   public void accrueInterest() 
   {
	   if (balance < 0){
		   balance += balance * interestRate;
	   }
   }
   
   @Override
   public double withdraw(double amount){
	   balance -= amount;
	   return amount;
   }
}
