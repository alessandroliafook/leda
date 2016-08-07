package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;
<<<<<<< HEAD

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");

=======
	protected int size;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
		this.size = 0;
	}
	
	@Override
	public boolean isEmpty() {
		return (this.size == 0);
>>>>>>> 0a81b92d489e4c7112fd7a9b6ab4a4dbde291975
	}

	@Override
	public int size() {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");

=======
		return this.size;
>>>>>>> 0a81b92d489e4c7112fd7a9b6ab4a4dbde291975
	}

	@Override
	public T search(T element) {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");

=======

		SingleLinkedListNode<T> node = this.head;

		while (!node.isNIL()) {

			if (node.getData().equals(element)) {
				return node.getData();

			} else {
				node = node.getNext();
			}
		}

		return null;
>>>>>>> 0a81b92d489e4c7112fd7a9b6ab4a4dbde291975
	}

	@Override
	public void insert(T element) {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");

=======

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
>>>>>>> 0a81b92d489e4c7112fd7a9b6ab4a4dbde291975
	}

	@Override
	public void remove(T element) {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");

	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");

=======

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
>>>>>>> 0a81b92d489e4c7112fd7a9b6ab4a4dbde291975
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
