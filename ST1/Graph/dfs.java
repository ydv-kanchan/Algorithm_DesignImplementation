import java.util.*;

public class dfs{
    //undirected unweighted graph 
    static class Graph {
        HashMap<Integer, HashSet<Integer>> graph;
        public Graph() {
            graph = new HashMap<>(); // Initialize the graph
        }

        // Add a vertex
        public void addVertex(int v) {
            graph.putIfAbsent(v, new HashSet<>());
        }

        // Add an undirected edge between v1 and v2
        public void addEdge(int v1, int v2) {
            graph.putIfAbsent(v1, new HashSet<>());
            graph.putIfAbsent(v2, new HashSet<>());
            graph.get(v1).add(v2);
            graph.get(v2).add(v1); // Since the graph is undirected
        }

        // Display the graph
        public void display() {
            for (int v : graph.keySet()) {
                System.out.print(v + " -> ");
                for (int neighbor : graph.get(v)) {
                    System.out.print(neighbor + " ");
                }
                System.out.println();
            }
        }

        // BFS method to check if there's a path from src to dest
        public boolean dfs(int src, int dest) {
            // Initialize a stack for DFS
            Stack<Integer> stack = new Stack<>();
            HashSet<Integer> visited = new HashSet<>(); // Keep track of visited nodes

            stack.push(src); // Start with the source node

            // Perform DFS
            while (!stack.isEmpty()) {
                int current = stack.pop();

                // If destination is found
                if (current == dest) {
                    return true;
                }

                // If not visited, mark it as visited
                if (!visited.contains(current)) {
                    visited.add(current);

                    // Add all unvisited neighbors of the current node to the stack
                    for (int neighbor : graph.getOrDefault(current, new HashSet<>())) {
                        if (!visited.contains(neighbor)) {
                            stack.push(neighbor);
                        }
                    }
                }
            }
            return false; // Destination not found
        }
        
        public boolean dfsRecursive(int src, int dest, HashSet<Integer> visited) {
            // Base case: if the source is the destination, return true
            if (src == dest) {
                return true;
            }

            // Mark the current node as visited
            visited.add(src);

            // Recursively visit each unvisited neighbor
            for (int neighbor : graph.getOrDefault(src, new HashSet<>())) {
                if (!visited.contains(neighbor)) {
                    if (dfsRecursive(neighbor, dest, visited)) {
                        return true;
                    }
                }
            }

            // If no path is found, return false
            return false;
        }


        // Remove edge
        public void removeEdge(int v1, int v2) {
            if (graph.containsKey(v1)) {
                graph.get(v1).remove(v2);
            }
            if (graph.containsKey(v2)) {
                graph.get(v2).remove(v1);
            }
        }

        // Remove vertex
        public void removeVertex(int v) {
            if (graph.containsKey(v)) {
                for (int neighbor : graph.get(v)) {
                    graph.get(neighbor).remove(v);
                }
                graph.remove(v);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        
        // Adding vertices
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addVertex(6);
        g.addVertex(7);


        // Adding edges
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);

        System.out.println("Actual graph:");
        g.display(); // Display the graph

        // Removing an edge and displaying the graph again
        g.removeEdge(2, 3);
        System.out.println("Graph after removing edge (2,3):");
        g.display();

        // Removing a vertex and displaying the graph again
        g.removeVertex(4);
        System.out.println("Graph after removing vertex 4:");
        g.display();

        // Check for path using BFS
        System.out.println("Is there a path from 1 to 5 using dfs with stack?");
        if (g.dfs(1, 5)) {
            System.out.println("Yes, there is a path.");
        } else {
            System.out.println("No, there is no path.");
        }

        System.out.println("Is there a path from 1 to 3 using dfs with stack?");
        if (g.dfs(1, 3)) {
            System.out.println("Yes, there is a path.");
        } else {
            System.out.println("No, there is no path.");
        }

        System.out.println("Is there a path from 1 to 3 using dfs with recurssion?");
        HashSet<Integer> visited = new HashSet<>();
        if (g.dfsRecursive(1, 3,visited)) {
            System.out.println("Yes, there is a path.");
        } else {
            System.out.println("No, there is no path.");
        }

        System.out.println("Is there a path from 1 to 3 using dfs with recurssion?");
        HashSet<Integer> visited1 = new HashSet<>();
        if (g.dfsRecursive(1, 3,visited1)) {
            System.out.println("Yes, there is a path.");
        } else {
            System.out.println("No, there is no path.");
        }
    }
}