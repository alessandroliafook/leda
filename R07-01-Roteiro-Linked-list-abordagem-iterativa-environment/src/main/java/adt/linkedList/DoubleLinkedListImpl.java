package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	private final DoubleLinkedListNode<T> NILL = new DoubleLinkedListNode<T>();

	public DoubleLinkedListImpl() {
		setLast(NILL);
		setHead(NILL);
	}

	@Override
	public void insertFirst(T element) {

		if (element == null)
			return;
		
		else if(isEmpty()) {

			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>(element, this.NILL, this.NILL);
			setHead(newHead);
			setLast(newHead);
			super.size++;

			
		} else {

			DoubleLinkedListNode<T> oldHead = (DoubleLinkedListNode<T>) getHead();
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>(element, oldHead, NILL);

			oldHead.setPrevious(newHead);
			setHead(newHead);
			super.size++;
		}
	}

	@Override
	public void removeFirst() {

		if (!isEmpty()) {
			DoubleLinkedListNode<T> newHead = (DoubleLinkedListNode<T>) getHead().getNext();
			newHead.setPrevious(NILL);
			setHead(newHead);
			super.size--;
		}
	}

	@Override
	public void removeLast() {

		DoubleLinkedListNode<T> newLast = (DoubleLinkedListNode<T>) getLast().getPrevious();
		setLast(newLast);
		getLast().setNext(this.NILL);
		super.size--;
	}

	@Override
	public void insert(T element) {

		if (element == null)
			return;

		else if (isEmpty()) {
			insertFirst(element);

		} else {

			DoubleLinkedListNode<T> auxNode = (DoubleLinkedListNode<T>) getLast();
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, NILL, auxNode);
			
			auxNode.setNext(newNode);
			setLast(newNode);
			super.size++;
		}
	}

	@Override
	public void remove(T element) {

		if (element == null || isEmpty())
			return;

		else if (head.getData().equals(element))
			removeFirst();

		else {

			DoubleLinkedListNode<T> node = searchNode(element);

			if (!node.isNIL()) {

				DoubleLinkedListNode<T> previousNode = (DoubleLinkedListNode<T>) node.getPrevious();
				DoubleLinkedListNode<T> nextNode = (DoubleLinkedListNode<T>) node.getNext();
				
				previousNode.setNext(nextNode);
				nextNode.setPrevious(previousNode);
				super.size--;
			}
		}
	}

	private DoubleLinkedListNode<T> searchNode(T element) {

		DoubleLinkedListNode<T> node = (DoubleLinkedListNode<T>) getHead();

		while (!node.isNIL() && !node.getData().equals(element)) {
			node = (DoubleLinkedListNode<T>) node.getNext();
		}
		return node;
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}
}
