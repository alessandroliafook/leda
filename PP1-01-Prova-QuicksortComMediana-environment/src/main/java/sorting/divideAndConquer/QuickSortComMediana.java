package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * A mediana de uma colecao de valores é o valor que divide a coleção na metade.
 * A forma mais custosa de encontrar a mediana seria ordenar o array completo e
 * escolher o elemento da metade. Essa abordagem limita o tempo de execucao ao
 * tempo do algoritmo de ordenacao utilizado. Entretanto, existem outras formas
 * de se encontrar a mediana usando-se estrategias dos algoritmos de ordenação
 * vistos (excetuando-se mergesort e quicksort). Sabe-se que a mediana é um
 * excelente pivot para garantir um bom tempo de execução do quicksort.
 * 
 * Voce deve implementar o algoritmo do quicksort que seleciona a mediana dos
 * dados a serem ordenados como pivot. Considere o comentário acima para
 * escolher a mediana.
 * 
 * Obs: VOCE NAO PODE ORDENAR OS DADOS E ESCOLHER O ELEMENTO DO MEIO COMO
 * MEDIANA!!! Qualquer metodo auxiliar deve ser implementado nesta classe!
 * 
 */
public class QuickSortComMediana<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (!validaParametros(array, leftIndex, rightIndex)) {
			return;
		}

		int i = leftIndex;
		int j = rightIndex;
		int indexPivot = mediana(array, leftIndex, rightIndex); // metodo que
																// encontra o
																// indice do
																// pivot que ira
																// dividir a
																// lista ao meio
		T pivot = array[indexPivot];

		while (i <= j) {

			while (array[i].compareTo(pivot) < 0) {
				i++;
			}

			while (array[j].compareTo(pivot) > 0) {
				j--;
			}

			if (i <= j) {
				Util.swap(array, i, j);
				i++;
				j--;
			}
		}

		sort(array, i, rightIndex);
		sort(array, leftIndex, j);
	}

	private int mediana(T[] array, int leftIndex, int rightIndex) {

		int length = rightIndex - leftIndex;
		int[] arrayIndex = new int[length + 1]; // cria um array para armazenar
												// os indices do vetor original
		int i = 0;

		// preenche o array com os indices possíveis
		while (leftIndex <= rightIndex) {
			arrayIndex[i++] = leftIndex++;
		}

		boolean flag = true;
		i = 0;
		int mid = length / 2;

		// ordena a lista de indice ateh a metade atraves de um bubblesort,
		// encontrando assim o indice que irah dividir a lista ao meio
		while (flag == true && i <= mid) {

			flag = false;

			for (int j = 0; j < arrayIndex.length - 1; j++) {

				int index = arrayIndex[j];
				int next = arrayIndex[j + 1];
				if (index < rightIndex) {
					if (array[index].compareTo(array[next]) > 0) {
						arrayIndex[j] = next;
						arrayIndex[j + 1] = index;
						flag = true;
					}
				}
			}
			i++;
		}
		return arrayIndex[mid]; // retorna o indice do futuro pivot
	}

	private boolean validaParametros(T[] array, int leftIndex, int rightIndex) {

		if (array == null || leftIndex < 0 || rightIndex >= array.length || leftIndex >= rightIndex
				|| rightIndex - leftIndex < 1) {
			return false;
		}

		for (T elemento : array) {
			if (elemento == null) {
				return false;
			}
		}

		return true;
	}

}
