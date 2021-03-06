package a9;

import a9.DynamicArray;

public class SpeedTest {
	public static void main(String[] args) {

		// Create an object of each array type
		DynamicArrayAddOne<Integer> addOne = new DynamicArrayAddOne<Integer>();
		DynamicArrayDouble<Integer> doubleData = new DynamicArrayDouble<Integer>();
		DynamicArrayCustom<String> custom = new DynamicArrayCustom<String>();
		
		// Set the desired number of iterations
		int N = 10_000;
		
		// Collect the time required to add N elements to the slow DA.
		long startTime = System.nanoTime();
		for(int i = 0; i < N; i++) {
			addOne.add("" + i);  // adds to the end of the array
		}
		long endTime = System.nanoTime();
		System.out.println("Add One took " + (endTime - startTime) / 1000000000.0 + 
				" sec to add " + N + " elements.")
		;

		// Collect the time required to add N elements to the fast DA.
		startTime = System.nanoTime();
		for(int i = 0; i < N; i++) {
			doubleData.add("" + i);   // adds to the end of the array
		}
		endTime = System.nanoTime();
		System.out.println("Double took " + (endTime - startTime) / 1000000000.0 + 
				" sec to add " + N + " elements.");
		
		startTime = System.nanoTime();
		for(int i = 0; i < N; i++) {
			custom.add("" + i);   // adds to the end of the array
		}
		endTime = System.nanoTime();
		System.out.println("Custom took " + (endTime - startTime) / 1000000000.0 + 
				" sec to add " + N + " elements.");
	}


}
