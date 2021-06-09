package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.account.Account;
import tests.factory.AccountFactory;

public class AccountTests {
	@Test
	public void depositShouldIncreaseBalanceWhenPositiveAmount() {
		double amount = 200.0;
		double expectValue =  196.0;
		
		Account acc = AccountFactory.createEmptyAccount();
		acc.deposit(amount);
		
		Assertions.assertEquals(expectValue, acc.getBalance());
	}
	
	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {

		double expectValue =  196.0;	
		Account acc = AccountFactory.createAccount(expectValue);
		double amount = -200.0;
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expectValue, acc.getBalance());
	}

	@Test
	public void fullWithDrawnShouldClearBalance() {
		double expectValue =  0.0;
		double initialValue = 666.0;
		Account acc = AccountFactory.createAccount(initialValue);
		
		double finalValue = acc.fullwithdrow();
		Assertions.assertEquals(expectValue, acc.getBalance());		
		Assertions.assertEquals(initialValue, finalValue);
	}
	
	@Test
	public void WithDrawnShouldDecreaseValueWhenSufficientBalance() {
		double expectValue =  0.0;
		double initialValue = 666.0;
		Account acc = AccountFactory.createAccount(initialValue);
		
		acc.withdrow(666.0);
		Assertions.assertEquals(expectValue, acc.getBalance());		
	}
	
	@Test
	public void WithDrawnShouldTrhowExceptionWhenInsufficientBalance() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			double expectValue =  666.0;
			double initialValue = 666.0;
			Account acc = AccountFactory.createAccount(initialValue);
			acc.withdrow(667.0);
		}
		);	
	}
}
