package bsu.tp;

public class SavingAccount extends BaseAccount {
	private double interestRate;

	public double getInterestRate() {
		return interestRate;
	}

	public void addProfit(){
		balans = balans * (1 + interestRate);
	}
}
