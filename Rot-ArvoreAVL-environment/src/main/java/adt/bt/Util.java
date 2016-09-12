package adt.bt;

import adt.bst.BSTNode;

public class Util {

	/**
	 * A rotacao a esquerda em node deve subir o seu filho a direita e
	 * retorna-lo em seguida
	 * 
	 * @param node
	 * @return the right node or null if the right son of the node is empty or null. 
	 */
	public static <T extends Comparable<T>> BSTNode<T> leftRotation(BSTNode<T> node) {

		if (node != null && !node.isEmpty()) {

			BSTNode<T> right = (BSTNode<T>) node.getRight();
			BSTNode<T> parent = (BSTNode<T>) node.getParent();

			if (right != null && !right.isEmpty()) {

				right.setParent(parent);

				if(parent != null) {
					if(parent.getLeft().equals(node))
						parent.setLeft(right);

					else
						parent.setRight(right);
				}

				if (!right.getLeft().isEmpty())
					node.setRight(right.getLeft());

				right.setLeft(node);
				node.setParent(right);
			}

			return right;
		}

		return null;
	}

	/**
	 * A rotacao a direita em node deve subir seu filho a esquerda s retorna-lo
	 * em seguida
	 * 
	 * @param node
	 * @return
	 */
	public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> node) {
		if (node != null && !node.isEmpty()) {

			BSTNode<T> left= (BSTNode<T>) node.getLeft();
			BSTNode<T> parent = (BSTNode<T>) node.getParent();

			if (left != null && !left.isEmpty()) {

				left.setParent(parent);

				if(parent != null) {

					if(parent != null) {
						if(parent.getLeft().equals(node))
							parent.setLeft(left);

						else
							parent.setRight(left);
					}
				}

				if (!left.getRight().isEmpty())
					node.setRight(left.getLeft());

				left.setRight(node);
				node.setParent(left);
			}

			return left;
		}

		return null;
	}

}
