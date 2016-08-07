package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;

	@SuppressWarnings("unchecked")
	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {

		if (isFull())
			throw new QueueOverflowException();

		else if (isEmpty()) {

			this.array[++this.head] = element;
			this.tail = this.head;
		}

		else {

			this.tail = ++this.tail % (array.length);
			array[tail] = element;
		}

	}

	@Override
	public T dequeue() throws QueueUnderflowException {

		if (isEmpty())
			throw new QueueUnderflowException();

		else {

			T element = this.array[head];
			
			if (head == tail) {
			
				head = -1;
				tail = -1;
			
			} else {
				this.head = ++this.head % (array.length);

			}
			
			return element;
		}
	}

	@Override
	public T head() {

		if (isEmpty())
			return null;

		else
			return this.array[head];
	}

	@Override
	public boolean isEmpty() {

		return (tail == -1 && head == -1);
	}

	@Override
	public boolean isFull() {

		return (head == (tail + 1) % array.length);
	}

}
