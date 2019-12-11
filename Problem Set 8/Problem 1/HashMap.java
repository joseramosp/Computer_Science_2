public class HashMap<K , V> {

    private static final int INIT_CAPACITY = 4;

    private int n;           // number of K-V pairs in the symbol table
    private int m;           // size of linear probing table
    private K[] keys;        // the keys
    private V[] values;      // the values


    /**
     * Initializes an empty symbol table.
     */
    public HashMap() {
        this(INIT_CAPACITY);
    }

    /**
     * Initializes an empty symbol table with the specified initial capacity.
     *
     * @param capacity the initial capacity
     */
    public HashMap(int capacity) {
        m = capacity;
        n = 0;
        keys = (K[]) new Object[m];
        values = (V[]) new Object[m];
    }

    /**
     * Returns the number of K-V pairs in this symbol table.
     *
     * @return the number of K-V pairs in this symbol table
     */
    public int size() {
        return n;
    }

    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     * {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table contains the specified K.
     *
     * @param K the K
     * @return {@code true} if this symbol table contains {@code K};
     * {@code false} otherwise
     * @throws IllegalArgumentException if {@code K} is {@code null}
     */
    public boolean contains(K K) {
        if (K == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(K) != null;
    }

    // hash function for keys - returns V between 0 and M-1
    private int hash(K K) {
        return (K.hashCode() & 0x7fffffff) % m;
    }

    // resizes the hash table to the given capacity by re-hashing all of the keys
    private void resize(int capacity) {
        HashMap<K, V> temp = new HashMap<K, V>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], values[i]);
            }
        }
        keys = temp.keys;
        values = temp.values;
        m = temp.m;
    }

    /**
     * Inserts the specified K-V pair into the symbol table, overwriting the old
     * V with the new V if the symbol table already contains the specified K.
     * Deletes the specified K (and its associated V) from this symbol table
     * if the specified V is {@code null}.
     *
     * @param K   the K
     * @param val the V
     * @throws IllegalArgumentException if {@code K} is {@code null}
     */
    public void put(K K, V val) {
        if (K == null) throw new IllegalArgumentException("first argument to put() is null");

        if (val == null) {
            delete(K);
            return;
        }

        // double table size if 50% full
        if (n >= m / 2) resize(2 * m);

        int i;
        for (i = hash(K); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(K)) {
                values[i] = val;
                return;
            }
        }
        keys[i] = K;
        values[i] = val;
        n++;
    }

    /**
     * Returns the V associated with the specified K.
     *
     * @param K the K
     * @return the V associated with {@code K};
     * {@code null} if no such V
     * @throws IllegalArgumentException if {@code K} is {@code null}
     */
    public V get(K K) {
        if (K == null) throw new IllegalArgumentException("argument to get() is null");
        for (int i = hash(K); keys[i] != null; i = (i + 1) % m)
            if (keys[i].equals(K))
                return values[i];
        return null;
    }

    /**
     * Removes the specified K and its associated V from this symbol table
     * (if the K is in this symbol table).
     *
     * @param K the K
     * @throws IllegalArgumentException if {@code K} is {@code null}
     */
    public void delete(K K) {
        if (K == null) throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(K)) return;

        // find position i of K
        int i = hash(K);
        while (!K.equals(keys[i])) {
            i = (i + 1) % m;
        }

        // delete K and associated V
        keys[i] = null;
        values[i] = null;

        // rehash all keys in same cluster
        i = (i + 1) % m;
        while (keys[i] != null) {
            // delete keys[i] an values[i] and reinsert
            K keyToRehash = keys[i];
            V valToRehash = values[i];
            keys[i] = null;
            values[i] = null;
            n--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % m;
        }

        n--;

        // halves size of array if it's 12.5% full or less
        if (n > 0 && n <= m / 8) resize(m / 2);

        assert check();
    }

    // integrity check - don't check after each put() because
    // integrity not maintained during a delete()
    private boolean check() {

        // check that hash table is at most 50% full
        if (m < 2 * n) {
            System.err.println("Hash table size m = " + m + "; array size n = " + n);
            return false;
        }

        // check that each K in table can be found by get()
        for (int i = 0; i < m; i++) {
            if (keys[i] == null) continue;
            else if (get(keys[i]) != values[i]) {
                System.err.println("get[" + keys[i] + "] = " + get(keys[i]) + "; values[i] = " + values[i]);
                return false;
            }
        }
        return true;
    }
}
