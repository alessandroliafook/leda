package adt.bst;

import adt.bt.BTNode;

import java.util.ArrayList;
import java.util.List;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	protected void setRoot(BSTNode<T> node) {
		this.root = node;
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

			int leftHeight = heightRecursive(root.getLeft());
			int rightHeight = heightRecursive(root.getRight());

			return (leftHeight >= rightHeight) ? leftHeight : rightHeight;
		}
	}

	public int heightRecursive(BTNode<T> node) {

		if (node.isEmpty())
			return 0;

		else {

			int leftHeight = heightRecursive(node.getLeft()) + 1;
			int rightHeight = heightRecursive(node.getRight()) + 1;

			return (leftHeight >= rightHeight) ? leftHeight : rightHeight;
		}
	}

	@Override
	public BSTNode<T> search(T element) {

		if (element == null)
			return new BSTNode<>();

		else {

			BTNode<T> node = root;

			while (!node.isEmpty() || !node.getData().equals(element)) {

				if (node.getData().compareTo(element) > 0)
					node = node.getLeft();

				else
					node = node.getRight();
			}
			return (BSTNode<T>) node;
		}
	}

	@Override
	public void insert(T element) {

		if (element != null) {

			insertRecursive(element, root);
		}
	}

	public void insertRecursive(T element, BTNode<T> node) {

		if (node.isEmpty()) {

			node.setData(element);

			BSTNode<T> newLeft = new BSTNode<T>();
			newLeft.setParent(node);
			node.setLeft(newLeft);

			BSTNode<T> newRight = new BSTNode<T>();
			newRight.setParent(node);
			node.setRight(newRight);

		} else if (node.getData().compareTo(element) > 0) {
			insertRecursive(element, node.getLeft());

		} else if (node.getData().compareTo(element) < 0) {
			insertRecursive(element, node.getRight());
		}
	}

	@Override
	public BSTNode<T> maximum() {

		return (isEmpty()) ? null : maximumRecursive(root);
	}

	private BSTNode<T> maximumRecursive(BTNode<T> node) {

		return (node.getRight().isEmpty()) ? (BSTNode<T>) node : maximumRecursive(node.getRight());
	}

	@Override
	public BSTNode<T> minimum() {

		return (isEmpty()) ? null : minimumRecursive(root);
	}

	private BSTNode<T> minimumRecursive(BTNode<T> node) {

		return (node.getLeft().isEmpty()) ? (BSTNode<T>) node : minimumRecursive(node.getLeft());
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
					return minimumRecursive(node.getRight());

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
					return maximumRecursive(node.getLeft());

				else {

					BSTNode<T> nodeParent = (BSTNode<T>) node.getParent();

					while (nodeParent != null && !nodeParent.isEmpty() && node.equals(nodeParent.getLeft())) {

						node = node.getParent();
						nodeParent = (BSTNode<T>) nodeParent.getParent();
					}

					return (BSTNode<T>) nodeParent;
				}
			}
		}
	}

	@Override
	public void remove(T element) {

		if (isEmpty() || element == null)
			return;

		else {

			BTNode<T> node = search(element);

			if (node.isEmpty())
				return;

			else
				removeRecursive(node);
		}
	}

	public void removeRecursive(BTNode<T> node) {

		if (node.isLeaf()) {
			node.setData(null);
			node.setRight(null);
			node.setLeft(null);

		} else {

			BTNode<T> auxNode;

			if (!node.getLeft().isEmpty() && !node.getRight().isEmpty()) {

				auxNode = sucessor(node.getData());
				node.setData(auxNode.getData());
				removeRecursive(auxNode);

			} else if (node.getLeft().isEmpty()) {

				auxNode = node.getRight();
				node.setData(auxNode.getData());
				node.setLeft(auxNode.getLeft());
				node.getLeft().setParent(node);
				node.setRight(auxNode.getRight());
				node.getRight().setParent(node);


			} else if (node.getRight().isEmpty()) {

				auxNode = node.getLeft();
				node.setData(auxNode.getData());
				node.setLeft(auxNode.getLeft());
				node.getLeft().setParent(node);
				node.setRight(auxNode.getRight());
				node.getRight().setParent(node);
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