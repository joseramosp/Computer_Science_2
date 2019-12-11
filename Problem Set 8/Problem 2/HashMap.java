/* Problem Set 8 - Problem 2

Name: Jose Ramos
NECC ID#: 00299444
Date: December 2, 2019

-- OBJECTIVE --

Write an implementation of a HashMap that uses chaining. The map and the chaining "buckets" should be implemented  on
a linked list. Provide testing code.

Reference: I worked with Vladimir Ventura to learn more about this topic and understand the API for record and HashMap.

NOTE: The line 108 was added to show all the records chained in a record with one or more record linked.

*/

public class HashMap<K extends Comparable<K>, V> {

    private Record[] table;
    private int size;           // Size of the HashMap
    int m = 25;                 // default mod

    public HashMap(){
        this.table = new Record[25];
        this.size = 0;
    }

    public HashMap(int maxSize){
        this.table = new Record[maxSize];
        this.size = 0;
    }

    public void clear(){
        for (int i = 0; i < size; i++) {
            table[i] = null;
        }
        size = 0;
    }

    private int hash(K key){
        return key.hashCode() % m;
    }

    public void insert(K key, V value){
        insert(key, value, hash(key));
    }

    public String allInHash(K key){
        StringBuilder message = new StringBuilder().append(key.toString()).append(": ");
        Record<K, V> headRecord = table[hash(key)];
        while (headRecord != null){
            message.append(headRecord.getValue().toString()).append(" ");
            headRecord = headRecord.getNext();
        }
        return message.toString();
    }

    public void insert(K key, V value, int hashToTableSpecs){
        if (table[hashToTableSpecs] == null){
            table[hashToTableSpecs] = new Record<>(key, value);
        } else { //Eliminated linear probing
            Record<K, V> temporal = table[hashToTableSpecs];
            if (temporal.getKey().compareTo(key) == 0){
                temporal.setValue(value);
            } else {
                Record<K, V> previous = temporal;
                boolean added = false;
                while (temporal != null && !added){
                    if (temporal.getKey().compareTo(key) == 0){
                        temporal.setValue(value);
                        added = true;
                    } else {
                        previous = temporal;
                        temporal = temporal.getNext();
                    }
                }
                if (!added) previous.setNext(new Record<>(key, value));
            }
        }
    }

    public V remove(K key){
        V removedValue = null;
        Record<K, V> headRecord = table[hash(key)];
        Record<K, V> previous = headRecord;
        while(headRecord != null){
            if (headRecord.getKey().compareTo(key) == 0){
                removedValue = headRecord.getValue();
                table[hash(key)] = headRecord.getNext();
                break;
            } else {
                headRecord = headRecord.getNext();
            }
        }
        return removedValue;
    }

    public V getValue(K key){
        V value = null;
        Record<K, V> headRecord = table[hash(key)];
        //Locate the record with the specific key
        while (headRecord != null){
            if (headRecord.getKey().compareTo(key) == 0){
                value = headRecord.getValue();
                break;
            } else {
                System.out.println(headRecord.toString());     // This line is for testing only
                headRecord = headRecord.getNext();
            }
        }
        return value;
    }
}
