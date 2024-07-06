package ArraySetPractice;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArraySetTest {

    @Test
    /** Test if contain works correct */
    public void containTest() {
        ArraySet<String> s = new ArraySet<>();
        s.add(null);
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add(null);
        s.add("fish");
        assertTrue("This set must contains horse", s.contains("horse"));
    }

}
