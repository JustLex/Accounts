package bsu.tp.logic;

import java.util.ArrayList;

import bsu.tp.model.BaseAccount;

public class Bank {
	private ArrayList<BaseAccount> accounts = new ArrayList<BaseAccount>();
	private BaseAccount currentAccount;
	public static int ACCOUNT_NUMBER_LENGTH = 8;
	public static int PIN_LENGTH = 4;
	
	public void addAccount(BaseAccount account){
		accounts.add(account);
	}
	
	public boolean hasId(int id){
		for (BaseAccount account : accounts) {
			if (account.getId() == id && account.isActive()){
				currentAccount = account;
				return true;
			}
		}
		return false;
	}
	
	public boolean checkPIN(int pin){
		return currentAccount.getPin() == pin;
	}
	
	public void blockCurrent(){
		currentAccount.setActive(false);
	}
	
	public String getBalance(){
		return "Curent balance: " + currentAccount.getBalance();
	}
	
	public String withdraw(int amount){
		double withdrawal = currentAccount.withdraw(amount);
		if (withdrawal > 0){
			return "You will gain: " + withdrawal;
		} else {
			return "Insufficient funds";
		}
	}
}
