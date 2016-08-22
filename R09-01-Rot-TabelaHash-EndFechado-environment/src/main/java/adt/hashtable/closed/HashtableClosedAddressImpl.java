package adt.hashtable.closed;

import java.util.LinkedList;

import adt.hashtable.hashfunction.HashFunction;
import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionDivisionMethod;
import adt.hashtable.hashfunction.HashFunctionFactory;
import adt.hashtable.hashfunction.HashFunctionMultiplicationMethod;
import util.Util;

public class HashtableClosedAddressImpl<T> extends AbstractHashtableClosedAddress<T> {

	/**
	 * A hash table with closed address works with a hash function with closed
	 * address. Such a function can follow one of these methods: DIVISION or
	 * MULTIPLICATION. In the DIVISION method, it is useful to change the size
	 * of the table to an integer that is prime. This can be achieved by
	 * producing such a prime number that is bigger and close to the desired
	 * size.
	 * 
	 * For doing that, you have auxiliary methods: Util.isPrime and
	 * getPrimeAbove as documented bellow.
	 * 
	 * The length of the internal table must be the immediate prime number
	 * greater than the given size. For example, if size=10 then the length must
	 * be 11. If size=20, the length must be 23. You must implement this idea in
	 * the auxiliary method getPrimeAbove(int size) and use it.
	 * 
	 * @param desiredSize
	 * @param method
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public HashtableClosedAddressImpl(int desiredSize, HashFunctionClosedAddressMethod method) {
		int realSize = desiredSize;

		if (method == HashFunctionClosedAddressMethod.DIVISION) {
			realSize = this.getPrimeAbove(desiredSize); // real size must the
														// the immediate prime
														// above
		}
		initiateInternalTable(realSize);
		HashFunction function = HashFunctionFactory.createHashFunction(method, realSize);
		this.hashFunction = function;
	}

	// AUXILIARY
	/**
	 * It returns the prime number that is closest (and greater) to the given
	 * number. You can use the method Util.isPrime to check if a number is
	 * prime.
	 */
	int getPrimeAbove(int number) {

		int valor = (Util.isPrime(number)) ? number : getPrimeAbove(number + 1);

		return valor;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void insert(T element) {

		T elementListed = search(element);
		
		if (element == null || elementListed != null)
			return;

		else {

			int key = generateKey(element);

			if (key == -1)
				return;

			else if (this.table[key] == null) {

				this.table[key] = new LinkedList<T>();
				LinkedList<T> list = (LinkedList<T>) this.table[key];

				if (list.add(element))
					super.elements++;

			} else {

				LinkedList<T> list = (LinkedList<T>) this.table[key];

				if (list.add(element)) {
					super.elements++;

					if (list.size() > 1) {
						super.COLLISIONS++;
					}
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void remove(T element) {

		if (element == null)
			return;

		else {

			int key = generateKey(element);

			if (key == -1 || this.table[key] == null)
				return;

			else {

				LinkedList<T> list = (LinkedList<T>) this.table[key];

				int actualSize = list.size();

				if (list.remove(element)) {
					super.elements--;

					if (list.size() <= actualSize) {
						super.COLLISIONS--;
					}
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T search(T element) {

		if (element != null) {

			int key = generateKey(element);

			if (key != -1) {

				if (this.table[key] != null) {

					LinkedList<T> list = (LinkedList<T>) this.table[key];
					
					if (list.contains(element))
						return element;
				}
			}
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int indexOf(T element) {

		int index = -1;

		if (element != null) {

			int key = generateKey(element);

			if (key != -1) {

				if (this.table[key] != null) {

					LinkedList<T> list = (LinkedList<T>) this.table[key];

					if (list.contains(element))
						return key;
				}
			}
		}

		return index;
	}

	private int generateKey(T element) {

		int index = -1;

		if (element != null) {

			if (getHashFunction() instanceof HashFunctionDivisionMethod)
				index = ((HashFunctionDivisionMethod<T>) getHashFunction()).hash(element);

			else if (getHashFunction() instanceof HashFunctionMultiplicationMethod)
				index = ((HashFunctionMultiplicationMethod<T>) getHashFunction()).hash(element);
		}

		return index;
	}
}
