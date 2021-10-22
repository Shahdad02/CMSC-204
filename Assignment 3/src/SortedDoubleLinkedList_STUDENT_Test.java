import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class SortedDoubleLinkedList_STUDENT_Test {
    SortedDoubleLinkedList<Soccer> sortedLinkedSoccer;
    SoccerComparator comparatorSoccer;

    public Soccer a = new Soccer("Messi", "PSG", 2021);
    public Soccer b = new Soccer("Ronaldo", "Manchester United", 2021);
    public Soccer c = new Soccer("Fati", "Barca", 2019);
    public Soccer d = new Soccer("Suarez", "Madrid", 2020);
    public Soccer e = new Soccer("Lukaku", "Chelsea", 2021);

    @Before
    public void setUp() throws Exception {
        comparatorSoccer = new SoccerComparator();
        sortedLinkedSoccer = new SortedDoubleLinkedList<Soccer>(comparatorSoccer);
    }

    @After
    public void tearDown() throws Exception {
        comparatorSoccer = null;
        sortedLinkedSoccer = null;

    }

    @Test
    public void addToEnd() {
        try{
            sortedLinkedSoccer.addToEnd(e);
            assertTrue("Did not throw an UnsupportedOperationException", false);
        }catch(UnsupportedOperationException e){
            assertTrue("Successfully threw an UnsupportedOperationException", true);
        }catch(Exception e){
            assertTrue("Threw an exception other than UnsupportedOperationException", false);
        }
    }

    @Test
    public void addToFront() {
        try{
            sortedLinkedSoccer.addToFront(a);
            assertTrue("Did not throw an UnsupportedOperationException", false);
        }catch(UnsupportedOperationException e){
            assertTrue("Successfully threw an UnsupportedOperationException", true);
        }catch(Exception e){
            assertTrue("Threw an exception other than UnsupportedOperationException", false);
        }
    }

    @Test
    public void testIteratorSuccessfulNext() {
        sortedLinkedSoccer.add(a);
        sortedLinkedSoccer.add(b);
        sortedLinkedSoccer.add(c);
        sortedLinkedSoccer.add(d);
        ListIterator<Soccer> iterator = sortedLinkedSoccer.iterator();
        assertEquals(true, iterator.hasNext());
        assertEquals(a, iterator.next());
        assertEquals(c, iterator.next());
        assertEquals(b, iterator.next());
        assertEquals(true, iterator.hasNext());
    }

    @Test
    public void testIteratorSuccessfulSoccerPrevious() {
        sortedLinkedSoccer.add(e);
        sortedLinkedSoccer.add(c);
        sortedLinkedSoccer.add(b);
        sortedLinkedSoccer.add(d);
        ListIterator<Soccer> iterator = sortedLinkedSoccer.iterator();
        assertEquals(true, iterator.hasNext());
        assertEquals(e, iterator.next());
        assertEquals(c, iterator.next());
        assertEquals(b, iterator.next());
        assertEquals(d, iterator.next());
        assertEquals(true, iterator.hasPrevious());
        assertEquals(d, iterator.previous());
        assertEquals(b, iterator.previous());
        assertEquals(c, iterator.previous());
    }

    @Test
    public void testIteratorNoSuchElementException() {
        sortedLinkedSoccer.add(e);
        sortedLinkedSoccer.add(c);
        sortedLinkedSoccer.add(b);
        sortedLinkedSoccer.add(d);
        ListIterator<Soccer> iterator = sortedLinkedSoccer.iterator();

        assertEquals(true, iterator.hasNext());
        assertEquals(e, iterator.next());
        assertEquals(c, iterator.next());
        assertEquals(b, iterator.next());
        assertEquals(true, iterator.hasNext());
        assertEquals(d, iterator.next());

        try{
            iterator.next();
            assertTrue("Did not throw a NoSuchElementException",false);
        }
        catch (NoSuchElementException e)
        {
            assertTrue("Successfully threw a NoSuchElementException",true);
        }
        catch (Exception e)
        {
            assertTrue("Threw an exception other than the NoSuchElementException", false);
        }
    }

    @Test
    public void testAddSocccer() {
        sortedLinkedSoccer.add(a);
        sortedLinkedSoccer.add(b);
        sortedLinkedSoccer.add(c);
        assertEquals(a, sortedLinkedSoccer.getFirst());
        assertEquals(b, sortedLinkedSoccer.getLast());
        sortedLinkedSoccer.add(d);
        sortedLinkedSoccer.add(e);
        assertEquals(e, sortedLinkedSoccer.getFirst());
        assertEquals(d, sortedLinkedSoccer.getLast());
        assertEquals(d,sortedLinkedSoccer.retrieveLastElement());
        assertEquals(b, sortedLinkedSoccer.getLast());
    }

    @Test
    public void testRemoveFirstSoccer() {
        sortedLinkedSoccer.add(b);
        sortedLinkedSoccer.add(c);
        assertEquals(c, sortedLinkedSoccer.getFirst());
        assertEquals(b, sortedLinkedSoccer.getLast());
        sortedLinkedSoccer.add(a);
        assertEquals(a, sortedLinkedSoccer.getFirst());
        sortedLinkedSoccer.remove(a, comparatorSoccer);
        assertEquals(c, sortedLinkedSoccer.getFirst());
    }

    @Test
    public void testRemoveEndSoccer() {
        sortedLinkedSoccer.add(b);
        sortedLinkedSoccer.add(e);
        assertEquals(e, sortedLinkedSoccer.getFirst());
        assertEquals(b, sortedLinkedSoccer.getLast());
        sortedLinkedSoccer.add(d);
        assertEquals(d, sortedLinkedSoccer.getLast());
        sortedLinkedSoccer.remove(d, comparatorSoccer);
        assertEquals(b, sortedLinkedSoccer.getLast());
    }

    @Test
    public void testRemoveMiddleCar() {
        sortedLinkedSoccer.add(a);
        sortedLinkedSoccer.add(b);
        assertEquals(a, sortedLinkedSoccer.getFirst());
        assertEquals(b, sortedLinkedSoccer.getLast());
        sortedLinkedSoccer.add(e);
        assertEquals(e, sortedLinkedSoccer.getFirst());
        assertEquals(b, sortedLinkedSoccer.getLast());
        assertEquals(3,sortedLinkedSoccer.getSize());
        sortedLinkedSoccer.remove(a, comparatorSoccer);
        assertEquals(e, sortedLinkedSoccer.getFirst());
        assertEquals(b, sortedLinkedSoccer.getLast());
        assertEquals(2,sortedLinkedSoccer.getSize());
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