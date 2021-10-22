import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.Assert.*;

public class BasicDoubleLinkedList_STUDENT_Test {
    BasicDoubleLinkedList<Soccer> linkedSoccer;
    SoccerComparator comparatorSoccer;

    public Soccer a = new Soccer("Messi", "PSG", 2021);
    public Soccer b = new Soccer("Ronaldo", "Manchester United", 2021);
    public Soccer c = new Soccer("Fati", "Barca", 2019);
    public Soccer d = new Soccer("Suarez", "Madrid", 2020);
    public Soccer e = new Soccer("Lukaku", "Chelsea", 2021);

    public ArrayList<Soccer> fill = new ArrayList<Soccer>();

    @Before
    public void setUp() throws Exception {
        linkedSoccer = new BasicDoubleLinkedList<Soccer>();
        linkedSoccer.addToEnd(b);
        linkedSoccer.addToEnd(c);
        comparatorSoccer = new SoccerComparator();
    }

    @After
    public void tearDown() throws Exception {
        linkedSoccer = null;
    }

    @Test
    public void getSize() {
        assertEquals(2, linkedSoccer.getSize());
    }

    @Test
    public void addToEnd() {
        assertEquals(c, linkedSoccer.getLast());
        linkedSoccer.addToEnd(d);
        assertEquals(d, linkedSoccer.getLast());
    }

    @Test
    public void addToFront() {
        assertEquals(b, linkedSoccer.getFirst());
        linkedSoccer.addToFront(a);
        assertEquals(a, linkedSoccer.getFirst());
    }

    @Test
    public void getFirst() {
        assertEquals(b, linkedSoccer.getFirst());
        linkedSoccer.addToFront(a);
        assertEquals(a, linkedSoccer.getFirst());
    }

    @Test
    public void getLast() {
        assertEquals(c, linkedSoccer.getLast());
        linkedSoccer.addToEnd(d);
        assertEquals(d, linkedSoccer.getLast());
    }

    @Test
    public void iterator() {
    }

    @Test
    public void remove() {
        assertEquals(b, linkedSoccer.getFirst());
        assertEquals(c, linkedSoccer.getLast());
        linkedSoccer.addToFront(a);
        assertEquals(a, linkedSoccer.getFirst());
        linkedSoccer.remove(a, comparatorSoccer);
        assertEquals(b, linkedSoccer.getFirst());
    }

    @Test
    public void retrieveFirstElement() {
        assertEquals(b, linkedSoccer.getFirst());
        linkedSoccer.addToFront(a);
        assertEquals(a, linkedSoccer.getFirst());
        assertEquals(a, linkedSoccer.retrieveFirstElement());
        assertEquals(b,linkedSoccer.getFirst());
        assertEquals(b, linkedSoccer.retrieveFirstElement());
        assertEquals(c,linkedSoccer.getFirst());
    }

    @Test
    public void retrieveLastElement() {
        assertEquals(c, linkedSoccer.getLast());
        linkedSoccer.addToEnd(d);
        assertEquals(d, linkedSoccer.getLast());
        assertEquals(d, linkedSoccer.retrieveLastElement());
        assertEquals(c,linkedSoccer.getLast());
    }

    @Test
    public void toArrayList() {
        ArrayList<Soccer> list;
        linkedSoccer.addToFront(a);
        linkedSoccer.addToEnd(d);
        list = linkedSoccer.toArrayList();
        assertEquals(a, list.get(0));
        assertEquals(b, list.get(1));
        assertEquals(c, list.get(2));
        assertEquals(d, list.get(3));
    }

    private class Soccer {
        String name;
        String team;
        int yearTransfered;

        public Soccer(String name, String team, int yearTransfered){
            this.name = name;
            this.team = team;
            this.yearTransfered = yearTransfered;
        }

        public String getName() {
            return name;
        }

        public String getTeam() {
            return team;
        }

        public int getYearTransfered() {
            return yearTransfered;
        }

        @Override
        public String toString() {
            return "Soccer{" +
                    "name='" + name + '\'' +
                    ", team='" + team + '\'' +
                    ", yearTransfered=" + yearTransfered +
                    '}';
        }
    }

    private class SoccerComparator implements Comparator<Soccer> {

        @Override
        public int compare(Soccer o1, Soccer o2) {
            return o1.toString().compareTo(o2.toString());
        }
    }
}