/* Problem Set 8 - Problem 2

Name: Jose Ramos
NECC ID#: 00299444
Date: December 2, 2019

-- OBJECTIVE --

Write an implementation of a HashMap that uses chaining. The map and the chaining "buckets" should be implemented  on
a linked list. Provide testing code.

Reference: I worked with Vladimir Ventura to learn more about this topic and understand the API for record and HashMap.

NOTE:

*/

public class Record<K extends Comparable<K>, V>  implements Comparable<Record<K, V>>{
    private K key;
    private V value;
    private Record<K, V> next;

    public Record(K key, V value){
        this.key = key;
        this.value = value;
    }

    public void setNext(Record<K, V> next) {
        this.next = next;
    }

    public Record<K, V> getNext() {
        return next;
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

    public String toString(){

        Record<K,V> temp = this;

        StringBuffer out = new StringBuffer((10 + 1) * 4);

        out.append("< ");
        while(temp != null) {
            out.append(temp.getKey() + ": \"" +temp.getValue()+ "\" ");
            temp = temp.getNext();
        }
        out.append(">");
        return out.toString();
    }
}