import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * TownGraphManager class
 * @author Shahdad Parsi
 */
public class TownGraphManager implements TownGraphManagerInterface{
    Graph graph = new Graph();

    /**
     * addRoad method
     * adds a road with two different towns and a road name
     * @param town1 name of town 1 (lastname, firstname)
     * @param town2 name of town 2 (lastname, firstname)
     * @param weight
     * @param roadName name of road
     * @return true if road was added, false otherwise
     */
    @Override
    public boolean addRoad(String town1, String town2, int weight, String roadName) {
        if(graph.addEdge(new Town(town1), new Town(town2), weight, roadName) != null){
            return true;
        }
        return false;
    }

    /**
     * getRoad method
     * @param town1 name of town 1 (lastname, firstname)
     * @param town2 name of town 2 (lastname, firstname)
     * @return name of road if town1 and 2 are on same road
     */
    @Override
    public String getRoad(String town1, String town2) {
        return ((Road) graph.getEdge(new Town(town1), new Town(town2))).getName();
    }

    /**
     * addTown method
     * @param v the town's name  (lastname, firstname)
     * @return if Town was added or not
     */
    @Override
    public boolean addTown(String v) {
        return graph.addVertex(new Town(v));
    }

    /**
     * getTown method
     * @param name the town's name
     * @return the Town specified by the name, or null if town does not exist
     */
    @Override
    public Town getTown(String name) {
        return new Town(name);
    }

    /**
     * containsTown method
     * @param v the town's name
     * @return true if the town is in the graph, false if not
     */
    @Override
    public boolean containsTown(String v) {
        return graph.containsVertex(new Town(v));
    }

    /**
     * containsRoadConnection method
     * @param town1 name of town 1 (lastname, firstname)
     * @param town2 name of town 2 (lastname, firstname)
     * @return true if the road is in the graph, false if not
     */
    @Override
    public boolean containsRoadConnection(String town1, String town2) {
        return graph.containsEdge(new Town(town1), new Town(town2));
    }

    /**
     * allRoads method
     * @return an arraylist of all road titles in sorted order by road name
     */
    @Override
    public ArrayList<String> allRoads() {
        ArrayList<Road> road = new ArrayList<Road>(graph.edgeSet());
        ArrayList<String> road1 = new ArrayList<String>();

        for(Road r: road){
            road1.add(r.getName());
        }

        Collections.sort(road1);
        return road1;
    }

    /**
     * deleteRoadConnection method
     * @param town1 name of town 1 (lastname, firstname)
     * @param town2 name of town 2 (lastname, firstname)
     * @param road the road name
     * @return true if the road was successfully deleted, false if not
     */
    @Override
    public boolean deleteRoadConnection(String town1, String town2, String road) {
        if(graph.removeEdge(new Town(town1), new Town(town2), 0, road) != null){
            return true;
        }
        return false;
    }

    /**
     * deleteTown method
     * @param v name of town (lastname, firstname)
     * @return true if the town was successfully deleted, false if not
     */
    @Override
    public boolean deleteTown(String v) {
        return graph.removeVertex(new Town(v));
    }

    /**
     * allTowns method
     * @return an arraylist of all towns in alphabetical order (last name, first name)
     */
    @Override
    public ArrayList<String> allTowns() {
        ArrayList<Town> town = new ArrayList<Town>(graph.vertexSet());
        ArrayList<String> town1 = new ArrayList<String>();

        for(Town t: town){
            town1.add(t.getName());
        }

        Collections.sort(town1);
        return town1;
    }

    /**
     * getPath method
     * @param town1 name of town 1 (lastname, firstname)
     * @param town2 name of town 2 (lastname, firstname)
     * @return an Arraylist of roads connecting the two towns together
     */
    @Override
    public ArrayList<String> getPath(String town1, String town2) {
        return graph.shortestPath(new Town(town1), new Town(town2));
    }


    public void populateTownGraph(File selectedFile) throws FileNotFoundException, IOException {
        Scanner scan = new Scanner(selectedFile);
        Town town;
        Town town1;
        String str = "";
        String[] split;

        while(scan.hasNext()){
            str = scan.nextLine();
            split = str.split("[,;]");
            town = new Town(split[2]);
            town1 = new Town(split[3]);
            graph.addVertex(town);
            graph.addVertex(town1);
            graph.addEdge(town, town1, Integer.parseInt(split[1]), split[0]);
        }
    }
}
