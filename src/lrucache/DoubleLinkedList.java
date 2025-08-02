package lrucache;

public class DoubleLinkedList<K, V> {

    private final Node<K, V> head;
    private final Node<K, V> tail;

    DoubleLinkedList(){
        this.head = new Node<>(null, null);
        this.tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    synchronized void addFirst(Node<K, V> node) {

    }

    synchronized void remove(Node<K, V> node) {

    }

    synchronized void moveToFirst(Node<K, V> node) {

    }

    synchronized void removeLast() {

    }

}
