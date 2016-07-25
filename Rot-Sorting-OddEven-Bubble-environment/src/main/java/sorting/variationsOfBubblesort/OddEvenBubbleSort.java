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
		
		boolean flag = true;
		int j = leftIndex;
		
			while(flag == true && j <= rightIndex){
				
				flag = false;
				
			for (int i = leftIndex; i <= rightIndex - 2; i++) {
				if (array[i].compareTo(array[i + 2]) > 0) {
					Util.swap(array, i, i + 2);
					flag = true;
				}
			}
			j++;
		}
		merge(array, leftIndex, rightIndex);

	}

	@SuppressWarnings("unchecked")
	private void merge(T[] array, int leftIndex, int rightIndex) {

		int indexPar = leftIndex;
		int indexImpar = leftIndex + 1;
		int indexCopy = 0;
		T[] arrayTemp = (T[]) new Comparable<?>[rightIndex - leftIndex + 1];

		while (indexPar <= rightIndex && indexImpar <= rightIndex) {
			if (array[indexPar].compareTo(array[indexImpar]) < 0) {
				arrayTemp[indexCopy++] = array[indexPar];
				indexPar = indexPar + 2;
			} else {
				arrayTemp[indexCopy++] = array[indexImpar];
				indexImpar = indexImpar + 2;
			}
		}

		while (indexPar <= rightIndex) {
			arrayTemp[indexCopy++] = array[indexPar];
			indexPar = indexPar + 2;
		}

		while (indexImpar <= rightIndex) {
			arrayTemp[indexCopy++] = array[indexImpar];
			indexImpar = indexImpar + 2;
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
