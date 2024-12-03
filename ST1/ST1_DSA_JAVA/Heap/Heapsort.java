import java.util.*;

public class Heapsort {
  public static void heapSort(int array[], int n) {
    // Write your code here
    Arrays.sort(array);
    for (int i = 0; i < n; i++) {
      System.out.print(array[i] + " ");
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i=0;i  <n;i++){
      arr[i] = sc.nextInt();
    }
    heapSort(arr,7);
  }
}
