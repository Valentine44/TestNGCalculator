package by.epam.atmentoring.unittest;

import com.epam.tat.module4.Calculator;
import org.testng.*;
import org.testng.annotations.*;

public class CalculatorTestCos {
	
	private Calculator calculator;
	
	@BeforeClass
	public void setUp() {
		calculator = new Calculator();
	}
	
	@Test (dataProvider = "cosDataProviderDouble", groups = "failed")	
	@Parameters ({"a", "expected"})
	public void testCos(double a, double expected) {
		double cos = Math.round (calculator.cos(a) * 10000.0) / 10000.0;
		Assert.assertEquals(cos, expected);
	}
	
	@DataProvider(name = "cosDataProviderDouble")
	public Object[][] cosDataProviderDouble() {
		return new Object[][] {
			{-6.2832, -1.0000}, // -360 degrees
			{0.0175, 0.9998}, // 1 degrees
			{1.0472, 0.5000}, // 60 degrees
			{1.5708, 0.0000}, // 90 degrees
			{3.1416, -1.0000}, //90 degrees
			{4.7997, 0.0872},
			{6.2832, 1.0000}
		};
	}
}