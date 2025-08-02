package lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, Node<K, V>> map;
    private final DoubleLinkedList<K, V> ddl;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.ddl = new DoubleLinkedList<K, V>();
    }

    V get(K key) {
        //move the K, V to front of the DLL
        return null;
    }

    void put(K key, V value) {
        // check if alread exist
        // else check capacity and work

    }

    void remove(K key) {
        // remove from map and DLL as well
    }
}
