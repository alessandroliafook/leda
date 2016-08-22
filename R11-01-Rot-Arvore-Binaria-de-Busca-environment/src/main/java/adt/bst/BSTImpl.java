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

		if (isEmpty())
			return -1;

		else {

			int leftHeight = nodeHeight(root.getLeft());
			int rightHeight = nodeHeight(root.getRight());

			return (leftHeight >= rightHeight) ? leftHeight : rightHeight;
		}
	}

	private int nodeHeight(BTNode<T> node) {

		if (node.isEmpty())
			return 0;

		else {

			int leftHeight = nodeHeight(node.getLeft()) + 1;
			int rightHeight = nodeHeight(node.getRight()) + 1;

			return (leftHeight >= rightHeight) ? leftHeight : rightHeight;
		}
	}

	@Override
	public BSTNode<T> search(T element) {

		if (element != null) {

			BTNode<T> node = root;
			while (!node.isEmpty()) {

				if (node.getData().equals(element))
					return (BSTNode<T>) node;

				else if (node.getData().compareTo(element) > 0)
					node = node.getLeft();

				else
					node = node.getRight();
			}
		}
		return new BSTNode<T>();
	}

	@Override
	public void insert(T element) {

		if (element != null) {

			insertNode(element, root);
		}
	}

	private void insertNode(T element, BTNode<T> node) {

		if (node.isEmpty()) {

			node.setData(element);

			BSTNode<T> newLeft = new BSTNode<T>();
			newLeft.setParent(node);
			node.setLeft(newLeft);

			BSTNode<T> newRight = new BSTNode<T>();
			newRight.setParent(node);
			node.setRight(newRight);

		} else if (node.getData().compareTo(element) > 0) {
			insertNode(element, node.getLeft());

		} else if (node.getData().compareTo(element) < 0) {
			insertNode(element, node.getRight());
		}
	}

	public void insertNode(BTNode<T> node, BTNode<T> nodeRoot) {

		if (nodeRoot.isEmpty())
			nodeRoot = node;

		else if (nodeRoot.getData().compareTo(node.getData()) > 0)
			insertNode(node, nodeRoot.getLeft());

		else if (node.getData().compareTo(node.getData()) < 0)
			insertNode(node, nodeRoot.getRight());

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

		if (element == null || isEmpty())
			return null;

		else {

			BTNode<T> node = search(element);

			if (node.isEmpty())
				return null;

			else {

				if (!node.getRight().isEmpty()) {
					return minimumNode(node.getRight());

				} else {

					BTNode<T> nodeParent = node.getParent();

					while (nodeParent != null && !nodeParent.isEmpty() && node.equals(nodeParent.getRight())) {
						node = nodeParent;
						nodeParent = nodeParent.getParent();
					}

					return (BSTNode<T>) nodeParent;
				}
			}
		}
	}

	@Override
	public BSTNode<T> predecessor(T element) {

		if (isEmpty() || element == null) {
			return null;

		} else {

			BTNode<T> node = search(element);

			if (node.isEmpty())
				return null;

			else {

				if (!node.getLeft().isEmpty())
					return maximumNode(node.getLeft());

				else {

					BTNode<T> nodeParent = node.getParent();

					while (nodeParent != null && !nodeParent.isEmpty() && node.equals(nodeParent.getLeft())) {

						node = nodeParent;
						nodeParent = nodeParent.getParent();
					}

					return (BSTNode<T>) nodeParent;
				}
			}
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

			BTNode<T> auxNode = null;

			if (!node.getRight().isEmpty()) {

				auxNode = minimumNode(node.getRight());
				node.setData(auxNode.getData());
				removeNode(auxNode);

			} else {

				auxNode = maximumNode(node.getLeft());
				node.setData(auxNode.getData());
				removeNode(auxNode);
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] preOrder() {

		int size = size();
		List<T> list = new ArrayList<>();
		T[] result = (T[]) new Comparable<?>[size];

		if (!isEmpty())
			insertPreOrder(root, list);

		int index = 0;
		for (T element : list)
			result[index++] = element;

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

		int size = size();
		List<T> list = new ArrayList<>();
		T[] result = (T[]) new Comparable<?>[size];

		if (!isEmpty())
			insertOrder(root, list);

		int index = 0;
		for (T element : list)
			result[index++] = element;

		return result;
	}

	private void insertOrder(BTNode<T> node, List<T> arrayList) {

		if (!node.isEmpty()) {

			insertOrder(node.getLeft(), arrayList);
			arrayList.add(node.getData());
			insertOrder(node.getRight(), arrayList);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] postOrder() {

		int size = size();
		List<T> list = new ArrayList<>();
		T[] result = (T[]) new Comparable<?>[size];

		if (!isEmpty())
			insertPostOrder(root, list);

		int index = 0;
		for (T element : list)
			result[index++] = element;

		return result;
	}

	private void insertPostOrder(BTNode<T> node, List<T> arrayList) {

		if (!node.isEmpty()) {

			insertPostOrder(node.getLeft(), arrayList);
			insertPostOrder(node.getRight(), arrayList);
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
