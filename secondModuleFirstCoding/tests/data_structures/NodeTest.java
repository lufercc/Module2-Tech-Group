package data_structures;

import org.junit.Test;

public class NodeTest {
    @Test
    public void testNodeConstructorPassingArgsShouldReturnAValidNode() {
        Node<String> testNode = new Node<>("abc");
    }
}
