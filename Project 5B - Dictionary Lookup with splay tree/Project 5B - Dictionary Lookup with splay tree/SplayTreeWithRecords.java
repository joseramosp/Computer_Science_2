/*
// * Jose Ramos
// * Student ID: 00299444
// * CIS 252 - T-7847
// * December 10/2019
// * Project 5B
// * -----------------------
// * Objectives:
// * This class is part of the "Project 5B" assignment. To see the objectives of this lab please read the readme.txt file.
// *
// * NOTE:
*/

public class SplayTreeWithRecords <K extends Comparable<K>, V> {

    protected Record<K,V> root;
    protected int nodeCount;

    // constructor
    public SplayTreeWithRecords() {
        root = null;
        nodeCount = 0;
    }

    // Reinitialize tree
    public void clear() {
        root = null;
        nodeCount = 0;
    }

    // TODO: This method needs to be reviewed. The frequency and the key has to be used.
    private Record<K,V> splay(Record<K,V> n, int f ) {

        if (n == null) {
            return null;
        }

        if (f < n.getFrequency()) {
            //we have reach the end of the tree so it is not here
            if (n.getLeft() == null) {
                return n;
            }
            if (f < n.getLeft().getFrequency()) {
                n.getLeft().setLeft(splay(n.getLeft().getLeft(), f));
                n = rotateRight(n);
            } else if (f > n.getLeft().getFrequency()) {
                n.getLeft().setRight(splay(n.getLeft().getRight(), f));
                if (n.getLeft().getRight() != null)
                    n.setLeft(rotateLeft(n.getLeft()));
            }

            if (n.getLeft() == null) {
                return n;
            } else {
                return rotateRight(n);
            }
        } else if (f > n.getFrequency()) {
            //we have reach the end of the tree so it is not here
            if (n.getRight() == null) {
                return n;
            }

            if (f < n.getRight().getFrequency()) {
                n.getRight().setLeft(splay(n.getRight().getLeft(), f));
                if (n.getRight().getLeft() != null)
                    n.setRight(rotateRight(n.getRight()));
            } else if (f > n.getRight().getFrequency()) {
                n.getRight().setRight(splay(n.getRight().getRight(), f));
                n = rotateLeft(n);
            }

            if (n.getRight() == null) {
                return n;
            } else {
                return rotateLeft(n);
            }
        } else return n;
    }

    private Record<K,V> rotateRight(Record<K,V> n) {
        Record<K,V> temp;
        temp = n.getLeft();
        n.setLeft(temp.getRight());
        temp.setRight(n);
        return temp;
    }

    private Record<K,V> rotateLeft(Record<K,V> n) {
        Record<K,V> temp;
        temp = n.getRight();
        n.setRight(temp.getLeft());
        temp.setLeft(n);
        return temp;
    }

    // TODO: This method needs to be done.
    public V find(K key) {
        root = splay(root, root.getFrequency());
        int cmp = key.compareTo(root.value());
        if (cmp == 0) {
            return root.value();
        } else {
            return null;
        }
    }

    // TODO: This method needs to be done.
    public void insert(K key, V value) {
        // splay key to root
        if (root == null) {
            root = new Record(key,value);
            return;
        }

        root = splay(root, key);

        int cmp = key.compareTo(root.value());

        // Insert new node at root
        if (cmp < 0) {
            Record<K,V> n = new Record(key, value);
            n.setLeft(root.getLeft());
            n.setRight(root);
            root.setLeft(null);
            root = n;
        }
        // Insert new node at root
        else if (cmp > 0) {
            Record<K,V> n = new Record(key, value);
            n.setRight(root.getRight());
            n.setLeft(root);
            root.setRight(null);
            root = n;
        }
        // It was a duplicate element do nothing
        else {

        }

    }

}
