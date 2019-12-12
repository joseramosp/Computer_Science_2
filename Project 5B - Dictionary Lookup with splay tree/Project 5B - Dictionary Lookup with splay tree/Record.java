/*
// * Jose Ramos
// * Student ID: 00299444
// * CIS 252 - T-7847
// * December 4/2019
// * Project 5B
// * -----------------------
// * Objectives:
// * This class is part of the "Project 5B" assignment. To see the objectives of this lab please read the readme.txt file.
// *
// * NOTE:
*/

public class Record<K extends Comparable<K>, V>  implements Comparable<Record<K, V>>{
    private K key;
    private V value;
    private Record<K, V> right;
    private Record<K, V> left;
    private int frequency;

    public Record(K key, V value){
        this.key = key;
        this.value = value;
        this.frequency = 1;
    }

    public void increaseFrequency(){
        this.frequency = this.frequency + 1;
    }

    public int getFrequency(){
        return this.frequency;
    }

    public void setRight(Record<K, V> right) { this.right = right; }

    public Record<K, V> getRight() { return right; }

    public void setLeft(Record<K, V> left) {
        this.left = left;
    }

    public Record<K, V> getLeft() {
        return left;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public int compareTo(Record<K, V> o) {
        return this.key.compareTo(o.getKey());
    }
}