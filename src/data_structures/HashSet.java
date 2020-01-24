package data_structures;

public class HashSet<T> {
    private static final int HASH_SET_SIZE = 10;
    private static final int MAX_LIST_SIZE = 10;

    private DoublyCircularLinkedList<T>[] index;
    private int indexSize;

    public HashSet() {
        this.indexSize = HASH_SET_SIZE;

    }

    private void initIndex(int sixe) {
        this.index = new DoublyCircularLinkedList[sixe];
        for (int i = 0; i <sixe ; i++) {
            index[i] = new DoublyCircularLinkedList<T>();
        }
    }

    public int getHashCode(T value) {
        if ( value instanceof String) {
            return ((String) value).length();
        }
        return value.hashCode();
    }

    public boolean add (T value) {
        int hashKey = this.getHashCode(value) % indexSize;
        if (contains(value, hashKey)){
            return false;
        }
        DoublyCircularLinkedList<T> currentList = index[hashKey];
        currentList.add(value);
        return true;
    }

    public boolean contains(T value, int hashKey) {
        DoublyCircularLinkedList<T> currentList = index[hashKey];
        return currentList.contains(value);
    }

}
