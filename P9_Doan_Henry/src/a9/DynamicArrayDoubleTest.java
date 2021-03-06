package a9;

import static org.junit.Assert.*;

import org.junit.Test;

public class DynamicArrayDoubleTest {

	private DynamicArrayAbstract<String> test;
	private DynamicArrayAbstract<Integer> test2;
	private DynamicArrayAbstract<Integer> test3;
	
	@Test
	public void test() {
		test = new DynamicArrayDouble<String>();
		assertEquals("[] real length: 0", test.toString());
		
		test.add("5");
		test.add("sam");
		assertEquals("sam", test.get(1));
		
		test.add(1, "Rock");
		assertEquals("Rock", test.get(1));
		
		test.remove(1);
		test.remove(2);
		assertEquals(2, test.size());
	}

}
