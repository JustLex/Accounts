package bsu.tp.test;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import bsu.tp.model.BaseAccount;
import bsu.tp.model.CheckingAccount;
import bsu.tp.model.OverdraftAccount;
import bsu.tp.model.SavingsAccount;
import bsu.tp.model.TimedMaturityAccount;

public class AccountsTest {

	@Test 
	public void testBaseAccount(){
		BaseAccount acc1 = new BaseAccount(10);
		acc1.withdraw(11);
		acc1.withdraw(-1);
		assertTrue(acc1.getBalance() == 10);
		assertTrue(acc1.getId() < 100000000 && acc1.getId() > 9999999);
		assertTrue(acc1.getPin() < 10000 && acc1.getPin() > 999);
	}
	
	@Test
	public void testOverdraftAccount(){
		OverdraftAccount acc1 = new OverdraftAccount(-2, 0.1);
		acc1.withdraw(-1);
		assertTrue(acc1.getBalance() == -2);
		OverdraftAccount acc2 = new OverdraftAccount(-100, 0.1);
		acc2.accrueInterest();
		assertTrue(acc2.getBalance() == -110);
		acc2.invest(120);
		acc2.accrueInterest();
		assertTrue(acc2.getBalance() == 10);
	}
	
	@Test
	public void testTimedMaturityAccount(){	
		TimedMaturityAccount acc3 = new TimedMaturityAccount(100, 0.1, new Date(System.currentTimeMillis() + 1000000000));
		assertTrue(acc3.withdraw(100) == 90);
		TimedMaturityAccount acc4 = new TimedMaturityAccount(100, 0.1, new Date(0));
		assertTrue(acc4.withdraw(100) == 100);
	}
	
	@Test
	public void testCheckingAccount(){
		CheckingAccount acc1 = new CheckingAccount(100, 10, 2);
		acc1.invest(10);
		acc1.withdraw(10);
		acc1.penalize();
		assertTrue(acc1.getBalance() == 100);
		acc1.invest(10);
		acc1.invest(10);
		acc1.withdraw(10);
		acc1.penalize();
		assertTrue(acc1.getBalance() == 100);
	}
	
	@Test
	public void testSavingAccounts(){
		SavingsAccount acc3 = new SavingsAccount(100, 0.1);
		acc3.accrueInterest();
		assertTrue(acc3.getBalance() == 110);
	}
}
