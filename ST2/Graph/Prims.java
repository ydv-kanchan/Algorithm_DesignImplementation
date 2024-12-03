import java.util.*;

public class Prims {
    private int n;
    private Map<Integer, HashMap<Integer, Integer>> vertex;

    Prims(int n) {
        this.n = n;
        vertex = new HashMap<>();
    }

    void addEdge(int src, int dest, int w) {
        vertex.putIfAbsent(src, new HashMap<>());
        vertex.putIfAbsent(dest, new HashMap<>());
        vertex.get(src).put(dest, w);
        vertex.get(dest).put(src, w); // For undirected graph
    }

    public void displayGraph() {
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : vertex.entrySet()) {
            int vertexKey = entry.getKey();
            HashMap<Integer, Integer> edges = entry.getValue();
            System.out.print("vertex " + vertexKey + " -> ");

            for (Map.Entry<Integer, Integer> edge : edges.entrySet()) {
                System.out.print("(" + edge.getKey() + ", " + edge.getValue() + ") ");
            }
            System.out.println();
        }
    }

    public void primsMST() {
    boolean[] inMST = new boolean[n];
    int[] minWeight = new int[n]; 
    int[] mstParent = new int[n]; 

    Arrays.fill(minWeight, Integer.MAX_VALUE);
    Arrays.fill(mstParent, -1);

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    pq.offer(new int[] { 0, 0 });
    minWeight[0] = 0;

    int totalWeight = 0;

    while (!pq.isEmpty()) {
        int[] curr = pq.poll();
        int u = curr[0];
        if (inMST[u])
            continue;

        inMST[u] = true;
        totalWeight += curr[1];

        if (vertex.containsKey(u)) {
            for (Map.Entry<Integer, Integer> n : vertex.get(u).entrySet()) {
                int v = n.getKey();
                int weight = n.getValue();

                if (!inMST[v] && weight < minWeight[v]) {
                    minWeight[v] = weight;
                    pq.offer((new int[] { v, weight }));
                    mstParent[v] = u;
                }
            }
        }
    }
    System.out.println("Edges in MST:");
        for (int i = 1; i < n; i++) {
            System.out.println(mstParent[i] + " - " + i + " (weight: " + minWeight[i] + ")");
        }
        System.out.println("Total weight of MST: " + totalWeight);
    }

    public static void main(String[] args) {
        Prims g = new Prims(4);

        g.addEdge(0, 1, 2);
        g.addEdge(0, 3, 5);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 3, 5);
        g.addEdge(2, 3, 3);

        System.out.println("Graph:");
        g.displayGraph();

        g.primsMST();
    }
}
