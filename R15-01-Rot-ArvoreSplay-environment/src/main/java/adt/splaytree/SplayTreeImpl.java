package adt.splaytree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.BTNode;
import adt.bt.Util;

public class SplayTreeImpl<T extends Comparable<T>> extends BSTImpl<T>
		implements SplayTree<T> {

	@Override
	public BSTNode<T> search(T element) {

		if (element != null) {

			BTNode<T> node = root;
			while (!node.isEmpty()) {

				if (node.getData().equals(element)) {
					splay((BSTNode<T>) node);
					return (BSTNode<T>) node;
				}
				else if (node.getData().compareTo(element) > 0)
					node = node.getLeft();

				else
					node = node.getRight();
			}
			splay((BSTNode<T>) node.getParent());
		}
		return new BSTNode<>();
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

			splay((BSTNode<T>) node);

		} else if (node.getData().compareTo(element) > 0) {
			insertRecursive(element, node.getLeft());

		} else if (node.getData().compareTo(element) < 0) {
			insertRecursive(element, node.getRight());
		}
	}

	@Override
	public void remove(T element) {

		if (isEmpty() || element == null)
			return;

		else {

			BTNode<T> node = super.search(element);

			if (node.isEmpty()) {
				splay((BSTNode<T>) node.getParent());
				return;
			}

			else {
				BSTNode<T> parent = (BSTNode<T>) node.getParent();
				removeRecursive(node);
				splay(parent);
			}
		}
	}

	private void splay(BSTNode<T> node) {

		BSTNode<T> parent = (BSTNode<T>) node.getParent();

		while(parent != null) {

			if (parent.getLeft().equals(node))
				Util.rightRotation(parent);

			else
				Util.leftRotation(parent);

			parent = (BSTNode<T>) node.getParent();
		}
	}
}
