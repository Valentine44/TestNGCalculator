package by.epam.atmentoring.unittest;

import com.epam.tat.module4.Calculator;
import org.testng.*;
import org.testng.annotations.*;

public class CalculatorTestMult {
	
	private Calculator calculator;
	
	@BeforeClass
	public void setUp() {
		calculator = new Calculator();
	}
	// test calculator.mult(long a, long b)
	@Test (dataProvider = "multDataProviderLong")	
	@Parameters ({"a", "b", "expected"})
	public void testMult(long a, long b, long expected) {
		long prod = calculator.mult(a, b);
		Assert.assertEquals(prod, expected);
	}
	
	@DataProvider(name = "multDataProviderLong")
	public Object[][] multDataProviderLong() {
		return new Object[][] {
			{-1, 10, -10},
			{-1, 1, -1},
			{1, 0, 0},
			{1, 1, 1},
			{1, 10, 10}
		};
	}
	// test calculator.mult(double a, double b)
	@Test (dataProvider = "multDataProviderDouble", groups = {"failed"})	
	@Parameters ({"a", "b", "expected"})
	public void testMult(double a, double b, double expected) {
		double prod = calculator.mult(a, b);
		Assert.assertEquals(prod, expected);
	}
	
	@DataProvider(name = "multDataProviderDouble")
	public Object[][] multDataProviderDouble() {
		return new Object[][] {
			{-1.5, 0.75, -1.125},
			{-1.5, -1.5, 2.25},
			{-1.5, 0.0, 0.0},
			{0.0, 1.5, 0.0},
			{1.5, 0.0, 0.0},
			{1.5, 1.5, 2.25},
			{1.5, 0.75, 1.125}
		};
	}
	
	@AfterClass (alwaysRun=true)
	public void tearDown() {
		
	}
}