package sorting.comparationSorting;

import sorting.AbstractSorting;
import util.Util;

public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (!validaParametros(array, leftIndex, rightIndex)) {
			return;
		}

		boolean flag = true;
		int i = (rightIndex + 1) - leftIndex;
		int pass = 0;

		while (flag == true && pass <= i) {

			flag = false;

			for (int j = leftIndex; j < rightIndex - pass; j++) {

				if (array[j].compareTo(array[j + 1]) > 0) {
					Util.swap(array, j, j + 1);
					flag = true;
				}
			}
			pass++;
		}
	}

	private boolean validaParametros(T[] array, int leftIndex, int rightIndex) {

		if (array == null || leftIndex < 0 || leftIndex >= rightIndex || rightIndex - leftIndex < 2
				|| rightIndex >= array.length) {
			return false;
		}

		return true;
	}

}
