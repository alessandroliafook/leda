package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (rightIndex - leftIndex == 2) {

			if (array[leftIndex].compareTo(array[rightIndex]) > 0) {
				Util.swap(array, rightIndex, leftIndex);
			}

		} else if (rightIndex - leftIndex > 2) {

			boolean change = false;
			oneStepBubble(array, leftIndex, rightIndex, change);

			if (change = true) {
				sort(array, leftIndex, --rightIndex);
			}
		}
	}

	/**
	 * This sort algorithm iterates over the array one time, and move the
	 * big element to the end of the array.
	 */

	private void oneStepBubble(T[] array, int leftIndex, int rightIndex, boolean change) {

		if (leftIndex < rightIndex) {

			if (array[leftIndex].compareTo(array[leftIndex + 1]) > 0) {
				Util.swap(array, leftIndex + 1, leftIndex);
				change = true;
			}

			oneStepBubble(array, leftIndex + 1, rightIndex, change);
		}
	}
}
