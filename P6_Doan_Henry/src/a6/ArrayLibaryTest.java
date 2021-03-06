package a6;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayLibaryTest extends ArrayLibrary {

	@Test
	public void testClear() {
		int[] result = {0, 0, 0, 0, 0};
		
		int[] test = {2, -1, 21, 3, -41};
		clear(test);
		assertArrayEquals(result, test);
		
		int[] test2 = {-1, -2, -3, -4, -5};
		clear(test2);
		assertArrayEquals(result, test2);
		
		int[] test3 = {2, 'a', -21, '.', -41};
		clear(test3);
		assertArrayEquals(result, test3);
	}
	
	@Test
	public void testReverseFill() {
		int[] result = {1};
		int[] result2 = { 17, 16, 15, 14, 13};
		int[] result3 = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
		
		int[] test = new int[1];
		reverseFill(test, 1);
		assertArrayEquals(result, test);
		
		int[] test2 = new int[5];
		reverseFill(test2, 13);
		assertArrayEquals(result2, test2);
		
		int[] test3 = new int[10];
		reverseFill(test3, 2);
		assertArrayEquals(result3, test3);
	}
	
	@Test
	public void testArrayToString() {
		String result = "{2,-1,21,3,-41}";
		String result2 = "{0}";
		String result3 = "{2, 'a', -21, '.', -41}";
		
		int[] test = {2, -1, 21, 3, -41};
		arrayToString(test);
		equals(result);
		
		int[] test2 = {0};
		arrayToString(test2);
		equals(result2);
		
		int[] test3 = {2, 'a', -21, '.', -41};
		arrayToString(test3);
		equals(result3);
	}
	
	@Test
	public void testContainsDuplicate() {
		
		String[] test = { "the" };
		containsDuplicate(test);
		equals(false);
		
		String[] test2 = { "the", "the", "the", "the", "the" };
		containsDuplicate(test2);
		equals(true);
		
		String[] test3 = { "the", "2", "2", "word" };
		containsDuplicate(test3);
		equals(true);
	}
	
	@Test
	public void testAverage() {
		double result = -0.6;
		double result2 = 1.0;
		double result3 = -3.0;
		
		int[] test = {-1, 2, -3, 4, -5};
		average(test);
		equals(result);
		
		int[] test2 = {1};
		average(test2);
		equals(result2);
		
		int[] test3 = {-1, -2, -3, -4, -5};
		average(test3);
		equals(result3);
	}
	
	@Test
	public void testFrequencyCount() {
		int[] result = { 0, 2, 3, 3, 4, 3, 0, 0, 0, 1};
		int[] result2 = { 0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
		int[] result3 = {4, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		int[] test = { 4, 2, 3, 5, 4, 4, 3, 2, 9, 1, 3, 4, 5, 2, 1, 5 };
		frequencyCount(test);
		assertArrayEquals(result, test);
		
		int[] test2 = { 0, 0, 0, 0 };
		frequencyCount(test2);
		assertArrayEquals(result2, test2);
		
		int[] test3 = { 1, 3, 5, 7, 9 };
		frequencyCount(test3);
		assertArrayEquals(result3, test3);
	}
	

	@Test
	public void testmakeFilledArray() {
		int[] result = { 0 };
		int[] result2 = { 0, 1, 2};
		int[] result3 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		
		int test = 1;
		makeFilledArray(test);
		equals(result);
		
		int test2 = 3;
		makeFilledArray(test2);
		equals(result2);
		
		int test3 = 12;
		makeFilledArray(test3);
		equals(result3);
	}

}
