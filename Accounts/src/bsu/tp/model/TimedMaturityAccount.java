package bsu.tp.model;

import java.util.Date;

public class TimedMaturityAccount extends BaseAccount 
{
   private Date paymentDate;
   private double penaltyRate;
   
   public TimedMaturityAccount(double initialAmount, double penaltyRate, Date paymentDate){
	   super(initialAmount);
	   this.paymentDate = paymentDate;
	   this.penaltyRate = penaltyRate;
   }
   
   @Override
   public double withdraw(double amount){
	   if (!paymentDate.after(new Date())){
		   return super.withdraw(amount);
	   } else{
		   double fee = amount * (1 - penaltyRate);
		   double amountGiven = amount - fee;
		   return amountGiven > 0 ? amountGiven : 0;
	   }
   }
}
