package data_structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MyLinkedListTest {
    @Test
    public void testAddMethodShouldIncreaseTheSizeOfTheList() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        myLinkedList.add("sdsdf");
        myLinkedList.add("dsdf");
        myLinkedList.add("hello");

        assertEquals(3, myLinkedList.size());
    }

    @Test
    public void testToString() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        myLinkedList.add("world");
        myLinkedList.add("hello");
        myLinkedList.add("gat");
        assertEquals("[world, hello, gat]", myLinkedList.toString());
    }

    @Test
    public void testGetMethodShouldReturnTheValueOfTheNodeOnTheSpecifiedIndex() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        myLinkedList.add("world");
        myLinkedList.add("people");
        myLinkedList.add("hello");

        assertEquals("world", myLinkedList.get(0));
        assertEquals("people", myLinkedList.get(1));
        assertEquals("hello", myLinkedList.get(2));
    }


    @Test
    public void testConstainsShouldReturnTrueIfExists() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        myLinkedList.add("world");
        myLinkedList.add("people");
        myLinkedList.add("hello");

        assertFalse(myLinkedList.contains("hola"));
        assertTrue(myLinkedList.contains("people"));
    }
}
