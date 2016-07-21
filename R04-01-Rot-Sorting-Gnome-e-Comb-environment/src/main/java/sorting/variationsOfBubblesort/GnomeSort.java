package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * The implementation of the algorithm must be in-place!
 */
public class GnomeSort<T extends Comparable<T>> extends AbstractSorting<T> {
	
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if( ! validaParametros(array, leftIndex, rightIndex)){
			return;
		}

		int pivot = leftIndex + 1;

		while (pivot < rightIndex) {

			int i = pivot + 1;
			
			if (array[i].compareTo(array[pivot]) >= 0) {
				pivot++;

			} else if (array[i].compareTo(array[pivot]) < 0) {

				if (pivot == leftIndex) {

					Util.swap(array, pivot, i);
					pivot++;

				} else {

					Util.swap(array, pivot, i);
					pivot--;
				}
			}
		}
	}

	public boolean validaParametros(T[] array, int leftIndex, int rightIndex) {

		if (array == null || leftIndex < 0 || leftIndex >= rightIndex || rightIndex >= array.length) {
			return false;
		}

		return true;
	}

}
