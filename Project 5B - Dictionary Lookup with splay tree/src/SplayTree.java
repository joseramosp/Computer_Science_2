/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;

public class SplayTree<E extends Comparable<E>> {

    protected BSTNode<E> root; // Root of the BST
    protected int nodeCount; // Number of nodes in the BST

    public SplayTree() {
        root = null;
        nodeCount = 0;
    }


    private BSTNode<E> splay(BSTNode<E> n, E e) {

        if (n == null) {
            return null;
        }
        int cmp1 = e.compareTo(n.value());

        if (cmp1 < 0) {
            //we have reach the end of the tree so it is not here
            if (n.left() == null) {
                return n;
            }
            int cmp2 = e.compareTo(n.left().value());
            if (cmp2 < 0) {
                n.left().setLeft(splay(n.left().left(), e));
                n = rotateRight(n);
            } else if (cmp2 > 0) {
                n.left().setRight(splay(n.left().right(), e));
                if (n.left().right() != null)
                    n.setLeft(rotateLeft(n.left()));
            }

            if (n.left() == null) {
                return n;
            } else {
                return rotateRight(n);
            }
        } else if (cmp1 > 0) {
            //we have reach the end of the tree so it is not here
            if (n.right() == null) {
                return n;
            }

            int cmp2 = e.compareTo(n.right().value());
            if (cmp2 < 0) {
                n.right().setLeft(splay(n.right().left(), e));
                if (n.right().left() != null)
                    n.setRight(rotateRight(n.right()));
            } else if (cmp2 > 0) {
                n.right().setRight(splay(n.right().right(), e));
                n = rotateLeft(n);
            }

            if (n.right() == null) {
                return n;
            } else {
                return rotateLeft(n);
            }
        } else return n;
    }

    private BSTNode<E> rotateRight(BSTNode<E> n) {
        BSTNode<E> temp;
        temp = n.left();
        n.setLeft(temp.right());
        temp.setRight(n);
        return temp;
    }

    private BSTNode<E> rotateLeft(BSTNode<E> n) {
        BSTNode<E> temp;
        temp = n.right();
        n.setRight(temp.left());
        temp.setLeft(n);
        return temp;

    }

    public E find(E key) {
        root = splay(root, key);
        int cmp = key.compareTo(root.value());
        if (cmp == 0) {
            return root.value();
        } else {
            return null;
        }
    }


    public void insert(E key) {
        // splay key to root
        if (root == null) {
            root = new BSTNode(key);
            return;
        }

        root = splay(root, key);

        int cmp = key.compareTo(root.value());

        // Insert new node at root
        if (cmp < 0) {
            BSTNode<E> n = new BSTNode(key);
            n.setLeft(root.left());
            n.setRight(root);
            root.setLeft(null);
            root = n;
        }
        // Insert new node at root
        else if (cmp > 0) {
            BSTNode<E> n = new BSTNode(key);
            n.setRight(root.right());
            n.setLeft(root);
            root.setRight(null);
            root = n;
        }
        // It was a duplicate element do nothing
        else {

        }

    }


    public void remove(E key) {
        if (root == null) return; // empty tree

        root = splay(root, key);

        int cmp = key.compareTo(root.value());

        if (cmp == 0) {
            if (root.left() == null) {
                root = root.right();
            } else {
                BSTNode<E> temp = root.right();
                root = root.left();
                splay(root, key);
                root.setRight(temp);
            }
        }
    }

    public void clear() {
        root = null;
        nodeCount = 0;
    }

    public int size() {
        return nodeCount;
    }

    public void print() {
        System.out.print("[");
        printhelp(root);
        System.out.println("]");
    }

    private void printhelp(BSTNode rt) {
        if (rt == null) return;
        printhelp(rt.left());
        System.out.print(" " + rt.value() + " ");
        printhelp(rt.right());
    }

    public void printLevelOrder() {
        ArrayList<BSTNode> q = new ArrayList(size());
        if (root != null) {
            q.add(root);
            while (!q.isEmpty()) {
                BSTNode n = q.remove(0);
                if (n != null) {
                    System.out.print(" " + n.value() + " ");
                    q.add(n.left());
                    q.add(n.right());
                }
            }
        }
        System.out.println(" ");

    }

}

