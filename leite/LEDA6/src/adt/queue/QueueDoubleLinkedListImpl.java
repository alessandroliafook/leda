package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	
	protected DoubleLinkedList<T> list;
	protected int size;
	
	public QueueDoubleLinkedListImpl(int size) {
		list = new DoubleLinkedListImpl<T>();
		this.size = size;
	}
	
	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()){
			throw new QueueOverflowException();
		}
		
		if (element != null){
			list.insert(element);
		}
		
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()){
			throw new QueueUnderflowException();
		}
		
		T removed_element = list.toArray()[0];
		list.removeFirst();
		return removed_element;
	}

	@Override
	public T head() {
		if (isEmpty()){
			return null;
		}
		return list.toArray()[0];
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
