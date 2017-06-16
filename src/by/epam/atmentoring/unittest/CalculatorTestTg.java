package by.epam.atmentoring.unittest;

import com.epam.tat.module4.Calculator;
import org.testng.*;
import org.testng.annotations.*;

public class CalculatorTestTg {
	
	private Calculator calculator;
	
	@BeforeClass
	public void setUp() {
		calculator = new Calculator();
	}
	
	@Test (dataProvider = "tgDataProviderDouble", groups = "failed")	
	@Parameters ({"a", "expected"})
	public void testTg(double a, double expected) {
		double tg = calculator.tg(a);
		Assert.assertEquals(tg, expected);
	}
	
	@DataProvider(name = "tgDataProviderDouble")
	public Object[][] tgDataProviderDouble() {
		return new Object[][] {
			{-6.2832, 0.0000},
			{0.0175, 0.0175},
			{1.0472, 1.7321},
			{1.5708, Double.POSITIVE_INFINITY},
			{3.1416, 0.0000},
			{4.7997, -11.4301},
			{6.2832, 0.0000}
		};
	}
}