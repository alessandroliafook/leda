package adt.bst;

import java.util.ArrayList;
import java.util.List;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected  BSTNode<T> root;
	
	
	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot(){
		return this.root;
	}
	
	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return recursiveHeight(root);
	}

	private int recursiveHeight(BTNode<T> node) {
		if (node.isEmpty()){
			return -1;
		}
		
		return 1 + Math.max(recursiveHeight(node.getLeft()), recursiveHeight(node.getRight()));
	}
	
	
	// se o argumento for null, o metodo retorna null
	@Override
	public BSTNode<T> search(T element) {
		if (element != null){
			return recursiveSearch(root, element);
		}
		return null;
	}

	private BSTNode<T> recursiveSearch(BTNode<T> node, T element) {
		
		if (node.isEmpty() || element.compareTo(node.getData()) == 0){
			return (BSTNode<T>) node;
		}
		
		else if (element.compareTo(node.getData()) < 0){
			return recursiveSearch(node.getLeft(), element);
		} else {
			return recursiveSearch(node.getRight(), element);
		}
	}

	@Override
	public void insert(T element) {
		if (element != null){
			if (root.isEmpty()){
				this.root.setData(element);
				this.root.setLeft(new BSTNode<T>());
				this.root.setRight(new BSTNode<T>());
			} else {
				recursiveInsert(root, element);
			}
			
		}

	}

	private void recursiveInsert(BTNode<T> node, T element) {
		if (element.compareTo(node.getData()) < 0){
			if (node.getLeft().isEmpty()){
				node.getLeft().setData(element);
				node.getLeft().setParent(node);
				node.getLeft().setRight(new BSTNode<T>());
				node.getLeft().setLeft(new BSTNode<T>());
			} else {
				recursiveInsert(node.getLeft(), element);
			}
		}
		
		else if (element.compareTo(node.getData()) > 0){
			if (node.getRight().isEmpty()){
				node.getRight().setData(element);
				node.getRight().setParent(node);
				node.getRight().setRight(new BSTNode<T>());
				node.getRight().setLeft(new BSTNode<T>());
			} else {
				recursiveInsert(node.getRight(), element);
			}
		}
		
	}

	@Override
	public BSTNode<T> maximum() {
		if (root.isEmpty()){
			return null;
		}
		return recursiveMaximum(root);
	}

	private BSTNode<T> recursiveMaximum(BTNode<T> node) {
		if (node.getRight().isEmpty()){
			return (BSTNode) node;
		}
		
		return recursiveMaximum(node.getRight());
	}

	@Override
	public BSTNode<T> minimum() {
		if (root.isEmpty()){
			return null;
		}
		
		return recursiveMinimum(root);
	}

	private BSTNode<T> recursiveMinimum(BTNode<T> node) {
		if (node.getLeft().isEmpty()){
			return (BSTNode<T>) node;
		}
		
		return recursiveMinimum(node.getLeft());
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BTNode<T> node_element = search(element);
		if (element == null || node_element.isEmpty()) {
			return null;
		}
		else if (! node_element.getRight().isEmpty()){
			BSTNode<T> node_return = recursiveMinimum(node_element.getRight());
			return node_return;
			
		} else { 
			BTNode<T> pai = node_element.getParent();
			while (pai != null && !node_element.equals(pai.getLeft())){
				node_element = pai;
				pai = pai.getParent();
			}
			
			return (BSTNode<T>) pai;
		}
		
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BTNode<T> node_element = search(element);
		if (element == null || node_element.isEmpty()) {
			return null;
		}
		else if (! node_element.getLeft().isEmpty()){
			BSTNode<T> node_return = recursiveMaximum(node_element.getLeft());
			return node_return;
			
		} else { 
			BTNode<T> pai = node_element.getParent();
			while (pai != null && !node_element.equals(pai.getRight())){
				node_element = pai;
				pai = pai.getParent();
			}
			
			return (BSTNode<T>) pai;
		}
	}

	@Override
	public void remove(T element) {
		BTNode<T> removed_node = search(element);
		if (element == null || removed_node.isEmpty()){
			return;
		}
		
		recursiveRemove(removed_node); 
		

	}

	private void recursiveRemove(BTNode<T> node) {
		if (node.getLeft().isEmpty() && node.getRight().isEmpty()){
			node.setData(null);   // eh folha. Sera um NIL agora
			node.setLeft(null);
			node.setRight(null);
		}
		else if (node.getLeft().isEmpty()){  // tem filho a direita
		
			node.setData(node.getRight().getData());
			node.setLeft(node.getRight().getLeft());      // o nó "removido" recebe as informacoes de seu filho
			node.setRight(node.getRight().getRight());
		}
		else if (node.getRight().isEmpty()){   // tem filho a esquerda
		
			node.setData(node.getLeft().getData());
			node.setRight(node.getLeft().getRight());     // o nó "removido" recebe as informacoes de seu filho
			node.setLeft(node.getLeft().getLeft());
		}
		
		else { // tem dois filhos
			T removed_node_value = node.getData();
			BTNode<T> sucessor = sucessor(removed_node_value);
			node.setData(sucessor.getData());
			sucessor.setData(removed_node_value);
			recursiveRemove(sucessor);
 		}
	}

	@Override
	public T[] preOrder() {
		List<T> lista = new ArrayList<T>();
		recursivePreOrder(root, lista);
		
		T[] array = (T[]) new Comparable[lista.size()];
		
		int i = 0;
		for (T element: lista) {
			array[i] = element;
			i++;
		}
		
		return array;
	}

	private void recursivePreOrder(BTNode<T> node, List<T> lista) {
		if (! node.isEmpty()){
			lista.add(node.getData());
			recursivePreOrder(node.getLeft(), lista);
			recursivePreOrder(node.getRight(), lista);
		}
		
	}
	
	@Override
	public T[] order() {
		List<T> lista = new ArrayList<T>();
		recursiveOrder(root, lista);
		
		T[] array = (T[]) new Comparable[lista.size()];
		
		int i = 0;
		for (T element: lista) {
			array[i] = element;
			i++;
		}
		
		return array;
	}

	private void recursiveOrder(BTNode<T> node, List<T> lista) {
		if (! node.isEmpty()){
			recursiveOrder(node.getLeft(), lista);
			lista.add(node.getData());
			recursiveOrder(node.getRight(), lista);
		}
		
	}

	@Override
	public T[] postOrder() {
		List<T> lista = new ArrayList<T>();
		recursivePostOrder(root, lista);
		
		T[] array = (T[]) new Comparable[lista.size()];
		
		int i = 0;
		for (T element: lista) {
			array[i] = element;
			i++;
		}
		
		return array;
		
	}

	private void recursivePostOrder(BTNode<T> node, List<T> lista) {
		if (! node.isEmpty()){
			recursivePostOrder(node.getLeft(), lista);
			recursivePostOrder(node.getRight(), lista);
			lista.add(node.getData());
		}
		
	}

	@Override
	public int size() {
		return size(root);
	}
	
	private int size(BSTNode<T> node){
		if (node.isEmpty()){
			return 0;
		} else {
			return 1 + size((BSTNode<T>)node.getLeft()) + size((BSTNode<T>)node.getRight());
		}
		
	}
	

}
