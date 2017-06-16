package by.epam.atmentoring.unittest;

import com.epam.tat.module4.Calculator;
import org.testng.*;
import org.testng.annotations.*;

public class CalculatorTestSum {
	
	private Calculator calculator;
	
	@BeforeClass
	public void setUp() {
		calculator = new Calculator();
	}
	// test calculator.sum(long a, long b)
	@Test (dataProvider = "sumDataProviderLong")	
	public void testSum(long a, long b, long expected) {
		long sum = calculator.sum(a, b);
		Assert.assertEquals(sum, expected);
	}
	
	@DataProvider(name = "sumDataProviderLong")
	public Object[][] sumDataProviderLong() {
		return new Object[][] {
			{Long.MIN_VALUE, 1, -9223372036854775807L},
			{-3, -2, -5},
			{-3, 2, -1},
			{-2, 3, 1},
			{0, -1, -1},
			{0, 0, 0},
			{0, 1, 1},
			{2, 3, 5},
			{Long.MAX_VALUE, -1, 9223372036854775806L}
		};
	}
	// test calculator.sum(double a, double b)
	@Test (dataProvider = "sumDataProviderDouble")	
	public void testSum(double a, double b, double expected) {
		double sum = calculator.sum(a, b);
		Assert.assertEquals(sum, expected);
	}
	
	@DataProvider(name = "sumDataProviderDouble")
	public Object[][] sumDataProviderDouble() {
		return new Object[][] {
			{-Double.MAX_VALUE, 1, -179769313486231569999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999D},
			{-1.5, 1.5, 0},
			{0.1, 1.01, 1.11},
			{1.5, 1.5, 3.0},
			{Double.MAX_VALUE, -1, 179769313486231569999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999D},
		};
	}
	
	@AfterClass (alwaysRun=true)
	public void tearDown() {
		
	}
}