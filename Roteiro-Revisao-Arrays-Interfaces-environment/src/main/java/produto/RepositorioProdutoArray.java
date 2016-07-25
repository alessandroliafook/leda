package produto;

/**
 * Classe que representa um repositório de produtos usando arrays como estrutura
 * sobrejacente. Alguns métodos (atualizar, remover e procurar) ou executam com
 * sucesso ou retornam um erro. Para o caso desde exercício, o erro será
 * representado por uma RuntimeException que não precisa ser declarada na
 * clausula "throws" do mos metodos.
 * 
 * Obs: Note que você deve utilizar a estrutura de dados array e não
 * implementações de array prontas da API Collections de Java (como ArrayList,
 * por exemplo).
 * 
 * @author Adalberto
 *
 */
public class RepositorioProdutoArray implements RepositorioProdutos {

	/**
	 * A estrutura (array) onde os produtos sao mantidos.
	 */
	private Produto[] produtos;

	/**
	 * A posicao do ultimo elemento inserido no array de produtos. o valor
	 * inicial é -1 para indicar que nenhum produto foi ainda guardado no array.
	 */
	private int index = -1;

	/**
	 * Constante que indice indice inexistente na estrutura.
	 */
	private int INDEXNULL = -1;

	public RepositorioProdutoArray(int size) {
		super();
		this.produtos = new ProdutoPerecivel[size];
	}

	/**
	 * Recebe o codigo do produto e devolve o indice desse produto no array ou
	 * -1 caso ele nao se encontre no array. Esse método é util apenas na
	 * implementacao com arrays por questoes de localizacao. Outras classes que
	 * utilizam outras estruturas internas podem nao precisar desse método.
	 * 
	 * @param codigo
	 * @return
	 */
	private int procurarIndice(int codigo) {
		int indice = 0;

		while (indice < this.index) {

			if (produtos[indice].getCodigo() == codigo) {
				return indice;
			}

			indice++;
		}

		return INDEXNULL;
	}

	/**
	 * Recebe o codigo e diz se tem produto com esse codigo armazenado
	 * 
	 * @param codigo
	 * @return
	 */
	public boolean existe(int codigo) {

		if (this.procurarIndice(codigo) == INDEXNULL) {
			return false;

		} else {
			return true;
		}
	}

	/**
	 * Insere um novo produto (sem se preocupar com duplicatas)
	 */
	public void inserir(Produto produto) {

		if (index < this.produtos.length) {
			this.produtos[++index] = produto;

		} else {
			throw new RuntimeException("Repositorio lotado!");
		}
	}

	/**
	 * Atualiza um produto armazenado ou retorna um erro caso o produto nao
	 * esteja no array. Note que, para localizacao, o código do produto será
	 * utilizado.
	 */
	public void atualizar(Produto produto) {

		int codigo = produto.getCodigo();
		int indice = this.procurarIndice(codigo);
		this.verificaIndice(indice);
		produtos[indice] = produto;
	}

	/**
	 * Remove produto com determinado codigo, se existir, ou entao retorna um
	 * erro, caso contrário. Note que a remoção NÃO pode deixar "buracos" no
	 * array.
	 * 
	 * @param codigo
	 */
	public void remover(int codigo) {

		int indice = this.procurarIndice(codigo);
		this.verificaIndice(indice);
		this.produtos[indice] = this.produtos[index];
		this.produtos[index] = null;
		index--;

	}

	/**
	 * Retorna um produto com determinado codigo ou entao um erro, caso o
	 * produto nao esteja armazenado
	 * 
	 * @param codigo
	 * @return
	 */
	public Produto procurar(int codigo) {

		int indice = this.procurarIndice(codigo);
		this.verificaIndice(indice);
		return this.produtos[indice];
	}

	/**
	 * Metodo que verifica se o indice corresponde a um valor que indique a
	 * existencia de produto na estrutura.
	 * 
	 * @param indice
	 *            Inteiro que indica a localização do produto na estrutura.
	 * @exception RuntimeException
	 *                caso o indice indique o produto nao exista na estrutura.
	 */
	private void verificaIndice(int indice) {
		if (indice == INDEXNULL) {
			throw new RuntimeException("Produto Inexistente!");
		}
	}	
}