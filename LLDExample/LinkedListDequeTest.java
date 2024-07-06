package LLDExample;

import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListDequeTest {

    @Test
    public void testSize() {
        LinkedListDeque lld = new LinkedListDeque<>(1);
        assertEquals(1, lld.size());
    }

    @Test
    public void test() {
        LinkedListDeque lld = new LinkedListDeque<>(1);
        lld.addLast(3);
        lld.addLast(5);
        lld.addFirst(0);
        lld.addFirst(-1);
        assertEquals(5, lld.size());
        assertEquals(1, lld.get(2));
    }
}
