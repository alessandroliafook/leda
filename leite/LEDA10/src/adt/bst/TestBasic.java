package adt.bst;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import adt.bst.BST;
import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.BTNode;

public class TestBasic {

	private BST<Integer> bst;

	@Before
	public void before() {
		bst = new BSTImpl<>();
	}

	@Test
	public void testBasics() {
		
		
		BTNode<Integer> bt = new BSTNode<Integer>();
		BTNode<Integer> btMax = new BSTNode<Integer>();
		BTNode<Integer> btMin = new BSTNode<Integer>();
		Assert.assertEquals(-1, bst.height());
		Assert.assertEquals(null, bst.maximum());
		Assert.assertEquals(null, bst.minimum());

		Assert.assertEquals(bt, bst.search(1));
		bst.insert(1);
		bt.setData(1);
		btMax.setData(1);
		btMin.setData(1);

		Assert.assertEquals(bt, bst.search(1));
		Assert.assertEquals(1, bst.size());
		Assert.assertArrayEquals(new Integer[] { 1 }, bst.order());
		Assert.assertEquals(btMax, bst.maximum());
		Assert.assertEquals(btMin, bst.minimum());

		bst.insert(2);
		bt.setData(2);
		btMax.setData(2);
		Assert.assertEquals(bt, bst.search(2));
		Assert.assertEquals(2, bst.size());
		Assert.assertArrayEquals(new Integer[] { 1, 2 }, bst.order());
		Assert.assertEquals(btMax, bst.maximum());
		Assert.assertEquals(btMin, bst.minimum());

		bst.insert(3);
		bt.setData(3);
		btMax.setData(3);
		Assert.assertEquals(bt, bst.search(3));
		Assert.assertEquals(3, bst.size());
		Assert.assertArrayEquals(new Integer[] { 1, 2, 3 }, bst.order());
		Assert.assertEquals(btMax, bst.maximum());
		Assert.assertEquals(btMin, bst.minimum());

		bst.insert(10);
		bt.setData(10);
		btMax.setData(10);
		Assert.assertEquals(bt, bst.search(10));
		Assert.assertEquals(4, bst.size());
		Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 10 }, bst.order());
		Assert.assertEquals(btMax, bst.maximum());
		Assert.assertEquals(btMin, bst.minimum());

		bst.insert(8);
		bt.setData(8);
		Assert.assertEquals(bt, bst.search(8));
		Assert.assertEquals(5, bst.size());
		Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 8, 10 }, bst.order());
		Assert.assertEquals(btMax, bst.maximum());
		Assert.assertEquals(btMin, bst.minimum());

		bst.insert(4);
		bt.setData(4);
		Assert.assertEquals(bt, bst.search(4));
		Assert.assertEquals(6, bst.size());
		Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4, 8, 10 },
				bst.order());
		Assert.assertEquals(btMax, bst.maximum());
		Assert.assertEquals(btMin, bst.minimum());

		bst.insert(0);
		bt.setData(0);
		btMin.setData(0);
		Assert.assertEquals(bt, bst.search(0));
		Assert.assertEquals(7, bst.size());
		Assert.assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4, 8, 10 },
				bst.order());
		Assert.assertEquals(btMax, bst.maximum());
		Assert.assertEquals(btMin, bst.minimum());

		bst.insert(198);
		bt.setData(198);
		btMax.setData(198);
		Assert.assertEquals(bt, bst.search(198));
		Assert.assertEquals(8, bst.size());
		Assert.assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4, 8, 10, 198 },
				bst.order());
		Assert.assertEquals(btMax, bst.maximum());
		Assert.assertEquals(btMin, bst.minimum());
		
		bst.insert(9);
		bt.setData(9);
		Assert.assertEquals(bt, bst.search(9));
		Assert.assertEquals(9, bst.size());
		Assert.assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4, 8, 9, 10, 198 },
				bst.order());
		Assert.assertEquals(btMax, bst.maximum());
		Assert.assertEquals(btMin, bst.minimum());
		
		
		bt.setData(8);
		Assert.assertEquals(bt,bst.sucessor(4));
	
		Assert.assertTrue(bst.sucessor(198) == null);
	
		bt.setData(2);
		Assert.assertEquals(bt,bst.sucessor(1));
		
		bt.setData(10);
		Assert.assertEquals(bt,bst.sucessor(9));
		
		
		bt.setData(3);
		Assert.assertEquals(bt,bst.predecessor(4));
	
		Assert.assertTrue(bst.predecessor(0) == null);
	
		bt.setData(0);
		Assert.assertEquals(bt,bst.predecessor(1));
		
		bt.setData(9);
		Assert.assertEquals(bt,bst.predecessor(10));
	
		
		bst.insert(9);
		Assert.assertEquals(9, bst.size());
		Assert.assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4, 8, 9, 10, 198 },
				bst.order());
		Assert.assertEquals(btMax, bst.maximum());
		Assert.assertEquals(btMin, bst.minimum());
		
		bst.insert(0);
		Assert.assertEquals(9, bst.size());
		Assert.assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4, 8, 9, 10, 198 },
				bst.order());
		Assert.assertEquals(btMax, bst.maximum());
		Assert.assertEquals(btMin, bst.minimum());
		
		
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
		
		
		
		bst = new BSTImpl<>();
		Assert.assertEquals(-1, bst.height());
		
		bst.insert(1);
		Assert.assertEquals(0, bst.height());
		
		bst.insert(2);
		bst.insert(3);
		bst.insert(-1);
		Assert.assertEquals(2, bst.height());
		
		bst.insert(5);
		bst.insert(6);
		Assert.assertEquals(4, bst.height());
		
		bst.insert(4);
		Assert.assertEquals(4, bst.height());
		
		bst.insert(-2);	
		bst.insert(-7);	
		bst.insert(-5);	
		bst.insert(-20);
		bst.insert(-15);	
		
		Assert.assertEquals(5, bst.height());
		
		bst.remove(-1);
		Assert.assertEquals(4, bst.height());
		
		bst.remove(1);
		Assert.assertEquals(4, bst.height());
		
		bst.remove(-5);
		Assert.assertEquals(4, bst.height());
		
		
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
	public void testRemove1(){
		

		bst.insert(null);
		bst.remove(null);
		
		bst.insert(1);
		bst.insert(3);
		bst.insert(2);
		bst.insert(0);

		Assert.assertEquals(4, bst.size());
		Assert.assertArrayEquals(new Integer[] { 0, 1, 2 ,3}, bst.order());

		bst.remove(1);
		Assert.assertEquals(3, bst.size());
		Assert.assertArrayEquals(new Integer[] { 0, 2 ,3}, bst.order());
	
		bst.insert(1);
		bst.insert(3);
		bst.insert(2);
		bst.insert(0);
		bst.insert(null);
		bst.remove(null);
		Assert.assertEquals(4, bst.size());
		Assert.assertArrayEquals(new Integer[] { 0, 1,  2 ,3}, bst.order());
		
		bst.remove(0);
		Assert.assertEquals(3, bst.size());
		Assert.assertArrayEquals(new Integer[] { 1,  2 ,3}, bst.order());
		
		bst.remove(1);
		Assert.assertEquals(2, bst.size());
		Assert.assertArrayEquals(new Integer[] {2 ,3}, bst.order());
		
		bst.remove(2);
		Assert.assertEquals(1, bst.size());
		Assert.assertArrayEquals(new Integer[] {3}, bst.order());
	
		bst.remove(3);
		Assert.assertEquals(0, bst.size());
		Assert.assertArrayEquals(new Integer[] {}, bst.order());
		Assert.assertEquals(new BTNode<>(null,null,null,null),bst.search(3));
		bst.remove(3);
		Assert.assertEquals(0, bst.size());
		Assert.assertArrayEquals(new Integer[] {}, bst.order());

	}

	@Test
	public void testRemove2(){
		
		bst.insert(5);
		bst.insert(1);
		bst.insert(7);
		bst.insert(-2);
		bst.insert(4);
		bst.insert(0);
		bst.insert(6);
		bst.insert(10);
		bst.insert(8);
		bst.insert(9);
		bst.insert(15);
		
		Assert.assertEquals(new BTNode<>(15,null,null,null), bst.maximum());
		Assert.assertEquals(new BTNode<>(-2,null,null,null), bst.minimum());
		Assert.assertEquals(new BTNode<>(7,null,null,null), bst.sucessor(6));
		Assert.assertEquals(new BTNode<>(5,null,null,null), bst.predecessor(6));
		Assert.assertArrayEquals(new Integer[] {-2,0,1,4,5,6,7,8,9,10,15}, bst.order());
		Assert.assertArrayEquals(new Integer[] {5,1,-2,0,4,7,6,10,8,9,15}, bst.preOrder());
		Assert.assertArrayEquals(new Integer[] {0,-2,4,1,6,9,8,15,10,7,5}, bst.postOrder());
		Assert.assertEquals(4, bst.height());
		
		bst.remove(7);
	
		Assert.assertEquals(new BTNode<>(15,null,null,null), bst.maximum());
		Assert.assertEquals(new BTNode<>(-2,null,null,null), bst.minimum());
		Assert.assertEquals(new BTNode<>(8,null,null,null), bst.sucessor(6));
		Assert.assertEquals(new BTNode<>(5,null,null,null), bst.predecessor(6));
		Assert.assertArrayEquals(new Integer[] {-2,0,1,4,5,6,8,9,10,15}, bst.order());
		Assert.assertArrayEquals(new Integer[] {5,1,-2,0,4,8,6,10,9,15}, bst.preOrder());
		Assert.assertArrayEquals(new Integer[] {0,-2,4,1,6,9,15,10,8,5}, bst.postOrder());
		Assert.assertEquals(3, bst.height());
		
	
		Assert.assertEquals(new BTNode<>(9,null,null,null), bst.sucessor(8));
		Assert.assertEquals(new BTNode<>(6,null,null,null), bst.predecessor(8));

		Assert.assertEquals(new BTNode<>(5,null,null,null), bst.sucessor(4));
		Assert.assertEquals(new BTNode<>(1,null,null,null), bst.predecessor(4));

		Assert.assertEquals(new BTNode<>(1,null,null,null), bst.sucessor(0));
		Assert.assertEquals(new BTNode<>(-2,null,null,null), bst.predecessor(0));

		Assert.assertEquals(new BTNode<>(0,null,null,null), bst.sucessor(-2));
		Assert.assertTrue(null ==  bst.predecessor(-2));

		Assert.assertEquals(new BTNode<>(10,null,null,null), bst.sucessor(9));
		Assert.assertEquals(new BTNode<>(8,null,null,null), bst.predecessor(9));

		Assert.assertTrue(null == bst.sucessor(15));
		Assert.assertEquals(new BTNode<>(10,null,null,null), bst.predecessor(15));
		
		bst.insert(13);

		Assert.assertEquals(new BTNode<>(15,null,null,null), bst.maximum());
		bst.remove(15);

		Assert.assertEquals(new BTNode<>(13,null,null,null), bst.maximum());
		Assert.assertEquals(new BTNode<>(-2,null,null,null), bst.minimum());
		Assert.assertTrue(null == bst.sucessor(13));
		Assert.assertEquals(new BTNode<>(10,null,null,null), bst.predecessor(13));
		Assert.assertArrayEquals(new Integer[] {-2,0,1,4,5,6,8,9,10,13}, bst.order());
		Assert.assertArrayEquals(new Integer[] {5,1,-2,0,4,8,6,10,9,13}, bst.preOrder());
		Assert.assertArrayEquals(new Integer[] {0,-2,4,1,6,9,13,10,8,5}, bst.postOrder());
		Assert.assertEquals(3, bst.height());
		
		Assert.assertEquals(new BTNode<>(9,null,null,null), bst.sucessor(8));
		Assert.assertEquals(new BTNode<>(6,null,null,null), bst.predecessor(8));

		Assert.assertEquals(new BTNode<>(5,null,null,null), bst.sucessor(4));
		Assert.assertEquals(new BTNode<>(1,null,null,null), bst.predecessor(4));

		Assert.assertEquals(new BTNode<>(1,null,null,null), bst.sucessor(0));
		Assert.assertEquals(new BTNode<>(-2,null,null,null), bst.predecessor(0));

		Assert.assertEquals(new BTNode<>(0,null,null,null), bst.sucessor(-2));
		Assert.assertTrue(null ==  bst.predecessor(-2));

		Assert.assertEquals(new BTNode<>(10,null,null,null), bst.sucessor(9));
		Assert.assertEquals(new BTNode<>(8,null,null,null), bst.predecessor(9));
		
		Assert.assertTrue(null == bst.sucessor(13));
		Assert.assertEquals(new BTNode<>(10,null,null,null), bst.predecessor(13));
		
		Assert.assertTrue(null == bst.sucessor(15));
		Assert.assertTrue(null == bst.predecessor(15));
			
		bst.remove(4);
		Assert.assertEquals(new BTNode<>(13,null,null,null), bst.maximum());
		Assert.assertEquals(new BTNode<>(-2,null,null,null), bst.minimum());
		Assert.assertArrayEquals(new Integer[] {-2,0,1,5,6,8,9,10,13}, bst.order());
		Assert.assertArrayEquals(new Integer[] {5,1,-2,0,8,6,10,9,13}, bst.preOrder());
		Assert.assertArrayEquals(new Integer[] {0,-2,1,6,9,13,10,8,5}, bst.postOrder());
		Assert.assertEquals(3, bst.height());
		
		bst.remove(5);
		Assert.assertEquals(new BTNode<>(13,null,null,null), bst.maximum());
		Assert.assertEquals(new BTNode<>(-2,null,null,null), bst.minimum());
		Assert.assertArrayEquals(new Integer[] {-2,0,1,6,8,9,10,13}, bst.order());
		Assert.assertArrayEquals(new Integer[] {6,1,-2,0,8,10,9,13}, bst.preOrder());
		Assert.assertArrayEquals(new Integer[] {0,-2,1,9,13,10,8,6}, bst.postOrder());
		Assert.assertEquals(3, bst.height());
			
		bst.insert(-4);
		bst.insert(-6);
		Assert.assertEquals(new BTNode<>(13,null,null,null), bst.maximum());
		Assert.assertEquals(new BTNode<>(-6,null,null,null), bst.minimum());
		Assert.assertArrayEquals(new Integer[] {-6,-4,-2,0,1,6,8,9,10,13}, bst.order());
		Assert.assertArrayEquals(new Integer[] {6,1,-2,-4,-6,0,8,10,9,13}, bst.preOrder());
		Assert.assertArrayEquals(new Integer[] {-6,-4, 0,-2,1,9,13,10,8,6}, bst.postOrder());
		Assert.assertEquals(4, bst.height());
		
		bst.remove(1);
		Assert.assertEquals(new BTNode<>(13,null,null,null), bst.maximum());
		Assert.assertEquals(new BTNode<>(-6,null,null,null), bst.minimum());
		Assert.assertArrayEquals(new Integer[] {-6,-4,-2,0,6,8,9,10,13}, bst.order());
		Assert.assertArrayEquals(new Integer[] {6,-2,-4,-6,0,8,10,9,13}, bst.preOrder());
		Assert.assertArrayEquals(new Integer[] {-6,-4, 0,-2,9,13,10,8,6}, bst.postOrder());
		Assert.assertEquals(3, bst.height());
		
		bst.remove(8);
		Assert.assertEquals(new BTNode<>(13,null,null,null), bst.maximum());
		Assert.assertEquals(new BTNode<>(-6,null,null,null), bst.minimum());
		Assert.assertArrayEquals(new Integer[] {-6,-4,-2,0,6,9,10,13}, bst.order());
		Assert.assertArrayEquals(new Integer[] {6,-2,-4,-6,0,10,9,13}, bst.preOrder());
		Assert.assertArrayEquals(new Integer[] {-6,-4, 0,-2,9,13,10,6}, bst.postOrder());
		Assert.assertEquals(3, bst.height());
		
	}

	@Test
	public void removeBug(){
		
		bst.insert(15);
		bst.insert(13);

		Assert.assertEquals(new BTNode<>(15,null,null,null), bst.maximum());
		bst.remove(15);

		Assert.assertTrue(null  ==  bst.sucessor(13));
		Assert.assertTrue(null  ==  bst.predecessor(13));
		Assert.assertArrayEquals(new Integer[] {13}, bst.order());
		Assert.assertArrayEquals(new Integer[] {13}, bst.preOrder());
		Assert.assertArrayEquals(new Integer[] {13}, bst.postOrder());
		Assert.assertEquals(0, bst.height());
	}
	
	
	@Test
	public void testMaximumMinimum(){
		
		Assert.assertTrue(null == bst.maximum());
		Assert.assertTrue(null == bst.minimum());
		
		bst.insert(2);
		Assert.assertEquals(new BTNode<>(2,null,null,null), bst.maximum());
		Assert.assertEquals(new BTNode<>(2,null,null,null), bst.minimum());
		
		bst.insert(3);
		Assert.assertEquals(new BTNode<>(3,null,null,null), bst.maximum());
		Assert.assertEquals(new BTNode<>(2,null,null,null), bst.minimum());
		
		bst.insert(-1);
		Assert.assertEquals(new BTNode<>(3,null,null,null), bst.maximum());
		Assert.assertEquals(new BTNode<>(-1,null,null,null), bst.minimum());
		
		bst.insert(1000);
		Assert.assertEquals(new BTNode<>(1000,null,null,null), bst.maximum());
		Assert.assertEquals(new BTNode<>(-1,null,null,null), bst.minimum());
		
		bst.insert(999);
		Assert.assertEquals(new BTNode<>(1000,null,null,null), bst.maximum());
		Assert.assertEquals(new BTNode<>(-1,null,null,null), bst.minimum());
		
		bst.remove(1000);
		Assert.assertEquals(new BTNode<>(999,null,null,null), bst.maximum());
		Assert.assertEquals(new BTNode<>(-1,null,null,null), bst.minimum());
		
		bst.remove(999);
		Assert.assertEquals(new BTNode<>(3,null,null,null), bst.maximum());
		Assert.assertEquals(new BTNode<>(-1,null,null,null), bst.minimum());
		
		bst.remove(2);
		Assert.assertEquals(new BTNode<>(3,null,null,null), bst.maximum());
		Assert.assertEquals(new BTNode<>(-1,null,null,null), bst.minimum());
		
		bst.remove(3);
		Assert.assertEquals(new BTNode<>(-1,null,null,null), bst.maximum());
		Assert.assertEquals(new BTNode<>(-1,null,null,null), bst.minimum());
		
		bst.remove(-1);
		Assert.assertTrue(null == bst.maximum());
		Assert.assertTrue(null == bst.minimum());
		
		bst.insert(999);
		Assert.assertEquals(new BTNode<>(999,null,null,null), bst.maximum());
		Assert.assertEquals(new BTNode<>(999,null,null,null), bst.minimum());
		
	}
	
	@Test
	public void testSucessorAndPredecessor(){
		
		Assert.assertTrue(null == bst.sucessor(null));
		Assert.assertTrue(null == bst.predecessor(null));
		Assert.assertTrue(null == bst.sucessor(1));
		Assert.assertTrue(null == bst.predecessor(1));
		
		bst.insert(2);
		Assert.assertTrue(null == bst.sucessor(1));
		Assert.assertTrue(null == bst.predecessor(1));
		Assert.assertTrue(null == bst.sucessor(2));
		Assert.assertTrue(null == bst.predecessor(2));
		
		bst.insert(3);
		Assert.assertTrue(null == bst.predecessor(2));
		Assert.assertEquals(new BTNode<>(3,null,null,null), bst.sucessor(2));
		Assert.assertTrue(null == bst.sucessor(3));
		Assert.assertEquals(new BTNode<>(2,null,null,null), bst.predecessor(3));
		
		bst.insert(-1);
		Assert.assertEquals(new BTNode<>(-1,null,null,null), bst.predecessor(2));
		
		bst.insert(1000);
		Assert.assertEquals(new BTNode<>(1000,null,null,null), bst.sucessor(3));
		Assert.assertEquals(new BTNode<>(3,null,null,null), bst.predecessor(1000));
		
		bst.insert(999);
		Assert.assertEquals(new BTNode<>(999,null,null,null), bst.sucessor(3));
		Assert.assertEquals(new BTNode<>(3,null,null,null), bst.predecessor(999));
		Assert.assertEquals(new BTNode<>(999,null,null,null), bst.predecessor(1000));
		
		bst.remove(1000);
		Assert.assertEquals(new BTNode<>(999,null,null,null), bst.sucessor(3));
		Assert.assertEquals(new BTNode<>(3,null,null,null), bst.predecessor(999));
		Assert.assertTrue(null == bst.predecessor(1000));
		
		bst.remove(999);
		Assert.assertTrue(null == bst.sucessor(3));
		Assert.assertTrue(null == bst.predecessor(999));
		Assert.assertEquals(new BTNode<>(2,null,null,null), bst.predecessor(3));
		
	}
	
	@Test
	public void testSearch(){
		
		Assert.assertTrue(null == bst.search(null));
		Assert.assertEquals(new BTNode<>(null,null,null,null), bst.search(3));
		Assert.assertEquals(new BTNode<>(null,null,null,null), bst.search(4));
		Assert.assertEquals(new BTNode<>(null,null,null,null), bst.search(1000));
		Assert.assertEquals(new BTNode<>(null,null,null,null), bst.search(-129012901));
		
		bst.insert(3);
		bst.insert(4);
		bst.insert(54);
		bst.insert(12);
		bst.insert(-1);
		Assert.assertEquals(new BTNode<>(3,null,null,null), bst.search(3));
		Assert.assertEquals(new BTNode<>(4,null,null,null), bst.search(4));
		Assert.assertEquals(new BTNode<>(12,null,null,null), bst.search(12));
		Assert.assertEquals(new BTNode<>(-1,null,null,null), bst.search(-1));
		Assert.assertEquals(new BTNode<>(54,null,null,null), bst.search(54));
		Assert.assertEquals(new BTNode<>(null,null,null,null), bst.search(-129012901));
		
		bst.remove(3);
		bst.insert(4);
		bst.insert(54);
		bst.remove(12);
		bst.insert(-1);
		Assert.assertEquals(new BTNode<>(null,null,null,null), bst.search(3));
		Assert.assertEquals(new BTNode<>(4,null,null,null), bst.search(4));
		Assert.assertEquals(new BTNode<>(null,null,null,null), bst.search(12));
		Assert.assertEquals(new BTNode<>(-1,null,null,null), bst.search(-1));
		Assert.assertEquals(new BTNode<>(null,null,null,null), bst.search(1000));
		Assert.assertEquals(new BTNode<>(null,null,null,null), bst.search(-129012901));
			
	}
	

}
