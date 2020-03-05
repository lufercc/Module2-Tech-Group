package data_structures.hashMap;

public class MyHashMap<K, T> {
    private Node ini;
    private Node last;
    private int size;

    public MyHashMap() {
        this.size = 0;
        this.ini = null;
        this.last = null;
    }

    private static int getHashCode(Object value) {
        return value.hashCode();
    }


    public boolean contains(K key) {
        Node current = this.ini;
        int hashKey = getHashCode(key);
        return contains(hashKey, current);
    }

    private static boolean contains(int hashKey, Node node) {
        Node current = node;
        while (current != null){
            int keyNode = getHashCode(current.getKey());
            if (keyNode == hashKey){
                return  true;
            }
            current = current.getNext();
        }
        return false;
    }
    public T getValue(K key){
        Node<K, T> current = this.ini;
        int hashKey = getHashCode(key);
        while (current != null){
            int keyNode = getHashCode(current.getKey());
            if (keyNode == hashKey){
                return current.getValue();
            }
            current = current.getNext();
        }
        throw new NullPointerException("no item found");
    }

    public boolean add(K key, T newValue) {
        int hashKey = getHashCode(key);
        if(contains(hashKey, this.ini)){
            this.replace(hashKey, newValue);
            return true;
        }
        Node<K, T> newNode = new Node<K, T>(key, newValue);
        if(this.ini == null){
            this.ini = newNode;
            this.last = newNode;
            this.size++;
            return true;
        }else {
            last.setNext(newNode);
            this.last = newNode;
            this.size++;
            return true;
        }

    }

    private void replace(int hashKey, T newValue) {
        Node<K, T> current = this.ini;
        while (current != null){
            int keyNode = getHashCode(current.getKey());
            if (keyNode == hashKey){
                current.setValue(newValue);
            }
            current = current.getNext();
        }
    }

    public boolean delete(K key) {
        boolean deleted = false;
        if (contains(key)){
            Node current = this.ini;
            Node next = current.getNext();
            Node previous = this.ini;
            int hashKey = getHashCode(key);
            while (current != null){
                if (hashKey == getHashCode(current.getKey())){
                    if (size == 1){
                        last = ini = null;
                    }
                    if (current == last){
                        last = previous;
                    }
                    if (current == ini){
                        ini = next;
                    }
                    previous.setNext(next);
                    current = previous;
                    size--;
                    deleted = true;

                }
                previous = current;
                current = current.getNext();
            }
        }
        return deleted;
    }

    public int size() {
        return this.size;
    }
}
