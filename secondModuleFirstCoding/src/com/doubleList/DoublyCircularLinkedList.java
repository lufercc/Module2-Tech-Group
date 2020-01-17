package com.doubleList;

public class DoublyCircularLinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public DoublyCircularLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public void add(T value) {
        Node<T> aux = last;
        Node<T> newValue = new Node<T>(value);
        if (first == null) {
            first = newValue;
            last = newValue;
            last.setPrevius(first);
            first.setNext(last);
        } else {
            last = newValue;
            last.setPrevius(aux);
            aux.setNext(last);
        }
        size++;
    }

    @Override
    public String toString(){
        String res = "[";
        Node<T> aux = first;
        while (aux != null) {
            res += aux.getValue().toString();
            if (aux != last) {
                res +=  ", ";
            }
            aux = aux.getNext();
        }
        return  res += "]";
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        Node<T> aux = first;
        if (index > size) {
            throw new Error("no found index");
        }
        for (int i = 0; i < index ; i++) {
            aux = aux.getNext();
        }
        return aux.getValue();
    }

    public boolean contains(T value) {
        Node<T> aux = first;
        while (aux != null) {
            if (aux.getValue() == value) {
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean remove(T value) {
        Node<T> aux = first;
        while (aux != null) {
            if (aux.getValue() == value) {
                Node<T> previus = aux.getPrevius();
                Node<T> next = aux.getNext();
                previus.setNext(next);
                next.setPrevius(previus);
                size --;
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

}
