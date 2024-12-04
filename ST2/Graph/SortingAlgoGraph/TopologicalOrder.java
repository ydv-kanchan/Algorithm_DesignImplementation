package SortingAlgoGraph;
import java.util.*;

public class TopologicalOrder {
    private int n;
    private LinkedList<Integer> adj[];

    TopologicalOrder(int num) {
        n = num;
        adj = new LinkedList[n];
        for (int i = 0; i < n; ++i)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int vertex, int nbr) {
        adj[vertex].add(nbr);
    }

    void DFS(int curr, boolean visited[], Stack<Integer> s) {
        visited[curr] = true;

        for (Integer i : adj[curr]) {
            if (!visited[i]) {
                DFS(i, visited, s);
            }
        }
        s.push(curr);
    }

    void topologicalSort() {
        Stack<Integer> s = new Stack<>();
        boolean visited[] = new boolean[n];

        for (int i = 0; i < n; i++)
            visited[i] = false;

        for (int i = 0; i < n; i++) {
            if (!visited[i])
                DFS(i, visited, s);
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void main(String[] args) {
        TopologicalOrder g = new TopologicalOrder(6);

        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Topological Sort of the graph:");
        g.topologicalSort();
    }
}