import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Town_STUDENT_Test {
    private Town town1, town2;

    @Before
    public void setUp() throws Exception {
        town1 = new Town("Town_1");
        town2 = new Town("Town_2");
    }

    @After
    public void tearDown() throws Exception {
        town1 = null;
        town2 = null;
    }

    @Test
    public void getName() {
        assertEquals("Town_1", town1.getName());
        assertEquals("Town_2", town2.getName());
    }

    @Test
    public void compareTo() {
        assertEquals(0, town1.compareTo(town1));
        assertEquals(0, town1.compareTo(new Town("Town_1")));
        assertEquals(-1, town1.compareTo(town2));
    }

    @Test
    public void testToString() {
        assertEquals("Town_1", town1.toString());
        assertEquals("Town_2", town2.toString());
    }

    @Test
    public void testHashCode() {
        assertEquals(town1.hashCode(), new Town("Town_1").hashCode());
        assertEquals(town2.hashCode(), new Town("Town_2").hashCode());
    }

    @Test
    public void testEquals() {
        assertEquals(true, town1.equals(town1));
        assertEquals(true, town1.equals(new Town("Town_1")));
        assertEquals(false, town1.equals(town2));
    }
}