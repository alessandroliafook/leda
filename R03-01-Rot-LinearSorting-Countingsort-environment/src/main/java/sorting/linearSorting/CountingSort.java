package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure evitar desperdicio de 
 * memoria alocando o array de contadores com o tamanho sendo o máximo inteiro presente no array 
 * a ser ordenado.  
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array,int leftIndex, int rightIndex) {

	Integer menor = array[0];
	Integer maior = array[0];
	
	for(int i = leftIndex + 1; i <= rightIndex; i++){
		
		if(menor.compareTo(array[i]) > 0){
			menor = array[i];
		}
		
		if(maior.compareTo(array[i]) < 0){
			maior = array[i];
		}
		
	}

	int length = (int) maior.intValue() - menor.intValue(); 
	int[] arrayIndex = new int[length];
	
	for (int i = 0; i < array.length; i++) {

		int index = array[i] - menor.intValue() - 1;
		arrayIndex[index]++;
				
	}
	
	for (int i = 1; i < arrayIndex.length; i++) {
		arrayIndex[i] += arrayIndex[i - 1];
	}

	for(int i = leftIndex; i <= rightIndex; i++){
		
	}
	
	
	}

}
