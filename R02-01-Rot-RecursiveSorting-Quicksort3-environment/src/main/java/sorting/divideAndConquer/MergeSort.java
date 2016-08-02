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

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (!validaParametros(array, leftIndex, rightIndex)) {
			return;
		}
		
		int mid = (rightIndex + leftIndex) / 2;
		
		sort(array, leftIndex, mid);
		sort(array, mid + 1, rightIndex);
		merge(array, leftIndex, rightIndex);
	}

	private void merge(T[] array, int leftIndex, int rightIndex) {

		int mid = (rightIndex + leftIndex) / 2;
		
		T[] leftArray = Arrays.copyOfRange(array, leftIndex, mid + 1);
		T[] rightArray = Arrays.copyOfRange(array, mid + 1, rightIndex + 1);
		int i = 0;
		int j = 0;
		
		while(i < leftArray.length && j < rightArray.length){
			if(leftArray[i].compareTo(rightArray[j]) <= 0){
				array[leftIndex++] = leftArray[i++];
			} else {
				array[leftIndex++] = rightArray[j++];
			}
		}

		while(i < leftArray.length){
			array[leftIndex++] = leftArray[i++];
		}

		while(j < rightArray.length){
			array[leftIndex++] = rightArray[j++];
		}
	}

	private boolean validaParametros(T[] array, int leftIndex, int rightIndex) {

		if (array == null || leftIndex < 0 || leftIndex >= rightIndex || rightIndex >= array.length
				|| rightIndex - leftIndex < 1) {
			return false;
		}

		return true;
	}
}
