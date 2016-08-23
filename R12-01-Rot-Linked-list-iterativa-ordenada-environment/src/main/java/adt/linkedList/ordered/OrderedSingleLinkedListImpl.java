package adt.linkedList.ordered;

import java.util.Comparator;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

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
public class OrderedSingleLinkedListImpl<T> extends SingleLinkedListImpl<T>
		implements OrderedLinkedList<T> {

	protected Comparator<T> comparator;

	@SuppressWarnings("unchecked")
	public OrderedSingleLinkedListImpl() {

		comparator = (T o1, T o2) -> ((Comparable<T>) o1).compareTo(o2);
	}

	public OrderedSingleLinkedListImpl(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	@Override
	public void insert(T element) {

		if (element == null)
			return;

		else if (isEmpty()) {

			SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>(element, NILL);
			setHead(newHead);
			super.size++;

		} else if (comparator.compare(head.getData(), element) >= 0) {

			SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>(element, getHead());
			setHead(newHead);
			super.size++;

		} else {

			SingleLinkedListNode<T> auxNode = getHead();

			while (!auxNode.getNext().isNIL() && comparator.compare(auxNode.getNext().getData(), element) <= 0) {
				auxNode = auxNode.getNext();
			}

			SingleLinkedListNode<T> nextNode = (auxNode.getNext().isNIL()) ? new SingleLinkedListNode<T>(element, NILL)
					: new SingleLinkedListNode<T>(element, auxNode.getNext());

			auxNode.setNext(nextNode);
			super.size++;
		}
	}

	@Override
	public T minimum() {
		
		if(isEmpty())
			return null;
		
		else if(size() == 1)
			return getHead().getData();
		
		else if(comparator.compare(getHead().getData(), getHead().getNext().getData()) < 0)
			return getHead().getData();
		
		else {
			
			SingleLinkedListNode<T> node = getHead();
			
			while(! node.getNext().isNIL() && comparator.compare(node.getData(), node.getNext().getData()) <= 0){
				node = node.getNext();
			}
			
			return node.getData();
		}
	}

	@Override
	public T maximum() {
		
		if(isEmpty())
			return null;
		
		else if(size() == 1)
			return getHead().getData();
		
		else if(comparator.compare(getHead().getData(), getHead().getNext().getData()) > 0)
			return getHead().getData();
		
		else {
			
			SingleLinkedListNode<T> node = getHead();
			
			while(! node.getNext().isNIL() && comparator.compare(node.getData(), node.getNext().getData()) <= 0){
				node = node.getNext();
			}
			
			return node.getData();
		}
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	protected void clear() {

		this.setHead(NILL);
		setSize(0);
	}

	public void setComparator(Comparator<T> comparator) {

		this.comparator = comparator;

		T[] array = this.toArray();
		clear();

		for (T element : array) {
			insert(element);
		}
	}
}
