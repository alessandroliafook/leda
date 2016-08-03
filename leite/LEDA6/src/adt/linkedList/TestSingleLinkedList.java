package adt.linkedList;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class TestSingleLinkedList {

	@Test
	public void testBase(){
		LinkedList<Integer> lList = new SingleLinkedListImpl<Integer>();
		Assert.assertTrue(lList.isEmpty());
		Assert.assertEquals(0, lList.size());
		lList.insert(1);
		System.out.println(Arrays.toString(lList.toArray()));

		Assert.assertFalse(lList.isEmpty());
		Assert.assertEquals(1, lList.size());
		lList.insert(1);
		lList.insert(1);
		lList.insert(3);
		lList.insert(4);
		lList.insert(2);
		System.out.println("Adicionados 1,1,3,4,2");

		System.out.println(Arrays.toString(lList.toArray()));
		lList.remove(1);
		System.out.println("Removido 1");

		System.out.println(Arrays.toString(lList.toArray()));
		lList.remove(2);
		System.out.println(Arrays.toString(lList.toArray()));
		lList.remove(2);
		System.out.println(Arrays.toString(lList.toArray()));
		lList.remove(3);
		System.out.println(Arrays.toString(lList.toArray()));

		lList.remove(1);
		lList.remove(1);
		lList.remove(1);
		lList.remove(1);
		System.out.println(Arrays.toString(lList.toArray()));
		Assert.assertEquals(1, lList.size());
		Assert.assertEquals(new Integer (4), lList.search(4));
		lList.remove(4);
		Assert.assertEquals(null, lList.search(4));

		Assert.assertTrue(lList.isEmpty());
		Assert.assertEquals(0, lList.size());
		lList.remove(4);
		lList.insert(10);
		Assert.assertFalse(lList.isEmpty());
		Assert.assertEquals(1, lList.size());
		System.out.println(Arrays.toString(lList.toArray()));
		Assert.assertEquals(new Integer (10), lList.search(10));



	}
}