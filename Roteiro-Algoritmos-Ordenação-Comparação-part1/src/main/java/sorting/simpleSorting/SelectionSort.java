package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (leftIndex < rightIndex) {
			int smaler = leftIndex;

			smaler = selectSmaler(array, leftIndex, rightIndex, smaler);

			Util.swap(array, leftIndex, smaler);
			sort(array, ++leftIndex, rightIndex);
		}
	}

	/**
	 * This sort algorithm chooses the smallest element from the array and return his index.
	 */
	private int selectSmaler(T[] array, int leftIndex, int rightIndex, int smaler) {

		if (leftIndex <= rightIndex) {

			if (array[leftIndex].compareTo(array[smaler]) < 0) {
				smaler = selectSmaler(array, ++leftIndex, rightIndex, leftIndex);

			} else {
				smaler = selectSmaler(array, ++leftIndex, rightIndex, smaler);
			}
		}
		return smaler;
	}
}
