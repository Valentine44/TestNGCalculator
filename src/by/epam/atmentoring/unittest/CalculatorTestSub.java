package by.epam.atmentoring.unittest;

import com.epam.tat.module4.Calculator;
import org.testng.*;
import org.testng.annotations.*;

public class CalculatorTestSub {
	
	private Calculator calculator;
	
	@BeforeClass
	public void setUp() {
		calculator = new Calculator();
	}
	// test calculator.sub(long a, long b)
	@Test (dataProvider = "subDataProviderLong")	
	@Parameters ({"a", "b", "expected"})
	public void testSub(long a, long b, long expected) {
		long dif = calculator.sub(a, b);
		Assert.assertEquals(dif, expected);
	}
	
	@DataProvider(name = "subDataProviderLong")
	public Object[][] subDataProviderLong() {
		return new Object[][] {
			{Long.MIN_VALUE, -1, -9223372036854775807L},
			{-3, -2, -1},
			{-3, 2, -5},
			{-2, 3, -5},
			{0, -1, 1},
			{0, 0, 0},
			{0, 1, -1},
			{2, 3, -1},
			{Long.MAX_VALUE, 1, 9223372036854775806L}
		};
	}
	// test calculator.sub(double a, double b)
	@Test (dataProvider = "subDataProviderDouble")	
	@Parameters ({"a", "b", "expected"})
	public void testSub(double a, double b, double expected) {
		double dif = calculator.sub(a, b);
		Assert.assertEquals(dif, expected);
	}
	
	@DataProvider(name = "subDataProviderDouble")
	public Object[][] subDataProviderDouble() {
		return new Object[][] {
			{-Double.MAX_VALUE, -1, -179769313486231569999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999D},
			{-1.5, 1.5, -3.0},
			{0.1, 1.01, -0.91},
			{1.5, 1.5, 0.0},
			{Double.MAX_VALUE, 1, 179769313486231569999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999D},

		};
	}
	
	@AfterClass (alwaysRun=true)
	public void tearDown() {
		
	}
}