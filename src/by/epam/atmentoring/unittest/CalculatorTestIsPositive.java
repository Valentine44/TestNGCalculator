package by.epam.atmentoring.unittest;

import com.epam.tat.module4.Calculator;
import org.testng.*;
import org.testng.annotations.*;

public class CalculatorTestIsPositive {
	
	private Calculator calculator;
	
	@BeforeClass
	public void setUp() {
		calculator = new Calculator();
	}
	
	@Test (dataProvider = "isPositiveDataProviderLong")	
	@Parameters ({"a", "expected"})
	public void testIsPositive(long a, boolean expected) {
		boolean isPositive = calculator.isPositive(a);
		Assert.assertEquals(isPositive, expected);
	}
	
	@DataProvider(name = "isPositiveDataProviderLong")
	public Object[][] isPositiveDataProviderLong() {
		return new Object[][] {
			{Long.MIN_VALUE, false},
			{-1, false},
			{0, false},
			{1, true},
			{Long.MAX_VALUE, true}
		};
	}
}