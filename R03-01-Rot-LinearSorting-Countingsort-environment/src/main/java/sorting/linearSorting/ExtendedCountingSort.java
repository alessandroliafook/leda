package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	private int min = 0;
	private int max = 0;

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if (array.length == 0) {
			return;
		}

		int length = rightIndex + 1;
		int[] sortedArray = new int[length];

		assertMinMax(array, leftIndex, rightIndex);

		int[] arrayOfIndex = new int[this.max - this.min + 1];

		insertIndex(array, leftIndex, rightIndex, arrayOfIndex);
		makeCounts(arrayOfIndex);
		countingSort(array, sortedArray, arrayOfIndex);

		int i = 0;
		int j = leftIndex;

		while (i < sortedArray.length && j <= rightIndex) {
			array[j++] = sortedArray[i++];

		}

	}

	private void countingSort(Integer[] array, int[] sortedArray, int[] arrayOfIndex) {
		for (int i = array.length - 1; i >= 0; i--) {

			int value = array[i] - this.min;
			int index = arrayOfIndex[value];

			sortedArray[index] = array[i];
			arrayOfIndex[value]--;

		}
	}

	private void makeCounts(int[] arrayOfIndex) {

		arrayOfIndex[0]--;

		for (int i = 1; i < arrayOfIndex.length; i++) {
			arrayOfIndex[i] = arrayOfIndex[i] + arrayOfIndex[i - 1];
		}
	}

	private void insertIndex(Integer[] array, int leftIndex, int rightIndex, int[] arrayOfIndex) {

		for (int i = leftIndex; i <= rightIndex; i++) {

			int index = array[i] - this.min;
			arrayOfIndex[index]++;
		}
	}

	private void assertMinMax(Integer[] array, int leftIndex, int rightIndex) {

		this.min = array[leftIndex];
		this.max = array[leftIndex];

		for (int i = 1; i <= rightIndex; i++) {

			if (array[i] < this.min) {
				this.min = array[i];

			} else if (array[i] > this.max) {
				this.max = array[i];
			}
		}
	}
}
