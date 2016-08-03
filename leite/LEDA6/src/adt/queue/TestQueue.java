package adt.queue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import adt.queue.Queue;
import adt.queue.QueueOverflowException;
import adt.queue.QueueUnderflowException;

public class TestQueue {

	private Queue<Integer> queue1;
	private Queue<Integer> queue2;

	@Before
	public void before() {

		queue1 = new QueueDoubleLinkedListImpl<>(10);
		queue2 = new QueueDoubleLinkedListImpl<>(3);

	}

	@Test
	public void testEnqueue() {

		Assert.assertTrue(queue1.isEmpty());
		Assert.assertFalse(queue1.isFull());

		try {
			Assert.assertTrue(queue1.head().equals(null));
			Assert.fail();
		} catch (NullPointerException npe) {

		}
		

		try {
			queue1.enqueue(null);
			Assert.assertTrue(queue1.isEmpty());
			Assert.assertFalse(queue1.isFull());

		} catch (QueueOverflowException soe) {
			Assert.fail();
		}

		try {

			queue1.enqueue(1);
			Assert.assertTrue(queue1.head().equals(1));

			queue1.enqueue(2);
			Assert.assertFalse(queue1.isEmpty());
			Assert.assertFalse(queue1.isFull());

			Assert.assertTrue(queue1.head().equals(1));

			queue1.enqueue(3);
			Assert.assertTrue(queue1.head().equals(1));

			queue1.enqueue(4);
			Assert.assertTrue(queue1.head().equals(1));

			queue1.enqueue(5);
			Assert.assertTrue(queue1.head().equals(1));

			queue1.enqueue(6);
			Assert.assertTrue(queue1.head().equals(1));

			queue1.enqueue(7);
			Assert.assertTrue(queue1.head().equals(1));

			queue1.enqueue(8);
			Assert.assertTrue(queue1.head().equals(1));

			queue1.enqueue(9);
			Assert.assertTrue(queue1.head().equals(1));

			queue1.enqueue(10);
			Assert.assertTrue(queue1.head().equals(1));

			Assert.assertFalse(queue1.isEmpty());
			Assert.assertTrue(queue1.isFull());

		} catch (QueueOverflowException soe) {
			Assert.fail();
		}

		try {
			queue1.enqueue(11);
			Assert.fail();
		} catch (QueueOverflowException e) {

		}

	}

	@Test
	public void testDequeue() {

		try {
			queue1.enqueue(10);
			queue1.enqueue(-1);
			queue1.enqueue(12);
			queue1.enqueue(13);
			queue1.enqueue(0);
			queue1.enqueue(20);
			queue1.enqueue(10);
			Assert.assertTrue(queue1.head().equals(10));
		} catch (QueueOverflowException e) {
			Assert.fail();
		}

		try {
			Integer element = queue1.dequeue();
			Assert.assertTrue(element.equals(10));

			element = queue1.dequeue();
			Assert.assertTrue(element.equals(-1));

			element = queue1.dequeue();
			Assert.assertTrue(element.equals(12));

			element = queue1.dequeue();
			Assert.assertTrue(element.equals(13));

			element = queue1.dequeue();
			Assert.assertTrue(element.equals(0));
			
			element = queue1.dequeue();
			Assert.assertTrue(element.equals(20));

			element = queue1.dequeue();
			Assert.assertTrue(element.equals(10));

		} catch (QueueUnderflowException e) {
			Assert.fail();
		}

		try {
			Integer element = queue1.dequeue();
			Assert.fail();
		} catch (QueueUnderflowException e) {

		}

	}
	
	@Test
	public void testEnqueueDequeue() {
		
		try {
			queue1.enqueue(10);
			queue1.enqueue(-1);
			queue1.enqueue(12);
			queue1.enqueue(10);
			Assert.assertTrue(queue1.head().equals(10));
		} catch (QueueOverflowException e) {
			Assert.fail();
		}
		
		try {
			Integer element = queue1.dequeue();
			Assert.assertTrue(element.equals(10));
			
			queue1.enqueue(1);
			
			element = queue1.dequeue();
			Assert.assertTrue(element.equals(-1));

			element = queue1.dequeue();
			Assert.assertTrue(element.equals(12));

			element = queue1.dequeue();
			Assert.assertTrue(element.equals(10));

			element = queue1.dequeue();
			Assert.assertTrue(element.equals(1));

		} catch (Exception excp) {
			Assert.fail();
		}
		
		Assert.assertTrue(queue1.isEmpty());
		
		try {
			queue1.enqueue(-12);
			queue1.enqueue(1);
			queue1.enqueue(11);
			queue1.enqueue(3);
			queue1.enqueue(6);
			queue1.enqueue(-23);
			queue1.enqueue(9);
			queue1.enqueue(11);
			queue1.enqueue(10);
			queue1.enqueue(12);
			
			Assert.assertTrue(queue1.head().equals(-12));
			Assert.assertTrue(queue1.isFull());
			
		} catch (QueueOverflowException e) {
			Assert.fail();
		}
		
		try {
			Integer element = queue1.dequeue();
			Assert.assertTrue(element.equals(-12));
			Assert.assertTrue(queue1.head().equals(1));
			
			queue1.enqueue(1);
			
			element = queue1.dequeue();
			Assert.assertTrue(element.equals(1));
			
			element = queue1.dequeue();
			Assert.assertTrue(element.equals(11));

		} catch (Exception excp) {
			Assert.fail();
		}
		
		
	}
	
	@Test
	public void testQeueuzin(){
		
		try {
			queue2.enqueue(0);
			queue2.enqueue(1);
			queue2.enqueue(2);
		} catch (QueueOverflowException e) {
			Assert.fail();
		}
		
		try {
			queue2.dequeue();
			queue2.enqueue(3);
			
			queue2.dequeue();
			queue2.dequeue();
			queue2.dequeue();
			Assert.assertTrue(queue2.isEmpty());
			
			queue2.enqueue(3);
			Assert.assertEquals(new Integer(3), queue2.head());
			
		} catch (Exception e) {
			Assert.fail();
		}
		
		
	}
	

}

