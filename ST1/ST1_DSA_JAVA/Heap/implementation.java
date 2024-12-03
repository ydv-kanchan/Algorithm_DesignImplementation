
// public class implementation {
    //   static int heap[]=new int[100];
    //   static int heapSize = -1;
    //   static void Insert(int element) {
    //     heapSize++;
    //     heap[heapSize] = element; /* Insert in the last place */
    //     int now = heapSize;

    //     while (now > 0 && heap[(now - 1) / 2] > element) {
    //         heap[now] = heap[(now - 1) / 2];
    //         now = (now - 1) / 2;
    //     }
    //     heap[now] = element;
    // }

    //   public static void main(String ab[]) 
    //   {
    //     int i;
    //     Insert(30);
    //     Insert(10);
    //     Insert(80);
    //     Insert(60);
    //     Insert(15);
    //     Insert(55);
    //     for (i = 0; i < 6; i++)
    //       System.out.print(heap[i]+" ");
    //     System.out.println();
    //   }

// }



public class implementation {
    static int heap[] = new int[100];
    static int heapSize = -1;

    static void Insert(int element) {
        heapSize++;
        heap[heapSize] = element; // Insert in the last place
        int now = heapSize;

        // Ensure max-heap property by moving the element up
        while (now > 0 && heap[(now - 1) / 2] < element) {
            heap[now] = heap[(now - 1) / 2];
            now = (now - 1) / 2;
        }
        heap[now] = element;
    }

    public static void main(String[] args) {
        Insert(30);
        Insert(10);
        Insert(80);
        Insert(60);
        Insert(15);
        Insert(55);

        for (int i = 0; i <= heapSize; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
