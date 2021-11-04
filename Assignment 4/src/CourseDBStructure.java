import java.io.IOException;
import java.util.LinkedList;

/**
 * CourseDBStructure class - implements CourseDBStructureInterface
 * @author Shahdad Parsi
 */

public class CourseDBStructure implements CourseDBStructureInterface{

    protected int hash;
    protected int size;
    public LinkedList<CourseDBElement>[] hashTable;

    public CourseDBStructure(String testString, int size){
        this.size = size;
        hashTable = new LinkedList[size];
    }

    public CourseDBStructure(int size){
        this.size = size;
        hashTable = new LinkedList[size];
    }

    /**
     * the add method which takes a CourseDBElement and
     * then adds it into the data structure
     * @param element the CDE to be added
     */
    @Override
    public void add(CourseDBElement element) {
        int ok;
        ok = element.hashCode() % hashTable.length;
        LinkedList<CourseDBElement> hashh = hashTable[ok];

        if(hashh == null){
            hashTable[ok] = new LinkedList<CourseDBElement>();
        }
        hashTable[ok].add(element);
        size++;
    }

    /**
     * This get method takes a crn number and gets the
     * CourseDBElement of the data structure
     * @param crn
     * @return CourseDBElement element
     * @throws IOException
     */
    @Override
    public CourseDBElement get(int crn) throws IOException {
       String str;
       str = Integer.toString(crn);
       int hash;
       hash = str.hashCode() % size;

       if(hashTable[hash] == null){
           throw new IOException();
       }else{
           return hashTable[hash].get(0);
       }
    }

    /**
     * returns the size of the table
     * @return hashtable length
     */
    @Override
    public int getTableSize() {
        return hashTable.length;
    }
}
