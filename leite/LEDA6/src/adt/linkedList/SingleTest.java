package adt.linkedList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adt.linkedList.SingleLinkedListImpl;

public class SingleTest {

	SingleLinkedListImpl<Integer> list, list2;

	@Before
	public void setUp() throws Exception {
		list = new SingleLinkedListImpl<>();
		list2 = new SingleLinkedListImpl<>();
	}

	@Test
	public void test() {
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
		assertTrue(list.getHead().isNIL());
		assertArrayEquals(new Integer[] {}, list.toArray());

		assertEquals(null, list.search(7));
		assertEquals(null, list.search(2));
		assertEquals(null, list.search(99));

		list.insert(1);
		list.insert(2);
		list.insert(3);

		assertTrue(!list.isEmpty());
		assertEquals(3, list.size());
		assertEquals(new Integer(1), list.getHead().getData());
		assertArrayEquals(new Integer[] {1, 2, 3}, list.toArray());

		assertEquals(null, list.search(7));
		assertEquals(new Integer(2), list.search(2));
		assertEquals(null, list.search(99));

		list.remove(3);
		list.insert(4);
		list.insert(5);
		list.remove(1);

		assertTrue(!list.isEmpty());
		assertEquals(3, list.size());
		assertEquals(new Integer(2), list.getHead().getData());
		assertArrayEquals(new Integer[] {2, 4, 5}, list.toArray());

		assertEquals(null, list.search(1));
		assertEquals(new Integer(2), list.search(2));
		assertEquals(new Integer(5), list.search(5));

		list2.setHead(list.getHead());

		assertTrue(!list2.isEmpty());
		assertEquals(3, list2.size());
		assertEquals(new Integer(2), list2.getHead().getData());
		assertArrayEquals(new Integer[] {2, 4, 5}, list2.toArray());

		assertEquals(null, list2.search(1));
		assertEquals(new Integer(2), list2.search(2));
		assertEquals(new Integer(5), list2.search(5));
	}

}
