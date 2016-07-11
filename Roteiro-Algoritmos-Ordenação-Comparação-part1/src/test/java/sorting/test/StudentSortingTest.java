package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.simpleSorting.BubbleSort;
import sorting.simpleSorting.InsertionSort;
import sorting.simpleSorting.SelectionSort;
import sorting.variationsOfBubblesort.BidirectionalBubbleSort;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
	
	public AbstractSorting<Integer> implementation;
	public AbstractSorting<Integer> implementation2;
	public AbstractSorting<Integer> implementation3;
	public AbstractSorting<Integer> implementation4;
	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] {30, 28, 7, 29, 11, 26, 4, 22, 23, 31});
		populaVetorTamanhoImpar(new Integer[] {6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36});
		populaVetorRepetido(new Integer[] {4, 9, 3, 4, 0, 5, 1, 4});
		populaVetorIgual(new Integer[] {6, 6, 6, 6, 6, 6});
		
		getImplementation();
	}
	
	//// MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Metodo que inicializa a implementacao a ser testada com a implementacao do aluno
	 */
	private void getImplementation() {
		//TODO O aluno deve instanciar sua implementação abaixo ao inves de null 
		this.implementation = new BubbleSort<Integer>();
		this.implementation2 = new InsertionSort<Integer>();
		this.implementation3 = new SelectionSort<Integer>();
		this.implementation4 = new BidirectionalBubbleSort<Integer>();
		
		//Assert.fail("Implementation not provided");
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao){
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao){
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao){
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao){
		this.vetorValoresIguais = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO
	
	//METODOS DE TESTE
	
	public void genericTest(Integer[] array) {
		Integer[] copy1 = Arrays.copyOf(array, array.length);
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	public void genericTest2(Integer[] array) {
		Integer[] copy1 = Arrays.copyOf(array, array.length);
		implementation2.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}
	
	public void genericTest3(Integer[] array) {
		Integer[] copy1 = Arrays.copyOf(array, array.length);
		implementation3.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}
	
	public void genericTest4(Integer[] array) {
		Integer[] copy1 = Arrays.copyOf(array, array.length);
		implementation4.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}
	
	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
		genericTest2(vetorTamPar);
		genericTest3(vetorTamPar);
		genericTest4(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
		genericTest2(vetorTamImpar);
		genericTest3(vetorTamImpar);
		genericTest4(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
		genericTest2(vetorVazio);
		genericTest3(vetorVazio);
		genericTest4(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
		genericTest2(vetorValoresIguais);
		genericTest3(vetorValoresIguais);
		genericTest4(vetorValoresIguais);
	}
	
	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
		genericTest2(vetorValoresRepetidos);
		genericTest3(vetorValoresRepetidos);
		genericTest4(vetorValoresRepetidos);
	}
	
	//METODOS QUE OS ALUNOS PODEM CRIAR 
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES ARGUMENTOS
	 * PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM SEGUIR A ESTRUTURA DOS
	 * MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS UMA PARTE DO ARRAY.
	 */
}