package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	private final SingleLinkedListNode<T> NILL = new SingleLinkedListNode<T>();
	protected SingleLinkedListNode<T> head;
	protected int size;

	public SingleLinkedListImpl() {
		this.head = this.NILL;
		this.size = 0;
	}

	@Override
	public boolean isEmpty() {
		return (this.size == 0);

	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public T search(T element) {

		if (element == null || isEmpty())
			return null;

		else {
			SingleLinkedListNode<T> listNode = getHead();

			while (!listNode.getNext().isNIL()) {
				if (listNode.getData().equals(element)) {
					return listNode.getData();
				}
				listNode = listNode.getNext();
			}

			return null;
		}
	}

	@Override
	public void insert(T element) {
		
		if (element == null)
			return;

		else if (isEmpty()) {

			SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>(element, getHead());
			setHead(newHead);
			setSize(getSize() + 1);
		
		} else {

			SingleLinkedListNode<T> listNode = getHead();
			
			while(!listNode.getNext().isNIL()){
				listNode = listNode.getNext();
			}
			
			SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>(element, listNode.getNext());
			listNode.setNext(newNode);
			setSize(getSize() + 1);
		}
	}

	@Override
	public void remove(T element) {
		
		if(element == null)
			return;
		
		else if (head.getData().equals(element)){
			setHead(getHead().getNext());
			setSize(getSize() - 1);
		
		} else {
			
			SingleLinkedListNode<T> listNode = getHead();
			SingleLinkedListNode<T> auxNode = listNode.getNext();
			
			while(!auxNode.isNIL()){
				auxNode = listNode;
				listNode = listNode.getNext();
				
				if(listNode.getData().equals(element)){
					auxNode.setNext(listNode.getNext());
					setSize(getSize() - 1);
					return;
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {

		T[] array = (T[]) new Object[getSize()];
		int i = 0;
		
		SingleLinkedListNode<T> listNode = getHead();
		
		while(!listNode.isNIL() && i < getSize()){
			
			array[i++] = listNode.getData();
			listNode = listNode.getNext();
		}

		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
