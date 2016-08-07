package adt.queue;
 
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
 
public class QueueTestFinal {
 
	QueueDoubleLinkedListImpl<String> filaCircular;
 
	@Before
	public void setUp() {
		filaCircular = new QueueDoubleLinkedListImpl<String>(5);
	}
 
	@Test
	public void testIsEmpty() {
		Assert.assertTrue(filaCircular.isEmpty());
	}
 
	@Test
	public void testIsFull() {
		Assert.assertFalse(filaCircular.isFull());
	}
 
	@Test
	public void testEnqueue() throws QueueOverflowException {
		filaCircular.enqueue("A");
		filaCircular.enqueue("B");
		filaCircular.enqueue("C");
		filaCircular.enqueue("D");
		filaCircular.enqueue("E");
 
		Assert.assertTrue(filaCircular.isFull());
 
		try {
			filaCircular.enqueue("F");
			Assert.fail("Circular Queue is full");
		} catch ( QueueOverflowException e ) {
			Assert.assertEquals("Fila cheia", e.getMessage());
		}
	}
 
	@Test
	public void testDequeue() throws QueueOverflowException, QueueUnderflowException {
		filaCircular.enqueue("A");
		filaCircular.enqueue("B");
		filaCircular.enqueue("C");
		filaCircular.enqueue("D");
		filaCircular.enqueue("E");
		Assert.assertTrue(filaCircular.isFull());
		Assert.assertFalse(filaCircular.isEmpty());
		Assert.assertEquals("A", filaCircular.head());
		Assert.assertEquals("A", filaCircular.dequeue());
		Assert.assertFalse(filaCircular.isFull());
		Assert.assertFalse(filaCircular.isEmpty());
		Assert.assertEquals("B", filaCircular.head());
		Assert.assertEquals("B", filaCircular.dequeue());
		Assert.assertFalse(filaCircular.isFull());
		Assert.assertFalse(filaCircular.isEmpty());
		Assert.assertEquals("C", filaCircular.head());
		Assert.assertEquals("C", filaCircular.dequeue());
		Assert.assertFalse(filaCircular.isFull());
		Assert.assertFalse(filaCircular.isEmpty());
		filaCircular.enqueue("F");
		Assert.assertFalse(filaCircular.isFull());
		Assert.assertFalse(filaCircular.isEmpty());
		Assert.assertEquals("D", filaCircular.head());
		filaCircular.enqueue("G");
		Assert.assertFalse(filaCircular.isFull());
		Assert.assertFalse(filaCircular.isEmpty());
		Assert.assertEquals("D", filaCircular.head());
		filaCircular.enqueue("H");
		Assert.assertTrue(filaCircular.isFull());
		Assert.assertFalse(filaCircular.isEmpty());
		Assert.assertEquals("D", filaCircular.head());
		Assert.assertEquals("D", filaCircular.dequeue());
		Assert.assertFalse(filaCircular.isFull());
		Assert.assertFalse(filaCircular.isEmpty());
		Assert.assertEquals("E", filaCircular.head());
		Assert.assertEquals("E", filaCircular.dequeue());
		Assert.assertFalse(filaCircular.isFull());
		Assert.assertFalse(filaCircular.isEmpty());
		Assert.assertEquals("F", filaCircular.head());
		Assert.assertEquals("F", filaCircular.dequeue());
		Assert.assertFalse(filaCircular.isFull());
		Assert.assertFalse(filaCircular.isEmpty());
		Assert.assertEquals("G", filaCircular.head());
		Assert.assertEquals("G", filaCircular.dequeue());
		Assert.assertFalse(filaCircular.isFull());
		Assert.assertFalse(filaCircular.isEmpty());
		Assert.assertEquals("H", filaCircular.head());
		Assert.assertEquals("H", filaCircular.dequeue());
		Assert.assertFalse(filaCircular.isFull());
		Assert.assertTrue(filaCircular.isEmpty());
		Assert.assertTrue(null == filaCircular.head());
 
		try {
			filaCircular.dequeue();
			Assert.fail("Queue is empty");
		} catch ( QueueUnderflowException e ) {
			Assert.assertEquals("Fila vazia", e.getMessage());
		}
 
		filaCircular.enqueue("Outra");
		Assert.assertFalse(filaCircular.isFull());
		Assert.assertFalse(filaCircular.isEmpty());
		Assert.assertEquals("Outra", filaCircular.head());
	}
}