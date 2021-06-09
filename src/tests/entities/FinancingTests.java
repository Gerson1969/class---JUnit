package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.financing.Financing;

public class FinancingTests {
	@Test
	public void entryShouldReturnTwentyPercentOfTotalAmount() {
		Financing f = new Financing(100000.0, 2000.0, 80);
		double expectValue =  100000.0*0.2;

		double result = f.entry();

		Assertions.assertEquals(expectValue, result);
	}
	
	@Test
	public void quotaShouldReturnCorrectQuotaValue() {
		Financing f = new Financing(100000.0, 2000.0, 80);
		double expectValue =  100000.0*0.8/80;

		double result = f.quota();

		Assertions.assertEquals(expectValue, result);
	}

	@Test
	public void constructorShouldSetValuesWhenValidData() {
		Financing f = new Financing(100000.0, 2000.0, 80);

		Assertions.assertEquals(100000.0, f.getTotalAmount());
		Assertions.assertEquals(2000.0, f.getIncome());
		Assertions.assertEquals(80, f.getMonths());
	}

	
	@Test
	public void constructorShouldThrowIllegalArgumentExceptionWhenInvaliData() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing f = new Financing(100000.0, 2000.0, 79);
		});
	}

	@Test
	public void setTotalAmountShouldSetValuesWhenValidData() {
		Financing f = new Financing(100000.0, 2000.0, 80);

		f.setTotalAmount(90000);
		Assertions.assertEquals(90000.0, f.getTotalAmount());
	}
	
	@Test
	public void setTotalAmountShouldThrowIllegalArgumentExceptionWhenInvaliData() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing f = new Financing(100000.0, 2000.0, 80);	
			f.setTotalAmount(110000);
		});
	}

	@Test
	public void setIncomeShouldSetValuesWhenValidData() {
		Financing f = new Financing(100000.0, 2000.0, 80);

		f.setIncome(3000.0);
		Assertions.assertEquals(3000.0, f.getIncome());
	}
	
	@Test
	public void setIncomeShouldThrowIllegalArgumentExceptionWhenInvaliData() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing f = new Financing(100000.0, 2000.0, 80);	
			f.setIncome(1990);
		});
	}
	@Test
	public void setMonthsShouldSetValuesWhenValidData() {
		Financing f = new Financing(100000.0, 2000.0, 80);

		f.setMonths(90);
		
		Assertions.assertEquals(90, f.getMonths());
	}
	
	@Test
	public void setMonthsShouldThrowIllegalArgumentExceptionWhenInvaliData() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing f = new Financing(100000.0, 2000.0, 80);	
			f.setMonths(79);
		});
	}	
}
