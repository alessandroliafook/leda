package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it pushes big
 * elements to the right, like the normal bubble sort does. Then in the second, iterates the
 * array backwards, that is, from right to left, while pushing small elements to the left.
 * This process is repeated until the array is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends AbstractSorting<T>{

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		int start = leftIndex;
		int end = rightIndex - 1;
		
		while(start < end){

			for(int indice = start; indice <= end; indice ++){
				if(array[indice].compareTo(array[indice+1]) > 0){
					Util.swap(array, indice, indice+1);
				}
			}
			start++;

			for(int indice = end; indice >= start; indice --){
				if(array[indice].compareTo(array[indice-1]) < 0){
					Util.swap(array, indice, indice-1);
				}
			}
			end--;
		}
	}
}
