package bsu.tp;

import java.util.Date;

public class RepaymentTimeAccount extends SavingAccount {
	private double penalty;
	private Date paymentDate;
	
	@Override
	public boolean withdrawWithCheck(double amount){
		if(balans - amount < 0){
			return false;
		}
		balans = balans * (1 - penalty);
		return true;
	}

	public double getPenalty() {
		return penalty;
	}

	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}
}
