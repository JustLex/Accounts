package bsu.tp;

public abstract class BaseAccount {
	protected double balans;
	private boolean overdraft;
	
	public double getBalans() {
		return balans;
	}
	
	public void contribute(double amount){
		balans += amount;
	}
	
	public boolean withdrawWithCheck(double amount){
		if(balans - amount < 0){
			return false;
		}
		balans -= amount;
		return true;
	}
}
