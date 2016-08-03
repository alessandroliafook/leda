package test;

import java.util.Comparator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;
import adt.linkedList.extended.ExtendedSingleLinkedListImpl;
 
public class testaLinked {
 
	private SingleLinkedListImpl<Integer> singleInt;
	private SingleLinkedListImpl<String> singleString;
	private SingleLinkedListImpl<Integer> rsllInteger;
	private SingleLinkedListImpl<Double> rsllDouble;
	private SingleLinkedListImpl<String> rsllString;
	private ExtendedSingleLinkedListImpl<Integer> extendedInt, extended2;
	private ExtendedSingleLinkedListImpl<Integer> lista;
	private ExtendedSingleLinkedListImpl<Integer> lista2;
	private Comparator<Integer> comp;
	
	@Before
    public void criaConstrutor() {
		
		comp = new Comp1();
		singleInt = new SingleLinkedListImpl<Integer>();
		singleString = new SingleLinkedListImpl<String>();
		rsllInteger = new SingleLinkedListImpl<Integer>();
        rsllDouble = new SingleLinkedListImpl<Double>();
        rsllString = new SingleLinkedListImpl<String>();   
        extendedInt = new ExtendedSingleLinkedListImpl<Integer>(null); 
        extended2 = new ExtendedSingleLinkedListImpl<Integer>(null);
		lista = new ExtendedSingleLinkedListImpl<Integer>(comp);
		lista2 = new ExtendedSingleLinkedListImpl<Integer>(comp);
    }
	
	@Test
	public void testConcatenate() {

		lista.insert(10);
		
		lista2.insert(1);
		lista2.insert(2);
		lista2.insert(3);
		lista2.insert(2);
		lista2.insert(2);
		lista2.insert(2);
		
		lista.concatenate(lista2);
		Assert.assertArrayEquals(new Integer[] {10, 1, 2, 3, 2, 2, 2}, lista.toArray());

		Assert.assertTrue(lista.size() == 7);

		lista2.removeAll(2);
	
		Assert.assertArrayEquals(new Integer[] {1,3}, lista2.toArray());
		Assert.assertArrayEquals(new Integer[] {10, 1, 2, 3, 2, 2, 2}, lista.toArray());

		lista.insert(10);
		lista.insert(100);
		Assert.assertTrue(lista.size() == 9);
		Assert.assertArrayEquals(lista.toArray(), new Integer[] {10,1,2,3,2,2,2,10,100});
		lista.concatenate(lista2);
		Assert.assertTrue(lista.size() == 11);
		Assert.assertArrayEquals(lista.toArray(), new Integer[] {10,1,2,3,2,2,2,10,100,1,3});
		
			
	}
	
 
	 @Test
     public void testInsertAndSize(){
          
         rsllInteger.insert(2);
         rsllString.insert("a");
         rsllString.insert("v");
         rsllString.insert("c");
         Assert.assertEquals("Size wrong", 1, rsllInteger.size());
         Assert.assertEquals("Size wrong", 0, rsllDouble.size());
         Assert.assertEquals("Size wrong", 3, rsllString.size());        
     }
      
     @Test
     public void testIsEmpty(){
      
         rsllInteger.insert(2);
         Assert.assertEquals("Test failed", false, rsllInteger.isEmpty());
         Assert.assertEquals("Test failed", true, rsllDouble.isEmpty());
         Assert.assertEquals("Test failed", true, rsllString.isEmpty());     
     }
      
     @Test
     public void testSearch(){
          
    	 rsllInteger.search(null);
         rsllInteger.insert(2);
         rsllInteger.insert(45);
         rsllInteger.insert(87);
         rsllInteger.insert(1);
         rsllInteger.insert(456);        
         rsllString.insert("a");
         rsllString.insert("v");
         rsllString.insert("c");
         rsllDouble.insert(2.4);
         rsllDouble.insert(56.4);
         rsllDouble.insert(98.1);
         Assert.assertEquals("Search failed", 1, rsllInteger.search(1), 0.0005);
         Assert.assertEquals("Search failed", null, rsllDouble.search(9.9));
         Assert.assertEquals("Search failed", "v", rsllString.search("v"));      
     }
      
     @Test
     public void testRemove(){       
          
         rsllInteger.insert(2);
         rsllInteger.insert(45);
         rsllInteger.insert(87);
         rsllInteger.insert(1);
         rsllInteger.insert(456);        
         rsllString.insert("a");
         rsllString.insert("v");
         rsllString.insert("c");
         rsllDouble.insert(2.4);
         rsllDouble.insert(56.4);
         rsllDouble.insert(98.1);
          
         rsllInteger.remove(45);
         Assert.assertEquals("Remove failed", 4, rsllInteger.size());
         rsllInteger.remove(2);
         Assert.assertEquals("Remove failed", 3, rsllInteger.size());
         rsllInteger.remove(87);
         Assert.assertEquals("Remove failed", 2, rsllInteger.size());
         rsllInteger.remove(1);
         Assert.assertEquals("Remove failed", 1, rsllInteger.size());
         
         rsllInteger.remove(456);
         Assert.assertEquals("Remove failed", 0, rsllInteger.size());

         rsllDouble.remove(56.4);
         rsllDouble.remove(2.4);
         Assert.assertEquals("Remove failed", 1, rsllDouble.size());
         rsllString.remove("v");
         rsllString.remove("a");
         Assert.assertEquals("Remove failed", 1, rsllString.size());
          
     }
      
     @Test
     public void testToArray() {
    	 
         rsllInteger.insert(2);
         rsllInteger.insert(45);
         rsllInteger.insert(87);
         rsllInteger.insert(1);
         rsllInteger.insert(456);        
         rsllString.insert("a");
         rsllString.insert("v");
         rsllString.insert("c");
         rsllDouble.insert(2.4);
         rsllDouble.insert(56.4);

         Assert.assertArrayEquals("toArray failed", new Integer[] {2, 45, 87, 1, 456}, rsllInteger.toArray());
         Assert.assertArrayEquals("toArray failed", new Double[] {2.4, 56.4}, rsllDouble.toArray());
         Assert.assertArrayEquals("toArray failed", new String[] {"a", "v", "c"}, rsllString.toArray());     
     }
	
	@Test
	public void testaInteiros() {
		
		Assert.assertTrue(singleInt.isEmpty());
		Assert.assertTrue(singleInt.getHead().isNIL());
		Assert.assertEquals(singleInt.size(), 0);
		Assert.assertEquals(singleInt.search(1), null);
		Assert.assertEquals(singleInt.toArray(), new String[0]);
		
		singleInt.insert(1);
		Assert.assertFalse(singleInt.isEmpty());
		Assert.assertFalse(singleInt.getHead().isNIL());
		Assert.assertEquals(singleInt.size(), 1);
		Assert.assertEquals((Integer) singleInt.search(1), (Integer) 1);
		
		singleInt.insert(3);
		singleInt.insert(2);
		singleInt.insert(1);
		Assert.assertFalse(singleInt.isEmpty());
		Assert.assertEquals(singleInt.size(), 4);
		Assert.assertEquals((Integer) singleInt.search(1), (Integer) 1);
		Assert.assertEquals((Integer) singleInt.search(2), (Integer) 2);
		Assert.assertEquals((Integer) singleInt.search(3), (Integer) 3);
		Assert.assertEquals((Integer) singleInt.search(4), null);
		
		singleInt.remove(1);
		Assert.assertFalse(singleInt.isEmpty());
		Assert.assertEquals(singleInt.size(), 3);
		Assert.assertEquals((Integer) singleInt.search(1), (Integer) 1);
		Assert.assertEquals((Integer) singleInt.search(2), (Integer) 2);
		Assert.assertEquals((Integer) singleInt.search(3), (Integer) 3);
		Assert.assertEquals((Integer) singleInt.search(4), null);

		Integer[] result = {3,2,1};
		Assert.assertEquals(singleInt.toArray(), result);
	}
	
	@Test
	public void testaStrings() {
		
		Assert.assertTrue(singleString.isEmpty());
		Assert.assertTrue(singleString.getHead().isNIL());
		Assert.assertEquals(singleString.size(), 0);
		Assert.assertEquals(singleString.search("oi"), null);
		Assert.assertEquals(singleString.toArray(), new Integer[0]);
		
		singleString.insert("oi");
		Assert.assertFalse(singleString.isEmpty());
		Assert.assertFalse(singleString.getHead().isNIL());
		Assert.assertEquals(singleString.size(), 1);
		Assert.assertEquals(singleString.search("oi"), "oi");
		
		singleString.insert("ola");
		singleString.insert("hello");
		singleString.insert("oi");
		Assert.assertFalse(singleString.isEmpty());
		Assert.assertEquals(singleString.size(), 4);
		Assert.assertEquals(singleString.search("oi"), "oi");
		Assert.assertEquals(singleString.search("ola"), "ola");
		Assert.assertEquals(singleString.search("hello"), "hello");
		Assert.assertEquals(singleString.search("tchau"), null);
		
		singleString.remove("oi");
		Assert.assertFalse(singleString.isEmpty());
		Assert.assertEquals(singleString.size(), 3);
		Assert.assertEquals(singleString.search("oi"), "oi");
		Assert.assertEquals(singleString.search("ola"), "ola");
		Assert.assertEquals(singleString.search("hello"), "hello");
		Assert.assertEquals(singleString.search("tchau"), null);
		
		singleString.remove("oi");
		Assert.assertEquals(singleString.search("oi"), null);
		
		String[] result = {"ola", "hello"};
		Assert.assertEquals(singleString.toArray(), result);
	}

	@Test
	public void testaExtended() {
		
		Assert.assertTrue(extendedInt.isEmpty());
		Assert.assertTrue(extendedInt.getHead().isNIL());
		Assert.assertEquals(extendedInt.size(), 0);
		Assert.assertEquals(extendedInt.search(1), null);
		Assert.assertEquals(extendedInt.toArray(), new Integer[0]);
		
		extendedInt.insert(2);
		extendedInt.insert(2);
		extendedInt.insert(1);
		Assert.assertEquals(extendedInt.size(), 3);
		
		extended2.insert(5);
		extended2.insert(8);
		extended2.insert(9);
		Assert.assertEquals(extended2.size(), 3);
		
		extendedInt.concatenate(extended2);
		Assert.assertEquals(extendedInt.size(), 6);
		
		extended2.insert(10);
		extendedInt.concatenate(extended2);
		
	}
	
	@Test
	public void testaExceptions() {
		
		extendedInt.removeAll(1); // checa nullpointer
		Assert.assertEquals(extendedInt.size(), 0);
		Assert.assertEquals(extendedInt.minimum(), null);
		Assert.assertTrue(extendedInt.getHead().isNIL());
		
		extendedInt.concatenate(extended2); // checa nullpointer
		
		singleString.remove(null);
		singleString.remove("..............");
		
	}
	
	@Test
	public void testIsEmptyAndSize() {
		Assert.assertTrue(lista.isEmpty());
		Assert.assertTrue(lista.size() == 0);
		
		lista.insert(8);
		Assert.assertFalse(lista.isEmpty());
		Assert.assertTrue(lista.size() == 1);
	
		Assert.assertTrue(lista.getHead().equals(new SingleLinkedListNode<Integer>(new Integer(8),null)));
		
		lista.remove(8);
		Assert.assertTrue(lista.isEmpty());
		Assert.assertTrue(lista.size() == 0);
		Assert.assertTrue(lista.getHead().getData() == null);
		
		lista.insert(9);
		lista.insert(10);
		lista.insert(11);
		lista.insert(12);
		Assert.assertFalse(lista.isEmpty());
		Assert.assertTrue(lista.size() == 4);
		Assert.assertTrue(lista.getHead().equals(new SingleLinkedListNode<Integer>(new Integer(9),null)));
		
		lista.remove(9);
		Assert.assertTrue(lista.size() == 3);
		Assert.assertTrue(lista.getHead().equals(new SingleLinkedListNode<Integer>(new Integer(10),null)));
		
		lista.remove(12);
		Assert.assertTrue(lista.size() == 2);
		Assert.assertTrue(lista.getHead().equals(new SingleLinkedListNode<Integer>(new Integer(10),null)));
		
		lista.insert(9);
		lista.insert(10);
		lista.insert(11);
		lista.insert(12);
		Assert.assertTrue(lista.size() == 6);

	}
	
	@Test
	public void testesInsertAndRemove() {
		
		Assert.assertTrue(lista.isEmpty());
		Assert.assertArrayEquals(new Integer[] {}, lista.toArray());
		lista.insert(1);
		Assert.assertArrayEquals(new Integer[] {1}, lista.toArray());
		lista.insert(2);
		Assert.assertArrayEquals(new Integer[] {1, 2}, lista.toArray());
		lista.insert(3);
		Assert.assertArrayEquals(new Integer[] {1, 2, 3}, lista.toArray());
		lista.insert(4);
		Assert.assertArrayEquals(new Integer[] {1, 2, 3, 4}, lista.toArray());
		lista.insert(5);
		Assert.assertTrue(lista.size() == 5);
		Assert.assertFalse(lista.isEmpty());
		Assert.assertArrayEquals(new Integer[] {1, 2, 3, 4, 5}, lista.toArray());
		
		lista.remove(6);
		Assert.assertTrue(lista.size() == 5);
		Assert.assertArrayEquals(new Integer[] {1, 2, 3, 4, 5}, lista.toArray());
		
		lista.remove(1);
		Assert.assertTrue(lista.size() == 4);
		Assert.assertArrayEquals(new Integer[] {2, 3, 4, 5}, lista.toArray());
		
		lista.remove(5);
		Assert.assertTrue(lista.size() == 3);
		Assert.assertArrayEquals(new Integer[] {2, 3, 4}, lista.toArray());
		
		lista.remove(3);
		Assert.assertTrue(lista.size() == 2);
		Assert.assertArrayEquals(new Integer[] {2, 4}, lista.toArray());
		
		lista.remove(null);
		Assert.assertTrue(lista.size() == 2);
		Assert.assertArrayEquals(new Integer[] {2, 4}, lista.toArray());
		
		lista.insert(null);
		Assert.assertTrue(lista.size() == 2);
		Assert.assertArrayEquals(new Integer[] {2, 4}, lista.toArray());
		
		lista.remove(2);
		lista.remove(4);
		Assert.assertTrue(lista.size() == 0);
		Assert.assertTrue(lista.isEmpty());
		Assert.assertArrayEquals(new Integer[] {}, lista.toArray());
		
		lista.insert(45);
		Assert.assertTrue(lista.size() == 1);
		Assert.assertFalse(lista.isEmpty());
		Assert.assertArrayEquals(new Integer[] {45}, lista.toArray());
	}
	
	@Test
	public void testSearch2(){
		
		lista.insert(1);
		lista.insert(1);
		lista.insert(2);
		lista.insert(3);
		lista.insert(null);
		lista.insert(4);
		lista.insert(4);
		Assert.assertEquals(null, lista.search(null));
	
		Assert.assertEquals(new Integer(1), lista.search(1));
		Assert.assertEquals(new Integer(2), lista.search(2));
		Assert.assertEquals(new Integer(3), lista.search(3));
		Assert.assertEquals(new Integer(4), lista.search(4));
		Assert.assertEquals(null, lista.search(5));
		Assert.assertEquals(null, lista.search(null));
		
		lista.remove(null);
		lista.remove(1);
		Assert.assertEquals(new Integer(1), lista.search(1));
		Assert.assertArrayEquals(new Integer[] {1,2,3,4,4}, lista.toArray());
		lista.remove(1);
		Assert.assertEquals(null, lista.search(1));
		Assert.assertArrayEquals(new Integer[] {2,3,4,4}, lista.toArray());
		Assert.assertEquals(null, lista.search(null));
		
		lista.remove(4);
		Assert.assertEquals(new Integer(4), lista.search(4));
		Assert.assertArrayEquals(new Integer[] {2,3,4}, lista.toArray());
		
		lista.remove(3);
		Assert.assertEquals(null, lista.search(3));
		Assert.assertArrayEquals(new Integer[] {2,4}, lista.toArray());
		
		Assert.assertEquals(null, lista.search(null));
		
	}
	
	@Test
	public void testMinimun(){
		
		lista.insert(1);
		lista.insert(7);
		lista.insert(5);
		lista.insert(0);
		lista.insert(-1);
		lista.insert(-1);
		lista.insert(10);
		
		Assert.assertArrayEquals(new Integer[] {1,7,5,0,-1,-1,10}, lista.toArray());
		
		Assert.assertEquals(lista.minimum(), new Integer(-1));
		
		lista.remove(-1);
		
		Assert.assertEquals(lista.minimum(), new Integer(-1));
		
		lista.remove(-1);
		Assert.assertEquals(lista.minimum(), new Integer(0));
		lista.remove(0);
		Assert.assertEquals(lista.minimum(), new Integer(1));
		lista.remove(7);
		Assert.assertEquals(lista.minimum(), new Integer(1));
		lista.remove(1);
		Assert.assertEquals(lista.minimum(), new Integer(5));
	}
	
	@Test
	public void testRemoveAll() {

		lista.insert(-1);
		lista.insert(-1);
		lista.insert(-1);
		lista.insert(0);
		Assert.assertEquals(lista.minimum(), new Integer(-1));
		
		lista.removeAll(-1);
		Assert.assertEquals(lista.minimum(), new Integer(0));
		
		lista.removeAll(0);
		Assert.assertTrue(lista.minimum() == null);
		
		lista.insert(2);
		for(int i = 0 ; i < 100; i++)
			lista.insert(1);
		
		Assert.assertEquals(lista.minimum(), new Integer(1));
		
		lista.removeAll(1);
		Assert.assertEquals(lista.minimum(), new Integer(2));;
			
	}
	
	@Test
	public void testConcatenate2() {

		lista.insert(10);
		
		lista2.insert(1);
		lista2.insert(2);
		lista2.insert(3);
		lista2.insert(2);
		lista2.insert(2);
		lista2.insert(2);
		
		lista.concatenate(lista2);
		Assert.assertArrayEquals(new Integer[] {10, 1, 2, 3, 2, 2, 2}, lista.toArray());

		Assert.assertTrue(lista.size() == 7);

		lista2.removeAll(2);
	
		Assert.assertArrayEquals(new Integer[] {1,3}, lista2.toArray());
		Assert.assertArrayEquals(new Integer[] {10, 1, 2, 3, 2, 2, 2}, lista.toArray());

		lista.insert(10);
		lista.insert(100);
		Assert.assertTrue(lista.size() == 9);
		Assert.assertArrayEquals(lista.toArray(), new Integer[] {10,1,2,3,2,2,2,10,100});
		lista.concatenate(lista2);
		Assert.assertTrue(lista.size() == 11);
		Assert.assertArrayEquals(lista.toArray(), new Integer[] {10,1,2,3,2,2,2,10,100,1,3});
		
			
	}
}