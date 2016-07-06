package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor<T extends Comparable<T>> {

	// O array interno onde os objetos manipulados são guardados
	private T[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	/**
	 * Constante que indica o valor correspondente ao indice do array se estiver
	 * vazio.
	 */
	private int ARRAYVAZIO = -1;

	// O Comparators a serem utilizados
	private Comparator comparadorMaximo;
	private Comparator comparadorMinimo;

	@SuppressWarnings("unchecked")
	public Vetor(int tamanho) {
		this.tamanho = tamanho;
		this.indice = -1;
		this.arrayInterno = (T[]) new Comparable<?>[tamanho];
	}

	public void setComparadorMaximo(Comparator comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	// Insere um objeto no vetor
	public void inserir(T element) {

		if (this.indice < this.tamanho) {
			this.arrayInterno[++this.indice] = element;
		}
	}

	// Remove um objeto do vetor
	public T remover(T element) {

		int i = 0;
		while (i < this.tamanho) {
			if (this.arrayInterno[i].equals(element)) {

				int j = i;

				while (j < this.indice && j + 1 < this.tamanho) {
					this.arrayInterno[j] = this.arrayInterno[j + 1];
				}

					if (this.indice == this.tamanho - 1) {
						this.arrayInterno[indice] = null;
					}
				return this.arrayInterno[i];
			}
		}

		return null;
	}

	// Procura um elemento no vetor
	public T procurar(T element) {

		int indiceProcurado = 0;

		while (indiceProcurado <= this.indice) {

			if (this.arrayInterno[indiceProcurado].equals(element)) {
				return this.arrayInterno[indiceProcurado];
			}
		
			indiceProcurado++;
		}

		return null;
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {

		if (this.indice == this.ARRAYVAZIO) {
			return true;

		} else {
			return false;
		}
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {

		if (this.indice == this.tamanho - 1) {
			return true;

		} else {
			return false;
		}
	}
	
	//metodo que retorna o elemento maximo
	public T maximo(){

		T elementoMaximo = this.arrayInterno[0];
		
		for(int i = 1; i <= this.indice; i++){

			if(elementoMaximo.compareTo(this.arrayInterno[i]) < 0){
				elementoMaximo = this.arrayInterno[i];
			}
		}
				
		return elementoMaximo;
	}

	//metodo que retorna o elemento minimo
	public T minimo(){

		T elementoMaximo = this.arrayInterno[0];
		
		for(int i = 1; i <= this.indice; i++){

			if(elementoMaximo.compareTo(this.arrayInterno[i]) > 0){
				elementoMaximo = this.arrayInterno[i];
			}
		}
				
		return elementoMaximo;
	}

	public String toString(){
		
		String array = "";
		
			for(int i = 0; i <= this.indice; i ++){
				array += arrayInterno[i].toString() + System.lineSeparator();
			}
		
		return array;
	}
	
}
