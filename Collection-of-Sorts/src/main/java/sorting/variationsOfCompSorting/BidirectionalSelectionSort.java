package sorting.variationsOfCompSorting;

import sorting.AbstractSorting;
import util.Util;

public class BidirectionalSelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (!validaParametros(array, leftIndex, rightIndex)) {
			return;
		}

		while (rightIndex >= leftIndex) {

			int temp = leftIndex;

			for (int i = leftIndex + 1; i <= rightIndex; i++) {

				if (array[i].compareTo(array[temp]) < 0) {
					temp = i;
				}
			}

			Util.swap(array, temp, leftIndex++);
			temp = rightIndex;

			for (int i = rightIndex; i >= leftIndex; i--) {

				if (array[i].compareTo(array[temp]) > 0) {
					temp = i;
				}
			}
			Util.swap(array, temp, rightIndex--);
		}
	}

	private boolean validaParametros(T[] array, int leftIndex, int rightIndex) {

		if (array == null || leftIndex < 0 || rightIndex >= array.length || rightIndex - leftIndex <= 1
				|| leftIndex > rightIndex) {
			return false;
		}

		return true;
	}

}
