package com.company;

public class BinarySearchTree {
    private Node root;
    private int level;
    private int size;


    public boolean add(int value) {
        Node newNode = new Node(value);
        boolean result;
        if (root == null) {
            root = newNode;
            this.size++;
            result = true;
        } else {
            result = add(root, newNode);
            if (result) {
                this.size++;
            }
        }
        return result;
    }

    private boolean add(Node cursor, Node newNode) {
        boolean result = false;
        if (newNode.getValue() > cursor.getValue()) {
            if (cursor.getRight() == null) {
                cursor.setRight(newNode);
                result = true;
            } else {
                return add(cursor.getRight(), newNode);
            }
        } else if (newNode.getValue() < cursor.getValue()) {
            if (cursor.getLeft() == null) {
                cursor.setLeft(newNode);
                result = true;
            } else {
                return add(cursor.getLeft(), newNode);
            }
        }
        return result;
    }

    public int getLevel() {
        return level;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");

        visit(root, builder);

        builder.append("]");
        return builder.toString();
    }

    private void visit(Node cursor, StringBuilder builder) {
        if (cursor == null) return;

        visit(cursor.getLeft(), builder);
        builder.append(cursor.getValue());
        visit(cursor.getRight(), builder);
    }

    public boolean remove(int value) {
        boolean result = false;
        result = remove(this.root, null, value);
        return result;
    }

    private boolean remove(Node cursor, Node parent, int value) {
        if (cursor == null) {
            return false;
        }
        boolean result = false;
        if (cursor.getValue() == value) {
            if (cursor.getRight() != null && cursor.getLeft() != null) {
                int minRight = this.minRight(cursor.getRight());
                cursor.setValue(minRight);
                remove(cursor.getRight(), cursor, minRight);
            } else if (cursor.getRight() != null) {
                parent.setRight(cursor.getRight());
            } else if (cursor.getLeft() != null) {
                parent.setRight(cursor.getLeft());
            } else {
                if (cursor == parent.getLeft()) {
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }
            }
            result = true;
        } else if (value < cursor.getValue()) {
            result = remove(cursor.getLeft(), cursor, value);
        } else {
            result = remove(cursor.getRight(), cursor, value);
        }
        return result;
    }

    private int minRight(Node cursor) {
        int minValue =0;
        while(cursor != null){
            minValue = cursor.getValue();
            cursor = cursor.getLeft();
        }
        return minValue;
    }
}
