package GraphTraversals.GraphTraversals;
import java.util.*;

public class GraphTraverals {
    private int n; //number of vertices in graph
    private Map<Integer, HashMap<Integer, Integer>> vertex;
    //for each key in the map have a hashMap with (key,value) pairs as:
    // the key will be to which outer key directes or hasEdge and the value will be the weight or a constant value in case of unweighted graph

    //constructor to initialise no. of vertices and each vertix
    GraphTraverals(int n) {
        this.n = n;
        vertex = new HashMap<>();
    }

    //add Edge with direction and weight
    void addEdge(int src, int dest, int w) {
        vertex.putIfAbsent(src, new HashMap<>()); //outer key and value
        vertex.get(src).put(dest, w); //inner key value as destination and weight to the outer source
    }

    public void displayGraph() {
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : vertex.entrySet()) {
            int vertexKey = entry.getKey();
            HashMap<Integer, Integer> edges = entry.getValue();
            System.out.print("vertex " + vertexKey + "->");

            for (Map.Entry<Integer, Integer> edge : edges.entrySet()) {
                System.out.print("(" + edge.getKey() + "," + edge.getValue() + ")");
            }
            System.out.println();
        }
    }

    //bfs using Queue
    public void BFS(int start) {
        //take a queue 
        Queue<Integer> q = new LinkedList<>();
        //keep track on visited nodes 
        boolean[] visited = new boolean[n]; // size equal to the total no. of nodes
        Arrays.fill(visited, false);

        q.offer(start); //start bfs from the given node
        visited[start] = true;
        while (!q.isEmpty()) {
            int curr = q.poll(); //retirves and removes curr
            System.out.print(curr + " "); //print the curr node in bfs
            if (vertex.containsKey(curr)) {
                for (Integer neighbor : vertex.get(curr).keySet()) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        q.offer(neighbor);//add neighbours to the q and mark them visited
                    }
                }
            }
        }
        System.out.println(); //new line after first level   
    }

    //DFS with recurssion
    public void DFS(int start) {
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        dfsUtil(start, visited);
        System.err.println();
    }

    private void dfsUtil(int curr, boolean[] visited) {
        visited[curr] = true;
        System.out.print(curr + " ");
        if (vertex.containsKey(curr)) {
            for (Integer neighbor : vertex.get(curr).keySet()) {
                if (!visited[neighbor]) {
                    dfsUtil(neighbor, visited);
                }
            }
        }
    }

    //DFS without recurssion 
    public void DFSstack(int start) {
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        Stack<Integer> s = new Stack<>();
        s.push(start);

        while (!s.isEmpty()) {
            int curr = s.pop(); //retrive and remove top

            if (!visited[curr]) {
                visited[curr] = true;
                System.err.print(curr + " ");
                if (vertex.containsKey(curr)) {
                    for (Integer n : vertex.get(curr).keySet()) {
                        if (!visited[n]) {
                            s.push(n);
                        }
                    }
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //define graph
        GraphTraverals g = new GraphTraverals(4);

        //put edges in the graph
        g.addEdge(0, 1, 2);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 3, 5);
        g.addEdge(2, 3, 3);

        // print graph
        System.out.println("graph: ");
        g.vertex.forEach((outerkey, innermap)->{
            System.out.println("vertex " + outerkey + "->" + innermap);
        });
        
        System.out.println("display() graph: ");
        g.displayGraph();

        System.out.print("bfs traversal: ");
        g.BFS(0);
        System.out.print("dfs using recurssion: ");
        g.DFS(0);
        System.out.print("dfs without using recurssion:");
        g.DFSstack(0);
    }
}