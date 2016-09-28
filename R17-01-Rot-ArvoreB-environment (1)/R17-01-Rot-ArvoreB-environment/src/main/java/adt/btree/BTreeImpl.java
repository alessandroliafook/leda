package adt.btree;

import java.util.ArrayList;
import java.util.List;

public class BTreeImpl<T extends Comparable<T>> implements BTree<T> {

   protected BNode<T> root;
   protected int order;

   public BTreeImpl(int order) {
      this.order = order;
      this.root = new BNode<T>(order);
   }

   @Override
   public BNode<T> getRoot() {
      return this.root;
   }

   @Override
   public boolean isEmpty() {
      return this.root.isEmpty();
   }

   @Override
   public int height() {
      return height(this.root);
   }

   private int height(BNode<T> node) {
      if (node.isEmpty())
         return -1;

      int childHeight = -1;

      for (BNode<T> child : node.getChildren()) {
         childHeight = Math.max(childHeight, height(child));
      }

      return 1 + childHeight;
   }

   @Override
   @SuppressWarnings("unchecked")
   public BNode<T>[] depthLeftOrder() {

      if (isEmpty()) {
         return new BNode[0];
      }

      else {
          ArrayList<BNode<T>> arrayList = new ArrayList<>();
          depthLeftOrder(this.root, arrayList);
		  BNode[] array = arrayList.toArray(new BNode[arrayList.size()]);
		  return array;
      }
   }

   private void depthLeftOrder(BNode<T> node, List<BNode<T>> arraylist) {

      if (node.isEmpty())
         return;

      arraylist.add(node);

      for (BNode<T> nextChild : node.getChildren()) {
         depthLeftOrder(nextChild, arraylist);
      }
   }

   @Override
   public int size() {
      if (isEmpty())
         return 0;
      return size(this.root);
   }

   private int size(BNode<T> node) {
      if (isEmpty())
         return 0;

      int childSize = 0;

      for (BNode<T> nodeChild : node.getChildren()) {
         childSize += size(nodeChild);
      }

      return node.getElements().size() + childSize;
   }

   @Override
   public BNodePosition<T> search(T element) {
	   if(element == null) return new BNodePosition<T>();
      return search(this.root, element);
   }

   private BNodePosition<T> search(BNode<T> node, T element) {

      int index = 0;

      while (index < node.getElements().size() && node.getElementAt(index).compareTo(element) < 0) {
         index++;
      }

      if (index < node.getElements().size() && node.getElementAt(index).equals(element))
         return new BNodePosition<T>(node, index);

      else if (node.isLeaf())
         return new BNodePosition<T>();

      else
         return search(node.getChildren().get(index), element);
   }

   @Override
   public void insert(T element) {
	   if(element == null) return;

      insert(this.root, element);
   }

   private void insert(BNode<T> node, T element) {
      int index = 0;

      while (index < node.getElements().size() && node.getElementAt(index).compareTo(element) < 0) {
         index++;
      }

      if (index < node.getElements().size() && node.getElementAt(index).equals(element))
         ;

      else if (node.isLeaf()) {
         node.addElement(element);
      }

      else
         insert(node.getChildren().get(index), element);

      if (node.getMaxKeys() < node.getElements().size()) {
         split(node);
      }
   }

   private void split(BNode<T> node) {

      int medianIndex = node.getElements().size() / 2;
      T medianElement = node.getElementAt(medianIndex);

      BNode<T> leftNode = new BNode<T>(order);
      BNode<T> rightNode = new BNode<T>(order);

      for (int i = 0; i < medianIndex; i++) {
         leftNode.getElements().add(node.getElementAt(i));
      }

      for (int i = medianIndex + 1; i < node.getElements().size(); i++) {
         rightNode.getElements().add(node.getElementAt(i));
      }

      if (node == root) {
         BNode<T> newRoot = new BNode<T>(order);
         newRoot.addElement(medianElement);
         node.setParent(newRoot);
         root = newRoot;

         if (node.getChildren().size() > 0) {

            for (int i = 0; i <= medianIndex; i++) {
               leftNode.addChild(i, node.getChildren().get(i));
            }

            int index = 0;
            for (int i = medianIndex + 1; i < node.getChildren().size(); i++) {
               rightNode.addChild(index++, node.getChildren().get(i));
            }

         }

         newRoot.addChild(0, leftNode);
         newRoot.addChild(1, rightNode);
         newRoot.getChildren().get(0).setParent(newRoot);
         newRoot.getChildren().get(1).setParent(newRoot);

         return;
      }

      else {

         node.addChild(0, leftNode);
         node.addChild(1, rightNode);

         promote(node);
      }

   }

   private void promote(BNode<T> node) {
      int medianIndex = node.getElements().size() / 2;
      T medianElement = node.getElementAt(medianIndex);

      node.getElements().clear();
      node.addElement(medianElement);

      BNode<T> parent = node.getParent();

      if (parent != null) {
         node.getChildren().get(0).setParent(parent);
         node.getChildren().get(1).setParent(parent);
         int index = parent.getChildren().indexOf(node);
         parent.addElement(medianElement);
         parent.addChild(index, node.getChildren().get(0));
         parent.addChild(index + 1, node.getChildren().get(1));
         node.getChildren().get(0).setParent(parent);
         node.getChildren().get(1).setParent(parent);
         parent.getChildren().remove(node);
      }

   }

   // NAO PRECISA IMPLEMENTAR OS METODOS ABAIXO
   @Override
   public BNode<T> maximum(BNode<T> node) {
      // NAO PRECISA IMPLEMENTAR
      throw new UnsupportedOperationException("Not Implemented yet!");
   }

   @Override
   public BNode<T> minimum(BNode<T> node) {
      // NAO PRECISA IMPLEMENTAR
      throw new UnsupportedOperationException("Not Implemented yet!");
   }

   @Override
   public void remove(T element) {
      // NAO PRECISA IMPLEMENTAR
      throw new UnsupportedOperationException("Not Implemented yet!");
   }

}
