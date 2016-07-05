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

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = -1;
		arrayInterno = (T[]) new Object[tamanho];
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
			arrayInterno[++indice] = element;
		}

	}

	// Remove um objeto do vetor
	public T remover(T element) {

		int i = 0;
		while (i < tamanho) {
			if (arrayInterno[i].equals(element)) {

				int j = i;

				while (j < indice && j + 1 < tamanho) {
					arrayInterno[j] = arrayInterno[j + 1];
				}

				if (indice == tamanho - 1) {
					arrayInterno[indice] = null;
				}
				return arrayInterno[i];
			}
		}

		return null;
	}

	// Procura um elemento no vetor
	public T procurar(T element) {
		
		int indiceProcurado = 0;
		
		while(indiceProcurado <= this.indice){
			
			if(arrayInterno[indiceProcurado].equals(element)){
				return arrayInterno[indiceProcurado];
				
			}
			indiceProcurado++;
		}
	
		return null;
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {

		if (indice == ARRAYVAZIO) {
			return true;

		} else {
			return false;
		}
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		if (indice == tamanho - 1) {
			return true;

		} else {
			return false;
		}

	}
}
