package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

public class BidirectionalBubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	/**
	 * This bubble sort variation has two internal iterations. In the first, it
	 * pushes big elements to the right, like the normal bubble sort does. Then
	 * in the second, iterates the array backwards, that is, from right to left,
	 * while pushing small elements to the left. This process is repeated until
	 * the array is sorted.
	 */
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (!validaParametros(array, leftIndex, rightIndex)) {
			return;
		}

		boolean wasTrade = true;

		while (rightIndex >= leftIndex && wasTrade == true) {

			wasTrade = false;

			for (int i = leftIndex; i < rightIndex; i++) {

				if (array[i].compareTo(array[i + 1]) > 0) {
					Util.swap(array, i, i + 1);
					wasTrade = true;
				}
			}
			rightIndex--;

			for (int j = rightIndex; j > leftIndex; j--) {

				if (array[j].compareTo(array[j - 1]) < 0) {
					Util.swap(array, j, j - 1);
					wasTrade = true;
				}
			}
			leftIndex++;
		}
	}

	private boolean validaParametros(T[] array, int leftIndex, int rightIndex) {

		if (array == null || leftIndex < 0 || rightIndex >= array.length || leftIndex >= rightIndex
				|| rightIndex - leftIndex == 1) {
			return false;
		}

		return true;
	}

}
