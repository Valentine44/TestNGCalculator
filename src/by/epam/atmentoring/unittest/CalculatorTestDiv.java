package by.epam.atmentoring.unittest;

import com.epam.tat.module4.Calculator;
import org.testng.*;
import org.testng.annotations.*;

public class CalculatorTestDiv {
	
	private Calculator calculator;
	
	@BeforeClass
	public void setUp() {
		calculator = new Calculator();
	}
	// test calculator.div(long a, long b)
	@Test (dataProvider = "divDataProviderLong")	
	@Parameters ({"a", "b", "expected"})
	public void testDiv(long a, long b, long expected) {
		long quot = calculator.div(a, b);
		Assert.assertEquals(quot, expected);
	}
	
	@DataProvider(name = "divDataProviderLong")
	public Object[][] divDataProviderLong() {
		return new Object[][] {
			{Long.MIN_VALUE, 2, -4611686018427387904L},
			{-42, -7, 6},
			{0, 10, 0},
			{1, 3, 0},
			{10, 3, 3},
			{225, 15, 15},
			{Long.MAX_VALUE, 2, 4611686018427387903L}
		};
	}
	
	@Test (expectedExceptions=NumberFormatException.class, dataProvider = "divDataProviderLongZero")
	@Parameters ({"a"})
	public void testDiv(long a) {
		calculator.div(a, 0);
	}
	
	@DataProvider(name = "divDataProviderLongZero")
	public Object[][] divDataProviderLongZero() {
		return new Object[][] {
			{Long.MIN_VALUE},
			{-1},
			{0},
			{1},
			{Long.MAX_VALUE}
		};
	}
	
	// test calculator.div(double a, double b)
	@Test (dataProvider = "divDataProviderDouble")	
	@Parameters ({"a", "b", "expected"})
	public void testDiv(double a, double b, double expected) {
		double quot = calculator.div(a, b);
		Assert.assertEquals(quot, expected);
	}
	
	@DataProvider(name = "divDataProviderDouble")
	public Object[][] divDataProviderDouble() {
		return new Object[][] {
			{-Double.MAX_VALUE, -2, 8.988465674311579E307},
			{-5.1, 2.0, -2.55},
			{0.0, 123.45678, 0},
			{1.1, 0.1, 11},
			{10, 3, 3.3333333333333335},
			{Double.MAX_VALUE, 2, 8.988465674311579E307},
		};
	}
	
	@Test (expectedExceptions=NumberFormatException.class, dataProvider = "divDataProviderDoubleZero", groups = "failed")
	@Parameters ({"a"})
	public void testDiv(double a) {
		calculator.div(a, 0);
	}
	
	@DataProvider(name = "divDataProviderDoubleZero")
	public Object[][] divDataProviderDoubleZero() {
		return new Object[][] {
			{-Double.MAX_VALUE},
			{-1.0},
			{0.0},
			{1.0},
			{Double.MAX_VALUE}
		};
	}
	
	@AfterClass (alwaysRun=true)
	public void tearDown() {
		
	}
}