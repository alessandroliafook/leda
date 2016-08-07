package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class TestSingle {

	
	private SingleLinkedListImpl<Integer> linked;
	
	@Before
	public void before(){
		
		linked = new SingleLinkedListImpl<Integer>();
		
	}
	
	@Test
	public void testInsertRemove(){
		
		Assert.assertTrue(linked.isEmpty());
		Assert.assertEquals(0, linked.size());
		
		linked.insert(1);
	
		Assert.assertFalse(linked.isEmpty());
		Assert.assertEquals(1, linked.size());
		Assert.assertArrayEquals(new Integer[] {1}, linked.toArray());

		Assert.assertEquals(new SingleLinkedListNode<>(1,null), linked.getHead());
		
		linked.insert(1);
		linked.insert(1);
		
		Assert.assertFalse(linked.isEmpty());
		Assert.assertEquals(3, linked.size());
		Assert.assertArrayEquals(new Integer[] {1,1,1}, linked.toArray());
		
		linked.insert(3);
		linked.insert(4);
		linked.insert(2);
		
		Assert.assertEquals(new SingleLinkedListNode<>(1,null), linked.getHead());
		
		Assert.assertFalse(linked.isEmpty());
		Assert.assertEquals(6, linked.size());
		Assert.assertArrayEquals(new Integer[] {1,1,1,3,4,2}, linked.toArray());
	
		linked.remove(1);
		
		Assert.assertFalse(linked.isEmpty());
		Assert.assertEquals(5, linked.size());
		Assert.assertArrayEquals(new Integer[] {1,1,3,4,2}, linked.toArray());
		
		linked.remove(2);
		
		Assert.assertFalse(linked.isEmpty());
		Assert.assertEquals(4, linked.size());
		Assert.assertArrayEquals(new Integer[] {1,1,3,4}, linked.toArray());
		
		linked.remove(2);
		
		Assert.assertFalse(linked.isEmpty());
		Assert.assertEquals(4, linked.size());
		Assert.assertArrayEquals(new Integer[] {1,1,3,4}, linked.toArray());
		
		linked.remove(3);
		
		Assert.assertFalse(linked.isEmpty());
		Assert.assertEquals(3, linked.size());
		Assert.assertArrayEquals(new Integer[] {1,1,4}, linked.toArray());
	
		linked.remove(1);
		linked.remove(1);
		linked.remove(1);
		linked.remove(1);
		
		Assert.assertEquals(1, linked.size());
		Assert.assertEquals(new Integer (4), linked.search(4));
		
		linked.remove(4);
		
		Assert.assertEquals(null, linked.search(4));

		Assert.assertTrue(linked.isEmpty());
		Assert.assertEquals(0, linked.size());
		Assert.assertArrayEquals(new Integer[] {}, linked.toArray());
		
		linked.remove(4);
		
		linked.insert(10);
		Assert.assertFalse(linked.isEmpty());
		Assert.assertEquals(1, linked.size());
		Assert.assertEquals(new Integer (10), linked.search(10));
		Assert.assertEquals(new SingleLinkedListNode<>(10,null), linked.getHead());
		
		linked.insert(10);
		linked.insert(100);
		Assert.assertEquals(3, linked.size());
		
	}
	
	@Test
	public void testSearch(){
		

		linked.insert(1);
		linked.insert(1);
		linked.insert(1);
		
		linked.insert(3);
		linked.insert(4);
		linked.insert(2);
		
		Assert.assertTrue(null == linked.search(10));
		Assert.assertEquals(new Integer (1), linked.search(1));
		Assert.assertEquals(new Integer (4), linked.search(4));
		Assert.assertEquals(new Integer (2), linked.search(2));
		
		linked.remove(4);
		
		linked.remove(4);
		Assert.assertTrue(null == linked.search(4));
		
		linked.insert(10);

		Assert.assertEquals(new Integer (10), linked.search(10));
		Assert.assertEquals(new SingleLinkedListNode<>(1,null), linked.getHead());
		
		linked.insert(10);
		linked.insert(100);
		
		
	}
	
}