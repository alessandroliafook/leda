package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	private final DoubleLinkedListNode<T> NILL = new DoubleLinkedListNode<T>();

	public DoubleLinkedListImpl() {
		setLast(NILL);
		setHead(NILL);
	}

	@Override
	public void insertFirst(T element) {

		DoubleLinkedListNode<T> oldHead = (DoubleLinkedListNode<T>) getHead();
		DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>(element,
				oldHead, NILL);

		oldHead.setPrevious(newHead);

		if (isEmpty()) {
			setLast(newHead);
		}

		setHead(newHead);
		super.size++;
	}

	@Override
	public void removeFirst() {

		if (!isEmpty()) {

			DoubleLinkedListNode<T> newHead = (DoubleLinkedListNode<T>) head
					.getNext();

			newHead.setPrevious(NILL);
			setHead(newHead);
			super.size--;

			if (isEmpty()) {
				setLast(newHead);
			}
		}
	}

	@Override
	public void removeLast() {

		if (!isEmpty()) {

			setLast(last.getPrevious());
			last.setNext(NILL);
			super.size--;

			if (getLast().isNIL()) {
				setHead(getLast());
			}
		}
	}

	@Override
	public void insert(T element) {

		if (element == null) {
			return;

		} else if (isEmpty()) {
			insertFirst(element);

		} else {

			DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<T>(
					element, NILL, getLast());

			last.setNext(newLast);
			setLast(newLast);
			super.size++;

			if (isEmpty()) {
				setHead(newLast);
			}
		}
	}

	@Override
	public void remove(T element) {

		if (element == null) {
			return;

		} else if (head.getData().equals(element)) {
			removeFirst();

		} else {

			DoubleLinkedListNode<T> node = (DoubleLinkedListNode<T>) getHead();

			while ((!node.isNIL()) && (!node.getData().equals(element))) {
				node = (DoubleLinkedListNode<T>) node.getNext();
			}

			if (!node.isNIL()) {

				if (node.getNext().isNIL()) {
					removeLast();

				} else if (node.getPrevious().isNIL()) {
					removeFirst();

				} else {

					node.getPrevious().setNext(node.getNext());
					DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) node
							.getNext();
					aux.setPrevious(node.getPrevious());
					super.size--;
				}
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}
}
