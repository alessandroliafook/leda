package sorting.variationsOfCompSorting;

import sorting.AbstractSorting;
import util.Util;

public class BidirectionalBubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if(! validaParametros(array, leftIndex, rightIndex)){
			return;
		}
		
		
			while(rightIndex >= leftIndex){
				
				for(int i = leftIndex; i < rightIndex; i ++){
					
					if(array[i].compareTo(array[i + 1]) > 0){
						Util.swap(array, i, i + 1);
					}
				}
				rightIndex--;
				
				for(int j = rightIndex; j > leftIndex; j--){
					
					if(array[j].compareTo(array[j - 1]) < 0){
						Util.swap(array, j, j - 1);
					}
					
				}
				leftIndex++;
		}
	}

	private boolean validaParametros(T[] array, int leftIndex, int rightIndex) {

		if (array == null || leftIndex < 0 || rightIndex >= array.length || leftIndex >= rightIndex
				|| rightIndex - leftIndex == 1) {
			return false;
		}

		return true;
	}

}
