package adt.heap;

import java.util.Arrays;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Test1 {

	private MaxHeapImpl<Integer> heap;

	@Before
	public void before() {
		heap = new MaxHeapImpl<>();
	}
	
	@Test
	public void testInitialization() {

		Assert.assertTrue(null == heap.heapsort(null));
		Assert.assertTrue(heap.isEmpty());
		Assert.assertTrue(heap.extractRootElement() == null);
		Assert.assertTrue(heap.rootElement() == null);
		Assert.assertArrayEquals(new Integer[] {}, heap.toArray());
		
		heap.buildHeap(null);
		Assert.assertTrue(heap.isEmpty());
		Assert.assertTrue(heap.extractRootElement() == null);
		Assert.assertTrue(heap.rootElement() == null);
		Assert.assertArrayEquals(new Integer[] {}, heap.toArray());
		
		heap.insert(null);
		Assert.assertTrue(heap.isEmpty());
		Assert.assertTrue(heap.extractRootElement() == null);
		Assert.assertTrue(heap.rootElement() == null);
		Assert.assertArrayEquals(new Integer[] {}, heap.toArray());
		
	}
	
	@Test
	public void testInsert() {
		
		heap.insert(3);
		Assert.assertFalse(heap.isEmpty());
		Assert.assertEquals(new Integer(3),heap.rootElement());
		Assert.assertArrayEquals(new Integer[] {3}, heap.toArray());
		
		heap.insert(2);
		Assert.assertFalse(heap.isEmpty());
		Assert.assertEquals(new Integer(3),heap.rootElement());
		Assert.assertArrayEquals(new Integer[] {3, 2}, heap.toArray());
		
		heap.insert(4);
		Assert.assertFalse(heap.isEmpty());
		Assert.assertEquals(new Integer(4),heap.rootElement());
		Assert.assertArrayEquals(new Integer[] {4,2,3}, heap.toArray());
		
		heap.insert(5);
		Assert.assertFalse(heap.isEmpty());
		Assert.assertEquals(new Integer(5),heap.rootElement());
		Assert.assertArrayEquals(new Integer[] {5,4,3,2}, heap.toArray());
		
		heap.insert(1);
		Assert.assertFalse(heap.isEmpty());
		Assert.assertEquals(new Integer(5),heap.rootElement());
		Assert.assertArrayEquals(new Integer[] {5,4,3,2,1}, heap.toArray());
		
		heap.insert(8);
		Assert.assertFalse(heap.isEmpty());
		Assert.assertEquals(new Integer(8),heap.rootElement());
		Assert.assertArrayEquals(new Integer[] {8,4,5,2,1,3}, heap.toArray());
		
		heap.insert(6);
		Assert.assertFalse(heap.isEmpty());
		Assert.assertEquals(new Integer(8),heap.rootElement());
		Assert.assertArrayEquals(new Integer[] {8,4,6,2,1,3,5}, heap.toArray());
			
		heap.insert(7);
		Assert.assertFalse(heap.isEmpty());
		Assert.assertEquals(new Integer(8),heap.rootElement());
		Assert.assertArrayEquals(new Integer[] {8,7,6,4,1,3,5,2}, heap.toArray());
		
		heap.insert(9);
		Assert.assertFalse(heap.isEmpty());
		Assert.assertEquals(new Integer(9),heap.rootElement());
		Assert.assertArrayEquals(new Integer[] {9,8,6,7,1,3,5,2,4}, heap.toArray());
			
		heap.insert(10);
		Assert.assertFalse(heap.isEmpty());
		Assert.assertEquals(new Integer(10),heap.rootElement());
		Assert.assertArrayEquals(new Integer[] {10,9,6,7,8,3,5,2,4,1}, heap.toArray());
		
		heap.insert(0);
		heap.insert(-1);
		heap.insert(-2);
		heap.insert(-3);
		heap.insert(-4);
		heap.insert(-5);
		heap.insert(-6);
		heap.insert(-7);
		heap.insert(-8);
		heap.insert(-9);
		
		Assert.assertArrayEquals(new Integer[] {10,9,6,7,8,3,5,2,4,1,0,-1,-2,-3,-4,-5,-6,-7,-8,-9}, heap.toArray());
		
		heap.insert(-10);
		Assert.assertArrayEquals(new Integer[] {10,9,6,7,8,3,5,2,4,1,0,-1,-2,-3,-4,-5,-6,-7,-8,-9,-10}, heap.toArray());
		
		heap.insert(11);
		Assert.assertArrayEquals(new Integer[] {11,10,6,7,9,3,5,2,4,1,8,-1,-2,-3,-4,-5,-6,-7,-8,-9,-10,0}, heap.toArray());
		
		heap.insert(0);
		heap.insert(-1);
		heap.insert(-2);
		heap.insert(-3);
		heap.insert(-4);
		heap.insert(-5);
		heap.insert(-6);
		heap.insert(-7);
		
	}
	
	@Test
	public void testRemove(){
		
		heap.insert(3);
		heap.insert(10);
		heap.insert(1);
		heap.insert(15);
		heap.insert(-10);
		heap.insert(9);
		
		Assert.assertArrayEquals(new Integer[] {15,10,9,3,-10,1}, heap.toArray());
		
		Assert.assertEquals(new Integer(15), heap.extractRootElement());
		Assert.assertArrayEquals(new Integer[] {10,3,9,1,-10}, heap.toArray());
		
		Assert.assertEquals(new Integer(10), heap.extractRootElement());
		Assert.assertArrayEquals(new Integer[] {9,3,-10,1}, heap.toArray());
		
		Assert.assertEquals(new Integer(9), heap.extractRootElement());
		Assert.assertArrayEquals(new Integer[] {3,1,-10}, heap.toArray());
		
		Assert.assertEquals(new Integer(3), heap.extractRootElement());
		Assert.assertArrayEquals(new Integer[] {1,-10}, heap.toArray());
		
		Assert.assertEquals(new Integer(1), heap.extractRootElement());
		Assert.assertArrayEquals(new Integer[] {-10}, heap.toArray());
		
		Assert.assertEquals(new Integer(-10), heap.extractRootElement());
		Assert.assertArrayEquals(new Integer[] {}, heap.toArray());
		
		Assert.assertTrue(heap.isEmpty());
		Assert.assertTrue(null == heap.extractRootElement());
		
		heap.insert(3);
		heap.insert(1);
		Assert.assertArrayEquals(new Integer[] {3,1}, heap.toArray());
		heap.insert(100);
		Assert.assertArrayEquals(new Integer[] {100,1,3}, heap.toArray());
		heap.insert(32);
		Assert.assertArrayEquals(new Integer[] {100,32,3,1}, heap.toArray());
		heap.insert(0);
		Assert.assertArrayEquals(new Integer[] {100,32,3,1,0}, heap.toArray());
		heap.insert(99);
		Assert.assertArrayEquals(new Integer[] {100,32,99,1,0,3}, heap.toArray());
		heap.insert(13);
		Assert.assertArrayEquals(new Integer[] {100,32,99,1,0,3,13}, heap.toArray());
		heap.insert(34);
		Assert.assertArrayEquals(new Integer[] {100,34,99,32,0,3,13,1}, heap.toArray());
		heap.insert(21);
		Assert.assertArrayEquals(new Integer[] {100,34,99,32,0,3,13,1,21}, heap.toArray());
		
		Assert.assertEquals(new Integer(100), heap.rootElement());
		Assert.assertArrayEquals(new Integer[] {100,34,99,32,0,3,13,1,21}, heap.toArray());
		
		Assert.assertEquals(new Integer(100), heap.extractRootElement());
		Assert.assertArrayEquals(new Integer[] {99,34,21,32,0,3,13,1}, heap.toArray());
		
		Assert.assertEquals(new Integer(99), heap.extractRootElement());
		Assert.assertArrayEquals(new Integer[] {34,32,21,1,0,3,13}, heap.toArray());
		
		Assert.assertEquals(new Integer(34), heap.extractRootElement());
		Assert.assertArrayEquals(new Integer[] {32,13,21,1,0,3}, heap.toArray());
		
		Assert.assertEquals(new Integer(32), heap.extractRootElement());
		Assert.assertArrayEquals(new Integer[] {21,13,3,1,0}, heap.toArray());
		
		Assert.assertEquals(new Integer(21), heap.extractRootElement());
		Assert.assertArrayEquals(new Integer[] {13,1,3,0}, heap.toArray());

		Assert.assertEquals(new Integer(13), heap.extractRootElement());
		Assert.assertArrayEquals(new Integer[] {3,1,0}, heap.toArray());

		Assert.assertEquals(new Integer(3), heap.extractRootElement());
		Assert.assertArrayEquals(new Integer[] {1,0}, heap.toArray());
		
		Assert.assertEquals(new Integer(1), heap.extractRootElement());
		Assert.assertArrayEquals(new Integer[] {0}, heap.toArray());
		
		Assert.assertEquals(new Integer(0), heap.extractRootElement());
		Assert.assertArrayEquals(new Integer[] {}, heap.toArray());
		
		Assert.assertTrue(heap.isEmpty());
		Assert.assertTrue(null == heap.extractRootElement());	
		
	}
	
	@Test
	public void testBuildHeap(){
		
		Integer[] array = new Integer[] {1,2,3};
	
		heap.buildHeap(array);
		Assert.assertFalse(heap.isEmpty());
		Assert.assertEquals(new Integer(3), heap.rootElement());
		Assert.assertArrayEquals(new Integer[] {3,2,1},heap.toArray());
		
		Integer[] array2 = new Integer[] {1,2,3,null};
		
		heap.buildHeap(array2);
		Assert.assertFalse(heap.isEmpty());
		Assert.assertEquals(new Integer(3), heap.rootElement());
		Assert.assertArrayEquals(new Integer[] {3,2,1},heap.toArray());
		
		Integer[] array3 = new Integer[] {null,null,null};
		
		heap.buildHeap(array3);
		Assert.assertTrue(heap.isEmpty());
		Assert.assertTrue(null == heap.rootElement());
		Assert.assertArrayEquals(new Integer[] {},heap.toArray());
		
		Integer[] array4 = new Integer[] {1,2,3};
		
		heap.buildHeap(array4);
		Assert.assertFalse(heap.isEmpty());
		Assert.assertEquals(new Integer(3), heap.rootElement());
		Assert.assertArrayEquals(new Integer[] {3,2,1},heap.toArray());
		
		Assert.assertFalse(heap.isEmpty());
		
		heap.insert(5);
		Assert.assertFalse(heap.isEmpty());
		Assert.assertEquals(new Integer(5), heap.rootElement());
		Assert.assertArrayEquals(new Integer[] {5,3,1,2},heap.toArray());
		
		heap.insert(2);
		Assert.assertFalse(heap.isEmpty());
		Assert.assertEquals(new Integer(5), heap.rootElement());
		Assert.assertArrayEquals(new Integer[] {5,3,1,2,2},heap.toArray());
		
		heap.insert(7);
		Assert.assertFalse(heap.isEmpty());
		Assert.assertEquals(new Integer(7), heap.rootElement());
		Assert.assertArrayEquals(new Integer[] {7,3,5,2,2,1},heap.toArray());
		
		Assert.assertEquals(new Integer(7), heap.extractRootElement());
		Assert.assertArrayEquals(new Integer[] {5,3,1,2,2},heap.toArray());
		
		Assert.assertEquals(new Integer(5), heap.extractRootElement());
		Assert.assertArrayEquals(new Integer[] {3,2,1,2},heap.toArray());
		
		Assert.assertEquals(new Integer(3), heap.extractRootElement());
		Assert.assertArrayEquals(new Integer[] {2,2,1},heap.toArray());
		
		Assert.assertEquals(new Integer(2), heap.extractRootElement());
		Assert.assertArrayEquals(new Integer[] {2,1},heap.toArray());
		
		Assert.assertEquals(new Integer(2), heap.extractRootElement());
		Assert.assertArrayEquals(new Integer[] {1},heap.toArray());
		
		Assert.assertEquals(new Integer(1), heap.extractRootElement());
		Assert.assertArrayEquals(new Integer[] {},heap.toArray());
		
		Assert.assertTrue(null ==  heap.extractRootElement());
		Assert.assertArrayEquals(new Integer[] {},heap.toArray());
		
	}
	
	
	private static boolean isSorted(Integer[] v) {
		for (int i = 0; i < v.length - 1; i++)
			if (v[i] > v[i + 1])
				return false;
		return true;
	}

	@Test
	public void testSortRandom() {

		Random random = new Random();

		for (int i = 0; i <= 1000; i++) {
			Integer[] v = new Integer[i];
			for (int j = 0; j < i; j++)
				v[j] = random.nextInt(101);
			Integer[] v2 = heap.heapsort(v);
			Assert.assertTrue(isSorted(v2));
			Assert.assertArrayEquals(v, v);
		}
		
		heap.insert(3);
		Assert.assertFalse(heap.isEmpty());
		Assert.assertEquals(new Integer(3),heap.rootElement());
		Assert.assertArrayEquals(new Integer[] {3}, heap.toArray());
		
		heap.insert(2);
		Assert.assertFalse(heap.isEmpty());
		Assert.assertEquals(new Integer(3),heap.rootElement());
		Assert.assertArrayEquals(new Integer[] {3, 2}, heap.toArray());
		
		heap.insert(4);
		Assert.assertFalse(heap.isEmpty());
		Assert.assertEquals(new Integer(4),heap.rootElement());
		Assert.assertArrayEquals(new Integer[] {4,2,3}, heap.toArray());
		heap.insert(5);
		Assert.assertFalse(heap.isEmpty());
		Assert.assertEquals(new Integer(5),heap.rootElement());
		Assert.assertArrayEquals(new Integer[] {5,4,3,2}, heap.toArray());
		
		heap.insert(1);
		Assert.assertFalse(heap.isEmpty());
		Assert.assertEquals(new Integer(5),heap.rootElement());
		Assert.assertArrayEquals(new Integer[] {5,4,3,2,1}, heap.toArray());
		
		heap.insert(8);
		Assert.assertFalse(heap.isEmpty());
		Assert.assertEquals(new Integer(8),heap.rootElement());
		Assert.assertArrayEquals(new Integer[] {8,4,5,2,1,3}, heap.toArray());
		
		heap.insert(6);
		Assert.assertFalse(heap.isEmpty());
		Assert.assertEquals(new Integer(8),heap.rootElement());
		Assert.assertArrayEquals(new Integer[] {8,4,6,2,1,3,5}, heap.toArray());
			
		heap.insert(7);
		Assert.assertFalse(heap.isEmpty());
		Assert.assertEquals(new Integer(8),heap.rootElement());
		Assert.assertArrayEquals(new Integer[] {8,7,6,4,1,3,5,2}, heap.toArray());
		
		heap.insert(9);
		Assert.assertFalse(heap.isEmpty());
		Assert.assertEquals(new Integer(9),heap.rootElement());
		Assert.assertArrayEquals(new Integer[] {9,8,6,7,1,3,5,2,4}, heap.toArray());
			
		heap.insert(10);
		Assert.assertFalse(heap.isEmpty());
		Assert.assertEquals(new Integer(10),heap.rootElement());
		Assert.assertArrayEquals(new Integer[] {10,9,6,7,8,3,5,2,4,1}, heap.toArray());
		
		heap.insert(0);
		heap.insert(-1);
		heap.insert(-2);
		heap.insert(-3);
		heap.insert(-4);
		heap.insert(-5);
		heap.insert(-6);
		heap.insert(-7);
		heap.insert(-8);
		heap.insert(-9);
		
		Assert.assertArrayEquals(new Integer[] {10,9,6,7,8,3,5,2,4,1,0,-1,-2,-3,-4,-5,-6,-7,-8,-9}, heap.toArray());
		
		heap.insert(-10);
		Assert.assertArrayEquals(new Integer[] {10,9,6,7,8,3,5,2,4,1,0,-1,-2,-3,-4,-5,-6,-7,-8,-9,-10}, heap.toArray());
		
		heap.insert(11);
		Assert.assertArrayEquals(new Integer[] {11,10,6,7,9,3,5,2,4,1,8,-1,-2,-3,-4,-5,-6,-7,-8,-9,-10,0}, heap.toArray());
		
		heap.insert(0);
		heap.insert(-1);
		heap.insert(-2);
		heap.insert(-3);
		heap.insert(-4);
		heap.insert(-5);
		heap.insert(-6);
		heap.insert(-7);
		

	}

}
