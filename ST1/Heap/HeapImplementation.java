package Heap;

class MinHeap {
    int[] arr;
    int size;
    int capacity;

    public MinHeap(int c) {
        capacity = c;
        arr = new int[capacity];
        size = 0;
    }

    public int left(int i) {
        return i * 2 + 1;
    }

    public int right(int i) {
        return i * 2 + 2;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public void insert(int element) {
        //size == capacity, element can not be added
        if (size == capacity) {
            System.out.println("heap is full");
            return;
        }

        size++;
        arr[size - 1] = element;

        for (int i = size - 1; i != 0 && arr[parent(i)] > arr[i];) {
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i = parent(i);
        }
    }

    public void minHeapify(int i) {
        //we have to check if the element at i is correct according to the heap properties
        int lf = left(i);
        int rt = right(i);
        int smallest = i;
        if (lf < size && arr[lf] < arr[i]) {
            smallest = lf;
        }
        if (rt < size && arr[rt] < arr[i]) {
            smallest = rt;
        }

        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            smallest = temp;
            minHeapify(smallest);
        }

    }

    public void extractMin(int i) {
        //replace root with last element
        arr[i] = arr[size - 1];
        //remove last element
        size--;
        minHeapify(i);
    }

    public int extractMin2() {
        if (size == 0) {
            return Integer.MAX_VALUE;
        }
        if (size == 1) {
            size--;
            return arr[0];
        }
        int temp = arr[0];
        arr[0] = arr[size - 1];
        size--;
        minHeapify(0);
        return temp;
    }
    
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }
    
    public void changevalueatindex(int key,int i)
    {
        arr[i]=key;
        while(i!=0 && arr[parent(i)]>arr[i])
        {
            int temp=arr[i];
            arr[i]=arr[parent(i)];
            arr[parent(i)]=temp;
            i=parent(i);
        }
    }
}

public class HeapImplementation {
    public static void main(String[] args) {
        MinHeap h = new MinHeap(10);
        h.insert(12);
        h.insert(10);
        h.insert(30);
        h.insert(40);
        h.insert(20);
        // h.extractMin(0);
        h.changevalueatindex(5,3);
        h.printHeap();
    }
}
