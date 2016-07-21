package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * The combsort algoritm.
 */
public class CombSort<T extends Comparable<T>> extends AbstractSorting<T> {
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (!validaParametros(array, leftIndex, rightIndex)) {
			return;
		}

		int length = rightIndex - leftIndex;
		double fator = 1.25;
		double gap = length / fator;
		int jump = (int) gap;

		while (jump > 1) {

			int i = leftIndex;

			while (i + jump <= rightIndex) {

				if (array[i].compareTo(array[i + jump]) > 0) {
					Util.swap(array, i, i + jump);
				}

				i++;
			}

			gap = gap / fator;
			jump = (int) gap;
		}

		bubbleSort(array, leftIndex, rightIndex);

	}

	private boolean validaParametros(T[] array, int leftIndex, int rightIndex) {

		if (array == null || leftIndex < 0 || leftIndex >= rightIndex || rightIndex >= array.length) {
			return false;
		}

		return true;
	}

	private void bubbleSort(T[] array, int leftIndex, int rightIndex) {

		boolean change = true;
		int i = leftIndex;
		
		while(change == true && i <= rightIndex){

			change = false;
			
			for (int j = leftIndex; j < rightIndex; j++) {

				if (array[j].compareTo(array[j + 1]) > 0) {
					Util.swap(array, j, j + 1);
					change = true;
				}

			}
			
			i++;
		}

	}
}
