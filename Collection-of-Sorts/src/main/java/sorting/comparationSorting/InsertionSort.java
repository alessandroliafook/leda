package sorting.comparationSorting;

import sorting.AbstractSorting;
import util.Util;

public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (! validaParam(array, leftIndex, rightIndex)) {
			return;
		}

		for (int i = leftIndex + 1; i <= rightIndex; i++) {

			int j = i;

			while (j > leftIndex && array[j].compareTo(array[j - 1]) < 0) {
				Util.swap(array, j, j - 1);
				j--;
			}
		}
	}

	private boolean validaParam(T[] array, int leftIndex, int rightIndex) {

		if (array == null || leftIndex < 0 || leftIndex >= rightIndex || rightIndex - leftIndex == 1
				|| rightIndex >= array.length) {
			
			return false;

		}

		return true;
	}

}
