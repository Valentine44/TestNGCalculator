package by.epam.atmentoring.unittest;

import com.epam.tat.module4.Calculator;
import org.testng.*;
import org.testng.annotations.*;

public class CalculatorTestSin {
	
	private Calculator calculator;
	
	@BeforeClass
	public void setUp() {
		calculator = new Calculator();
	}
	
	@Test (dataProvider = "sinDataProviderDouble")	
	@Parameters ({"a", "expected"})
	public void testSin(double a, double expected) {
		double sin = Math.round(calculator.sin(a) * 10000.0) / 10000.0;
		Assert.assertEquals(sin, expected);
	}
	
	@DataProvider(name = "sinDataProviderDouble")
	public Object[][] sinDataProviderDouble() {
		return new Object[][] {
			{-6.2832, 0.0000},
			{0.0175, 0.0175},
			{1.0472, 0.8660},
			{1.5708, 1.0000},
			{3.1416, 0.0000},
			{4.7997, -0.9962},
			{6.2832, 0.0000}
		};
	}
}