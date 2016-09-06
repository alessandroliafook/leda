package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements AVLTree<T> {

   // TODO Do not forget: you must override the methods insert and remove
   // conveniently.

   @Override
   public void insert(T element) {

      if (element == null)
         return;

      else
         this.insertRecursive(super.getRoot(), element);
   }

   protected void insertRecursive(BSTNode<T> node, T element) {

      if (node.isEmpty()) {

         node.setData(element);

         BSTNode<T> newLeft = new BSTNode<T>();
         newLeft.setParent(node);
         node.setLeft(newLeft);

         BSTNode<T> newRight = new BSTNode<T>();
         newRight.setParent(node);
         node.setRight(newRight);

      }

      else if (node.getData().compareTo(element) > 0)
         this.insertRecursive((BSTNode<T>) node.getLeft(), element);

      else if (node.getData().compareTo(element) < 0)
         this.insertRecursive((BSTNode<T>) node.getRight(), element);

      this.rebalance(node);
   }

   @Override
   public void remove(T element) {

      if (element == null)
         return;

      BSTNode<T> node = super.search(element);

      this.removeRecursive(node);
   }

   protected void removeRecursive(BSTNode<T> node) {

      if (node.isEmpty())
         return;

      else if (node.isLeaf()) {

         node.setData(null);
         this.rebalanceUp(node);
      }

      else if (!node.getLeft().isEmpty() && !node.getRight().isEmpty()) {

         BSTNode<T> sucessor = super.sucessor(node.getData());
         node.setData(sucessor.getData());
         this.removeRecursive(sucessor);
      }

      else {

         if (node.getLeft().isEmpty()) {

            BSTNode<T> aux = (BSTNode<T>) node.getRight();

            node.setData(aux.getData());
            node.setRight(aux.getRight());
            node.setLeft(aux.getLeft());

            BSTNode<T> right = (BSTNode<T>) node.getRight();
            right.setParent(node);

            BSTNode<T> left = (BSTNode<T>) node.getLeft();
            left.setParent(node);
         }

         else {

            BSTNode<T> aux = (BSTNode<T>) node.getLeft();

            node.setData(aux.getData());
            node.setRight(aux.getRight());
            node.setLeft(aux.getLeft());

            BSTNode<T> right = (BSTNode<T>) node.getRight();
            right.setParent(node);

            BSTNode<T> left = (BSTNode<T>) node.getLeft();
            left.setParent(node);
         }

         rebalanceUp(node);
      }
   }

   // AUXILIARY
   protected int calculateBalance(BSTNode<T> node) {

      if (node.isEmpty())
         return 0;

      else {

         BSTNode<T> right = (BSTNode<T>) node.getRight();
         BSTNode<T> left = (BSTNode<T>) node.getLeft();

         int balance = super.nodeHeight(right) - super.nodeHeight(left);

         return balance;
      }
   }

   // AUXILIARY
   protected void rebalance(BSTNode<T> node) {

      if (node.isEmpty())
         return;

      BSTNode<T> left = (BSTNode<T>) node.getLeft();
      BSTNode<T> right = (BSTNode<T>) node.getRight();

      int balance = this.calculateBalance(node);

      if (balance >= -1 && balance <= 1)
         return;

      else if (balance > 1)
         leftRotation(node);

      else if (balance < -1)
         rightRotation(node);

      rebalance(left);
      rebalance(right);
   }

   // AUXILIARY
   protected void rebalanceUp(BSTNode<T> node) {

      if (node == null || node.isEmpty() || node.getParent() == null || node.getParent().isEmpty())
         return;

      BSTNode<T> parent = (BSTNode<T>) node.getParent();
      this.rebalance(parent);
      rebalanceUp(parent);
   }

   // AUXILIARY
   protected void leftRotation(BSTNode<T> node) {

      if (node == null || node.isEmpty())
         return;

      else if (node.getRight().isEmpty() && !node.getLeft().isEmpty()) {

         BSTNode<T> left = (BSTNode<T>) node.getLeft();

         Util.rightRotation(left);
         Util.leftRotation(node);
      }

      else
         Util.leftRotation(node);

   }

   // AUXILIARY
   protected void rightRotation(BSTNode<T> node) {

      if (node == null || node.isEmpty())
         return;

      else if (!node.getRight().isEmpty() && node.getLeft().isEmpty()) {

         BSTNode<T> right = (BSTNode<T>) node.getRight();

         Util.leftRotation(right);
         Util.rightRotation(node);
      }

      else
         Util.rightRotation(node);

   }
}
