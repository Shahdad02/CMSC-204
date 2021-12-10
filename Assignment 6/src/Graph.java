import java.lang.reflect.Array;
import java.util.*;

/**
 * Graph class
 * @author Shahdad Parsi
 */
public class Graph implements GraphInterface<Town, Road> {
    ArrayList<Town> towns = new ArrayList<Town>();
    ArrayList<LinkedList> edges = new ArrayList<LinkedList>();
    HashMap<Town, Town> hash = new HashMap<>();
    HashMap<String, HashMap<String, Road>> hash2 = new HashMap<>();
    ArrayList<String> arr;

    //added for dijkstra method
    private String[] before;
    private int[] dest;

    @Override
    public Road getEdge(Town sourceVertex, Town destinationVertex) {
        Road r = new Road(sourceVertex, destinationVertex,"r");
        int source = 0;
        int destination = 0;
        boolean foundSource = false;
        boolean foundDestination = false;

        if(sourceVertex == null || destinationVertex == null) {
            return null;
        }

        for(int i = 0; i < towns.size(); i++) {
            if(towns.get(i).compareTo(sourceVertex) == 0) {
                source = i;
                foundSource = true;
            }
            if(towns.get(i).compareTo(destinationVertex) == 0) {
                destination = i;
                foundDestination = true;
            }
            if(foundSource == true && foundDestination == true) {
                break;
            }
        }

        ListIterator<Road> it = edges.get(source).listIterator(0);
        while(it.hasNext()) {
            Road road = it.next();
            if(r.equals(road)) {
                return road;
            }
        }
        return null;
    }

    @Override
    public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
        int source = 0;
        int destination = 0;
        boolean foundSource = false;
        boolean foundDestination = false;
        //Road edge = new Road(sourceVertex, destinationVertex, weight, description);

        if(sourceVertex == null || destinationVertex == null){
            throw new NullPointerException();
        }
        Road edge = new Road(sourceVertex, destinationVertex, weight, description);
        for(int i = 0; i < towns.size(); i++){
            if(towns.get(i).compareTo(sourceVertex) == 0){
                source = i;
                foundSource = true;
            }
            if(towns.get(i).compareTo(destinationVertex) == 0){
                destination = i;
                foundDestination = true;
            }
            if(foundSource == true && foundDestination == true){
                break;
            }
        }

        if(foundSource == false || foundDestination == false){
            throw new IllegalArgumentException();
        }else{
            if(!edges.get(destination).contains(edge) && !edges.get(source).contains(edge)){
                edges.get(source).add(edge);
                edges.get(destination).add(edge);
                sourceVertex.addTowns(destinationVertex);
                destinationVertex.addTowns(sourceVertex);
                return edge;
            }
        }
        return null;
    }

    @Override
    public boolean addVertex(Town town) {
        for (Town value : towns) {
            if (value.compareTo(town) == 0) {
                return false;
            }
        }
        towns.add(town);

        if(edges.isEmpty()) {
            edges.add(new LinkedList<Road>());
        }else{
            edges.add(new LinkedList<Road>());
        }
        return true;
    }

    @Override
    public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
        int source = 0;
        int destination = 0;
        boolean foundSource = false;
        boolean foundDestination = false;

        for(int i = 0; i < towns.size(); i++) {
            if(towns.get(i).compareTo(sourceVertex) == 0) {
                source = i;
                foundSource = true;
            }
            if(towns.get(i).compareTo(destinationVertex) == 0) {
                destination = i;
                foundDestination = true;
            }
            if(foundSource == true && foundDestination == true) {
                break;
            }
        }

        if(foundSource == true && foundDestination == true) {
            ListIterator<Road> list = edges.get(source).listIterator(0);
            while(list.hasNext()) {
                Road road = list.next();
                if(road.contains(sourceVertex) && road.contains(destinationVertex)) {
                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public boolean containsVertex(Town town) {
        for (Town value : towns) {
            if (value.compareTo(town) == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<Road> edgeSet() {
        Set<Road> roads = new HashSet<Road>();
        for (LinkedList edge : edges) {
            ListIterator<Road> list = edge.listIterator(0);
            while (list.hasNext()) {
                Road road = list.next();
                if (!roads.contains(road)) {
                    roads.add(road);
                }
            }
        }
        return roads;
    }

    @Override
    public Set<Road> edgesOf(Town vertex) {
        Set<Road> roads = new HashSet<Road>();
        int okay = 0;

        for(int i = 0; i < towns.size(); i++) {
            if(towns.get(i).compareTo(vertex) == 0) {
                okay = i;
            }
        }

        ListIterator<Road> list = edges.get(okay).listIterator(0);
        while(list.hasNext()) {
            Road road = list.next();
            if(!roads.contains(road)) {
                roads.add(road);
            }
        }
        return roads;
    }

    @Override
    public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
        int source = 0;
        int destination = 0;
        boolean foundSource = false;
        boolean foundDestination = false;
        Road road = new Road(sourceVertex, destinationVertex, weight, description);


        if(containsEdge(sourceVertex, destinationVertex)) {
            for(int i = 0; i < towns.size(); i++) {
                if(towns.get(i).compareTo(sourceVertex) == 0) {
                    source = i;
                    foundSource = true;
                }
                if(towns.get(i).compareTo(destinationVertex)==0) {
                    destination = i;
                    foundDestination = true;
                }
                if(foundSource == true && foundDestination == true) {
                    break;
                }
            }

            ListIterator<Road> list = edges.get(source).listIterator(0);
            ListIterator<Road> list1 = edges.get(destination).listIterator(0);
            while(list.hasNext()) {
                Road road1 = list.next();
                if(road1.equals(road)) {
                    if(edges.get(source).remove(road1)) {
                        break;
                    }
                }
            }

            while(list1.hasNext()) {
                Road road1 = list1.next();
                if(road1.equals(road)) {
                    if(edges.get(destination).remove(road1)) {
                        break;
                    }
                }
            }
            return road;
        }
        return null;
    }

    @Override
    public boolean removeVertex(Town town) {
        int index = 0;
        if(containsVertex(town)) {
            for(int i = 0; i < towns.size(); i++) {
                if(towns.get(i).compareTo(town) == 0) {
                    index = i;
                    break;
                }
            }
            for(int i = 0; i < town.getTowns().size(); i++) {
                Road road = getEdge(town.getTowns().get(i), town);
                if(containsEdge(town.getTowns().get(i), town)) {
                    removeEdge(town.getTowns().get(i), town, road.getWeight(), road.getName());
                }
            }
            towns.remove(index);
            edges.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public Set<Town> vertexSet() {
        Set<Town> set = new HashSet<Town>();
        for(int i = 0; i < towns.size(); i++){
            if(towns.contains(towns.get(i))){
                set.add(towns.get(i));
            }
        }
        return set;
    }

    @Override
    public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
//        dijkstraShortestPath(sourceVertex);
        String edge;
        String path = "";
        Town town = (Town) destinationVertex;
        Town before = hash.get(destinationVertex);

        dijkstraShortestPath(sourceVertex);
        while(town.compareTo(sourceVertex) != 0) {
            edge = getEdge(town, before).getName();
            path = before.getName()+ " via " + edge + " to " + town.getName()+ " " + getEdge(town, before).getWeight() + " mi";
            arr.add(0, path);
            town = before;
            before = hash.get(town);

        }
        return arr;
    }

    @Override
    public void dijkstraShortestPath(Town sourceVertex) {
        String str = ((Town)sourceVertex).getName();
        List<Town> vertex = new ArrayList<>(vertexSet());
        ArrayList<String> unvisited = new ArrayList<String>();
        arr = new ArrayList<String>();
        int[] distance;
        String[] before;

        for(Town t: vertex){
            arr.add(t.getName());
            unvisited.add(t.getName());
        }
        distance = new int[towns.size()];
        before = new String[towns.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[towns.indexOf(str)] = 0;

        while(!unvisited.isEmpty()){
            HashMap<String, Road> connected = hash2.get(str);
            for(String str2 : connected.keySet()){
                if(unvisited.indexOf(str2) != -1 && connected.get(str2) != null){
                    int index = towns.indexOf(str2);
                    int current = towns.indexOf(str);
                    int weight = connected.get(str2).getWeight();
                    if (distance[current] + weight < distance[index]){
                        distance[index] = weight + distance[current];
                        before[index] = str;
                    }
                }
            }
            unvisited.remove(unvisited.indexOf(str));
            if(unvisited.isEmpty()){
                break;
            }

            int shortIndex = -1;
            int shortPath = Integer.MAX_VALUE;
            for(String str2: unvisited){
                int index = towns.indexOf(str2);
                if(distance[index] < shortPath){
                    shortPath = distance[index];
                    shortIndex = index;
                }
            }
            if(shortIndex == -1){
                break;
            }
            str = arr.get(shortIndex);
        }
    }
}
