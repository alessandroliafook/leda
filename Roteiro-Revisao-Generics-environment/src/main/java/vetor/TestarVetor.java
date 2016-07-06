package vetor;

public class TestarVetor {

	public static void main(String[] args) {
		
		Vetor<Aluno> vetor = new Vetor<Aluno>(10);
		
		vetor.inserir(new Aluno("Alessandro", 8.0));
		vetor.inserir(new Aluno("Lucas", 9.7));
		vetor.inserir(new Aluno("Filipe", 6.8));
		
		System.out.println(vetor.toString());
		System.out.println(vetor.maximo().toString());
		System.out.println(vetor.minimo().toString());
		
		//preencha esse metodo com codigo para testar a classe vetor.
		// À medida que voce evoluir no exercício o conteúdo deste mpetodo também será modificado.
	}
}
