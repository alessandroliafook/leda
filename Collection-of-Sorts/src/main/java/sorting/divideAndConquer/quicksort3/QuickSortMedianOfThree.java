package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte: 
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo. 
 * 2. Ordenar os elemento, tal que: A[left] < A[center] < A[right]. 
 * 3. Adotar o A[center] como pivô. 
 * 4. Colocar o pivô na penúltima posição A[right-1]. 
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1]. 
 * 6. Aplicar o algoritmo na metade a esquerda e na metade a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {

		int size = rightIndex - leftIndex + 1;

		if (size <= 3) {
			speedSort(array, leftIndex, rightIndex);

		} else {
			
			T pivot = choosePivot(array, leftIndex, rightIndex);
			int partition = applyParticion(array, leftIndex, rightIndex, pivot);

			sort(array, leftIndex, partition - 1);
			sort(array, partition + 1, rightIndex);
		}

	}

	/**
	 * Metodo que escolhe o pivo, entre os elementos do inicio, meio e fim do Array
	 * ordenando aqueles entre si.
	 */
	public T choosePivot(T[] array, int leftIndex, int rightIndex) {
		
		int middleIndex = (leftIndex + rightIndex) / 2;

		sortOf3(array, leftIndex, middleIndex, rightIndex);
		Util.swap(array, middleIndex, rightIndex - 1);

		return array[rightIndex - 1];
	}

	/**
	 * Metodo que seleciona o indice do array onde deve ocorrer a particao para otimizar a 
	 * ordenacao.
	 */
	public int applyParticion(T[] array, int leftIndex, int rightIndex, T pivot) {
		
		int leftPtr = leftIndex;
		int rightPtr = rightIndex - 1;
		boolean flag = true;
		
		while (flag) {
			
			while (array[++leftPtr].compareTo(pivot) < 0) {
				;
			}
			
			while (array[--rightPtr].compareTo(pivot) > 0) {
				;
			}
			
			if (leftPtr >= rightPtr) {
				flag = false;
			
			} else {
				Util.swap(array, leftPtr, rightPtr);
			}
		}

		Util.swap(array, leftPtr, rightIndex - 1);
		return leftPtr;
	}

	/**
	 * Metodo que ordena rapidamente uma lista que contenha 3 ou menos elementos.
	 */
	public void speedSort(T[] array, int leftIndex, int rightIndex) {
		
		int size = rightIndex - leftIndex + 1;
		
		if (size == 2) {

			if (array[leftIndex].compareTo(array[rightIndex]) > 0) {
				Util.swap(array, leftIndex, rightIndex);
			}
		
		} else if (size == 3) {
			
			sortOf3(array, leftIndex, rightIndex - 1, rightIndex);
		}
	}
	
	/**
	 * Metodo que ordena tres elementos de uma lista entre si.
	 */
	public void sortOf3(T[] array, int leftIndex, int middleIndex, int rightIndex){

		if (array[leftIndex].compareTo(array[middleIndex]) > 0) {
			Util.swap(array, leftIndex, middleIndex);
		}
		
		if (array[leftIndex].compareTo(array[rightIndex]) > 0) {
			Util.swap(array, leftIndex, rightIndex);
		}
		
		if (array[middleIndex].compareTo(array[rightIndex]) > 0) {
			Util.swap(array, middleIndex, rightIndex);
		}
	}
}
