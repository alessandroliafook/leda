package adt.rbtree;

import adt.bst.BSTImpl;
import adt.bt.BTNode;
import adt.bt.Util;
import adt.rbtree.RBNode.Colour;

import java.util.ArrayList;
import java.util.List;

public class RBTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements RBTree<T> {

   public RBTreeImpl() {
      this.root = new RBNode<T>();
   }

   protected int blackHeight() {
      if (isEmpty())
         return 0;

      else {

         int leftHeight = blackHeightRecursive((RBNode<T>) root.getLeft());
         int rightHeight = blackHeightRecursive((RBNode<T>) root.getRight());

         return (leftHeight >= rightHeight) ? leftHeight : rightHeight;
      }
   }

   public int blackHeightRecursive(RBNode<T> node) {

      if (node.isEmpty())
         return 1;

      else {

         int blackFactor = (node.getColour().equals(Colour.BLACK)) ? 1 : 0;
         int leftHeight = blackHeightRecursive((RBNode<T>) node.getLeft()) + blackFactor;
         int rightHeight = blackHeightRecursive((RBNode<T>) node.getRight()) + blackFactor;

         return (leftHeight >= rightHeight) ? leftHeight : rightHeight;
      }
   }

   protected boolean verifyProperties() {
      boolean resp = verifyNodesColour() && verifyNILNodeColour() && verifyRootColour() && verifyChildrenOfRedNodes()
            && verifyBlackHeight();

      return resp;
   }

   /**
    * The colour of each node of a RB tree is black or red. This is guaranteed
    * by the type Colour.
    */
   private boolean verifyNodesColour() {
      return true; // already implemented
   }

   /**
    * The colour of the root must be black.
    */
   private boolean verifyRootColour() {
      return ((RBNode<T>) root).getColour() == Colour.BLACK; // already
      // implemented
   }

   /**
    * This is guaranteed by the constructor.
    */
   private boolean verifyNILNodeColour() {
      return true; // already implemented
   }

   /**
    * Verifies the property for all RED nodes: the children of a red node must
    * be BLACK.
    */
   private boolean verifyChildrenOfRedNodes() {

      if (isEmpty())
         return true;

      else
         return verifyChildrenOfRedNodesRecursive(castNode(getRoot()));
   }

   private boolean verifyChildrenOfRedNodesRecursive(RBNode<T> node) {

      if (node.isEmpty()) {
         return true;

      } else if (node.getColour().equals(Colour.BLACK)
            || (node.getColour().equals(Colour.RED) && castNode(node.getLeft()).getColour().equals(Colour.BLACK) && castNode(
                  node.getRight()).getColour().equals(Colour.BLACK))) {

         return verifyChildrenOfRedNodesRecursive(castNode(node.getLeft()))
               && verifyChildrenOfRedNodesRecursive(castNode(node.getRight()));

      } else
         return false;
   }

   /**
    * Verifies the black-height property from the root. The method blackHeight
    * returns an exception if the black heights are different.
    */
   private boolean verifyBlackHeight() {
      return verifyBlackHeightRecursive(castNode(getRoot()));
   }

   private boolean verifyBlackHeightRecursive(RBNode<T> node) {

      if (node.isEmpty())
         return true;

      else if (blackHeightRecursive(castNode(node.getRight())) == blackHeightRecursive(castNode(node.getLeft()))) {

         return verifyBlackHeightRecursive(castNode(node.getRight()))
               && verifyBlackHeightRecursive(castNode(node.getLeft()));
      }

      else
         throw new RuntimeException("The black heights are different.");
   }

   @Override
   public void insert(T value) {

      if (value == null)
         return;

      RBNode<T> node = insertRecursive(value, (RBNode<T>) getRoot());
      fixUpCase1(node);
   }

   public RBNode<T> insertRecursive(T element, RBNode<T> node) {

      if (node.isEmpty()) {

         node.setData(element);
         node.setColour(Colour.RED);

         RBNode<T> newLeft = new RBNode<T>();
         newLeft.setParent(node);
         node.setLeft(newLeft);

         RBNode<T> newRight = new RBNode<T>();
         newRight.setParent(node);
         node.setRight(newRight);

         return node;

      } else if (node.getData().compareTo(element) > 0) {
         return insertRecursive(element, (RBNode<T>) node.getLeft());

      } else if (node.getData().compareTo(element) < 0) {
         return insertRecursive(element, (RBNode<T>) node.getRight());
      }
      return new RBNode<>();
   }

   @Override
   public RBNode<T>[] rbPreOrder() {
      int size = size();
      List<RBNode<T>> list = new ArrayList<>();
      RBNode<T>[] result = new RBNode[size];

      if (!isEmpty())
         insertPreOrder((RBNode<T>) root, list);

      int index = 0;
      for (RBNode<T> rbNode : list)
         result[index++] = rbNode;

      return result;
   }

   public void insertPreOrder(RBNode<T> node, List<RBNode<T>> arrayList) {

      if (!node.isEmpty()) {

         arrayList.add(node);
         insertPreOrder((RBNode<T>) node.getLeft(), arrayList);
         insertPreOrder((RBNode<T>) node.getRight(), arrayList);
      }
   }

   // FIXUP methods
   protected void fixUpCase1(RBNode<T> node) {
      if (node == null)
         return;

      if (node.equals(getRoot()))
         node.setColour(Colour.BLACK);

      else
         fixUpCase2(node);
   }

   protected void fixUpCase2(RBNode<T> node) {
      if (verifyParent(node))
         return;

      if (!(((RBNode<T>) node.getParent()).getColour().equals(Colour.BLACK))) {
         fixUpCase3(node);
      }
   }

   protected void fixUpCase3(RBNode<T> node) {

      RBNode<T> uncle = getUncle(node);
      if (uncle.getColour().equals(Colour.RED)) {

         RBNode<T> parent = (RBNode<T>) node.getParent();
         RBNode<T> granParent = (RBNode<T>) parent.getParent();

         parent.setColour(Colour.BLACK);
         uncle.setColour(Colour.BLACK);
         granParent.setColour(Colour.RED);
         fixUpCase1(granParent);
      }

      else
         fixUpCase4(node);
   }

   public RBNode<T> getUncle(RBNode<T> node) {

      RBNode<T> parent = (RBNode<T>) node.getParent();
      RBNode<T> granParent = (RBNode<T>) parent.getParent();
      RBNode<T> uncle;
      if (((RBNode<T>) granParent.getLeft()).equals(parent))
         uncle = (RBNode<T>) granParent.getRight();
      else
         uncle = (RBNode<T>) granParent.getLeft();

      return uncle;
   }

   protected void fixUpCase4(RBNode<T> node) {
      RBNode<T> next = node;
      RBNode<T> parent = (RBNode<T>) node.getParent();
      RBNode<T> granParent = (RBNode<T>) parent.getParent();

      if (((RBNode<T>) parent.getRight()).equals(node) && ((RBNode<T>) granParent.getLeft()).equals(parent)) {
         RBNode<T> newRoot = (RBNode<T>) Util.leftRotation(parent);
         if (newRoot.getParent() == null)
            setRoot(newRoot);

         next = (RBNode<T>) node.getLeft();
      }

      else if (((RBNode<T>) parent.getLeft()).equals(node) && ((RBNode<T>) granParent.getRight()).equals(parent)) {

         RBNode<T> newRoot = (RBNode<T>) Util.rightRotation(parent);

         if (newRoot.getParent() == null)
            setRoot(newRoot);

         next = (RBNode<T>) node.getRight();
      }

      fixUpCase5(next);
   }

   protected void fixUpCase5(RBNode<T> node) {
      if (node == null)
         return;

      RBNode<T> parent = (RBNode<T>) node.getParent();
      parent.setColour(Colour.BLACK);

      RBNode<T> granParent = (RBNode<T>) parent.getParent();
      granParent.setColour(Colour.RED);

      if (((RBNode<T>) parent.getLeft()).equals(node)) {
         RBNode<T> newRoot = (RBNode<T>) Util.rightRotation(granParent);

         if (newRoot.getParent() == null)
            setRoot(newRoot);
      } else {
         RBNode<T> newRoot = (RBNode<T>) Util.leftRotation(granParent);

         if (newRoot.getParent() == null)
            setRoot(newRoot);
      }
   }

   protected RBNode<T> castNode(BTNode node) {
      return (RBNode<T>) node;
   }

   protected  boolean verifyParent(RBNode<T> node) {
      if (node.getParent() == null)
         return true;

      else
         return false;

   }

}
