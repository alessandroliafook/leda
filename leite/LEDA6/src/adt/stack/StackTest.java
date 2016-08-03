package adt.stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adt.stack.*;


public class StackTest {

	StackDoubleLinkedListImpl<Integer> stack;

	@Before
	public void setUp() throws Exception {
		stack = new StackDoubleLinkedListImpl<>(5);
	}

	@Test
	public void test() throws StackOverflowException, StackUnderflowException {
		assertTrue(stack.isEmpty());
		assertEquals(null, stack.top());

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);

		assertTrue(!stack.isEmpty());

		assertEquals(new Integer(4), stack.top());
		assertEquals(new Integer(4), stack.pop());

		assertEquals(new Integer(3), stack.top());
		assertEquals(new Integer(3), stack.pop());

		assertEquals(new Integer(2), stack.top());
		assertEquals(new Integer(2), stack.pop());

		stack.push(5);
		stack.push(6);

		assertEquals(new Integer(6), stack.top());
		assertEquals(new Integer(6), stack.pop());

		assertEquals(new Integer(5), stack.top());
		assertEquals(new Integer(5), stack.pop());

		assertEquals(new Integer(1), stack.top());
		assertEquals(new Integer(1), stack.pop());

		assertTrue(stack.isEmpty());

		assertEquals(null, stack.top());

		try {
			stack.pop();
			fail();
		} catch(StackUnderflowException e) {}
	}

}
