package adt.linkedList.ordered;

import java.util.Comparator;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListNode;

/**
 * Para testar essa classe voce deve implementar seu comparador. Primeiro
 * implemente todos os métodos requeridos. Depois implemente dois comparadores
 * (com idéias opostas) e teste sua classe com eles. Dependendo do comparador
 * que você utilizar a lista funcionar como ascendente ou descendente, mas a
 * implemntação dos métodos é a mesma.
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class OrderedDoubleLinkedListImpl<T> extends OrderedSingleLinkedListImpl<T>
		implements OrderedLinkedList<T>, DoubleLinkedList<T> {

	private DoubleLinkedListNode<T> last;
	private final DoubleLinkedListNode<T> NILL = new DoubleLinkedListNode<T>();

	public OrderedDoubleLinkedListImpl() {
		super();
		setHead(this.NILL);
		setLast(this.NILL);
	}

	public OrderedDoubleLinkedListImpl(Comparator<T> comparator) {
		super(comparator);
	}

	/**
	 * Este método faz sentido apenas se o elemento a ser inserido pode
	 * realmente ficar na primeira posição (devido a ordem)
	 */
	@Override
	public void insertFirst(T element) {

		if (element == null)
			return;

		else if (isEmpty()) {

			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>(element, this.NILL, this.NILL);

			setHead(newHead);
			setLast(newHead);
			super.size++;

		} else if (comparator.compare(getHead().getData(), element) >= 0) {

			DoubleLinkedListNode<T> oldHead = (DoubleLinkedListNode<T>) getHead();
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>(element, oldHead, this.NILL);

			oldHead.setPrevious(newHead);
			setHead(newHead);
			super.size++;
		}
	}

	@Override
	public void removeFirst() {

		if (isEmpty())
			return;

		else if (size() == 1) {
			setHead(this.NILL);
			setLast(this.NILL);
			this.size--;

		} else {

			DoubleLinkedListNode<T> newHead = (DoubleLinkedListNode<T>) getHead().getNext();

			newHead.setPrevious(this.NILL);
			setHead(newHead);
			this.size--;

			if (size() == 1)
				setLast(newHead);
		}
	}

	@Override
	public void removeLast() {

		if (isEmpty())
			return;

		else {

			DoubleLinkedListNode<T> newLast = (DoubleLinkedListNode<T>) getLast().getPrevious();

			setLast(newLast);
			getLast().setNext(this.NILL);
			super.size--;
		}

	}

	public void insert(T element) {

		if (element == null)
			return;

		else if (isEmpty())
			insertFirst(element);

		else if (comparator.compare(head.getData(), element) >= 0)
			insertFirst(element);

		else {

			DoubleLinkedListNode<T> auxNode = (DoubleLinkedListNode<T>) getHead();

			while (!auxNode.getNext().isNIL() && comparator.compare(auxNode.getNext().getData(), element) <= 0) {
				auxNode = (DoubleLinkedListNode<T>) auxNode.getNext();
			}

			DoubleLinkedListNode<T> nextNode = (DoubleLinkedListNode<T>) auxNode.getNext();
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, nextNode, auxNode);

			auxNode.setNext(newNode);
			nextNode.setPrevious(newNode);
			super.size++;

			if (newNode.getNext().isNIL()) {
				setLast(newNode);
			}
		}
	}

	public void remove(T element) {

		if (element == null || isEmpty())
			return;

		else if (size() == 1)
			removeFirst();

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

	public void setLast(DoubleLinkedListNode<T> node) {
		this.last = node;
	}

	public DoubleLinkedListNode<T> getLast() {
		return this.last;
	}

	@Override
	protected void clear() {
		setHead(NILL);
		setLast(NILL);
		setSize(0);
	}
}
