import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Road_STUDENT_Test {
    private Town town1, town2, town3;
    private Road road1, road2, road3;

    @Before
    public void setUp() throws Exception {
        town1 = new Town("Town_1");
        town2 = new Town("Town_2");
        town3 = new Town("Town_3");
        road1 = new Road(town1, town2, "Road_1");
        road2 = new Road(town2, town1, "Road_2");
        road3 = new Road(town2, town1, "Road_3");
    }

    @After
    public void tearDown() throws Exception {
        town1 = null;
        town2 = null;
        town3 = null;
        road1 = null;
        road2 = null;
        road3 = null;
    }

    @Test
    public void contains() {
        assertTrue(road1.contains(town1));
        assertTrue(road1.contains(town2));
        assertFalse(road1.contains(town3));
    }

    @Test
    public void testToString() {
        assertEquals("Town_1 via Road_1 to Town_2 1 mi", road1.toString());
    }

    @Test
    public void getName() {
        assertEquals("Road_1", road1.getName());
    }

    @Test
    public void getDestination() {
        assertEquals(town1, road2.getDestination());
        assertEquals(town2, road1.getDestination());
    }

    @Test
    public void getSource() {
        assertEquals(town1, road1.getSource());
        assertEquals(town2, road2.getSource());
    }

    @Test
    public void compareTo() {
        assertEquals(0, road1.compareTo(road1));
        assertEquals(0, road1.compareTo(road2));
    }
}