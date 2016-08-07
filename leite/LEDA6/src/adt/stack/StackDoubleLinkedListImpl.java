package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {
	
	protected DoubleLinkedList<T> list;
	protected int size;
	
	public StackDoubleLinkedListImpl(int size) {
		list = new DoubleLinkedListImpl<T>();
		this.size = size;
	}
	
	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull()){
			throw new StackOverflowException();
		}
		if (element != null) {
			list.insert(element);
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty()){
			throw new StackUnderflowException();
		}
		
		T removed_element = list.toArray()[list.size() - 1];
		list.removeLast();
		return removed_element;
	}

	@Override
	public T top() {
		if (isEmpty()){
			return null;
		}
		return list.toArray()[list.size() - 1];
	}

	@Override
	public boolean isEmpty() {
		return list.size() == 0;
	}

	@Override
	public boolean isFull() {
		return list.size() == size;
	}

}
