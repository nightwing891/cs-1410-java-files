package a9;

import static org.junit.Assert.*;

import org.junit.Test;

public class DynamicArrayCustomTest {

	private DynamicArrayAbstract<String> test;
	private DynamicArrayAbstract<Integer> test2;
	private DynamicArrayAbstract<Integer> test3;
	
	@Test
	public void test() {
		test = new DynamicArrayCustom<String>();
		assertEquals("[] real length: 0", test.toString());
		
		test.add("2");
		test.add("sam");
		assertEquals("sam", test.get(1));
		
		test.add(1, "Iam");
		assertEquals("Iam", test.get(1));
		
		test.remove(1);
		test.remove(2);
		assertEquals(2, test.size());
	}

}
