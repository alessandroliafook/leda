package sorting.divideAndConquer;

import java.util.Arrays;

import sorting.SortingImpl;

public class Mergesort<T extends Comparable<T>> extends SortingImpl<T> {
	
	private T[] helper;

	@Override
	protected void sort(T[] array,int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex){
			int med = (rightIndex + leftIndex) / 2;
			sort(array, leftIndex, med);
			sort(array, med + 1, rightIndex);
			mergeTwoSortedList(array, leftIndex, med, rightIndex);
		}

	}
	
	private void mergeTwoSortedList(T[] array, int low, int middle, int high){
		helper = Arrays.copyOfRange(array, low, high + 1);
		
		int i = 0;
		int j = middle - low + 1;
		int k = low;
		
		while (i <= middle - low && j <= high - low){
			if (helper[i].compareTo(helper[j]) < 0){
				array[k] = helper[i];
				i++;
			}
			
			else{
				array[k] = helper[j];
				j++;
			}
			
			k++;
		}
		
		while (i <= middle - low){
			array[k++] = helper[i++];
		}
		
		while (j <= high - low) {
			array[k++] = helper[j++];
		}
		
		
		
	}

}
