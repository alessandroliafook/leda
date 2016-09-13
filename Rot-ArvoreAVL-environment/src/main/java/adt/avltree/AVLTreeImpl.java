package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.BTNode;
import adt.bt.Util;

/**
 * Performs consistency validations within a AVL Tree instance
 *
 * @param <T>
 * @author Claudio Campelo
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements AVLTree<T> {

    // TODO Do not forget: you must override the methods insert and remove
    // conveniently.

    @Override
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
        rebalance((BSTNode<T>) node);
    }

    @Override
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
        rebalanceUp((BSTNode<T>) node);
    }

    // AUXILIARY
    protected int calculateBalance(BTNode<T> node) {

        if (node.isEmpty())
            return 0;

        else {

            BSTNode<T> right = (BSTNode<T>) node.getRight();
            BSTNode<T> left = (BSTNode<T>) node.getLeft();

            int balance = super.heightRecursive(right) - super.heightRecursive(left);

            return balance;
        }
    }

    // AUXILIARY
    protected void rebalance(BSTNode<T> node) {

        if (node != null && !node.isEmpty()) {

            int balance = calculateBalance(node);

            if (balance > 1) {
                leftRotation(node);

            } else if (balance < -1) {
                rightRotation(node);
            }
        }

    }

    // AUXILIARY
    protected void rebalanceUp(BSTNode<T> node) {

        if (node != null) {

            BSTNode<T> parent = (BSTNode<T>) node.getParent();
            rebalance(node);
            rebalanceUp(parent);
        }
    }

    // AUXILIARY
    protected void leftRotation(BSTNode<T> node) {

        if (node != null && !node.isEmpty()) {

            int balance = calculateBalance(node.getRight());

            if (balance < 0) {
                Util.rightRotation((BSTNode<T>) node.getRight());
            }

            BTNode aux = Util.leftRotation(node);
            if (node.equals(getRoot()))
                setRoot((BSTNode<T>) aux);
        }
    }

    // AUXILIARY
    protected void rightRotation(BSTNode<T> node) {

        if (node != null && !node.isEmpty()) {

            int balance = calculateBalance(node.getLeft());

            if (balance > 0) {
                Util.leftRotation((BSTNode<T>) node.getLeft());
            }

            BTNode aux = Util.rightRotation(node);
            if (node.equals(getRoot()))
                setRoot((BSTNode<T>) aux);
        }
    }
}

