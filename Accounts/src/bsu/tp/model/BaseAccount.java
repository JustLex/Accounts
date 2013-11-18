package bsu.tp.model;

import java.util.Random;

public class BaseAccount {
	protected double balance;
	private int pin;
	private int id;
	private boolean active = true;

	public BaseAccount(double initialBalance) {
		balance = initialBalance;
		Random rand = new Random();
		this.id = rand.nextInt(89999999) + 10000000;
		this.pin = rand.nextInt(8999) + 1000;
	}
	
	public BaseAccount(double initialBalance, int id, int pin){
		this.balance = initialBalance;
		this.id = id;
		this.pin = pin;
	}

	public int getPin() {
		return pin;
	}

	public int getId() {
		return id;
	}
	
	public boolean isActive(){
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}

	public double withdraw(double amount) {
		if (balance - amount >= 0) {
			balance -= amount;
			return amount;
		}
		return 0;
	}

	public void invest(double amount) {
		balance += amount;
	}

	public double getBalance() {
		return balance;
	}
	
	@Override public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("id: ").append(this.id).append(" pin: ").append(this.pin);
		return builder.toString();
	}
}
