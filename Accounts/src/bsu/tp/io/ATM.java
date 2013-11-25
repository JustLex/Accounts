package bsu.tp.io;

import java.util.Scanner;

public class ATM {
	private Scanner input = new Scanner(System.in);
	public static final String MENU = "1. Show balance\n" +
									  "2. Withdraw\n" +
									  "0. Return card";
	public static final String REQ_INPUT_CARD_NUMBER = "Input card number";
	public static final String REQ_INPUT_PIN = "Input PIN";
	public static final String REQ_INPUT_AMOUNT = "Input amount to withdraw";
	public static final String REQ_CHOOSE_OPERATION = "Choose operation";
	public static final String ERR_INVALID_NUMBER = "Invalid number";
	public static final String ERR_INVALID_CARD = "No such account";
	public static final String ERR_PIN_CHECK_FAILED = "3 incorrect inputs. Account blocked";
	public static final String ERR_INVALID_PIN = "Invalid PIN. Try again";
	public static final String INF_EJECT = "Have a good day";
	
	public void showMessage(String message){
		System.out.println(message);
		System.out.println("============================");
	}
	
	public String getInput(){
		return input.next();
	}
}
