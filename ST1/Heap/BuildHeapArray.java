package Heap;

import java.util.Scanner;

class BuildHeap {
    int[] arr;
    int size;
    int capacity;

    //constructor 
    public BuildHeap(int c) {
        capacity = c;
        arr = new int[capacity];
        size = 0;
    }

    public int left(int i) {
        return i   * 2 + 1;
    }
    
    public int right(int i){
        return i*2 + 2;

    }

    public int parent(int i)  {
        return (i - 1) / 2;
    }
    
    public void insert ( int x){
        if (size == capacity) {
            System.out.println("heap is full");
            return;
        }

        size++;
        arr[size-1] = x;

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

    public void buildheap() {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            minHeapify(i);
        }
    }
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class BuildHeapArray{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BuildHeap h = new BuildHeap(n);
        for (int i = 0; i < n; i++) {
            int ele = sc.nextInt();
            h.insert(ele);
        }
        h.printHeap();
        sc.close();
    }
}