import java.util.ArrayList;

/**
 * Town class
 * @author Shahdad Parsi
 */
public class Town implements Comparable<Town> {
    private String name;
    private ArrayList<Town> towns;

    /**
     * Constructor method
     * name of town
     * @param name
     */
    public Town(String name){
        this.name = name;
        towns = new ArrayList<Town>();
    }

    /**
     * Copy constructor
     * @param templateTown
     */
    public Town(Town templateTown){
        //this.name = templateTown.name;
        this(templateTown.name);
        setTowns(templateTown.getTowns());
    }

    /**
     * getName method
     * get name of Town
     * @return name of town
     */
    public String getName() {
        return name;
    }

    /**
     * compareTo method
     * @param o
     * @return 0 if names are equal, a positive or negative number
     * if the names are not equal
     */
    @Override
    public int compareTo(Town o) {
        if(o.getName().equals(name)){
            return 0;
        }else{
            return name.compareTo(o.getName());
        }
    }

    /**
     * toString method
     * @return town name in string format
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * hashCode method
     * @return hashCode of name of town
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }

    /**
     * equals method
     * @param obj
     * @return true if the town names are equal, false if not
     */
    @Override
    public boolean equals(Object obj) {
        //return super.equals(obj);
        if(obj == null){
            return false;
        }
        if(obj == this){
            return true;
        }else if(!(obj instanceof Town)){
            return false;
        }
        Town t = (Town) obj;
        return this.name.equals(t.name);
    }

    /**
     * getTowns method
     * gets list of towns
     * @return list of towns
     */
    public ArrayList<Town> getTowns() {
        return towns;
    }

    /**
     * setTowns method
     * sets list of towns
     * @param towns
     */
    public void setTowns(ArrayList<Town> towns) {
        for(int i = 0; i < towns.size(); i++){
            towns.add(towns.get(i));
        }
    }

    /**
     * addTowns method
     * adds towns into the list
     * @param town
     */
    public void addTowns(Town town){
        towns.add(town);
    }
}
