public class BSTree<E extends Comparable<E>>
{
 protected Question<E> root; // Root of the BST
  protected int nodeCount; // Number of nodes in the BST

  // constructor
  public BSTree() { root = null; nodeCount = 0; }

  // Reinitialize tree
  public void clear() { root = null; nodeCount = 0; }

  // Insert a record into the tree.
  // Records can be anything, but they must be Comparable
  // e: The record to insert.
  public void insert(E e) {
    root = insertHelp(root, e);
    nodeCount++;
  }

  // Remove a record from the tree
  // key: The key question of record to remove
  // Returns the record removed, null if there is none.
  public E remove(E key) {
    E temp = (E) findHelp(root, key); // First find it
    if (temp != null) {
      root = removeHelp(root, key); // Now remove it
      nodeCount--;
    }
    return temp;
  }

  // Return the record with key question k, null if none exists
  // key: The key question to find
  public E find(E key) { return (E) findHelp(root, key); }

  // Return the number of records in the dictionary
  public int size() { return nodeCount; }

  
  protected E findHelp(Question<E> rt, E k)
  {
      if(rt == null) return null;
      E c = rt.question();
      if(c.compareTo(k) > 0)
          return (E) findHelp(rt.no(), k);
      else if(c.compareTo(k) == 0)
          return rt.question();
      else return (E) findHelp(rt.yes(), k);
  }
  
  
  
  protected Question insertHelp(Question<E> rt, E e)
  {
      if(rt == null) return new Question<>(e);
      if(rt.question().compareTo(e) >= 0)
          rt.setNo(insertHelp(rt.no(), e));
      else 
          rt.setYes(insertHelp(rt.yes(), e));
      return rt;
  }

    protected Question removeHelp(Question<E> rt, E k) {
        if(rt == null) return null;
        if(rt.question().compareTo(k) > 0)
        {
            rt.setNo(removeHelp(rt.no(), k));
        }
        else if(rt.question().compareTo(k) < 0)
        {
            rt.setYes(removeHelp(rt.yes(), k));
        }
        else
        {
            if(rt.no() == null) return rt.yes();
            else if(rt.yes() == null) return rt.no();
            else
            {
                Question<E>temp = getMax(rt.no());
                rt.setQuestion(temp.question());
                rt.setNo(deleteMax(rt.no()));
            }
        }
        
        return rt;
      }

    // Get the maximum valued element in a subtree
  protected Question<E> getMax(Question<E> rt) {
    if (rt.yes() == null) return rt;
    return getMax(rt.yes());
  }

    protected Question deleteMax(Question rt) {
        if (rt.yes() == null) return rt.no();
        rt.setYes(deleteMax(rt.yes()));
        return rt;   }
    
    
    public void print()
    {
        System.out.print("[");
        printHelp(root);
        System.out.println("]");
    }
    protected void printHelp(Question rt)
    {
        if(rt == null) return;
        printHelp(rt.no());
        System.out.print(" "+rt.question() +" ");
        printHelp(rt.yes());
    }
   
}