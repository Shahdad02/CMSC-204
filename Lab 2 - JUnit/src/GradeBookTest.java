import static org.junit.Assert.*;

public class GradeBookTest {
    GradeBook grade;
    GradeBook grade2;

    @org.junit.Before
    public void setUp() throws Exception {
        grade = new GradeBook(5);
        grade2 = new GradeBook(5);

        grade.addScore(55.0);
        grade.addScore(84.0);
        grade2.addScore(64.0);
        grade2.addScore(78.0);
    }

    @org.junit.After
    public void tearDown() throws Exception {
        grade = null;
        grade2 = null;
    }

    @org.junit.Test
    public void addScore() {
        assertTrue(grade.toString().equals("55.0 84.0 "));
        assertTrue(grade2.toString().equals("64.0 78.0 "));
    }

    @org.junit.Test
    public void sum() {
        assertEquals(139, grade.sum(), .0001);
        assertEquals(142, grade2.sum(), .0001);
    }

    @org.junit.Test
    public void minimum() {
        assertEquals(55, grade.minimum(), .001);
        assertEquals(64, grade2.minimum(), .001);
    }

    @org.junit.Test
    public void finalScore() {
        assertEquals(84, grade.finalScore(), .001);
        assertEquals(78, grade2.finalScore(), .001);

    }

}