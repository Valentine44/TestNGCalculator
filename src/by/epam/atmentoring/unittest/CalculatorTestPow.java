package by.epam.atmentoring.unittest;

import com.epam.tat.module4.Calculator;
import org.testng.*;
import org.testng.annotations.*;

public class CalculatorTestPow {
	
	private Calculator calculator;
	
	@BeforeClass
	public void setUp() {
		calculator = new Calculator();
	}
	
	@Test (dataProvider = "powDataProviderDouble")	
	@Parameters ({"a", "b", "expected"})
	public void testPow(double a, double b, double expected) {
		double pow = calculator.pow(a, b);
		Assert.assertEquals(pow, expected);
	}
	
	@DataProvider(name = "powDataProviderDouble")
	public Object[][] powDataProviderDouble() {
		return new Object[][] {
			{-2.0, 2.0, 4.0},
			{-2.0, 1.0, -2.0},
			{-2.0, 0.0, 1.0},
			{2.0, 0.0, 1.0},
			{2.0, 1.0, 2.0},
			{2.0, 2.0, 4.0},
			{2.0, -1.0, 0.5}
		};
	}
	
	@AfterClass (alwaysRun=true)
	public void tearDown() {
		
	}
}