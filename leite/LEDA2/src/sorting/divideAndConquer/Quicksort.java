/**
 * 
 */
package sorting.divideAndConquer;

import sorting.SortingImpl;
import sorting.Util;

public class Quicksort<T extends Comparable<T>> extends SortingImpl<T> {

	
	@Override
	protected void sort(T[] array,int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && leftIndex >= 0){
			int pivot_position = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivot_position - 1);
			sort(array, pivot_position + 1, rightIndex);
		}

	}
	
	private int partition(T[] array, int left, int right){
		int pivot_index = left;
		T pivo = array[left];
		for (int j = pivot_index + 1; j <= right; j++) {
			if (array[j].compareTo(pivo) < 0){
				pivot_index++;
				Util.swap(array, pivot_index, j);
			}
		}
		Util.swap(array, left, pivot_index);
		
		return pivot_index;
		
	}

}
