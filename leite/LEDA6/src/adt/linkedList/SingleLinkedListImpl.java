package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;
	
	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();  // direciona o head para o NIL ao criar o objeto
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
		SingleLinkedListNode<T> auxNode = head;
		while (! auxNode.isNIL()){
			if (auxNode.getData().equals(element)){
				return auxNode.getData();
			}
			auxNode = auxNode.getNext();
		}
		
		return null;
	}

	@Override
	public void insert(T element) {
		if (isEmpty()){
			setHead(new SingleLinkedListNode<T>(element, head)); // nesse caso, o head anterior é o NIL
		}
		
		else {
			SingleLinkedListNode<T> auxNode = head;
			while (!auxNode.getNext().isNIL()){
				auxNode = auxNode.getNext();
			}
			
			auxNode.next = new SingleLinkedListNode<T>(element, auxNode.next);
		}

	}

	@Override
	public void remove(T element) {
		if (isEmpty()){
			return;
		}
		
		if (head.getData().equals(element)){
			setHead(head.next);
			return;
		}
		
		SingleLinkedListNode<T> auxNode = head;
		while (! auxNode.next.isNIL()){
			if (auxNode.getNext().getData().equals(element)){					
				auxNode.next = auxNode.next.next;
				return;
			}
			auxNode = auxNode.getNext();
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
	
	

	
}
