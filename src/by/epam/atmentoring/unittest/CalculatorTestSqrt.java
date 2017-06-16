package by.epam.atmentoring.unittest;

import com.epam.tat.module4.Calculator;
import org.testng.*;
import org.testng.annotations.*;

public class CalculatorTestSqrt {
	
	private Calculator calculator;
	
	@BeforeClass
	public void setUp() {
		calculator = new Calculator();
	}
	
	@Test (dataProvider = "sqrtDataProviderDouble")	
	@Parameters ({"a", "b", "expected"})
	public void testSqrt(double a, double expected) {
		double sqrt = calculator.sqrt(a);
		Assert.assertEquals(sqrt, expected);
	}
	
	@DataProvider(name = "sqrtDataProviderDouble")
	public Object[][] sqrtDataProviderDouble() {
		return new Object[][] {
			{0.0, 0.0},
			{1.0, 1.0},
			{2.25, 1.5},
			{10.0, 3.1622776601683795},
			{225.0, 15.0}
		};
	}
	
	@Test (dataProvider = "sqrtDataProviderDoubleNegative", expectedExceptions = NumberFormatException.class, groups = "failed")
	@Parameters ({"a", "b", "expected"})
	public void testSqrt(double a) {
		calculator.sqrt(a);
	}
	
	@DataProvider(name = "sqrtDataProviderDoubleNegative")
	public Object[][] sqrtDataProviderDoubleNegative() {
		return new Object[][] {
			{-1.0}
		};
	}
	
	@AfterClass (alwaysRun=true)
	public void tearDown() {
		
	}
}