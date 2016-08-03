package adt.linkedList.extended;

import java.util.Comparator;
import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

/**
 * The ExtendedSingleList class is a linked list that works with elements that can be compared.
 * To achieve this, the class uses a comparator. You must think about what methods of the super 
 * class must be rewritten to use the comparator. Furthermore, you must implement the new methods 
 * of this list according to their comments.
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class ExtendedSingleLinkedListImpl<T> extends SingleLinkedListImpl<T> {
	
	private Comparator<T> comparator;
	
	public ExtendedSingleLinkedListImpl(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}
	
	@Override
	public T search(T element) {
		if (element != null) {
			SingleLinkedListNode<T> auxNode = head;
			while (! auxNode.isNIL()){
				if (comparator.compare(auxNode.getData(), element) == 0){
					return element;
				}
				auxNode = auxNode.getNext();
			}
		}
		
		return null;
	}
	
	@Override
	public void remove(T element) {
		if (isEmpty()){
			return;
		}
		
		if (element != null) {
			if (comparator.compare(head.getData(), element) == 0){
				setHead(head.getNext());
				return;
			}
			
			SingleLinkedListNode<T> auxNode = head;
			while (! auxNode.getNext().isNIL()){
				if (comparator.compare(auxNode.getNext().getData(), element) == 0){					
					auxNode.setNext(auxNode.getNext().getNext());
					return;
				}
				auxNode = auxNode.getNext();
			}
		}
		
	}

	/**
	 * It returns the least (minimum) element of the list or null if the list is empty.
	 * @return
	 */
	public T minimum(){
		if (isEmpty()){
			return null;
		}
		
		T min_element = head.getData();
		SingleLinkedListNode<T> auxNode = head.getNext();
		
		while (! auxNode.isNIL()){
			if (comparator.compare(auxNode.getData(), min_element) < 0){
				min_element = auxNode.getData();
			}
			auxNode = auxNode.getNext();
		}
		
		return min_element;

	} 
	
	/**
	 * It puts all elements of otherList in this list. The elements are put in the same order 
	 * they appear in otherList. Try to make this methods as fast as possible, that is, with O(1). 
	 * @param otherList
	 */
	public void concatenate(ExtendedSingleLinkedListImpl<T> otherList){
		SingleLinkedListNode<T> auxNodeList1 = head;
		while (! auxNodeList1.isNIL()){
			auxNodeList1 = auxNodeList1.getNext();         // acha o ultimo elemento da lista 1
		}
		
		SingleLinkedListNode<T> auxNodeList2 = otherList.getHead();
		while (! auxNodeList2.isNIL()){
			auxNodeList1.setData(auxNodeList2.getData());
			auxNodeList1.setNext(new SingleLinkedListNode<T>());       // copia todos os elementos da lista 2 para a lista 1, a partir do ultimo elemento de 1
			auxNodeList1 = auxNodeList1.getNext();
			auxNodeList2 = auxNodeList2.getNext();
		}
	}
	
	/**
	 * As linked lists accept repeated elements, this methods remove all occurrences 
	 * of a same element in this list.
	 * @param element
	 */
	public void removeAll(T element){
		while (search(element) != null){
			remove(element);
		}
	}
	

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}
	

	
	
}
