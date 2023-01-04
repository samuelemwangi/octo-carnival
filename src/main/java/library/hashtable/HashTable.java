package library.hashtable;

public class HashTable<K, V> {

    private static final int DEFAULT_SLOTS = 100;
    private HashEntry<K, V>[] bucket;
    private int slots;
    private int size;


    public HashTable() {
        this(DEFAULT_SLOTS);
    }

    @SuppressWarnings("unchecked")
    public HashTable(int slots) {
        this.slots = slots;
        bucket = new HashEntry[slots];
        size = 0;

        for (int i = 0; i < slots; slots++) {
            bucket[i] = null;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(K key, V value) {
        int hashIndex = getIndex(key);
        HashEntry<K, V> newEntry = new HashEntry<>(key, value);
        if (bucket[hashIndex] == null) {
            newEntry.currentTail =  newEntry;
            bucket[hashIndex] = newEntry;

        } else {
            HashEntry<K, V> head = bucket[hashIndex];
            HashEntry<K,V> currentTail =  head.currentTail;


            currentTail.next = newEntry;
            head.currentTail = currentTail.next;
            // check threshHold and expand if necessary
            // expandSize();
        }

        size++;
    }

    public V getValue(K key){
        int hashIndex = getIndex(key);

        if(bucket[hashIndex] == null)
            return null;

        HashEntry<K, V> head = bucket[hashIndex];

        while (head != null){
            if(head.key.equals(key))
                return head.value;
            head = head.next;
        }

        return null;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        int i = 0;
        for(HashEntry<K,V> entry : bucket){
            if(entry == null)
                continue;
            s.append(i).append("::").append(entry.key).append(",").append(entry.value).append("->");
            HashEntry<K,V> curr =  entry;
            while (curr != null){
                s.append(curr.key).append(",").append(curr.value).append(" ");
                curr = curr.next;
            }
            s.append("\n\n");
            i++;
        }

        return s.toString();
    }

    private int getIndex(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % slots;

        if (index < 0) {
            index = (index + slots) % slots;
        }

        return index;
    }

    @SuppressWarnings("unchecked")
    private void expandSize() {
        // expand if 60% is filled
        if ((1.0 * size) / slots >= 0.6) {
            slots = 2 * slots;

            HashEntry<K, V>[] updatedBucket = new HashEntry[slots];

            System.arraycopy(bucket, 0, updatedBucket, 0, bucket.length);
            this.bucket = updatedBucket;
        }
    }
}
