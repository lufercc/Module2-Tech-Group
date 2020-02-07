package com.company;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTreeTest {
    @Test
    public void testAdd() {
        BinarySearchTree myTree = new BinarySearchTree();

        myTree.add(8);
        myTree.add(10);
        myTree.add(6);
        myTree.add(2);
        myTree.add(5);
        myTree.add(7);
        myTree.add(9);
        myTree.add(3);

//        assertEquals(3, myTree.getLevel());
        assertEquals(8, myTree.size());
    }

    @Test
    public void testToString() {
        BinarySearchTree myTree = new BinarySearchTree();

        myTree.add(8);
        myTree.add(6);
        myTree.add(10);
        myTree.add(9);
        myTree.add(3);
        myTree.add(7);
        myTree.add(2);
        myTree.add(4);

        assertEquals("[234678910]", myTree.toString());
    }

    @Test
    public void testRemoveRoot() {
        BinarySearchTree myTree = new BinarySearchTree();

        myTree.add(8);
        myTree.add(6);
        myTree.add(10);
        myTree.add(9);
        myTree.add(3);
        myTree.add(7);
        myTree.add(2);
        myTree.add(4);

        myTree.remove(8);

        assertEquals("[23467910]", myTree.toString());
    }

    @Test
    public void testRemove() {
        BinarySearchTree myTree = new BinarySearchTree();

        myTree.add(8);
        myTree.add(6);
        myTree.add(10);
        myTree.add(9);
        myTree.add(3);
        myTree.add(7);
        myTree.add(2);
        myTree.add(4);

        myTree.remove(6);

        assertEquals("[23478910]", myTree.toString());
    }

    @Test
    public void testRemoveLastChildRight() {
        BinarySearchTree myTree = new BinarySearchTree();

        myTree.add(8);
        myTree.add(6);
        myTree.add(10);
        myTree.add(9);
        myTree.add(3);
        myTree.add(7);
        myTree.add(2);
        myTree.add(4);

        myTree.remove(7);

        assertEquals("[23468910]", myTree.toString());
    }

    @Test
    public void testRemoveLastChild() {
        BinarySearchTree myTree = new BinarySearchTree();

        myTree.add(8);
        myTree.add(6);
        myTree.add(10);
        myTree.add(9);
        myTree.add(3);
        myTree.add(7);
        myTree.add(2);
        myTree.add(4);

        myTree.remove(2);

        assertEquals("[34678910]", myTree.toString());
    }

    @Test
    @Ignore
    public void testLevel() {
        BinarySearchTree myTree = new BinarySearchTree();

        myTree.add(8);
        myTree.add(10);
        myTree.add(6);
        myTree.add(2);
        myTree.add(5);
        myTree.add(7);
        myTree.add(9);
        myTree.add(3);

        assertEquals(3, myTree.getLevel());
    }
}
