package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;
	private int size;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		
		if (size > 0) {
		
			this.array = (T[]) new Object[size];
			this.top = -1;
			this.size = size;
		}
	}

	@Override
	public T top() {

		if (isEmpty())
			return null;

		else
			return this.array[this.top];
	}

	@Override
	public boolean isEmpty() {

		return (this.top == -1);
	}

	@Override
	public boolean isFull() {

		return (this.top == this.size - 1);
	}

	@Override
	public void push(T element) throws StackOverflowException {

		if (isFull())
			throw new StackOverflowException();

		else
			array[++this.top] = element;
	}

	@Override
	public T pop() throws StackUnderflowException {

		if (isEmpty())
			throw new StackUnderflowException();

		else
			return array[this.top--];
	}
}
