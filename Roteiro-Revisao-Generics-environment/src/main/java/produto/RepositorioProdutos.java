package produto;

public interface RepositorioProdutos<T extends Produto> {

	/**
	 * Recebe o codigo e diz se tem produto com  esse codigo armazenado
	 * 
	 * @param codigo
	 * @return
	 */
	public boolean existe(int codigo);
	
	/**
	 * Insere um novo produto (sem se preocupar com duplicatas)
	 */
	public void inserir(Produto produto);
	
	/**
	 * Atualiza um produto armazenado ou retorna um erro caso o produto nao esteja no array. 
	 * Note que, para localizacao, o código do produto será utilizado.
	 */
	public void atualizar(Produto produto);
	
	/**
	 * Remove produto com determinado codigo, se existir, ou entao retorna um erro, caso contrário.
	 * Note que a remoção NÃO pode deixar "buracos" no array.
	 * @param codigo
	 */
	public void remover(int codigo);
	
	/**
	 * Retorna um produto com determinado codigo ou entao um erro, caso o produto nao esteja armazenado
	 * 
	 * @param codigo
	 * @return
	 */
	public Produto procurar(int codigo);
}
