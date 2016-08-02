package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (!validaParametros(array, leftIndex, rightIndex)) {
			return;
		}

		int left = leftIndex;
		int right = rightIndex;
		T pivot = array[(leftIndex + rightIndex) / 2];

		while (left <= right) {

			while (array[left].compareTo(pivot) < 0) {
				left++;
			}

			while (array[right].compareTo(pivot) > 0) {
				right--;
			}
			if (left <= right) {
				Util.swap(array, left, right);
				left++;
				right--;
			}
		}

		if(left < rightIndex){
			sort(array, left, rightIndex);
		} 
		
		if (leftIndex < right){
			sort(array, leftIndex, right);
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
