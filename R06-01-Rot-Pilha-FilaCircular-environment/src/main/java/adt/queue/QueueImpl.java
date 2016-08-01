package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {

		if (isEmpty()) {
			return null;
		
		} else {
			return array[0];
		}
	}

	@Override
	public boolean isEmpty() {

		if (tail == -1) {
			return true;

		} else {
			return false;
		}
	}

	@Override
	public boolean isFull() {

		if (tail == (array.length - 1)) {
			return true;

		} else {
			return false;
		}
	}

	private void shiftLeft() {

		for (int i = 0; i < (array.length - 1); i++) {
			array[i] = array[i + 1];
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {

		if (element == null || isFull()) {
			throw new QueueOverflowException();

		} else {
			array[++tail] = element;
		}

	}

	@Override
	public T dequeue() throws QueueUnderflowException {

		if (isEmpty()) {
			throw new QueueUnderflowException();

		} else {
			T element = head();
			shiftLeft();
			return element;
		}
	}
}
