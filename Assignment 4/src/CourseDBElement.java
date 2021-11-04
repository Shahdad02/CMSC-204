/**
 * CourseDBElement class - implements Comparable
 * @author Shahdad Parsi
 */
public class CourseDBElement implements Comparable{

    public String id;
    public int crn;
    public int credits;
    public String room;
    public String teacher;

    /**
     * Basic class constructor
     * @param id
     * @param crn
     * @param credits
     * @param room
     * @param teacher
     */
    public CourseDBElement(String id, int crn, int credits, String room, String teacher){
        this.id = id;
        this.crn = crn;
        this.credits = credits;
        this.room = room;
        this.teacher = teacher;
    }

    /**
     * Basic class constructor that sets each value
     */
    public CourseDBElement() {
        id = null;
        crn = 00000;
        credits = 0;
        room = null;
        teacher = null;
    }

    /**
     * get the id of class
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * set the id of a class
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * get the amount of credits of a class
     * @return credits
     */
    public int getCredits() {
        return credits;
    }

    /**
     * sets the number of credits of a class
     * @param credits
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     * gets the room number
     * @return room
     */
    public String getRoom() {
        return room;
    }

    /**
     * sets the room number of class
     * @param room
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * gets the teacher name of class
     * @return teacher;
     */
    public String getTeacher() {
        return teacher;
    }

    /**
     * sets the teacher name of a class
     * @param teacher
     */
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    /**
     * returns the crn of a class
     * @return crn
     */
    public int getCrn(){
        return crn;
    }

    /**
     * sets the crn of a class
     * @param crn
     */
    public void setCrn(int crn){
        this.crn = crn;
    }

    /**
     * returns the string output of a hashcode
     * @return string of hashcode
     */
    public int hashCode(){
        String str;
        str = Integer.toString(crn);
        return str.hashCode();
    }

    /**
     * compares the data element of the crn
     * returns 0 if equal, -1 if element is greater than the crn
     * @param element
     * @return
     */
    @Override
    public int compareTo(CourseDBElement element) {
        if(element.crn == crn){
            return 0;
        }else if(element.crn < crn){
            return -1;
        }else{
            return 1;
        }
    }

    /**
     * @return the string representation format
     */
    public String toString(){
        //"\nCourse:CMSC203 CRN:30503 Credits:4 Instructor:Jill B. Who-Dunit Room:SC450"
        return "\nCourse:" + id + " CRN:" + crn + " Credits:" + credits + " Instructor:" + teacher + " Room:" + room;
    }

}
