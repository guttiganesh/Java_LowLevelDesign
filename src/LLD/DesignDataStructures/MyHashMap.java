package LLD.DesignDataStructures;

public class MyHashMap<K,V> {
    public static final int INITIAL_SIZE = 1 << 4;
    public static final int MAX_SIZE = 1 << 30;
    Entry[] hashMapTable;
    public MyHashMap(){
        hashMapTable = new Entry[INITIAL_SIZE];
    }
    public MyHashMap(int capacity){
        int size = getTableSize(capacity);
        hashMapTable = new Entry[size];
    }

    private int getTableSize(int capacity) {
        int n = capacity - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n < 0 ? 1 : n >= MAX_SIZE ? MAX_SIZE : n + 1;
    }

    class Entry<K,V>{
        K key;
        V value;
        Entry next;
        public Entry(K key,V value){
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
    public void put(K key,V value){
        int hasCode = key.hashCode() % hashMapTable.length;
        Entry node = hashMapTable[hasCode];
        if(node == null){
            Entry newNode = new Entry(key,value);
            hashMapTable[hasCode] = newNode;
        }else{
            Entry prevNode = node;
            while(node != null){
                if(node.key == key) {
                    node.value = value;
                    return;
                }
                prevNode = node;
                node = node.next;
            }
            Entry newNode = new Entry<>(key,value);
            prevNode.next = newNode;
        }
    }
    public V get(K key){
        int hashCode = key.hashCode() % hashMapTable.length;
        Entry node = hashMapTable[hashCode];
        while(node != null){
            if(node.key.equals(key)) return (V) node.value;
            node = node.next;
        }
        return null;
    }
    public static void main(String args[]) {

        MyHashMap<Integer, String> map = new MyHashMap<>(8);
        map.put(0, "hi");
        map.put(1, "my");
        map.put(2, "name");
        map.put(3, "is");
        map.put(4, "Shrayansh");
        map.put(5, "how");
        map.put(6, "are");
        map.put(7, "you");
        map.put(8, "friends");

        String value = map.get(7);
        System.out.println(value);

    }
}
