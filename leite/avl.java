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
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
        AVLTree<T> {

    // TODO Do not forget: you must override the methods insert and remove
    // conveniently.

    // AUXILIARY

    /**
     * Calculate balance factor for a given node
     *
     * @param node Node to be analyzed
     * @return Positive if left tree is taller, negative if right tree is taller, 0 if tree is balanced.
     */
    protected int calculateBalance(BSTNode<T> node) {
        if (node.isEmpty()) return 0;
        return height((BSTNode<T>) node.getLeft()) - height((BSTNode<T>) node.getRight());
    }

    // AUXILIARY
    protected void rebalance(BSTNode<T> node) {

        int balance = calculateBalance(node);
        int balanceLeftChild = calculateBalance((BSTNode<T>) node.getLeft());
        int balanceRightChild = calculateBalance((BSTNode<T>) node.getRight());


        if (balance > 1) {

            if (balanceLeftChild < 0) {
                leftRotation((BSTNode<T>) node.getLeft());
            }

            rightRotation(node);


        } else if (balance < -1) {

            if (balanceRightChild > 0) {
                rightRotation((BSTNode<T>) node.getRight());
            }

            leftRotation(node);
        }

    }


    @Override
    protected void insert(BSTNode<T> node, T element, BSTNode<T> parent) {

        if (node.isEmpty()) {
            node.setData(element);
            node.setLeft(new BSTNode<T>());
            node.setRight(new BSTNode<T>());
            node.setParent(parent);
        } else {

            T nodeData = node.getData();

            if (nodeData.equals(element)) {

                return;

            } else if (nodeData.compareTo(element) > 0) {

                insert((BSTNode<T>) node.getLeft(), element, node);

            } else {

                insert((BSTNode<T>) node.getRight(), element, node);

            }

        }

        rebalance(node);

    }


    @Override
    public void remove(BTNode<T> node) {

        if (node.isLeaf()) {
            node.setData(null);
            rebalanceUp((BSTNode<T>) node);

        } else {

            if (!node.getRight().isEmpty()) {

                BSTNode<T> minNode = minimum((BSTNode<T>) node.getRight());
                node.setData(minNode.getData());
                remove(minNode);

            } else {

                BSTNode<T> maxNode = maximum((BSTNode<T>) node.getLeft());
                node.setData(maxNode.getData());
                remove(maxNode);
            }

            rebalanceUp((BSTNode<T>) node);

        }
    }


    // AUXILIARY
    protected void rebalanceUp(BSTNode<T> node) {
        BSTNode<T> parent = (BSTNode<T>) node.getParent();

        while (!parent.isEmpty()) {
            rebalance(parent);
            parent = (BSTNode<T>) parent.getParent();
        }

    }

    // AUXILIARY
    protected void leftRotation(BSTNode<T> node) {
        BSTNode<T> newRoot = Util.leftRotation(node);
        if (node == root) {
            root = newRoot;
        }
    }


    // AUXILIARY
    protected void rightRotation(BSTNode<T> node) {
        BSTNode<T> newRoot = Util.rightRotation(node);
        if (node == root) {
            root = newRoot;
        }
    }

}
