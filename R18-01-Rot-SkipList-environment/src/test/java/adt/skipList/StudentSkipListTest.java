package adt.skipList;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StudentSkipListTest {

	SkipList<String> skip;
	SkipListNode<String>[] array;

	@Before
	public void setUp() {
		skip = new SkipListImpl<String>(4);

		// TODO ajuste o valor de acordo com o exercicio de sua turma
		((SkipListImpl<String>) skip).USE_MAX_HEIGHT_AS_HEIGHT = true;
	}

	@Test
	public void testInsert() {
		skip.insert(10, "A", 2);
		skip.insert(20, "B", 1);
		skip.insert(0, "C", 1);
		skip.insert(15, "D", 3);
		skip.insert(5, "E", 3);

		assertEquals(5, skip.size());

		array = skip.toArray();
		if (((SkipListImpl<String>) skip).USE_MAX_HEIGHT_AS_HEIGHT) {
			assertEquals(
					"[<ROOT,4,4>, <0,1>, <5,3>, <10,2>, <15,3>, <20,1>, <NIL,4>]",
					Arrays.toString(array));
		} else {
			assertEquals(
					"[<ROOT,4,3>, <0,1>, <5,3>, <10,2>, <15,3>, <20,1>, <NIL,4>]",
					Arrays.toString(array));
		}
		assertEquals(0, array[0].getForward(0).getKey());
		assertEquals(5, array[0].getForward(1).getKey());
		assertEquals(5, array[0].getForward(2).getKey());
		//assertNull(array[0].getForward(3));
		assertEquals(5, array[1].getForward(0).getKey());
		assertEquals(10, array[2].getForward(0).getKey());
		assertEquals(10, array[2].getForward(1).getKey());
		assertEquals(15, array[2].getForward(2).getKey());
		assertEquals(15, array[3].getForward(0).getKey());
		assertEquals(15, array[3].getForward(1).getKey());
		assertEquals(20, array[4].getForward(0).getKey());
		assertEquals(Integer.MAX_VALUE, array[4].getForward(1).getKey());
		assertEquals(Integer.MAX_VALUE, array[4].getForward(2).getKey());
		assertEquals(Integer.MAX_VALUE, array[5].getForward(0).getKey());


		List<String> aux = new ArrayList<>();
		for (int i = 1; i < array.length - 1; ++i)
			aux.add(array[i].getValue());

		assertEquals("[C, E, A, D, B]", aux.toString());

		skip.insert(0, "A", 1);
		skip.insert(5, "B", 3);
		skip.insert(10, "C", 2);
		skip.insert(15, "D", 3);
		skip.insert(20, "E", 1);

		assertEquals(5, skip.size());

		array = skip.toArray();
		if (((SkipListImpl<String>) skip).USE_MAX_HEIGHT_AS_HEIGHT) {
			assertEquals(
					"[<ROOT,4,4>, <0,1>, <5,3>, <10,2>, <15,3>, <20,1>, <NIL,4>]",
					Arrays.toString(array));
		} else {
			assertEquals(
					"[<ROOT,4,3>, <0,1>, <5,3>, <10,2>, <15,3>, <20,1>, <NIL,4>]",
					Arrays.toString(array));
		}

		assertEquals(0, array[0].getForward(0).getKey());
		assertEquals(5, array[0].getForward(1).getKey());
		assertEquals(5, array[0].getForward(2).getKey());
		assertEquals(5, array[1].getForward(0).getKey());
		assertEquals(10, array[2].getForward(0).getKey());
		assertEquals(10, array[2].getForward(1).getKey());
		assertEquals(15, array[3].getForward(0).getKey());
		assertEquals(20, array[4].getForward(0).getKey());
		assertEquals(Integer.MAX_VALUE, array[4].getForward(1).getKey());
		assertEquals(Integer.MAX_VALUE, array[5].getForward(0).getKey());

		aux.clear();
		for (int i = 1; i < array.length - 1; ++i)
			aux.add(array[i].getValue());

		assertEquals("[A, B, C, D, E]", aux.toString());
	}

	@Test
	public void testSearch() {
		skip.insert(10, "A", 2);
		skip.insert(20, "B", 1);
		skip.insert(0, "C", 1);
		skip.insert(15, "D", 3);
		skip.insert(5, "E", 2);

		assertEquals("A", skip.search(10).getValue());
		assertEquals("B", skip.search(20).getValue());
		assertEquals("C", skip.search(0).getValue());
		assertEquals("D", skip.search(15).getValue());
		assertEquals("E", skip.search(5).getValue());

		assertEquals(null, skip.search(-10));
		assertEquals(null, skip.search(30));
		assertEquals(null, skip.search(9));
	}

	@Test
	public void testRemove() {
		skip.insert(10, "A", 1);
		skip.insert(20, "B", 2);
		skip.insert(0, "C", 2);
		skip.insert(15, "D", 3);
		skip.insert(5, "E", 1);

		skip.insert(-10, "F", 1);
		skip.insert(30, "G", 3);
		skip.insert(9, "H", 2);
		skip.insert(17, "I", 2);
		skip.insert(-2, "J", 1);

		assertEquals(10, skip.size());

		skip.remove(10);
		skip.remove(20);
		skip.remove(0);
		skip.remove(15);
		skip.remove(5);

		assertEquals(5, skip.size());

		array = skip.toArray();
		if (((SkipListImpl<String>) skip).USE_MAX_HEIGHT_AS_HEIGHT) {
			assertEquals(
					"[<ROOT,4,4>, <-10,1>, <-2,1>, <9,2>, <17,2>, <30,3>, <NIL,4>]",
					Arrays.toString(array));
		} else {
			assertEquals(
					"[<ROOT,4,3>, <-10,1>, <-2,1>, <9,2>, <17,2>, <30,3>, <NIL,4>]",
					Arrays.toString(array));
		}
		assertEquals(-10, array[0].getForward(0).getKey());
		assertEquals(9, array[0].getForward(1).getKey());
		assertEquals(30, array[0].getForward(2).getKey());
		assertEquals(-2, array[1].getForward(0).getKey());
		assertEquals(9, array[2].getForward(0).getKey());
		assertEquals(17, array[3].getForward(0).getKey());
		assertEquals(17, array[3].getForward(1).getKey());
		assertEquals(30, array[4].getForward(0).getKey());
		assertEquals(30, array[4].getForward(1).getKey());
		assertEquals(Integer.MAX_VALUE, array[5].getForward(0).getKey());
		assertEquals(Integer.MAX_VALUE, array[5].getForward(1).getKey());
		assertEquals(Integer.MAX_VALUE, array[5].getForward(2).getKey());

		skip.remove(-10);
		skip.remove(30);
		skip.remove(9);
		skip.remove(17);
		skip.remove(-2);

		assertEquals(0, skip.size());

		array = skip.toArray();
		if (((SkipListImpl<String>) skip).USE_MAX_HEIGHT_AS_HEIGHT) {
			assertEquals("[<ROOT,4,4>, <NIL,4>]", Arrays.toString(array));
		} else {
			assertEquals("[<ROOT,4,1>, <NIL,4>]", Arrays.toString(array));
		}
		assertEquals(Integer.MAX_VALUE, array[0].getForward(0).getKey());
	}

	@Test
	public void dinizTest1() {

		assertEquals(0, skip.size());
		skip.insert(3, "B", 3);
		assertEquals(1, skip.size());
		skip.insert(1, "A", 2);
		assertEquals(2, skip.size());
		skip.insert(4, "C", 1);
		assertEquals(3, skip.size());

		((SkipListImpl<String>) skip).USE_MAX_HEIGHT_AS_HEIGHT = true;
		array = skip.toArray();
		assertEquals("[<ROOT,4,4>, <1,2>, <3,3>, <4,1>, <NIL,4>]", Arrays.toString(array));

		List<String> aux = new ArrayList<>();
		for(SkipListNode<String> node : array){
			aux.add(node.getValue());
		}

		assertEquals("[null, A, B, C, null]", aux.toString());
		assertEquals(4,skip.height());


		((SkipListImpl<String>) skip).USE_MAX_HEIGHT_AS_HEIGHT = false;
		array = skip.toArray();
		assertEquals("[<ROOT,4,3>, <1,2>, <3,3>, <4,1>, <NIL,4>]", Arrays.toString(array));

		aux.clear();
		for(SkipListNode<String> node : array){
			aux.add(node.getValue());
		}

		assertEquals("[null, A, B, C, null]", aux.toString());
		assertEquals(3,skip.height());


		skip.insert(5, "D", 2);
		assertEquals(4, skip.size());

		((SkipListImpl<String>) skip).USE_MAX_HEIGHT_AS_HEIGHT = true;
		array = skip.toArray();
		assertEquals("[<ROOT,4,4>, <1,2>, <3,3>, <4,1>, <5,2>, <NIL,4>]", Arrays.toString(array));

		aux.clear();
		for(SkipListNode<String> node : array){
			aux.add(node.getValue());
		}

		assertEquals("[null, A, B, C, D, null]", aux.toString());
		assertEquals(4,skip.height());


		((SkipListImpl<String>) skip).USE_MAX_HEIGHT_AS_HEIGHT = false;
		array = skip.toArray();
		assertEquals("[<ROOT,4,3>, <1,2>, <3,3>, <4,1>, <5,2>, <NIL,4>]", Arrays.toString(array));

		aux.clear();
		for(SkipListNode<String> node : array){
			aux.add(node.getValue());
		}

		assertEquals("[null, A, B, C, D, null]", aux.toString());
		assertEquals(3,skip.height());

		skip.remove(4);
		assertEquals(3, skip.size());

		((SkipListImpl<String>) skip).USE_MAX_HEIGHT_AS_HEIGHT = true;
		array = skip.toArray();
		assertEquals("[<ROOT,4,4>, <1,2>, <3,3>, <5,2>, <NIL,4>]", Arrays.toString(array));

		aux.clear();
		for(SkipListNode<String> node : array){
			aux.add(node.getValue());
		}

		assertEquals("[null, A, B, D, null]", aux.toString());
		assertEquals(4,skip.height());


		((SkipListImpl<String>) skip).USE_MAX_HEIGHT_AS_HEIGHT = false;
		array = skip.toArray();
		assertEquals("[<ROOT,4,3>, <1,2>, <3,3>, <5,2>, <NIL,4>]", Arrays.toString(array));

		aux.clear();
		for(SkipListNode<String> node : array){
			aux.add(node.getValue());
		}

		assertEquals("[null, A, B, D, null]", aux.toString());
		assertEquals(3,skip.height());


		skip.remove(1);
		skip.remove(5);
		assertEquals(1,skip.size());

		((SkipListImpl<String>) skip).USE_MAX_HEIGHT_AS_HEIGHT = true;
		array = skip.toArray();
		assertEquals("[<ROOT,4,4>, <3,3>, <NIL,4>]", Arrays.toString(array));

		aux.clear();
		for(SkipListNode<String> node : array){
			aux.add(node.getValue());
		}

		assertEquals("[null, B, null]", aux.toString());
		assertEquals(4,skip.height());
		assertEquals(1,skip.size());


		((SkipListImpl<String>) skip).USE_MAX_HEIGHT_AS_HEIGHT = false;
		array = skip.toArray();
		assertEquals("[<ROOT,4,3>, <3,3>, <NIL,4>]", Arrays.toString(array));

		aux.clear();
		for(SkipListNode<String> node : array){
			aux.add(node.getValue());
		}

		assertEquals("[null, B, null]", aux.toString());
		assertEquals(3,skip.height());
		assertEquals(1,skip.size());




		skip.remove(3);

		assertEquals(0,skip.size());

		((SkipListImpl<String>) skip).USE_MAX_HEIGHT_AS_HEIGHT = true;
		array = skip.toArray();
		assertEquals("[<ROOT,4,4>, <NIL,4>]", Arrays.toString(array));

		aux.clear();
		for(SkipListNode<String> node : array){
			aux.add(node.getValue());
		}

		assertEquals("[null, null]", aux.toString());
		assertEquals(4,skip.height());
		assertEquals(0,skip.size());


		((SkipListImpl<String>) skip).USE_MAX_HEIGHT_AS_HEIGHT = false;
		array = skip.toArray();
		assertEquals("[<ROOT,4,1>, <NIL,4>]", Arrays.toString(array));

		aux.clear();
		for(SkipListNode<String> node : array){
			aux.add(node.getValue());
		}

		assertEquals("[null, null]", aux.toString());
		assertEquals(1,skip.height());
		assertEquals(0,skip.size());


	}

	@Test
	public void insertComSuperposicao() {

		SkipList<String> bugTree = new SkipListImpl<String>(5);

		//max altura interna = 4
		bugTree.insert(5, "A", 1);
		bugTree.insert(2, "C", 3);
		bugTree.insert(6, "D", 2);
		bugTree.insert(4, "R", 4);
		bugTree.insert(8, "AAsS", 1);
		bugTree.insert(9, "12", 2);


		if(((SkipListImpl<String>) bugTree).USE_MAX_HEIGHT_AS_HEIGHT) {
			assertEquals(5, bugTree.height());
			change(bugTree);
			assertEquals(4, bugTree.height());

		} else {
			assertEquals(4, bugTree.height());
			change(bugTree);
			assertEquals(5, bugTree.height());
		}
	}

	@Test
	public void brainFuck() {

		SkipList<String> bugTree = new SkipListImpl<String>(0);


		if(((SkipListImpl<String>) bugTree).USE_MAX_HEIGHT_AS_HEIGHT) {
			assertEquals(0, bugTree.height());
			change(bugTree);
			assertEquals(1, bugTree.height());

		} else {
			assertEquals(1, bugTree.height());
			change(bugTree);
			assertEquals(0, bugTree.height());

		}

	}

	@Test
	public void testInsertRandom(){

		((SkipListImpl<String>) skip).USE_MAX_HEIGHT_AS_HEIGHT = false;

		((SkipListImpl<String>)skip).insert(1,"a");
		((SkipListImpl<String>)skip).insert(2,"b");
		((SkipListImpl<String>)skip).insert(3,"c");

		assertTrue(skip.height() <= ((SkipListImpl<String>) skip).maxHeight);
		assertEquals(3, skip.size());

	}

	@Test
	public void testInsertRandom2(){

		((SkipListImpl<String>) skip).USE_MAX_HEIGHT_AS_HEIGHT = false;

		for(int i = 0 ; i < 27 ; i++){
			((SkipListImpl<String>)skip).insert(i,"a" + i);

			assertTrue(skip.height() <= ((SkipListImpl<String>) skip).maxHeight);
			assertEquals(i + 1, skip.size());
		}

	}

	@Test
	public void finalTest(){
		((SkipListImpl<String>) skip).USE_MAX_HEIGHT_AS_HEIGHT = false;

		assertEquals(1, skip.height());
		skip.insert(1,"a",1);
		assertEquals(1, skip.height());
		skip.insert(2,"a",2);
		assertEquals(2, skip.height());
		skip.insert(3,"a",3);
		assertEquals(3, skip.height());

		skip.remove(3);
		assertEquals(2, skip.height());
		skip.remove(2);
		assertEquals(1, skip.height());
		skip.remove(1);
		assertEquals(1, skip.height());
	}

	@Test
	public void testFinal2(){
		((SkipListImpl<String>) skip).USE_MAX_HEIGHT_AS_HEIGHT = false;
		assertNull(((SkipListImpl<String>) skip).root.getForward(1));
		assertNull(((SkipListImpl<String>) skip).root.getForward(2));
		assertNull(((SkipListImpl<String>) skip).root.getForward(3));
		assertEquals(((SkipListImpl<String>) skip).root.getForward(0).getKey(), Integer.MAX_VALUE);

		((SkipListImpl<String>) skip).USE_MAX_HEIGHT_AS_HEIGHT = true;
		skip.insert(1,"a",1);
		assertEquals(((SkipListImpl<String>) skip).root.getForward(0).getKey(), 1);
		assertEquals(((SkipListImpl<String>) skip).root.getForward(1).getKey(), Integer.MAX_VALUE);
		assertEquals(((SkipListImpl<String>) skip).root.getForward(2).getKey(), Integer.MAX_VALUE);
		assertEquals(((SkipListImpl<String>) skip).root.getForward(3).getKey(), Integer.MAX_VALUE);

		((SkipListImpl<String>) skip).USE_MAX_HEIGHT_AS_HEIGHT = false;
		skip.remove(1);
		assertNull(((SkipListImpl<String>) skip).root.getForward(1));
		assertNull(((SkipListImpl<String>) skip).root.getForward(2));
		assertNull(((SkipListImpl<String>) skip).root.getForward(3));
		assertEquals(((SkipListImpl<String>) skip).root.getForward(0).getKey(), Integer.MAX_VALUE);
	}

	private void change(SkipList<String> bugTree) {
		((SkipListImpl<String>) bugTree).USE_MAX_HEIGHT_AS_HEIGHT = !((SkipListImpl<String>) bugTree).USE_MAX_HEIGHT_AS_HEIGHT;
	}



}