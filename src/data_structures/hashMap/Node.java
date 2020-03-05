package data_structures.hashMap;

public class Node<K, T> {
    private K key;
    private T value;
    private Node next;

    public Node(K key, T value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<K, T> getNext() {
        return next;
    }

    public void setNext(Node<K, T> next) {
        this.next = next;
    }
}
