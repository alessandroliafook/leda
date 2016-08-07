package adt.queue;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import adt.queue.Queue;
import adt.queue.QueueDoubleLinkedListImpl;
import adt.queue.QueueOverflowException;
import adt.queue.QueueUnderflowException;

public class QueueTest2 {

	private QueueDoubleLinkedListImpl<Integer> queue;

	@Before
	public void setUp() {
		queue = new QueueDoubleLinkedListImpl<>(4);
	}

	@Test
	public void testInit() {
		assertTrue(queue.isEmpty());
		assertFalse(queue.isFull());
		assertEquals(null, queue.head());
	}

	@Test
	public void testRepeat() throws Exception {
		for(int i=0; i<10; i++) {
			queue.enqueue(1);
			queue.enqueue(2);
			queue.enqueue(3);
			queue.enqueue(4);
			assertFalse(queue.isEmpty());
			assertTrue(queue.isFull());
			assertEquals(new Integer(1), queue.head());

			try {
				queue.enqueue(5);
				fail();
			} catch(QueueOverflowException e) {}

			assertEquals(new Integer(1), queue.dequeue());
			assertEquals(new Integer(2), queue.dequeue());
			assertEquals(new Integer(3), queue.dequeue());

			assertFalse(queue.isEmpty());
			assertFalse(queue.isFull());
			assertEquals(new Integer(4), queue.head());

			assertEquals(new Integer(4), queue.dequeue());

			try {
				queue.dequeue();
				fail();
			} catch(QueueUnderflowException e) {}

			assertTrue(queue.isEmpty());
			assertFalse(queue.isFull());
			assertEquals(null, queue.head());
		}
	}

	@Test
	public void testOdd() throws Exception {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);

		assertEquals(new Integer(1), queue.dequeue());
		assertEquals(new Integer(2), queue.dequeue());

		queue.enqueue(5);
		queue.enqueue(6);

		try {
			queue.enqueue(7);
			fail();
		} catch(QueueOverflowException e) {}

		assertEquals(new Integer(3), queue.dequeue());
		queue.enqueue(7);

		try {
			queue.enqueue(8);
			fail();
		} catch(QueueOverflowException e) {}

		assertEquals(new Integer(4), queue.dequeue());
		assertEquals(new Integer(5), queue.dequeue());
		assertEquals(new Integer(6), queue.dequeue());
		assertEquals(new Integer(7), queue.dequeue());
	}

	@Test
	public void testAlternate() throws Exception {
		queue.enqueue(0);
		queue.enqueue(1);
		queue.enqueue(2);

		for(int i=0; i<100; i+=2) {
			assertEquals(new Integer(i), queue.dequeue());
			assertEquals(new Integer(i+1), queue.dequeue());
			queue.enqueue(i+3);
			queue.enqueue(i+4);
		}

		queue.dequeue();
		queue.dequeue();
		queue.dequeue();

		try {
			queue.dequeue();
			fail();
		} catch(QueueUnderflowException e) {}
	}
}