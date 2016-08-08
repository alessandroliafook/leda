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
		
		if(element == null)
			return;		
		}

	@Override
	public void removeFirst() {

		}

	@Override
	public void removeLast() {

		}

	@Override
	public void insert(T element) {

		}

	@Override
	public void remove(T element) {

		}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}
}
