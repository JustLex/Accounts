package bsu.tp.model;

public class CheckingAccount extends BaseAccount 
{
   private double transactionFee;
   private int maxOperationsMonthly;
   private int operationsThisMonth;
   
   public CheckingAccount(double initialBalance, double fee, int maxOperations) 
   {
	   super(initialBalance);
	   this.transactionFee = fee;
	   this.maxOperationsMonthly = maxOperations;
   }
   
   public void penalize() 
   {
	   if (operationsThisMonth > maxOperationsMonthly){
		   balance -= (operationsThisMonth - maxOperationsMonthly)*transactionFee;
	   }
	   operationsThisMonth = 0;
   }
   
   @Override
   public void invest(double amount){
	   operationsThisMonth++;
	   super.invest(amount);
   }
   
   @Override
   public double withdraw(double amount){
	   operationsThisMonth++;
	   return super.withdraw(amount);
   }
}
