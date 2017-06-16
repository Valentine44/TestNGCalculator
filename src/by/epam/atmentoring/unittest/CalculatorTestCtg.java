package by.epam.atmentoring.unittest;

import com.epam.tat.module4.Calculator;
import org.testng.*;
import org.testng.annotations.*;

public class CalculatorTestCtg {
	
	private Calculator calculator;
	
	@BeforeClass
	public void setUp() {
		calculator = new Calculator();
	}
	
	@Test (dataProvider = "ctgDataProviderDouble", groups = "failed")	
	@Parameters ({"a", "expected"})
	public void testCtg(double a, double expected) {
		double ctg = calculator.ctg(a);
		Assert.assertEquals(ctg, expected);
	}
	
	@DataProvider(name = "ctgDataProviderDouble")
	public Object[][] ctgDataProviderDouble() {
		return new Object[][] {
			{-6.2832, Double.POSITIVE_INFINITY},
			{0.0175, 57.2900},
			{1.0472, 0.5774},
			{1.5708, 0.0000},
			{3.1416, Double.NEGATIVE_INFINITY},
			{4.7997, -0.0875},
			{6.2832, Double.POSITIVE_INFINITY}
		};
	}
}