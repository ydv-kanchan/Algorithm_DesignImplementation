import java.util.*;

public class graphUsingHashmap {
    static class Graph {
        HashMap<Integer, HashMap<Integer, Integer>> weightedGraph;

        // Constructor
        public Graph() {
            weightedGraph = new HashMap<>(); // Initialize the graph
        }

        // Add a vertex
        public void addVertex(int v) {
            // key = vertex, value is another new hashmap
            weightedGraph.put(v, new HashMap<>());
        }

        // Add an undirected, weighted edge between v1 and v2
        public void addEdge(int v1, int v2, int e) {
            weightedGraph.putIfAbsent(v1, new HashMap<>());
            weightedGraph.putIfAbsent(v2, new HashMap<>());
            weightedGraph.get(v1).put(v2, e);
            weightedGraph.get(v2).put(v1, e); // Since the graph is undirected
        }

        // Display the graph
        public void display() {
            for (int v : weightedGraph.keySet()) { // Use weightedGraph here
                System.out.print(v + " -> ");
                for (Map.Entry<Integer, Integer> neighbor : weightedGraph.get(v).entrySet()) {
                    System.out.print("(" + neighbor.getKey() + ", weight: " + neighbor.getValue() + ") ");
                }
                System.out.println();
            }
        }

        public boolean hasPath(int src, int dest, HashSet<Integer> visited) {
            if (src == dest)
                return true;
            for (int i : weightedGraph.get(src).keySet()) {
                if (!visited.contains(i)) {
                    boolean a = hasPath(i, dest, visited);
                    visited.add(i);

                    if (a) {
                        return true;
                    }
                }
            }
            return false;
        }

        //remove edge
        public void removeEdge(int v1, int v2) {
            if(weightedGraph.containsKey(v1) &&
                    weightedGraph.get(v1).containsKey(v2)) {
                weightedGraph.get(v1).remove(v2);
            }
            
            if(weightedGraph.containsKey(v2) &&
                    weightedGraph.get(v2).containsKey(v1)) {
                weightedGraph.get(v2).remove(v1);
                }
        }

        //remove vertex
        public void removeVertex(int v) {
            if (weightedGraph.containsKey(v)) {
                for (int neighbor : weightedGraph.get(v).keySet()) {
                    weightedGraph.get(neighbor).remove(v);
                }
                weightedGraph.remove(v);
            }
        }

    }

    // Main method to create and display the graph
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);

        g.addEdge(1, 2, 1);
        g.addEdge(2, 3, 3);
        g.addEdge(3, 4, 5);
        g.addEdge(4, 5, 9);
        
        System.out.println("actual graph: ");
        g.display(); // Display the graph
        g.removeEdge(2, 3);


        System.out.println("graph after remvoe Edge 2,3: ");
        g.display();
        g.removeVertex(4);

        System.out.println("graph after removing edge 4: ");
        g.display();

        System.out.println("has path from 2 to 1 ?  ");

        // Create a HashSet to keep track of visited nodes
        HashSet<Integer> visited = new HashSet<>();
        if (g.hasPath(2, 1,visited)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }

        System.out.println("has path from 3 to 5 ?  ");
        HashSet<Integer> visited2 = new HashSet<>();
        if (g.hasPath(3, 5,visited2)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
