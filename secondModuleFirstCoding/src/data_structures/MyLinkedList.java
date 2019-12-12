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
        this.last = last;
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
    public boolean add(T data) {
        Node node = new Node(data);
        if (first == null) {
            first = node;
            last = node;
            size++;
        }
        else{
            this.last.setNext(node);
            last = node;
            size++;
        }

        return false;
    }

    /**
     * Method to delete an object found into a node
     * @param o
     * @return {true} if the item is deleted success and {false} if the object is not found
     */
    @Override
    public boolean remove(Object o) {
        Node<T> current = first;
        Node<T> previus = null;
        while (current != null) {
            if (current.getValue().equals(o)) {
                if (first.equals(current)){
                    first = current.getNext();
                    return true;
                }
                previus.setNext(current.getNext());
                current.setValue(null);
                current.setNext(null);
                return true;
            }
            previus = current;
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
    public String toString() {
        String value = "[";
        Node nodeAux = first;
        while(nodeAux != null){
            if (nodeAux == last){
                value = value + nodeAux.getValue().toString();
            }
            else {
                value = value + nodeAux.getValue().toString() + ", ";

            }

            nodeAux = nodeAux.getNext();
        }
        return value + "]";
    }

    @Override
    public T get(int index) {
        if (index >= this.size){
            throw new IndexOutOfBoundsException();
        }
        Node<T> auxNode = first;

        for ( int i = 0; i==index; i++)
        {
            auxNode = auxNode.getNext();
        }

        return auxNode.getValue();
    }

    @Override
    public T set(int index, T element) {
        if (index >= this.size){
            throw new IndexOutOfBoundsException();
        }
        Node<T> auxNode = first;

        for ( int i = 0; i==index; i++)
        {
            auxNode = auxNode.getNext();
        }
        auxNode.setValue(element);
        return element;
    }

    @Override
    public void add(int index, T element) {
        if (index >= this.size){
            throw new IndexOutOfBoundsException();
        }
        Node<T> auxNode = first;
        Node<T> nodeToInsert = new Node<T>(element);

        for ( int i = 0; i==index; i++)
        {
            auxNode = auxNode.getNext();
        }
        nodeToInsert.setNext(auxNode.getNext());
        auxNode.setNext(nodeToInsert);
        size ++;
    }

    @Override
    public T remove(int index) {
        if (index >= this.size){
            throw new IndexOutOfBoundsException();
        }
        Node<T> auxNode = first;

        for ( int i = 0; i<=index; i++)
        {
            auxNode = auxNode.getNext();
        }
        Node<T> toDelete = auxNode.getNext();
        auxNode.setNext(toDelete.getNext());
        size --;
        return toDelete.getValue();
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        Node nodeAux = first;
        while(nodeAux != null){
            if (nodeAux.getValue() == o){
                return index;
            }
            nodeAux = nodeAux.getNext();
            index ++;
        }
        throw new IndexOutOfBoundsException();
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
