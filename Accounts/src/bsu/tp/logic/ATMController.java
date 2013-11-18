package bsu.tp.logic;

import bsu.tp.io.ATM;

public class ATMController {
	private Bank bank;
	private ATM atm;
	
	public ATMController(Bank bank, ATM atm){
		this.bank = bank;
		this.atm = atm;
	}
	
	public void start(String helloMessage){
		atm.showMessage(helloMessage);
		while(true){
			int cardNum;
			atm.showMessage(ATM.REQ_INPUT_CARD_NUMBER);
			cardNum = getRestrictedInt(Bank.ACCOUNT_NUMBER_LENGTH);
			if (cardNum == -1 || !bank.hasId(cardNum)){
				atm.showMessage(ATM.ERR_INVALID_CARD);
			} else {
				int operationNum = -1;
				while (operationNum != 0){
					atm.showMessage(ATM.MENU);
					atm.showMessage(ATM.REQ_CHOOSE_OPERATION);
					operationNum = getRestrictedInt(1);
					if (operationNum!= 0){
						atm.showMessage(ATM.REQ_INPUT_PIN);
						if (!checkPIN()){
							atm.showMessage(ATM.ERR_PIN_CHECK_FAILED);
							bank.blockCurrent();
						} else{
							switch (operationNum){
								case 1: atm.showMessage(bank.getBalance()); break;
								case 2: withdraw(); break;
							}	
						}
					} else {
						atm.showMessage(ATM.INF_EJECT);
					}
				}
			}
		}
	}
	
	private boolean checkPIN(){
		for (int i = 0; i < 3; i++){
			int input = getRestrictedInt(Bank.PIN_LENGTH);
			if ((input != -1) && (bank.checkPIN(input))){
				return true;
			} else {
				atm.showMessage(ATM.ERR_INVALID_PIN);
			}
		}
		return false;
	}
	
	private int getRestrictedInt(int length){
		String buffer = atm.getInput();
		try{
			if (buffer.length() == length){
				return Integer.parseInt(buffer);
			}
		} catch (NumberFormatException e){
		}
		return -1;
	}
	
	private void withdraw(){
		atm.showMessage(ATM.REQ_INPUT_AMOUNT);
		String buffer = atm.getInput();
		try {
			int amount = Integer.parseInt(buffer);
			atm.showMessage(bank.withdraw(amount));
		} catch (NumberFormatException e){
			atm.showMessage(ATM.ERR_INVALID_NUMBER);
		}
	}
}
