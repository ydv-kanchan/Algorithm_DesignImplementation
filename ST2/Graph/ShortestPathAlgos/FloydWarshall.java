package ShortestPathAlgos;
// import java.ut/il.*;

public class FloydWarshall {
    final static int INF = 99999; 

    public static void floydWarshall(int[][] graph) {
        int vertices = graph.length;
        int[][] dist = new int[vertices][vertices]; 

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < vertices; k++) { 
            for (int i = 0; i < vertices; i++) { 
                for (int j = 0; j < vertices; j++) { 
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < vertices; i++) {
            if (dist[i][i] < 0) {
                System.out.println("Negative weight cycle detected!");
                return;
            }
        }

        printSolution(dist);
    }

    public static void printSolution(int[][] dist) {
        System.out.println("Shortest distances between every pair of vertices:");
        for (int[] row : dist) {
            for (int value : row) {
                if (value == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(value + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 3, INF, 5},
            {2, 0, INF, 4},
            {INF, 1, 0, INF},
            {INF, INF, -2, 0}
        };
        floydWarshall(graph);
    }
}

