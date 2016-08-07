package adt.linkedList;

public class DoubleLinkedListNode<T> extends SingleLinkedListNode<T> {
	protected DoubleLinkedListNode<T> previous;

<<<<<<< HEAD
	public DoubleLinkedListNode() {
=======
	public DoubleLinkedListNode(){
>>>>>>> 0a81b92d489e4c7112fd7a9b6ab4a4dbde291975
	}

	public DoubleLinkedListNode(T data, DoubleLinkedListNode<T> next, DoubleLinkedListNode<T> previous) {
		super(data, next);
		this.previous = previous;
	}

	public DoubleLinkedListNode<T> getPrevious() {
		return previous;
	}

	public void setPrevious(DoubleLinkedListNode<T> previous) {
		this.previous = previous;
	}
	
	
}
