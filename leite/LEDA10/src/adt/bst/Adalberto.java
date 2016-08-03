package adt.bst;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import adt.bst.BST;
import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.BTNode;

public class Adalberto {

	private BST<Integer> bst;

	@Before
	public void before() {
		bst = new BSTImpl<>();
	}

	@Test
	public void testInsertHeightAndSize() {
		bst.insert(10);
		Assert.assertTrue(bst.height() == 0);
		Assert.assertTrue(bst.size() == 1);
		bst.insert(8);
		Assert.assertTrue(bst.height() == 1);
		Assert.assertTrue(bst.size() == 2);
		bst.insert(5);
		Assert.assertTrue(bst.height() == 2);
		Assert.assertTrue(bst.size() == 3);
		bst.insert(9);
		Assert.assertTrue(bst.height() == 2);
		Assert.assertTrue(bst.size() == 4);
		bst.insert(14);
		Assert.assertTrue(bst.height() == 2);
		Assert.assertTrue(bst.size() == 5);
		bst.insert(12);
		Assert.assertTrue(bst.height() == 2);
		Assert.assertTrue(bst.size() == 6);
		bst.insert(20);
		Assert.assertTrue(bst.height() == 2);
		Assert.assertTrue(bst.size() == 7);
		bst.insert(11);
		Assert.assertTrue(bst.height() == 3);
		Assert.assertTrue(bst.size() == 8);
		bst.insert(15);
		Assert.assertTrue(bst.height() == 3);
		Assert.assertTrue(bst.size() == 9);
		bst.insert(21);
		Assert.assertTrue(bst.height() == 3);
		Assert.assertTrue(bst.size() == 10);
		bst.insert(22);
		Assert.assertTrue(bst.height() == 4);
		Assert.assertTrue(bst.size() == 11);
	}
	
	@Test
	public void testRemoveMinimumAndMaximum(){
		bst.insert(10);
		Assert.assertTrue(bst.maximum().getData() == 10);
		Assert.assertTrue(bst.minimum().getData() == 10);
		bst.remove(10);
		bst.insert(10);
		bst.insert(8);
		Assert.assertTrue(bst.maximum().getData() == 10);
		Assert.assertTrue(bst.minimum().getData() == 8);
		bst.insert(5);
		Assert.assertTrue(bst.maximum().getData() == 10);
		Assert.assertTrue(bst.minimum().getData() == 5);
		bst.insert(9);
		Assert.assertTrue(bst.maximum().getData() == 10);
		Assert.assertTrue(bst.minimum().getData() == 5);
		bst.insert(14);
		Assert.assertTrue(bst.maximum().getData() == 14);
		Assert.assertTrue(bst.minimum().getData() == 5);
		bst.insert(12);
		Assert.assertTrue(bst.maximum().getData() == 14);
		Assert.assertTrue(bst.minimum().getData() == 5);
		bst.insert(20);
		Assert.assertTrue(bst.maximum().getData() == 20);
		Assert.assertTrue(bst.minimum().getData() == 5);
		bst.insert(11);
		Assert.assertTrue(bst.maximum().getData() == 20);
		Assert.assertTrue(bst.minimum().getData() == 5);
		bst.insert(15);
		Assert.assertTrue(bst.maximum().getData() == 20);
		Assert.assertTrue(bst.minimum().getData() == 5);
		bst.insert(21);
		Assert.assertTrue(bst.maximum().getData() == 21);
		Assert.assertTrue(bst.minimum().getData() == 5);
		bst.insert(22);
		Assert.assertTrue(bst.maximum().getData() == 22);
		Assert.assertTrue(bst.minimum().getData() == 5);
		
		bst.remove(22);
		Assert.assertTrue(bst.maximum().getData() == 21);
		bst.remove(5);
		Assert.assertTrue(bst.minimum().getData() == 8);
		
	}
	@Test
	public void RemoveSoRaiz(){
		bst.insert(10);
		Assert.assertArrayEquals(new Integer[] {10}, bst.order());
		bst.remove(10);
		Assert.assertArrayEquals(new Integer[] {}, bst.order());
		Assert.assertTrue(bst.getRoot().getData() == null);
		Assert.assertTrue(bst.getRoot().getRight() == null);
		Assert.assertTrue(bst.getRoot().getLeft() == null);
	}
	
	@Test
	public void testRemove(){
		bst.insert(10);
		bst.insert(8);	
		bst.insert(5);	
		bst.insert(9);
		bst.insert(14);	
		bst.insert(12);	
		bst.insert(20);	
		bst.insert(11);
		bst.insert(15);
		bst.insert(21);
		bst.insert(22);
		bst.insert(null);
		bst.insert(5);          //
		bst.insert(11);      // ja existem
		
		Assert.assertArrayEquals(new Integer[] {5, 8, 9, 10, 11, 12, 14, 15, 20, 21, 22}, bst.order());
		bst.remove(11);
		Assert.assertArrayEquals(new Integer[] {5, 8, 9, 10,12, 14, 15, 20, 21, 22}, bst.order());
		bst.remove(5);
		Assert.assertArrayEquals(new Integer[] {8, 9, 10,12, 14, 15, 20, 21, 22}, bst.order());
		bst.remove(10);
		Assert.assertArrayEquals(new Integer[] {8, 9, 12, 14, 15, 20, 21, 22}, bst.order());
		Assert.assertTrue(bst.getRoot().getData() == 12);
		bst.insert(10);
		Assert.assertArrayEquals(new Integer[] {8, 9, 10, 12, 14, 15, 20, 21, 22}, bst.order());
		Assert.assertTrue(bst.getRoot().getData() == 12);
		bst.remove(10);
		bst.remove(14);
		Assert.assertArrayEquals(new Integer[] {8, 9, 12, 15, 20, 21, 22}, bst.order());
		bst.remove(8);
		bst.remove(9);
		bst.remove(12);
		bst.remove(15);
		bst.remove(20);
		bst.remove(21);
		bst.remove(22);
		Assert.assertArrayEquals(new Integer[] {}, bst.order());
		Assert.assertTrue(bst.getRoot().isEmpty());
		Assert.assertTrue(bst.maximum() == null);
		Assert.assertTrue(bst.minimum() == null);
		bst.insert(20);
		Assert.assertFalse(bst.getRoot().isEmpty());
		bst.remove(21);
		bst.remove(null);
		Assert.assertArrayEquals(new Integer[] {20}, bst.order());

		
	}
	
	@Test
	public void testSearch(){
		bst.insert(10);
		bst.insert(8);	
		bst.insert(5);	
		bst.insert(9);
		bst.insert(14);	
		bst.insert(12);	
		bst.insert(20);	
		bst.insert(11);
		bst.insert(15);
		bst.insert(21);
		bst.insert(22);
		bst.insert(null);
		bst.insert(5);          //
		bst.insert(11);
		Assert.assertTrue(bst.search(10).getData() == 10);
		Assert.assertTrue(bst.search(8).getData() == 8);
		Assert.assertTrue(bst.search(11).getData() == 11);
		Assert.assertTrue(bst.search(null) == null);
		Assert.assertTrue(bst.search(26).equals(new BSTNode<Integer>()));
		bst.remove(11);
		Assert.assertTrue(bst.search(11).equals(new BSTNode<Integer>()));
		bst.remove(10);
		Assert.assertTrue(bst.search(10).equals(new BSTNode<Integer>()));
	}
	


	@Test
	public void testHeight() {

		Assert.assertEquals(-1, bst.height());
		bst.insert(1);
		Assert.assertEquals(0, bst.height());
		Assert.assertArrayEquals(new Integer[] { 1 }, bst.order());

		bst.insert(2);
		Assert.assertEquals(1, bst.height());
		Assert.assertArrayEquals(new Integer[] { 1, 2 }, bst.order());
		bst.insert(3);
		Assert.assertEquals(2, bst.height());
		Assert.assertArrayEquals(new Integer[] { 1, 2, 3 }, bst.order());
		bst.insert(10);
		Assert.assertEquals(3, bst.height());
		Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 10 }, bst.order());
		bst.insert(8);
		Assert.assertEquals(4, bst.height());
		Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 8, 10 }, bst.order());
		bst.insert(4);
		Assert.assertEquals(5, bst.height());
		Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4, 8, 10 },
				bst.order());
		bst.insert(0);
		Assert.assertEquals(5, bst.height());
		Assert.assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4, 8, 10 },
				bst.order());
		bst.insert(198);
		Assert.assertEquals(5, bst.height());
		Assert.assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4, 8, 10, 198 },
				bst.order());
		
		
		
		
		

	}

	@Test
	public void testOrdering() {

		bst.insert(1);
		Assert.assertArrayEquals(new Integer[] { 1 }, bst.order());
		Assert.assertArrayEquals(new Integer[] { 1 }, bst.order());
		Assert.assertArrayEquals(new Integer[] { 1 }, bst.order());

		bst.insert(2);
		Assert.assertArrayEquals(new Integer[] { 1, 2 }, bst.order());
		Assert.assertArrayEquals(new Integer[] { 1, 2 }, bst.preOrder());
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, bst.postOrder());

		bst.insert(3);
		Assert.assertArrayEquals(new Integer[] { 1, 2, 3 }, bst.order());
		Assert.assertArrayEquals(new Integer[] { 1, 2, 3 }, bst.preOrder());
		Assert.assertArrayEquals(new Integer[] { 3, 2, 1 }, bst.postOrder());

		bst.insert(10);
		Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 10 }, bst.order());
		Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 10 }, bst.preOrder());
		Assert.assertArrayEquals(new Integer[] { 10, 3, 2, 1 }, bst.postOrder());

		bst.insert(8);
		Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 8, 10 }, bst.order());
		Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 10, 8 },
				bst.preOrder());
		Assert.assertArrayEquals(new Integer[] { 8, 10, 3, 2, 1 },
				bst.postOrder());

		bst.insert(4);
		Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4, 8, 10 },
				bst.order());
		Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 10, 8, 4 },
				bst.preOrder());
		Assert.assertArrayEquals(new Integer[] { 4, 8, 10, 3, 2, 1 },
				bst.postOrder());

		bst.insert(0);
		Assert.assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4, 8, 10 },
				bst.order());
		Assert.assertArrayEquals(new Integer[] { 1, 0, 2, 3, 10, 8, 4 },
				bst.preOrder());
		Assert.assertArrayEquals(new Integer[] { 0, 4, 8, 10, 3, 2, 1 },
				bst.postOrder());

		bst.insert(198);
		Assert.assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4, 8, 10, 198 },
				bst.order());
		Assert.assertArrayEquals(new Integer[] { 1, 0, 2, 3, 10, 8, 4, 198 },
				bst.preOrder());
		Assert.assertArrayEquals(new Integer[] { 0, 4, 8, 198, 10, 3, 2, 1 },
				bst.postOrder());

	}
	
	@Test
	public void testaEspecial(){
		bst.insert(15);
		bst.insert(10);
		bst.insert(20);
		bst.insert(7);
		bst.insert(11);
		bst.insert(21);
		bst.insert(22);
		bst.insert(19);
		bst.insert(23);
		Assert.assertArrayEquals(new Integer[] { 7, 10, 11,15,19, 20, 21, 22, 23 },
				bst.order());
		
		bst.remove(21);
		
		Assert.assertArrayEquals(new Integer[] { 7, 10, 11,15,19, 20, 22, 23 },
				bst.order());
		
		bst.remove(20);
		Assert.assertArrayEquals(new Integer[] { 7, 10, 11,15,19, 22, 23 },
				bst.order());
		
		
	}

}

