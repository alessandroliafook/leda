package adt.skipList;

public class SkipListImpl<T> implements SkipList<T> {

   protected SkipListNode<T> root;
   protected SkipListNode<T> NIL;

   protected int height;
   protected int maxHeight;

   protected boolean USE_MAX_HEIGHT_AS_HEIGHT;
   protected double PROBABILITY = 0.5;

   public SkipListImpl(int maxHeight) {
      if (USE_MAX_HEIGHT_AS_HEIGHT) {
         this.height = maxHeight;

      } else {
         this.height = 1;
      }

      this.maxHeight = maxHeight;
      root = new SkipListNode(Integer.MIN_VALUE, maxHeight, null);
      NIL = new SkipListNode(Integer.MAX_VALUE, maxHeight, null);
      connectRootToNil();
   }

   /**
    * Faz a ligacao inicial entre os apontadores forward do ROOT e o NIL Caso
    * esteja-se usando o level do ROOT igual ao maxLevel esse metodo deve
    * conectar todos os forward. Senao o ROOT eh inicializado com level=1 e o
    * metodo deve conectar apenas o forward[0].
    */
   private void connectRootToNil() {
      if (maxHeight > 0)
         getRoot().getForward()[0] = getNIL();
   }

   public void fixUp(){
      for (int i = 0; i < getMaxHeight(); i++) {
         if (getRoot().getForward()[i] == null)
            getRoot().getForward()[i] = getNIL();
      }
   }

   /**
    * Metodo que gera uma altura aleatoria para ser atribuida a um novo no no
    * metodo insert(int,V)
    */
   private int randomLevel() {
      int randomLevel = 1;
      double random = Math.random();
      while (Math.random() <= PROBABILITY && randomLevel < maxHeight) {
         randomLevel = randomLevel + 1;
      }
      return randomLevel;
   }

   public void insert(int key, T newValue) {
      insert(key, newValue, randomLevel());
   }

   @Override
   public void insert(int key, T newValue, int height) {

      if (newValue == null || height > getMaxHeight() || height < 0) {
         return;
      }

      fixUp();

      SkipListNode<T>[] update = new SkipListNode[getMaxHeight()];
      SkipListNode<T> node = getRoot();

      for (int i = getHeight() - 1; i >= 0; i--) {

         while (node != null && node.getForward(i) != null && (!node.equals(getNIL())) && node.getForward(i).getKey() <
		         key) {
            node = node.getForward(i);
         }
         update[i] = node;
      }

      if (node.getForward(0) != null)
	      node = node.getForward(0);

      if (node.getKey() == key) {
         node.setValue(newValue);
      }

      else {

         if (height > getHeight()) {
            for (int i = getHeight(); i < height; i++) {
               update[i] = getRoot();
            }
            setHeight(height);
         }

         SkipListNode<T> newNode = new SkipListNode<>(key, height, newValue);
         for (int i = 0; i < height; i++) {
	        newNode.getForward()[i] = update[i].getForward()[i];
            update[i].getForward()[i] = newNode;
         }
      }
      fixHeight();
   }

   @Override
   public void remove(int key) {

      fixUp();

      SkipListNode<T>[] update = new SkipListNode[getMaxHeight()];
      SkipListNode<T> node = getRoot();

      for (int i = getHeight() - 1; i >= 0; i--) {
         while (node.getForward(i).getKey() < key) {
            node = node.getForward(i);
         }
         update[i] = node;
      }

      if (node.getForward(0) != null)
	      node = node.getForward(0);

      if (node.getKey() == key) {
         for (int i = 0; i < getHeight(); i++) {
            if (!update[i].getForward(i).equals(node))
               break;

            update[i].getForward()[i] = node.getForward(i);

            while (getHeight() > 1 && getRoot().getForward(getHeight() - 1).equals(getNIL())) {
               setHeight(getHeight() - 1);
            }
         }
      }
      fixHeight();
   }

   @Override
   public int height() {
	   if (USE_MAX_HEIGHT_AS_HEIGHT)
	   	return getMaxHeight();

	   else
        return getHeight();
   }

   @Override
   public SkipListNode<T> search(int key) {

      SkipListNode<T> node = getRoot();

      for (int i = getHeight() - 1; i >= 0; i--) {
         while (node != null && node.getForward(i) != null && (!node.equals(getNIL()))
               && node.getForward(i).getKey() < key) {
            node = node.getForward(i);
         }
      }

      if (node.getForward(0) != null)
	      node = node.getForward(0);

      if (node.getKey() == key)
         return node;

      else
         return null;
   }

   @Override
   public int size() {
      int size = 0;
      SkipListNode<T> node = getRoot().getForward(0);

      while (node != null && node.getForward(0) != null) {
         size++;
         node = node.getForward(0);
      }

      return size;
   }

   @Override
   public SkipListNode<T>[] toArray() {

      fixHeight();

      SkipListNode<T>[] array = new SkipListNode[size() + 2];
      SkipListNode<T> node = getRoot();

	   int i = 0;

	   while(node != null) {
		   array[i++] = node;
		   node = node.getForward(0);
	   }

      return array;
   }

   private void fixHeight() {

      if (USE_MAX_HEIGHT_AS_HEIGHT) {
         for (int i = getHeight(); i < getMaxHeight(); i++) {
            getRoot().getForward()[i] = getNIL();
         }
      }

      else {
         for (int i = getHeight(); i < getMaxHeight(); i++) {
	         if (i > 0)
	            getRoot().getForward()[i] = null;
         }
      }
   }

   // GETTERS E SETTERS

   public SkipListNode<T> getRoot() {
      return root;
   }

   public void setRoot(SkipListNode<T> root) {
      this.root = root;
   }

   public SkipListNode<T> getNIL() {
      return NIL;
   }

   public void setNIL(SkipListNode<T> NIL) {
      this.NIL = NIL;
   }

   public int getHeight() {
      return height;
   }

   public void setHeight(int height) {
      this.height = height;
   }

   public int getMaxHeight() {
      return maxHeight;
   }

   public void setMaxHeight(int maxHeight) {
      this.maxHeight = maxHeight;
   }

   public boolean isUSE_MAX_HEIGHT_AS_HEIGHT() {
      return USE_MAX_HEIGHT_AS_HEIGHT;
   }

   public void setUSE_MAX_HEIGHT_AS_HEIGHT(boolean USE_MAX_HEIGHT_AS_HEIGHT) {
      this.USE_MAX_HEIGHT_AS_HEIGHT = USE_MAX_HEIGHT_AS_HEIGHT;
   }

   public double getPROBABILITY() {
      return PROBABILITY;
   }

   public void setPROBABILITY(double PROBABILITY) {
      this.PROBABILITY = PROBABILITY;
   }
}
