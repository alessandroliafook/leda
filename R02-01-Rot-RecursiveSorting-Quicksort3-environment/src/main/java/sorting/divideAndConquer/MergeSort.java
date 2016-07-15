package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@SuppressWarnings("unchecked")
	public void sort(T[] array, int leftIndex, int rightIndex) {
	
		int length = rightIndex - leftIndex;
		T[] tmpArray = (T[]) new Comparable<?> [length + 1];
		
		mergeSort(array, tmpArray,  leftIndex, rightIndex);
	}


	private void mergeSort(T [ ] array, T [ ] tmpArray, int leftIndex, int rightIndex)	{
		
		if( leftIndex < rightIndex ) {
			
			int center = (leftIndex + rightIndex) / 2;
		
			mergeSort(array, tmpArray, leftIndex, center);
			mergeSort(array, tmpArray, center + 1, rightIndex);
			
			merge(array, tmpArray, leftIndex, center + 1, rightIndex);
		}
	}


    private void merge(T[ ] array, T[ ] tmpArray, int leftIndex, int rightIndex, int endIndex) {
        
    	int leftEnd = rightIndex - 1;
        int k = leftIndex;
        int num = endIndex - leftIndex + 1;

        while(leftIndex <= leftEnd && rightIndex <= endIndex) {
            
        	if(array[leftIndex].compareTo(array[rightIndex]) <= 0){
        		
                tmpArray[k++] = array[leftIndex++];
            
        	} else {
                tmpArray[k++] = array[rightIndex++];
        	}
        }
        
        while(leftIndex <= leftEnd) {    
            tmpArray[k++] = array[leftIndex++];
        }
        
        while(rightIndex <= endIndex) {  
            tmpArray[k++] = array[rightIndex++];

        }

        for(int i = 0; i < num; i++, endIndex--) {
            array[endIndex] = tmpArray[endIndex];
        }
    }
 }

