package main;

import util.Util;

public class Main {

	public static void main(String[] args) {
		
		Integer[] vetor = Util.<Integer>makeArray(10);
		
		vetor[0] = new Integer(10);
		vetor[1] = new Integer(11);

		System.out.println(vetor[0]);
		System.out.println(vetor[1]);
		
	}

}
