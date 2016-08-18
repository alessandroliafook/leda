package adt.bst;

import java.util.ArrayList;
import java.util.List;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {

		return (isEmpty()) ? -1 : nodeHeight(root);
	}

	private int nodeHeight(BTNode<T> node) {

		if (node.isEmpty()) {
			return 0;

		} else {

			int leftHeight = nodeHeight(node.getLeft()) + 1;
			int rightHeight = nodeHeight(node.getRight()) + 1;

			return (leftHeight >= rightHeight) ? leftHeight : rightHeight;
		}
	}

	@Override
	public BSTNode<T> search(T element) {

		return (element == null) ? null : nodeSearch(element, root);
	}

	public BSTNode<T> nodeSearch(T element, BTNode<T> node) {

		if (node.isEmpty() || node.getData().equals(element)) {
			return (BSTNode<T>) node;

		} else if (node.getData().compareTo(element) > 0) {
			return nodeSearch(element, node.getLeft());

		} else {
			return nodeSearch(element, node.getRight());
		}
	}

	@Override
	public void insert(T element) {

		if (element != null)
			insertNode(element, root);
	}

	private void insertNode(T element, BTNode<T> node) {

		if (node.isEmpty()) {

			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());

		} else if (node.getData().compareTo(element) > 0) {
			insertNode(element, node.getLeft());

		} else if (node.getData().compareTo(element) < 0) {
			insertNode(element, node.getRight());
		}
	}

	@Override
	public BSTNode<T> maximum() {

		return (isEmpty()) ? null : maximumNode(root);
	}

	private BSTNode<T> maximumNode(BTNode<T> node) {

		return (node.getRight().isEmpty()) ? (BSTNode<T>) node : maximumNode(node.getRight());
	}

	@Override
	public BSTNode<T> minimum() {

		return (isEmpty()) ? null : minimumNode(root);
	}

	private BSTNode<T> minimumNode(BTNode<T> node) {

		return (node.getLeft().isEmpty()) ? (BSTNode<T>) node : minimumNode(node.getLeft());
	}

	@Override
	public BSTNode<T> sucessor(T element) {

		if (isEmpty() || element == null) {
			return null;

		} else {

			BSTNode<T> node = search(element);
			return (node == null || node.getRight().isEmpty()) ? null : minimumNode(node.getRight());
		}
	}

	@Override
	public BSTNode<T> predecessor(T element) {

		if (isEmpty() || element == null) {
			return null;

		} else {

			BTNode<T> node = search(element);
			return (node == null || node.getLeft().isEmpty()) ? null : maximumNode(node.getLeft());
		}
	}

	@Override
	public void remove(T element) {

		if (isEmpty() || element == null) {
			return;
		} else {

			BTNode<T> node = search(element);
			removeNode(node);
		}
	}

	public void removeNode(BTNode<T> node) {

		if (node.isEmpty())
			return;

		else if (node.isLeaf())
			node.setData(null);

		else {

			BTNode<T> auxNode = sucessor(node.getData());

			if (auxNode != null) {
				node.setData(auxNode.getData());

			} else {
				auxNode = predecessor(node.getData());
				node.setData(auxNode.getData());
			}

			removeNode(auxNode);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] preOrder() {

		List<T> list = new ArrayList<>();
		insertPreOrder(root, list);

		T[] result = list.toArray((T[]) new Object[0]);

		return result;
	}

	public void insertPreOrder(BTNode<T> node, List<T> arrayList) {

		if (!node.isEmpty()) {

			arrayList.add(node.getData());
			insertPreOrder(node.getLeft(), arrayList);
			insertPreOrder(node.getRight(), arrayList);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] order() {

		List<T> list = new ArrayList<>();
		insertOrder(root, list);

		T[] result = list.toArray((T[]) new Object[0]);

		return result;
	}

	private void insertOrder(BTNode<T> node, List<T> arrayList) {

		if (!node.isEmpty()) {

			insertPreOrder(node.getLeft(), arrayList);
			arrayList.add(node.getData());
			insertPreOrder(node.getRight(), arrayList);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] postOrder() {

		List<T> list = new ArrayList<>();
		insertPostOrder(root, list);

		T[] result = list.toArray((T[]) new Object[0]);

		return result;
	}

	private void insertPostOrder(BTNode<T> node, List<T> arrayList) {

		if (!node.isEmpty()) {

			insertPreOrder(node.getLeft(), arrayList);
			insertPreOrder(node.getRight(), arrayList);
			arrayList.add(node.getData());
		}
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft()) + size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
