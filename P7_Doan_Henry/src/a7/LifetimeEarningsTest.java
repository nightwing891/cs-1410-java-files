package a7;

import static org.junit.Assert.*;

import org.junit.Test;

public class LifetimeEarningsTest extends LifetimeEarnings {

	public LifetimeEarningsTest(double _starterSalary, double _raise) {
		super(_starterSalary, _raise);
	}

	@Test
	
	public void testCurrentSalary() {
		double test1 = 1.0;
		double starterSalary = test1;
		double raisedPercentage = test1;
		
		currentSalary();
		equals(1.0);
		
		double test2 = 0;
		double starterSalary = test2;
		double raisedPercentage = test2;
		
		currentSalary();
		equals(0);
		
		double test3 = 10.0;
		double testPercentage3 = 10.00
		double starterSalary = test3;
		double raisedPercentage = test3;
		
		currentSalary();
		equals(11.0);
	}
	
	public void testSetYear() {
		int test1 = 0;
		int test2 = 5;
		int test3 = -5;
		
		setYear(test1);
		equals(0);
		
		setYear(test2);
		equals(5);
		
		setYear(test3);
		equals(0);
		
		
	}
	
	public void testIncrementYear() {
		int test1 = 0;
		int currentYear = test1;

		
		incrementYear();
		equals(1);
		
		int test2 = 5;
		int currentYear = test2;
		
		incrementYear();
		equals(6);
		
		int test3 = -5;
		int currentYear = test3;
		
		incrementYear();
		equals(1);
		
	}
	
	public void testComputeLifetimeEarnings() {
		int test1 = 0;
		double[] result1 = {};
		computeLifetimeEarnings(test1);
		assertArrayEquals(result1);
		
		int test2 = 5;
		double[] result2 = {1.0, 10.0, 100.0, 1000.0, 10000.0};
		computeLifetimeEarnings(test2);
		assertArrayEquals(result2);
		
		int test3 = -5;
		double[] result3 = {};
		computeLifetimeEarnings(test3);
		assertArrayEquals(result3);
	}
	
	public void testToString() {	
		String result = "$10x 1.0% for every 0 years";
		String result2 = "$10 x 1.0% for every 5 years";
		String result3 = "$10 x 1.0% for every -5 years";
		
		
		double starterSalary = 10.0;
		double risePercent = 1.0;
		double Yearly = 0;
		toString();
		equals(result);
		
		double Yearly2 = 0;
		toString();
		equals(result2);
		
		double Yearly3 = 0;
		toString();
		equals(result3);
		
	}
	

}
