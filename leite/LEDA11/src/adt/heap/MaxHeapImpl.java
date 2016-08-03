package adt.heap;

import java.util.Arrays;

public class MaxHeapImpl<T extends Comparable<T>> implements MaxHeap<T> {
	
	private static final int INITIAL_SIZE = 20;
	private static final int INCREASING_FACTOR = 10;
	
	private T[] array;
	private int size = 0;
	private int maxSize = INITIAL_SIZE;
	
	public MaxHeapImpl(){
		array = (T[]) new Comparable[INITIAL_SIZE];
	}

	private int parent(int i){
		return (i - 1) / 2;
	}
	
	private int left(int i){
		return 2 * i + 1;
	}

	private int right(int i){
		return 2 * i + 2;
	}

	
	@Override
	public void buildHeap(T[] array){
		if (array == null){
			return;
		}
		T[] auxArray = (T[]) new Comparable[array.length];
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null){
				auxArray[index] = array[i];        // "remove" os elementos nulos do array recebido
				index++;
			}
		}
		
		this.array = auxArray;
		this.maxSize = auxArray.length;
		this.size = index;  // size sera o numero de elementos nao nulos do array recebido
		
		for (int i = parent(size - 1); i >= 0; i--) {
			heapify(i);
		}
	}
	
	private void heapify(int position){
		int left = left(position);
		int right = right(position);
		int max = position;
		
		if (left < size && array[left].compareTo(array[position]) > 0){
			max = left;
		}
		
		if (right < size && array[right].compareTo(array[max]) > 0){
			max = right;
		}
		
		if (max != position){
			Util.swap(array, max, position);
			heapify(max);
		}
		
		
	}
	
	@Override
	public boolean isEmpty(){
		return size == 0;
	}
	
	@Override
	public void insert(T element) {
		if (element == null){
			return;
		}
		if (size == maxSize){
			increaseHeap();
		}
		
		size++;
		int i = size - 1;
		while ((i > 0) && array[parent(i)].compareTo(element) < 0){
			array[i] = array[parent(i)];
			i = parent(i);
		}
		
		array[i] = element;

	}

	private void increaseHeap() {
		int novoTamanho = maxSize + INCREASING_FACTOR;
		
		T[] new_array = (T[]) new Comparable[novoTamanho];
		
		for (int i = 0; i < array.length; i++) {
			new_array[i] = array[i];
		}
		
		this.array = new_array;
		maxSize = novoTamanho;
		
		
		
	}

	@Override
	public T extractRootElement(){
		if (! isEmpty()) {
			T old_root = rootElement();
			array[0] = array[size - 1];
			size--;
			heapify(0);
			return old_root;
		}
		return null;
	}

	@Override
	public T rootElement() {
		if (isEmpty()){
			return null;
		}
		
		return array[0];
	}

	@Override
	public T[] heapsort(T[] array) {
		if (array == null){
			return null;
		}
		
		buildHeap(array);
		
		T[] auxArray = Arrays.copyOf(array, size);
		
		for (int i = size - 1; i >= 0; i--) {
			auxArray[i] = extractRootElement();
		}

		return auxArray;
		
	}
	
	@Override
	public T[] toArray() {
		T[] toArray = (T[]) new Comparable[size];
		for (int i = 0; i < toArray.length; i++) {
			toArray[i] = array[i];
		}
		
		return toArray;
	}

}
