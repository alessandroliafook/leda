package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {

		if (isFull()) {
			throw new StackOverflowException();

		} else {
			list.insert(element);
		}
	}

	@Override
	public T pop() throws StackUnderflowException {

		if(isEmpty()) {
			throw new StackUnderflowException();
		
		} else {
			T[] array = list.toArray();
			list.removeLast();
			return array[list.size() - 1];
		}
	}

	@Override
	public T top() {

		if(isEmpty()){
			return null;

		} else {
			T[] array = list.toArray();
			return array[list.size() - 1];
		}
	
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return (list.size() == this.size);
	}

}
