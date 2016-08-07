package adt.linkedList;

import java.util.Arrays;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;
	
	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}
	
	@Override
	public boolean isEmpty() {
		return getHead().isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> auxNode = head;
		while (! auxNode.isNIL()){
			size++;
			auxNode = auxNode.getNext();
		}
		
		return size;
	}

	@Override
	public T search(T element) {
		if (element != null) {
			SingleLinkedListNode<T> auxNode = head;
			while (! auxNode.isNIL()){
				if (auxNode.getData().equals(element)){
					return element;
				}
				auxNode = auxNode.getNext();
			}
		}
		
		return null;
	}

	@Override
	public void insert(T element) {
		if (element != null){
			
			SingleLinkedListNode<T> auxNode = head;
			while (! auxNode.isNIL()){
				auxNode = auxNode.getNext();
			}
			auxNode.data = element;
			auxNode.next = new SingleLinkedListNode<T>();		
		}

	}

	@Override
	public void remove(T element) {
		if (isEmpty()){
			return;
		}
		
		if (element != null) {
			if (head.getData().equals(element)){
				setHead(head.getNext());
				return;
			}
			
			SingleLinkedListNode<T> auxNode = head;
			while (! auxNode.getNext().isNIL()){
				if (auxNode.getNext().getData().equals(element)){					
					auxNode.next = auxNode.getNext().getNext();
					return;
				}
				auxNode = auxNode.getNext();
			}
		}
		
	}
	
	@Override
	public T[] toArray(){
		T[] array = (T[]) new Object[size()];
		SingleLinkedListNode<T> auxNode = head;
		int i = 0;
		while (! auxNode.isNIL()){
			array[i] = auxNode.getData();
			auxNode = auxNode.getNext();
			i++;
		}
		
		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}
	
	public void add(T element, int indice){
		if (indice == 0){
			this.head = new SingleLinkedListNode<T>(element, head);
			return;
		}
		
		int i = 1;
		SingleLinkedListNode<T> auxNode = head;
		
		while (! auxNode.next.isNIL() && i != indice){
			auxNode = auxNode.getNext();
			i++;
		}
		
		auxNode.next = new SingleLinkedListNode<T>(element, auxNode.next);
		
	}
	
	
	public static void main(String[] args) {
		SingleLinkedListImpl<Integer> lista = new SingleLinkedListImpl<Integer>();
		lista.insert(1);
		lista.insert(3);
		lista.insert(4);
		
		System.out.println(Arrays.toString(lista.toArray()));
		
		lista.add(2, 5);
		
		System.out.println(Arrays.toString(lista.toArray()));
	}

	
}
