package library.hashtable;

public class HashEntry<K, V> {
    K key;
    V value;

    // for chaining
    HashEntry<K, V> next;

    public HashEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

}
