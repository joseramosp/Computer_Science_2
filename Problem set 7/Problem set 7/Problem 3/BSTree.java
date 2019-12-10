import java.util.ArrayList;

public class BSTree<E extends Comparable<E>> {
    protected BSTNode<E> root; // Root of the BST
    protected int nodecount; // Number of nodes in the BST
    public ArrayList<BSTNode<E>> repeatedWords = new ArrayList<>();

    // constructor
    public BSTree() {
        root = null;
        nodecount = 0;

    }

    // Reinitialize tree
    public void clear() {
        root = null;
        nodecount = 0;
    }

    // Insert a record into the tree.
    // Records can be anything, but they must be Comparable
    // e: The record to insert.
    public void insert(E e) {
        root = inserthelp(root, e);
        nodecount++;
    }

    // Remove a record from the tree
    // key: The key value of record to remove
    // Returns the record removed, null if there is none.
    public E remove(E key) {
        E temp = (E) findhelp(root, key); // First find it
        if (temp != null) {
            root = removehelp(root, key); // Now remove it
            nodecount--;
        }
        return temp;
    }

    // Return the record with key value k, null if none exists
    // key: The key value to find
    public E find(E key) {
        return (E) findhelp(root, key);
    }

    // Return the number of records in the dictionary
    public int size() {
        return nodecount;
    }


    protected E findhelp(BSTNode<E> rt, E k) {
        if (rt == null) return null;
        E c = rt.value();
        if (c.compareTo(k) > 0)
            return (E) findhelp(rt.left(), k);
        else if (c.compareTo(k) == 0) {
            rt.increaseFrequency();
            repeatedWords.add(rt);
            return rt.value();
        }
        else return (E) findhelp(rt.right(), k);
    }


    protected BSTNode inserthelp(BSTNode<E> rt, E e) {
        if (rt == null) return new BSTNode<>(e);
        if (rt.value().compareTo(e) >= 0)
            rt.setLeft(inserthelp(rt.left(), e));
        else
            rt.setRight(inserthelp(rt.right(), e));
        return rt;
    }

    protected BSTNode removehelp(BSTNode<E> rt, E k) {
        if (rt == null) return null;
        if (rt.value().compareTo(k) > 0) {
            rt.setLeft(removehelp(rt.left(), k));
        } else if (rt.value().compareTo(k) < 0) {
            rt.setRight(removehelp(rt.right(), k));
        } else {
            if (rt.left() == null) return rt.right();
            else if (rt.right() == null) return rt.left();
            else {
                BSTNode<E> temp = getmax(rt.left());
                rt.setValue(temp.value());
                rt.setLeft(deletemax(rt.left()));
            }
        }

        return rt;
    }

    // Get the maximum valued element in a subtree
    protected BSTNode<E> getmax(BSTNode<E> rt) {
        if (rt.right() == null) return rt;
        return getmax(rt.right());
    }

    protected BSTNode deletemax(BSTNode rt) {
        if (rt.right() == null) return rt.left();
        rt.setRight(deletemax(rt.right()));
        return rt;
    }


    public void print() {
        System.out.print("[");
        printhelp(root);
        System.out.println("]");
    }

    protected void printhelp(BSTNode rt) {
        if (rt == null) return;
        printhelp(rt.left());
        System.out.print(" " + rt.value() + " ");
        printhelp(rt.right());
    }

    public int getFrequencyOfAWord(E k){
        return getFrequencyOfAWord(root, k);
    }

    protected int getFrequencyOfAWord(BSTNode<E> rt, E k) {
        if (rt == null) return 0;
        E c = rt.value();
        if (c.compareTo(k) > 0)
            return getFrequencyOfAWord(rt.left(), k);
        else if (c.compareTo(k) == 0) {
            return rt.getFrequency();
        }
        else return getFrequencyOfAWord(rt.right(), k);
    }

    public void printFirstsWordsSortedByFrequency(){

        ArrayList<BSTNode<E>> tempArrayList = new ArrayList<>();

        //BSTNode<E> temp = repeatedWords.get(0);
        for(int i =0; i<repeatedWords.size(); i++){
            BSTNode<E> temp = repeatedWords.get(0);
            for(int h=0; h<repeatedWords.size(); h++){
                if(repeatedWords.get(i).getFrequency()>temp.getFrequency()){
                    temp = repeatedWords.get(i);
                }
            }
            tempArrayList.add(temp);
            repeatedWords.remove(temp);
        }
        System.out.print("[ ");
        for(int i = 0; i<tempArrayList.size();i++){
            System.out.print(tempArrayList.get(i).value()+" ");
        }
        System.out.println("]");
    }

}