package PriorityQueue;
import java.util.*;

public class ReversePQ {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
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
