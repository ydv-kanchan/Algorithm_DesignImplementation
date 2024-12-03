package PriorityQueue;
import java.util.*;

public class DefaultPQ {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(4); //O(log n)
        pq.add(3);
        pq.add(1);
        pq.add(9);
        while (!pq.isEmpty()) {
            System.out.println(pq.peek()); //O(1)

            pq.remove(); //O(log n)
        }
    }
}
