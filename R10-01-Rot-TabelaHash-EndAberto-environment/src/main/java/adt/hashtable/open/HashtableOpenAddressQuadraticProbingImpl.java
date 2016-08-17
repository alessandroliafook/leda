package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {

		if (element == null || indexOf(element) != -1) {
			return;

		} else if (isFull()) {
			throw new HashtableOverflowException();

		} else {

			int probe = 0;
			int index = getIndex(element, probe);

			if (isNull(index) || isDeleted(index)) {
				super.table[index] = element;
				super.elements++;

			} else {

				while (!isNull(index) && !isDeleted(index) && probe < super.table.length) {
					index = ((HashFunctionQuadraticProbing<T>) hashFunction).hash(element, ++probe);
					super.COLLISIONS++;
				}

				if (isNull(index) || isDeleted(index)) {
					super.table[index] = element;
					super.elements++;
				}
			}
		}
	}

	@Override
	public void remove(T element) {

		if (element == null)
			return;

		int index = indexOf(element);

		if (indexOf(element) == -1) {
			return;

		} else {

			int firstIndex = getIndex(element, 0);
			int probe = 0;

			if (index != firstIndex) {

				int auxIndex = getIndex(element, probe);

				while (auxIndex != index) {
					auxIndex = getIndex(element, ++probe);

				}
			}

			super.table[index] = deletedElement;
			super.elements--;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T search(T element) {

		if (element == null)
			return null;

		int index = indexOf(element);

		if (indexOf(element) == -1) {
			return null;

		} else {
			return (T) super.table[index];
		}
	}

	@Override
	public int indexOf(T element) {

		if (element == null) {
			return -1;
		}

		int probe = 0;
		int index = getIndex(element, probe);

		if (isNull(index)) {
			return -1;

		} else if (isEquals(element, index)) {
			return index;

		} else {

			int firstIndex = index;
			index = getIndex(element, ++probe);

			while (!isNull(index) && !isEquals(element, index) && index != firstIndex) {
				index = getIndex(element, probe++);
			}

			if (index == firstIndex || isNull(index)) {

				return -1;

			} else {

				return index;
			}
		}
	}

	//  metodos auxiliares

	private boolean isEquals(T element, int index) {
		return super.table[index].equals(element);
	}

	private boolean isDeleted(int index) {

		if (isNull(index))
			return false;

		else
			return (super.table[index] instanceof DELETED) ? true : false;
	}

	private boolean isNull(int index) {
		return super.table[index] == null;
	}

	private int getIndex(T element, int probe) {
		return ((HashFunctionQuadraticProbing<T>) hashFunction).hash(element, probe);
	}
}




