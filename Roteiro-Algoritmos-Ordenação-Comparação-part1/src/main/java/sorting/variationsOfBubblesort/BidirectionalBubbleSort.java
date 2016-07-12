package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (leftIndex < rightIndex) {

			moveGreater(array, leftIndex, rightIndex);
			leftIndex++;

			moveSmaler(array, leftIndex, rightIndex);
			rightIndex--;

			sort(array, leftIndex, rightIndex);
		}
	}

	/**
	 * This bubble sort variation where move the small element to the end of the
	 * array, with one pass and using recursion.
	 */
	private void moveSmaler(T[] array, int leftIndex, int rightIndex) {

		if (leftIndex < rightIndex) {

			if (array[rightIndex].compareTo(array[rightIndex - 1]) < 0) {
				Util.swap(array, rightIndex, rightIndex - 1);
			}

			moveSmaler(array, leftIndex, --rightIndex);
		}
	}

	/**
	 * This bubble sort variation where move the big element to the end of the
	 * array, with one pass and using recursion.
	 */
	private void moveGreater(T[] array, int leftIndex, int rightIndex) {

		if (leftIndex < rightIndex) {

			if (array[leftIndex].compareTo(array[leftIndex + 1]) > 0) {
				Util.swap(array, leftIndex, leftIndex + 1);
			}

			moveGreater(array, ++leftIndex, rightIndex);
		}
	}
}
