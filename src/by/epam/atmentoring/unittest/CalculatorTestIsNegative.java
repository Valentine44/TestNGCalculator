package by.epam.atmentoring.unittest;

import com.epam.tat.module4.Calculator;
import org.testng.*;
import org.testng.annotations.*;

public class CalculatorTestIsNegative {
	
	private Calculator calculator;
	
	@BeforeClass
	public void setUp() {
		calculator = new Calculator();
	}
	
	@Test (dataProvider = "isNegativeDataProviderLong")	
	@Parameters ({"a", "expected"})
	public void testIsNegative(long a, boolean expected) {
		boolean isNegative = calculator.isNegative(a);
		Assert.assertEquals(isNegative, expected);
	}
	
	@DataProvider(name = "isNegativeDataProviderLong")
	public Object[][] isNegativeDataProviderLong() {
		return new Object[][] {
			{Long.MIN_VALUE, true},
			{-1, true},
			{0, false},
			{1, false},
			{Long.MAX_VALUE, false}
		};
	}
}