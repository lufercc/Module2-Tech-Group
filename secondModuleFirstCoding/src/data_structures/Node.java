package data_structures;

public class Node<E> {

    private Node next;
    private E value;
    private int index;

    Node(E valuen) {
        this.value = value;
        this.next = null;
        this.index = 0;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
        this.next.setIndex(this.index + 1);
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index){
        this.index = index;
    }
}
