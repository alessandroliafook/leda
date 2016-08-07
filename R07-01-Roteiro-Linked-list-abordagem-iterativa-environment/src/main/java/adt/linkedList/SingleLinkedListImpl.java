package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;
	protected int size;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
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

		SingleLinkedListNode<T> node = this.head;

		while (!node.isNIL()) {

			if (node.getData().equals(element)) {
				return node.getData();

			} else {
				node = node.getNext();
			}
		}

		return null;
	}

	@Override
	public void insert(T element) {

		if (element == null) {
			return;
		}

		SingleLinkedListNode<T> aux = head;

		if (head.isNIL()) {

			SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>(element, aux);
			setHead(newHead);

		} else {

			while (!aux.getNext().isNIL()) {
				aux = aux.getNext();
			}

			SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>(element, aux.getNext());
			aux.setNext(newNode);
		}

		this.size++;
	}

	@Override
	public void remove(T element) {

		if (element == null || head.isNIL()) {
			return;

		} else if (head.getData().equals(element)) {
			head = head.getNext();
			this.size--;

		} else {

			SingleLinkedListNode<T> aux = head;
			SingleLinkedListNode<T> previous = head;

			while (!aux.isNIL() && (! aux.getData().equals(element))) {
				previous = aux;
				aux = aux.getNext();
			}

			if (! aux.isNIL()) {
				previous.setNext(aux.getNext());
				this.size--;
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {

		T[] array = (T[]) new Object[this.size];
		SingleLinkedListNode<T> node = this.head;
		int i = 0;

		while (!node.isNIL()) {
			array[i++] = node.data;
			node = node.next;
		}

		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
