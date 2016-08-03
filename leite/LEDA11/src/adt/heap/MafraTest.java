package adt.heap;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;

import org.junit.Test;
import org.junit.Before;

public class MafraTest {
	
public MaxHeapImpl<Integer> heap;
	
	@Before
	public void initialize() {
		heap = new MaxHeapImpl<Integer> ();
	}
	
	@Test
	public void testInsertAndRoot(){
		Assert.assertTrue(heap.isEmpty());
		Assert.assertTrue(heap.rootElement() == null);
		heap.insert(10);
		Assert.assertTrue(heap.rootElement().equals(10));
		Assert.assertFalse(heap.isEmpty());
		heap.insert(10);
		Assert.assertArrayEquals(new Integer[] {10, 10}, heap.toArray());
		Assert.assertTrue(heap.rootElement().equals(10));
		heap.insert(11);
		Assert.assertTrue(heap.rootElement().equals(11));
		heap.insert(9);
		Assert.assertTrue(heap.rootElement().equals(11));
		heap.insert(8);
		heap.insert(null);
		heap.insert(6);
		heap.insert(5);
		heap.insert(11);
		heap.insert(27);
		heap.insert(19);
		heap.insert(7);
		heap.insert(2);
		heap.insert(1);
		Assert.assertTrue(heap.rootElement().equals(27));
		heap.insert(6);
		heap.insert(6);
		heap.insert(6);
		heap.insert(null);
		heap.insert(null);
		heap.insert(6);
		heap.insert(6);
		heap.insert(6);
		heap.insert(6);
		heap.insert(6); // inseriu 21
		Assert.assertTrue(heap.rootElement().equals(27));
		heap.insert(40);
		Assert.assertTrue(heap.rootElement().equals(40));
		heap.extractRootElement();
		Assert.assertTrue(heap.rootElement().equals(27));
		heap.extractRootElement();
		Assert.assertTrue(heap.rootElement().equals(19));
		heap.extractRootElement();
		heap.extractRootElement();
		heap.extractRootElement();
		heap.extractRootElement();
		heap.insert(null);
		heap.extractRootElement();
		heap.extractRootElement();
		heap.extractRootElement();
		heap.extractRootElement();
		heap.extractRootElement();
		heap.extractRootElement();
		heap.extractRootElement();
		heap.extractRootElement();
		heap.extractRootElement();
		heap.extractRootElement();
		heap.extractRootElement();
		heap.extractRootElement();
		heap.extractRootElement();
		heap.extractRootElement();
		heap.insert(null);
		heap.extractRootElement();
		Assert.assertTrue(heap.extractRootElement().equals(1));
		Assert.assertTrue(heap.isEmpty());	
	}
	
	@Test
	public void testaBuilderAndSort(){
		Integer[] array = {null,18, 1,null, 0, 15, 20, -1, 1, 14, 16, 2, 5, 6, 7,null};
		heap.buildHeap(array);
		Assert.assertTrue(heap.rootElement().equals(20));
		Assert.assertTrue(heap.extractRootElement().equals(20));
		Assert.assertTrue(heap.extractRootElement().equals(18));
		Assert.assertTrue(heap.extractRootElement().equals(16));
		Assert.assertTrue(heap.extractRootElement().equals(15));
		Assert.assertTrue(heap.extractRootElement().equals(14));
		Assert.assertTrue(heap.extractRootElement().equals(7));
		Assert.assertTrue(heap.extractRootElement().equals(6));
		Assert.assertTrue(heap.extractRootElement().equals(5));
		Assert.assertTrue(heap.extractRootElement().equals(2));
		Assert.assertTrue(heap.extractRootElement().equals(1));
		Assert.assertTrue(heap.extractRootElement().equals(1));
		Assert.assertTrue(heap.extractRootElement().equals(0));
		Assert.assertTrue(heap.extractRootElement().equals(-1));
		
		Assert.assertArrayEquals(new Integer[] {-1, 0, 1, 1, 2, 5, 6, 7, 14, 15, 16, 18, 20}, heap.heapsort(array));
		
		
		Integer[] array2 = {null, null, null};
		heap.buildHeap(array2);
		Assert.assertTrue(heap.rootElement() == null);
		Assert.assertArrayEquals(new Integer[] {}, heap.toArray());
		Assert.assertArrayEquals(new Integer[] {}, heap.heapsort(array2));
		
		Integer[] array3 = {1, null};
		heap.buildHeap(array3);
		Assert.assertTrue(heap.rootElement().equals(1));
		Assert.assertArrayEquals(new Integer[] {1}, heap.toArray());
		Assert.assertArrayEquals(new Integer[] {1}, heap.heapsort(array3));
		heap.extractRootElement();
		Assert.assertTrue(heap.isEmpty());
		
		Integer[] array4 = {4,null, 4};
		heap.buildHeap(array4);
		Assert.assertTrue(heap.rootElement().equals(4));
		Assert.assertArrayEquals(new Integer[] {4, 4}, heap.toArray());
		heap.extractRootElement();
		Assert.assertArrayEquals(new Integer[] {4}, heap.toArray());
		Assert.assertArrayEquals(new Integer[] {4, 4}, heap.heapsort(array4));
		Assert.assertTrue(heap.isEmpty());
		
	}
}
