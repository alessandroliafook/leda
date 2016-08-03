package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	DoubleLinkedListNode<T> last;
	
	private final DoubleLinkedListNode<T> NIL = new DoubleLinkedListNode<T>();
	
	public DoubleLinkedListImpl() {
		this.last = new DoubleLinkedListNode<T>();
		this.head = new DoubleLinkedListNode<T>();
	}
	
	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>(element, (DoubleLinkedListNode<T>)head, NIL);
		DoubleLinkedListNode<T> oldHead = (DoubleLinkedListNode<T>) head;
		oldHead.previous = newHead;
		if (isEmpty()){
			last = newHead;
		}
		head = newHead;
	}

	@Override
	public void removeFirst() {
		if (! isEmpty()){
			head = head.next;
			if (isEmpty()){
				last = (DoubleLinkedListNode<T>)head;
			}
			DoubleLinkedListNode<T> atualHead = (DoubleLinkedListNode<T>) head;
			atualHead.previous = NIL; // NIL
		}
	}
	

	@Override
	public void removeLast() {
		if (! isEmpty()){
			last = last.previous;
			if (last.isNIL()){
				head = last;
			}
			
			last.next = NIL; // NIL
		}
	}
	
	@Override
	public void remove(T element){
		if (isEmpty()){
			return;
		}
		
		else {
			DoubleLinkedListNode<T> auxNode = (DoubleLinkedListNode<T>) head;
			while (! auxNode.isNIL() && ! auxNode.getData().equals(element)){
				auxNode = (DoubleLinkedListNode<T>) auxNode.next;
			}
			
			if (! auxNode.isNIL()){
				if (auxNode.next.isNIL()){        // o no removido é o ultimo da lista
					removeLast();
				}
				else if (auxNode.previous.isNIL()){     // o no removido é o primeiro da lista
					removeFirst();
					
				} else {
					auxNode.previous.next = auxNode.next;
					DoubleLinkedListNode<T> auxNodeNext = (DoubleLinkedListNode<T>) auxNode.next;   // o no está no meio da lista
					auxNodeNext.previous = auxNode.previous;
				}
			}
		}
		
	}
	
	@Override
	public void insert(T element){
		DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<T>(element, NIL, last);
		last.next = newLast;
		if (isEmpty()){
			head = newLast;
		}
		last = newLast;
	}

}
