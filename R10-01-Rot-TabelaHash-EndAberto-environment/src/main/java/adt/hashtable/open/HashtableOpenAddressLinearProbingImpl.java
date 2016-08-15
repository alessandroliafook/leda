package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size, HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {

		if (element == null && indexOf(element) != -1) {
			return;

		} else if (isFull()) {
			throw new HashtableOverflowException();

		} else {

			int probe = 0;
			int index = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, probe);

			if (isNull(index) || isDeleted(index)) {
				super.table[index] = element;
				super.elements++;

			} else {

				while (!isNull(index) && !isDeleted(index) && probe < super.table.length) {
					index = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, ++probe);
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

			int firstIndex = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, 0);
			int prob = 0;

			if (index != firstIndex) {

				int auxIndex = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, prob);

				while (auxIndex != index) {
					auxIndex = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, ++prob);

				}
			}

			super.table[index] = deletedElement;
			super.elements--;
			super.COLLISIONS = super.COLLISIONS - prob;
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
		int index = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, probe);

		if (isNull(index)) {
			return -1;

		} else if (isEquals(element, index)) {
			return index;

		} else {

			int firstIndex = index;
			index = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, ++probe);

			while (!isNull(index) && !isEquals(element, index) && index != firstIndex) {
				index = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, probe++);
			}

			if (index == firstIndex || isNull(index)) {

				return -1;

			} else {

				return index;
			}
		}
	}

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

}
