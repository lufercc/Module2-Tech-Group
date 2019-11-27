package data_structures;

import java.util.*;

public class MyLinkedList<T> implements List<T> {

    private Node<T> first;
    private Node<T> last;
    private Integer size;
//    private LinkedList

    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node<T> getLast() {
        return last;
    }

    public void setLast(Node last) {
        if (isEmpty()){
            this.first = this.last = last;
        }
        getLast().setNext(last);
        this.last = last;
        this.size = this.last.getIndex()+1;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size > 0? false : true;
    }

    @Override
    public boolean contains(Object o) {
        Node current = first;
        while (current != null) {
            if (current.getValue().equals(o)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] objects = new Object[this.size];
        if (!isEmpty()) {
            Node current = first;
            for (int i = 0; i < this.size; i++) {
                objects[i] = current.getValue();
                current = current.getNext();
            }
        }
        return objects;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        Node addNode = new Node<T>(t);
        this.setLast(addNode);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node current = first;
        while (current != null) {
            if (current.getValue().equals(o)) {
                current.setValue(null);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        this.first = null;
        this.last = null;
    }

    @Override
    public T get(int index) {
        Node<T> current = first;
        while (current != null) {
            if (current.getIndex() == index) {
                return current.getValue();
            }
            current = current.getNext();
        }
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        MyLinkedList<T> sublist = new MyLinkedList<T>();
        Node first = new Node<T>(get(fromIndex));
        Node last = new Node<T>(get(toIndex));
        last.setNext(null);
        sublist.setFirst((first));
        sublist.setLast((last));
        return sublist;
    }
}
