package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de Generics.
 * @author Adalberto
 *
 */
public class Vetor <T extends Comparable<T>> {
	
	//O array interno onde os objetos manipulados são guardados
	private T[] arrayInterno;
	
	//O tamanho que o array interno terá
	private int tamanho;
	
	//Indice que guarda a proxima posição vazia do array interno
	private int indice;
	
	//O Comparators a serem utilizados
	private Comparator comparadorMaximo;
	private Comparator comparadorMinimo;
	
	
	public Vetor(int tamanho) {
		super();
		arrayInterno = (T[]) new Object[tamanho];
		this.tamanho = tamanho;
		this.indice = -1;
	}
	
	public void setComparadorMaximo(Comparator comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}


	//Insere um objeto no vetor
	public void inserir(T o){

		if(indice < tamanho)
			arrayInterno[++indice] = o;
		
		else
			throw new RuntimeException("Vetor cheio!");
	}
	
	//Remove um objeto do vetor
	public T remover(T o){
		
		T object = null;
		int i = 0;
	
		while(i < tamanho){
			if(arrayInterno[i].equals(o)){
				object = arrayInterno[i];
				arrayInterno[i] = arrayInterno[tamanho];
				arrayInterno[tamanho] = null;
				tamanho--;
			}			
			i++;
		}				
		return object;
	}
	
	//Procura um elemento no vetor
	public Object procurar(T o){
		T object = null;
		int i = 0;
	
		while(i < tamanho){
			if(arrayInterno[i].equals(o)){
				object = arrayInterno[i];
			}			
			i++;
		}				
		return object;
	}
	
	//Diz se o vetor está vazio
	public boolean isVazio(){
		
		if(indice == -1){
			return true;
		
		} else {
			return false;
		}
	}
	
	//Diz se o vetor está cheio
	public boolean isCheio(){
		if(indice == tamanho){
			return true;
		
		} else {
			return false;
		}
	}
	
}
