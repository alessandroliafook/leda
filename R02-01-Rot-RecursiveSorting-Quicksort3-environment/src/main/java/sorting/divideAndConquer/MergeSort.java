package sorting.divideAndConquer;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (! validaParametros(array, leftIndex, rightIndex)) {
			return;
		}

		int mid = (rightIndex + leftIndex) / 2;
		sort(array, leftIndex, mid);
		sort(array, mid, rightIndex);
		merge(array, leftIndex, rightIndex);
	}

	private void merge(T[] array, int leftIndex, int rightIndex) {

		int mid = (rightIndex + leftIndex) / 2;
		T[] arrayLeft = Arrays.copyOfRange(array, leftIndex, mid);
		T[] arrayRight = Arrays.copyOfRange(array, mid, rightIndex + 1);

		int i = leftIndex;
		int j = 0;
		int k = 0;

		while (j < arrayLeft.length && k < arrayRight.length) {
			
			if (arrayLeft[j].compareTo(arrayRight[k]) <= 0) {
				array[i++] = arrayLeft[j++];
			
			} else {
				array[i++] = arrayRight[k++];
			}
		}

		while (j < arrayLeft.length) {
			array[i++] = arrayLeft[j++];
		}

		while (k < arrayRight.length) {
			array[i++] = arrayLeft[k++];
		}
	}

	private boolean validaParametros(T[] array, int leftIndex, int rightIndex) {

		if (array == null || rightIndex >= array.length || leftIndex >= rightIndex || leftIndex < 0
				|| rightIndex - leftIndex <= 1) {
			return false;
		}

		return true;
	}

}
