/* Problem set 7 - Problem 2

Name: Jose Ramos
NECC ID#: 00299444
Date: November 28, 2019

-- OBJECTIVE --

Design and implement the following Binary Search Tree Methods:

* leafCount - returns the number of leaves
* height - returns the height of the tree

Reference: - OpenDSA Chapter 11
*/

public class BSTree<E extends Comparable<E>> {
    protected BSTNode<E> root; // Root of the BST
    protected int nodeCount; // Number of nodes in the BST
    protected int height;

    // constructor
    public BSTree() {
        root = null;
        nodeCount = 0;
        height = 0;
    }

    // Reinitialize tree
    public void clear() {
        root = null;
        nodeCount = 0;
    }

    // Insert a record into the tree.
    // Records can be anything, but they must be Comparable
    // e: The record to insert.
    public void insert(E e) {
        root = insertHelp(root, e);
        nodeCount++;
    }

    // Remove a record from the tree
    // key: The key value of record to remove
    // Returns the record removed, null if there is none.
    public E remove(E key) {
        E temp = (E) findHelp(root, key); // First find it
        if (temp != null) {
            root = removeHelp(root, key); // Now remove it
            nodeCount--;
        }
        return temp;
    }

    // Return the record with key value k, null if none exists
    // key: The key value to find
    public E find(E key) {
        return (E) findHelp(root, key);
    }

    // Return the number of records in the dictionary
    public int size() {
        return nodeCount;
    }


    protected E findHelp(BSTNode<E> rt, E k) {
        if (rt == null) return null;
        E c = rt.value();
        if (c.compareTo(k) > 0)
            return (E) findHelp(rt.left(), k);
        else if (c.compareTo(k) == 0)
            return rt.value();
        else return (E) findHelp(rt.right(), k);
    }

    protected BSTNode insertHelp(BSTNode<E> rt, E e) {
        if (rt == null) return new BSTNode<>(e);
        if (rt.value().compareTo(e) >= 0)
            rt.setLeft(insertHelp(rt.left(), e));
        else
            rt.setRight(insertHelp(rt.right(), e));
        return rt;
    }

    protected BSTNode removeHelp(BSTNode<E> rt, E k) {
        if (rt == null) return null;
        if (rt.value().compareTo(k) > 0) {
            rt.setLeft(removeHelp(rt.left(), k));
        } else if (rt.value().compareTo(k) < 0) {
            rt.setRight(removeHelp(rt.right(), k));
        } else {
            if (rt.left() == null) return rt.right();
            else if (rt.right() == null) return rt.left();
            else {
                BSTNode<E> temp = getMax(rt.left());
                rt.setValue(temp.value());
                rt.setLeft(deleteMax(rt.left()));
            }
        }
        return rt;
    }

    // Get the maximum valued element in a subtree
    protected BSTNode<E> getMax(BSTNode<E> rt) {
        if (rt.right() == null) return rt;
        return getMax(rt.right());
    }

    protected BSTNode deleteMax(BSTNode rt) {
        if (rt.right() == null) return rt.left();
        rt.setRight(deleteMax(rt.right()));
        return rt;
    }

    public void print() {
        System.out.print("[");
        printHelp(root);
        System.out.println("]");
    }

    protected void printHelp(BSTNode rt) {
        if (rt == null) return;
        printHelp(rt.left());
        System.out.print(" " + rt.value() + " ");
        printHelp(rt.right());
    }

    public int leafCount() {
        int count = 0;
        return leafCount(root, count);
    }

    protected int leafCount(BSTNode rt, int count) {
        if (rt == null) {
            return count;
        } else if (rt.isLeaf()) return ++count;

        count = leafCount(rt.left(), count);
        count = leafCount(rt.right(), count);
        return count;
    }

    public int height() {
        if (nodeCount == 0) return 0;
        int tempHeight = 0;
        height(root, tempHeight);
        return height;
    }

    //This is the
    protected int height(BSTNode rt, int tempHeight) {
        if (rt == null) {
            --tempHeight;
            if(height < tempHeight){
                height = tempHeight;
            }
            return tempHeight;
        }
        if(rt == root){
            tempHeight = 1;
        }
        height(rt.left(), ++tempHeight);
        tempHeight--;
        height(rt.right(), ++tempHeight);
        return tempHeight;
    }

}