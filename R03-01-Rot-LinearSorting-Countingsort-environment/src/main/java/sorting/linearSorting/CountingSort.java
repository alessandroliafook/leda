package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if (array.length == 0) {
			return;
		}

		int max = getMax(array, leftIndex, rightIndex);
		int[] arrayOfIndex = new int[max + 1];
		int[] sortedArray = new int[array.length];

		insertIndex(array, leftIndex, rightIndex, arrayOfIndex);
		makeCounts(arrayOfIndex);
		countingSort(array, leftIndex, rightIndex, arrayOfIndex, sortedArray);

		int i = 0;
		int j = leftIndex;

		while (i < sortedArray.length && j <= rightIndex) {
			array[j++] = sortedArray[i++];

		}
	}

	private void countingSort(Integer[] array, int leftIndex, int rightIndex, int[] arrayOfIndex, int[] sortedArray) {

		for (int i = rightIndex; i >= leftIndex; i--) {

			int value = array[i];
			int index = arrayOfIndex[value];

			sortedArray[index] = value;
			arrayOfIndex[value]--;
		}
	}

	private void makeCounts(int[] arrayIndex) {
		arrayIndex[0]--;
		for (int i = 1; i < arrayIndex.length; i++) {
			arrayIndex[i] = arrayIndex[i] + arrayIndex[i - 1];
		}
	}

	private void insertIndex(Integer[] array, int leftIndex, int rightIndex, int[] arrayIndex) {
		for (int i = leftIndex; i <= rightIndex; i++) {

			int value = array[i];
			arrayIndex[value]++;
		}
	}

	private int getMax(Integer[] array, int leftIndex, int rightIndex) {
		
		int max = array[leftIndex];
		
		for (int i = leftIndex + 1; i <= rightIndex; i++) {

			if (array[i] > max) {
				max = array[i];
			}
		}
		
		return max;
	}

}
