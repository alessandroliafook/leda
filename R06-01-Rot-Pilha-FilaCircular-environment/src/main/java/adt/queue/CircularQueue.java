package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	@SuppressWarnings("unchecked")
	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {

		if (element == null || isFull()) {
			throw new QueueOverflowException();

		} else {

			if (isEmpty()) {
				head = 0;
				tail = 0;
				array[head] = element;

			} else {

				if (tail < (array.length - 1)) {
					array[++tail] = element;

				} else {
					tail = 0;
					array[tail] = element;
				}
			}
			
			this.elements++;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {

		if (isEmpty()) {
			throw new QueueUnderflowException();

		} else {

			T element = array[head];
			this.elements--;

			if (head < (array.length - 1)) {
				head++;

			} else {
				head = 0;
			}

			return element;
		}

	}

	@Override
	public T head() {

		if (isEmpty()) {
			return null;

		} else {
			return array[head];
		}
	}

	@Override
	public boolean isEmpty() {

		if (elements == 0) {
			return true;

		} else {
			return false;
		}
	}

	@Override
	public boolean isFull() {

		if (elements == array.length) {
			return true;

		} else {
			return false;
		}
	}

}
