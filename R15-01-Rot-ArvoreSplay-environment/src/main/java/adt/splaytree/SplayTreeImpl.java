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
                } else if (node.getData().compareTo(element) > 0)
                    node = node.getLeft();

                else
                    node = node.getRight();
            }
            if (node.getParent() != null)
                splay((BSTNode<T>) node.getParent());
        }
        return new BSTNode<>();
    }

    public void insert(T element) {

        if (element != null) {

            insertRecursive(element, root);
        }
    }

    public void insertRecursive(T element, BTNode<T> node) {

        if (node.isEmpty()) {

            node.setData(element);

            BSTNode<T> newLeft = new BSTNode<>();
            newLeft.setParent(node);
            node.setLeft(newLeft);

            BSTNode<T> newRight = new BSTNode<>();
            newRight.setParent(node);
            node.setRight(newRight);

            if (node.getParent() != null)
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

            } else {
                BSTNode<T> parent = (BSTNode<T>) node.getParent();
                removeRecursive(node);

                if (parent != null)
                    splay(parent);
            }
        }
    }

    private void splay(BSTNode<T> node) {

        if (node == null || node.isEmpty() || node.equals(getRoot()))
            return;

        BSTNode<T> parent = (BSTNode<T>) node.getParent();
        BSTNode<T> granParent = (BSTNode<T>) parent.getParent();

        while (parent != null) {

            if (parent.equals(getRoot())) {

                //ZIG Right
                if (parent.getLeft().equals(node))
                    Util.rightRotation(parent);

                //ZIG Left
                else
                    Util.leftRotation(parent);

                setRoot(node);

            } else {

                if (granParent.getRight().equals(parent)) {

                    //ZIG_ZIG Left
                    if (parent.getRight().equals(node)) {
                        Util.leftRotation(granParent);
                        Util.leftRotation(parent);
                    }
                        //ZIG Right ZAG Left
                    else {
                        Util.rightRotation(parent);
                        Util.leftRotation(granParent);
                    }
                } else {

                    //ZIG_ZIG Right
                    if (parent.getLeft().equals(node)) {
                        Util.rightRotation(granParent);
                        Util.rightRotation(parent);
                    }
                        //ZIG Right ZAG Left
                    else {
                        Util.leftRotation(parent);
                        Util.rightRotation(granParent);
                    }
                }
            }

            parent = (BSTNode<T>) node.getParent();

            if (parent != null) {

                granParent = (BSTNode<T>) parent.getParent();

                if (parent.getParent() == null)
                    setRoot(parent);
            }

            else
                setRoot(node);
        }
    }
}
