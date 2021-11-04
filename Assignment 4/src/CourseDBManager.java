import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * CourseDBManager class - implements CourseDBManagerInterface
 * @author Shahdad Parsi
 */

public class CourseDBManager implements CourseDBManagerInterface {

    public int size;
    //public LinkedList<CourseDBElement>[] hashTable;
    CourseDBStructure manage = new CourseDBStructure(10);

    /**
     * This add method uses CourseDBStructure to create
     * a CourseDBElement and add it into the data structure
     * @param id
     * @param crn
     * @param credits
     * @param roomNum
     * @param instructor
     */
    @Override
    public void add(String id, int crn, int credits, String roomNum, String instructor) {
        CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
        manage.add(element);
    }

    /**
     * This get method uses CourseDBStructure to get a CourseDBElement from the data structure
     * @param crn
     * @return element if found, else return null
     */
    @Override
    public CourseDBElement get(int crn)  {
        //return manage.get(crn);
        try{
            return manage.get(crn);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Reads every line from a text file
     * @param input
     * @throws FileNotFoundException
     */
    @Override
    public void readFile(File input) throws FileNotFoundException {
        Scanner scan = new Scanner(input);
        //manage = new CourseDBStructure(10);
        while(scan.hasNext()){
            String str = scan.nextLine();
            System.out.println(str);
        }
        scan.close();
    }

    /**
     * showAll method traverses through the data structure and
     * returns them into an array list
     * @return arraylist with elements
     */
    @Override
    public ArrayList<String> showAll() {
        ArrayList<String> arr = new ArrayList<>();
//        CourseDBElement manage2 = new CourseDBElement();
//            for(int i = 0; i < hashTable[i].size(); i++){
//            while(hashTable != null){
//                for(LinkedList<CourseDBElement> j: manage.hashTable){
//                    //CourseDBElement cdbe = (int) hashTable[i].get(j);
//                    arr.add("\n" + manage.toString());
//                }
//                break;
//            }
//        }
        for(int i = 0; i < manage.getTableSize(); i++){
            if(manage.hashTable[i] != null){
                arr.add(manage.hashTable[i].toString());
            }
        }
        return arr;
    }
}
