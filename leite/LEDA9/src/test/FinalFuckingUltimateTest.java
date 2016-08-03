package test;

import java.util.Comparator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.extended.ExtendedSingleLinkedListImpl;

public class FinalFuckingUltimateTest {

	private SingleLinkedListImpl<Integer> lista1;
	private ExtendedSingleLinkedListImpl<Integer> lista2;
	private Comparator comp;

	@Before
	public void before() {
		comp = new Comp2();
		lista1 = new SingleLinkedListImpl<>();
		lista2 = new ExtendedSingleLinkedListImpl<>(comp);

	}

	@Test
	public void test() {

		lista1.insert(2);
		lista1.insert(3);
		lista1.insert(4);
		lista1.insert(5);

		lista2.insert(2);
		lista2.insert(3);
		lista2.insert(4);
		lista2.insert(5);
		lista2.insert(5);
		lista2.insert(5);

		Assert.assertEquals(lista1.size(), lista2.size() - 2);
		Assert.assertEquals(lista1.getHead(), lista2.getHead());

		Assert.assertEquals(new Integer(5), lista2.minimum());
		lista2.insert(100);
		Assert.assertEquals(new Integer(100), lista2.minimum());

		lista1.remove(5);
		Assert.assertEquals(3, lista1.size());

		lista2.removeAll(2);
		Assert.assertEquals(7, lista2.size());
		Assert.assertArrayEquals(new Integer[] { 2, 3, 4, 5, 5, 5, 100 },
				lista2.toArray());
		
		lista2.removeAll(4);
		Assert.assertEquals(5, lista2.size());
		Assert.assertArrayEquals(new Integer[] { 4, 5, 5, 5, 100 },
				lista2.toArray());
		
		lista2.removeAll(5);
		Assert.assertEquals(4, lista2.size());
		Assert.assertArrayEquals(new Integer[] {5, 5, 5, 100 },
				lista2.toArray());
		
		lista2.removeAll(100);
		Assert.assertEquals(1, lista2.size());
		Assert.assertArrayEquals(new Integer[] {100 },
				lista2.toArray());
		
		Assert.assertTrue(null == lista2.search(100));
		Assert.assertTrue(100 == lista2.search(101));
		Assert.assertTrue(null == lista1.search(100));
		Assert.assertTrue(null == lista1.search(101));
		Assert.assertTrue(2 == lista1.search(2));
		Assert.assertTrue(3 == lista1.search(3));
	}

}
