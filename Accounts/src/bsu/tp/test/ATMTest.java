package bsu.tp.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import bsu.tp.io.ATM;
import bsu.tp.logic.ATMController;
import bsu.tp.logic.Bank;
import bsu.tp.model.BaseAccount;

public class ATMTest {
	@Test
	public void testInitialization(){
		ATM atm = new ATM();
		Bank bank = new Bank();
		ATMController controller = new ATMController(bank, atm);
		assertNotNull(atm);
		assertNotNull(bank);
		assertNotNull(controller);
	}
	
	@Test
	public void testAddition(){
		Bank bank = new Bank();
		BaseAccount account1 = new BaseAccount(100, 88888888, 1234);
		bank.addAccount(account1);
		assertTrue(bank.hasId((int) account1.getId()));
	}
	
	@Test
	public void testWithdrawal(){
		Bank bank = new Bank();
		BaseAccount account1 = new BaseAccount(100, 88888888, 1234);
		bank.addAccount(account1);
		bank.hasId((int) account1.getId());
		bank.withdraw(100);
		assertTrue(account1.getBalance() == 0);
	}
	
	@Test
	public void testBlocking(){
		Bank bank = new Bank();
		BaseAccount account1 = new BaseAccount(100, 88888888, 1234);
		bank.addAccount(account1);
		bank.hasId((int) account1.getId());
		bank.blockCurrent();
		assertTrue(!account1.isActive());
	}
	
	@Test
	public void testPINChecking(){
		Bank bank = new Bank();
		BaseAccount account1 = new BaseAccount(100, 88888888, 1234);
		bank.addAccount(account1);
		bank.hasId((int) account1.getId());
		assertTrue(bank.checkPIN(account1.getPin()));
	}
	
	@Test
	public void testBalanceInfo(){
		Bank bank = new Bank();
		BaseAccount account1 = new BaseAccount(100, 88888888, 1234);
		bank.addAccount(account1);
		bank.hasId((int) account1.getId());
		assertTrue("Current balance: 100.0".equals(bank.getBalance()));
	}
}
