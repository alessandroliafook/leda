package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int size;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {

		if (size > 0) {

			this.array = (T[]) new Object[size];
			this.tail = -1;
			this.size = size;
		}
	}

	@Override
	public T head() {
	
		if (isEmpty())
			return null;

		else
			return this.array[0];
	}

	@Override
	public boolean isEmpty() {

		return (this.tail == -1);
	}

	@Override
	public boolean isFull() {

		return (this.tail == this.size - 1);
	}

	private void shiftLeft() {

		int index = 1;

		while (index <= this.tail) 
			array[index - 1] = array[index++];
		
		tail--;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {

		if (isFull()) throw new QueueOverflowException();

		else
			this.array[++tail] = element;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {

		if (isEmpty())
			throw new QueueUnderflowException();

		else {

			T element = array[0];

			shiftLeft();

			return element;
		}

	}
}
