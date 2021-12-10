/**
 * Road class
 * @author Shahdad Parsi
 */
public class Road implements Comparable<Road>{
    private Town town;
    private Town town1;
    private int weight;
    private String name;

    /**
     * Constructor method
     * @param source
     * @param destination
     * @param degrees
     * @param name
     */
    public Road(Town source, Town destination, int degrees, String name) {
        town = source;
        town1 = destination;
        weight = degrees;
        this.name = name;
    }

    /**
     * Other constructor method
     * sets weight to 1
     * @param source
     * @param destination
     * @param name
     */
    public Road(Town source, Town destination, String name) {
        this(source, destination, 1, name);

    }

    /**
     * contains method
     * @param town
     * @return true if the edge contains the given vertex
     */
    public boolean contains(Town town) {
        return ((town.getName().equalsIgnoreCase(this.town.getName())) || (town.getName().equalsIgnoreCase(town1.getName())));
    }

    /**
     * toString method
     * @return road in string format
     */
    @Override
    public String toString() {
        return town.getName() + " via " + name + " to " + town1.getName() + " " + weight + " mi";

    }

    /**
     * getName method
     * @return name of road
     */
    public String getName() {
        return name;
    }

    /**
     * getDestination method
     * destination from source town
     * @return town1
     */
    public Town getDestination() {
        return town1;
    }

    /**
     * getSource method
     * source town
     * @return town
     */
    public Town getSource() {
        return town;
    }

    /**
     * compareTo method
     * @param r
     * @return 0 if the road names are the same, a positive or
     * negative number if the road names are not the same
     */
    @Override
    public int compareTo(Road r) {
        if(r.getName().equals(name)){
            return 0;
        }else{
            return name.compareTo(r.getName());
        }
    }

    /**
     * getWeight method
     * distance between towns
     * @return weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * equals method
     * @param o
     * @return true if each of the ends of the road o is the same
     * as the ends of this road.
     */
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Road)) {
            return false;
        }
        else {
            String rTown1=((Road) o).getSource().getName();
            String rTown2=((Road) o).getDestination().getName();
            if((town.getName().equalsIgnoreCase(rTown1)|| town.getName().equalsIgnoreCase(rTown2))&&(town1.getName().equalsIgnoreCase(rTown1)|| town1.getName().equalsIgnoreCase(rTown2))) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    /**
     * setSource method
     * sets the source town
     * @param town1
     */
    public void setSource(Town town1) {
        this.town = town1;
    }

    /**
     * setDestination method
     * sets the destination town
     * @param town2
     */
    public void setDestination(Town town2) {
        this.town1 = town2;
    }

    /**
     * setDistance method
     * sets the distance between each town
     * @param distance
     */
    public void setDistance(int distance) {
        this.weight = distance;
    }

    /**
     * setName method
     * sets name of road
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}