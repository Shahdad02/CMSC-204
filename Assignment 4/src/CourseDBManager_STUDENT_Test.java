import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CourseDBManager_STUDENT_Test {
    private CourseDBManagerInterface data;

    @Before
    public void setUp() throws Exception {
        data = new CourseDBManager();
    }

    @After
    public void tearDown() throws Exception {
        data = null;
    }

    @Test
    public void add() {
        try {
            data.add("CMSC140",30501,4,"SC450","Chandler Bing");
            data.add("CMSC203",30502,4,"SC451","Joey Tribbiani");
            data.add("CMSC204",30503,4,"SC452","Ross Geller");

        }
        catch(Exception e) {
            fail("This should not have caused an Exception");
        }
    }

    @Test
    public void get() {
        data.add("CMSC140",30501,4,"SC450","Chandler Bing");
        data.add("CMSC203",30502,4,"SC451","Joey Tribbiani");
        ArrayList<String> list = data.showAll();

        assertEquals(list.get(0), data.get(30502).toString());
        assertEquals(list.get(1), data.get(30501).toString());
    }

    @Test
    public void readFile() {
        try {
            File inputFile = new File("TestStudent.txt");
            PrintWriter inFile = new PrintWriter(inputFile);
            inFile.println("CMSC140 30501 4 SC450 Chandler Bing");
            inFile.print("CMSC203 30502 4 SC451 Joey Tribbiani");
            inFile.close();

            assertEquals(0, data.showAll().size());
            data.readFile(inputFile);
            //assertEquals(2, data.showAll().size());
        } catch (Exception e) {
            fail("Should not have thrown an exception");
        }
    }

    @Test
    public void showAll() {
        data.add("CMSC140",30501,4,"SC450","Chandler Bing");
        data.add("CMSC203",30502,4,"SC451","Joey Tribbiani");
        data.add("CMSC204",30503,4,"SC452","Ross Geller");
        ArrayList<String> list = data.showAll();

        assertEquals(list.get(0),"\nCourse:CMSC140 CRN:30501 Credits:4 Instructor:Chandler Bing Room:SC450");
        assertEquals(list.get(1),"\nCourse:CMSC203 CRN:30502 Credits:4 Instructor:Joey Tribbiani Room:SC451");
        assertEquals(list.get(2),"\nCourse:CMSC204 CRN:30553 Credits:4 Instructor:Ross Geller Room:SC452");
    }
}