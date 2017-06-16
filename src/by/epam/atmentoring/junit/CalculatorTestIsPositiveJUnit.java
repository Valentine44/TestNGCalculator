package by.epam.atmentoring.junit;

import com.epam.tat.module4.Calculator;
import java.util.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;
import org.testng.annotations.BeforeClass;

@RunWith(Parameterized.class)
public class CalculatorTestIsPositiveJUnit {
	
	Calculator calculator;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 /*{ Long.MIN_VALUE, false },*/ { -1, false }, { 0, false }, { 1, true }, { Long.MAX_VALUE, true }
           });
    }
    
    //@Parameter(0)
    private long a;
    
    //@Parameter(1)
    private boolean expected;
	
    
    public CalculatorTestIsPositiveJUnit(long input, boolean expected) {
    	a = input;
    	this.expected = expected;
    }
    
    @BeforeClass
	public void setUp() {
		calculator = new Calculator();
	}
    
    @Test
	public void testIsPositive() {
		Assert.assertEquals(expected, calculator.isPositive(a));
	}
}