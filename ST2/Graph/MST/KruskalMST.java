package MSTalgos;
import java.util.*;

public class KruskalMST {
    public static int n;
    public static List<int[]> edges;

    public KruskalMST(int n) {
        this.n = n;
        this.edges = new ArrayList<>();
    }

    public void addEdge(int src, int dest, int w) {
        edges.add(new int[] { src, dest, w });
    }

    private static int find(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]);
        }
        return parent[node];
    }
    
    public static void union(int[] parent, int[] rank, int src , int dest) {
        int rootSrc = find(parent, src);
        int rootDest = find(parent, dest);

        if (rootSrc != rootDest) {
            if(rank[rootSrc] > rank[rootDest])
                parent[rootDest] = rootSrc;
            else if (rank[rootSrc] < rank[rootDest])
                parent[rootSrc] = rootDest;
            else
                parent[rootDest] = rootSrc;
                rank[rootSrc]++;
        }
    }

    public static void findMST() {
        edges.sort(Comparator.comparingInt(e -> e[2])); //sort according to the weight 

        //find-union data structure
        int[] parent = new int[n]; 
        int[] rank = new int[n];

        //add thoses edges who are in the MST
        List<int[]> inMST = new ArrayList<>();
        int totalWeight = 0; //current weight = 0


        //initialise find-union data structure
        for (int i = 0; i < n; i++) {
            parent[i] = i; //every node is parent of itself as it is a undirected graph
            rank[i] = 0;
        }

        //process each edge
        for (int[] e : edges) {
            int src = e[0], dest = e[1], w = e[2];

            if (find(parent, src) != find(parent, dest)) {
                inMST.add(e);
                union(parent, rank, src, dest);
                totalWeight += w;
            }
        }

        System.out.println("edges in the MST : ");
        for (int[] e : edges) {
            System.out.println(e[0] + " " + e[1] + " " + e[2]);
        }
        System.out.println("total weight : "+  totalWeight);

    }
    public static void main(String[] args) {
        KruskalMST g = new KruskalMST(7);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 2, 4);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 4, 2);
        g.addEdge(2, 3, 5);
        g.addEdge(2, 5, 6);
        g.addEdge(3, 4, 6);
        g.addEdge(3, 5, 6);
        g.addEdge(4, 5, 3);
        g.addEdge(4, 6, 4);
        g.addEdge(5, 6, 4);

        g.findMST();
    }
}
