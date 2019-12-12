public class BSTNode<V extends Comparable <V>>  {
    
    private V value;
    
    private BSTNode left;
    private BSTNode right;

    public BSTNode(V data) {
        this.value = data;
    }

    public BSTNode(V data, BSTNode<V> parent) {
        this.value = data;
    }
    
      public BSTNode(V data, BSTNode<V> l, BSTNode<V> r ) {
        this.value = data;
        this.left = l;
        this.right = r;
    }

    public void setLeft(BSTNode<V> left) {
        this.left = left;
       
    }

    public void setRight(BSTNode<V> right) {
        this.right = right;
    }

    public void setValue(V value) {
        this.value = value; }
    
     public V value() {
        return value;
    }

     public BSTNode<V> right() {
       return right;
    }

     public  BSTNode<V> left() {
        return left;    
    }

   public boolean hasChild()
   {
       return (!isLeaf());
   }
   
   public boolean isLeaf()
   {
       return left == null && right == null;
   }
 
}
