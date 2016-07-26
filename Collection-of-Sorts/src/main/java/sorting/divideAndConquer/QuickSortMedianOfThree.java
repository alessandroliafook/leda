package sorting.divideAndConquer;

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

		if(! validaParametros(array, leftIndex, rightIndex)){
			return;
		}
		
		partition(array, leftIndex, rightIndex);
		
		int left = leftIndex + 1;
		int right = rightIndex - 1;
		T pivot = array[rightIndex - 1];
		
		while(left <= right){
			
			while(array[left].compareTo(pivot) < 0){
				left++;
			}
			
			while(array[right].compareTo(pivot) > 0){
				right--;
			}
			
			if(left <= right){
				Util.swap(array, right--, left++);
			}
		}
		
		if(leftIndex < right){
			sort(array, leftIndex, right);
		}
		
		if(left < rightIndex){
			sort(array, left, rightIndex);
		}
		
	}
	
	private boolean validaParametros(T[] array, int leftIndex, int rightIndex) {

		if (array == null || leftIndex < 0 || leftIndex >= rightIndex || rightIndex >= array.length
				|| rightIndex - leftIndex < 1) {
			return false;
		}

		return true;
	}
	
	private void partition(T[] array, int leftIndex, int rightIndex){
		
		int midIndex = (leftIndex + rightIndex) / 2;
		
		if(array[leftIndex].compareTo(array[midIndex]) > 0){
			Util.swap(array, leftIndex, midIndex);
		}
		if(array[leftIndex].compareTo(array[rightIndex]) > 0){
			Util.swap(array, leftIndex, rightIndex);
		}
		if(array[midIndex].compareTo(array[rightIndex]) > 0){
			Util.swap(array, midIndex, rightIndex);
		}
		
		Util.swap(array, midIndex, rightIndex - 1);
	}
	

}
