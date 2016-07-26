package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This algorithm simulates a logical partitioning of the input array by
 * considering different indexing, that is, the first sub-array is indexed by
 * even elements and the second sub-array is indexed by odd elements. Then, it
 * applies a complete bubblesort in the first sub-array considering neighbours
 * (even). After that, it applies a complete bubblesort in the second sub-array
 * considering neighbours (odd). After that, the algorithm performs a merge
 * between elements indexed by even and odd numbers.
 */
public class OddEvenBubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (!validaParametros(array, leftIndex, rightIndex)) {
			return;
		}

		boolean trade = true;
		int j = leftIndex;

		while (trade == true && j <= rightIndex) {

			trade = false;
			int indexEven = leftIndex;

			while (indexEven <= rightIndex - 2) {

				if (array[indexEven].compareTo(array[indexEven + 2]) > 0) {
		
					Util.swap(array, indexEven, indexEven + 2);
					trade = true;
				}
		
				indexEven += 2;
			}
			
			int indexOdd = leftIndex + 1;
			
			while (indexOdd <= rightIndex - 2) {

				if (array[indexOdd].compareTo(array[indexOdd + 2]) > 0) {
		
					Util.swap(array, indexOdd, indexOdd + 2);
					trade = true;
				}
				indexOdd += 2;
			}

			j++;
		}
		
		merge(array, leftIndex, rightIndex);
	}

	@SuppressWarnings("unchecked")
	private void merge(T[] array, int leftIndex, int rightIndex) {

		int indexEven = leftIndex;
		int indexOdd = leftIndex + 1;
		int indexCopy = 0;
		T[] arrayTemp = (T[]) new Comparable<?>[rightIndex - leftIndex + 1];

		while (indexEven <= rightIndex && indexOdd <= rightIndex) {
			
			if (array[indexEven].compareTo(array[indexOdd]) <= 0) {
				arrayTemp[indexCopy++] = array[indexEven];
				indexEven = indexEven + 2;
		
			} else {
				arrayTemp[indexCopy++] = array[indexOdd];
				indexOdd = indexOdd + 2;
			}
		}

		while (indexEven <= rightIndex) {
			
			arrayTemp[indexCopy++] = array[indexEven];
			indexEven = indexEven + 2;
		}

		while (indexOdd <= rightIndex) {
			
			arrayTemp[indexCopy++] = array[indexOdd];
			indexOdd = indexOdd + 2;
		}

		for (int index = 0; index < arrayTemp.length; index++) {
			array[leftIndex++] = arrayTemp[index];
		}

	}

	private boolean validaParametros(T[] array, int leftIndex, int rightIndex) {

		if (array == null || leftIndex >= rightIndex || rightIndex >= array.length || leftIndex < 0
				|| rightIndex - leftIndex < 2) {
			return false;
		}

		return true;
	}

}
