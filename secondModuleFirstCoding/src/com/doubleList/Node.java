package com.doubleList;

public class Node<T> {
    private T value;
    private Node<T> next;
    private Node<T> previus;

    public Node(T value){
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrevius() {
        return previus;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrevius(Node<T> previus) {
        this.previus = previus;
    }
}
